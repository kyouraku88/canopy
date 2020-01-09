'use strict';

var util = require('../util');

var Builder = function(parent, name) {
  if (parent) {
    this._parent = parent;
    this._indentLevel = parent._indentLevel;
  } else {
    this._buffer = '';
    this._indentLevel = 0;
  }
  this._name = name;
  this._varIndex = {};

  this._buffers = {};
  this._currentBuffer = null;
  this._labels = {};
};

var TYPES = {
    address:    'TreeNode',
    chunk:      'String',
    elements:   'List<TreeNode>',
    index:      'Int',
    remaining:  'Int'
};

Builder.create = function(filename, sep) {
    var builder = new Builder();
    builder.filename = filename;
    builder.pathsep = sep;
    return builder;
};

util.assign(Builder.prototype, {
    comment: function(lines) {
        lines = lines.map(function(line) { return ' * ' + line });
        return ['/**'].concat(lines).concat([' */']);
    },

    serialize: function() {
        return this._buffers;
    },

    _newBuffer: function(name) {
        this._currentBuffer = this.filename.replace(/\.peg$/, this.pathsep + name + '.kt');
        var namespace = this.filename.replace(/\.peg$/, '').split(this.pathsep);
        this._buffers[this._currentBuffer] = 'package ' + namespace.join('.') + ';\n\n';
    },

    _write: function(string) {
        if (this._parent) return this._parent._write(string);
        this._buffers[this._currentBuffer] += string;
    },

    _indent: function(block, context) {
        this._indentLevel += 1;
        block.call(context, this);
        this._indentLevel -= 1;
    },

    _newline: function() {
        this._write('\n');
    },

    _line: function(source, semicolon) {
        var i = this._indentLevel;
        while (i--) this._write('    ');
        this._write(source);
        this._newline();
    },

    _quote: function(string) {
        string = string.replace(/\\/g, '\\\\')
                        .replace(/"/g, '\\"')
                        .replace(/\x08/g, '\\b')
                        .replace(/\t/g, '\\t')
                        .replace(/\n/g, '\\n')
                        .replace(/\f/g, '\\f')
                        .replace(/\r/g, '\\r');

        return '"' + string + '"';
    },

    package_: function(name, block, context) {
        this._grammarName = name.replace(/\./g, '');
        block.call(context, this);
    },

    syntaxNodeClass_: function() {
        this._newBuffer('TreeNode');

        // var imports = ['ArrayList', 'EnumMap', 'Iterator', 'List', 'Map'];
        // for (var i = 0, n = imports.length; i < n; i++)
        // this._line('import java.util.' + imports[i]);

        var name = 'TreeNode';

        this._line('data class ' + name + ': Iterable<' + name + '>(');
        this._indent(function(builder) {
            builder._line('val text = "",');
            builder._line('val offset = 0,');
            builder._line('val elements = mutableListOf<' + name + '>(),');
            builder._line('val labelled = mutableMapOf<Label, ' + name + '>()');
            builder._line(') {');

            builder._newline();
            builder._line('fun get(Label key): ' + name + '? = labelled[key] {');

            builder._newline();
            builder._line('override fun iterator() = elements.iterator()');
        });
        this._line('}');

        return name;
    },

    grammarModule_: function(actions, block, context) {
        this._newBuffer('CacheRecord');
        this._line('data class CacheRecord (val node: TreeNode, tail: Int)');

        this._newBuffer('Actions');
        this._line('interface Actions {');
        this._indent(function(builder) {
        for (var i = 0, n = actions.length ; i < n; i++)
            builder._line('fun ' + actions[i] + '(input: String, start: Int, end: Int, elements: List<TreeNode>): TreeNode');
        });
        this._line('}');

        this._newBuffer('Grammar');
        this._line('import java.util.regex.Pattern');
        this._newline();
        this._line('abstract class Grammar(');
        this._indent(function(builder) {
            builder._line('val inputSize');
            builder._line('var offset = 0');
            builder._line('var failure = 0');
            builder._line('open val input: String');
            builder._line('var expected: mutableListOf<String>()');
            builder._line('val cache: mutableMapOf<Label, Map<Integer, CacheRecord>>()');
            builder._line('open val actions: Actions');
        });
        this._line(') {')
        this._indent(function(builder) {
            builder._newline();
            builder.assign_('val ' + builder.nullNode_(), 'TreeNode()');
            builder._newline();
            block.call(context, builder);
        });
        this._line('}', false);
    },

    compileRegex_: function(charClass, name) {
        var regex  = charClass.regex,
            source = regex.source.replace(/^\^/, '\\A');

        // this._line('companion object {');
        // this._indent(function(builder) {
            this.assign_('val ' + name, 'Pattern.compile(' + this._quote(source) + ')');
        // });
        // this._line('}')
        charClass.constName = name;
    },

    parserClass_: function(root) {
        this._newBuffer('ParseError');
        this._line('class ParseError(override val message: String): RuntimeException(message)');

        this._newBuffer(this._grammarName);
        this._line('class ' + this._grammarName + '(');
        this._indent(function(builder) {
            builder._line('override val input: String,');
            builder._line('override val actions: Actions');
        });
        this._line('): Grammar(')
        this._indent(function(builder) {
            builder._line('inputSize = input.length(),');
            builder._line('actions = actions,');
            builder._line('input = input');
        });
        this._line(') {')
        this._indent(function(builder) {
        builder._newline();
        builder._line('private fun formatError(input: String, offset: Int, expected: List<String>): String {');
        builder._indent(function(builder) {
            builder.assign_('val lines', 'input.split("\\n")');
            builder._line('var lineNo = 0');
            builder._line('var position = 0');
            builder._line('while (position <= offset) {');
            builder._indent(function(builder) {
                builder._line('position += lines[lineNo].length() + 1');
                builder._line('lineNo += 1');
            });
            builder._line('}');
            builder.assign_('var message', '"Line $lineNo: expected $expected\\n"');
            builder.assign_('val line', 'lines[lineNo - 1]');
            builder._line('message += line + "\\n"');
            builder._line('position -= line.length() + 1');
            builder._line('while (position < offset) {');
            builder._indent(function(builder) {
                builder._line('message += " "');
                builder._line('position += 1');
            });
            builder._line('}');
            builder.return_('"$message^"');
        });
        builder._line('}');

        builder._newline();
        builder._line('@Throws(ParseError::class)');
        builder._line('private fun parse(): TreeNode {');
        builder._indent(function(builder) {
            builder.jump_('val tree', root);
            builder.if_('tree !== ' + builder.nullNode_() + ' && offset === inputSize', function(builder) {
                builder.return_('tree');
            });
            builder.if_('expected.isEmpty()', function(builder) {
                builder.assign_('failure', 'offset');
                builder.append_('expected', '"<EOF>"');
            });
            builder._line('throw ParseError(formatError(input, failure, expected))');
        });
        builder._line('}');
        });
        this._line('}');
    },

    exports_: function() {
        var labels = [];
        for (var name in this._labels) labels.push(name);
        labels = labels.sort();
        this._newBuffer('Label');
        this._line('enum class Label {');
        this._indent(function(builder) {
        for (var i = 0, n = labels.length; i < n; i++)
            builder._line(labels[i] + (i < n - 1 ? ',' : ''));
        });
        this._line('}');
    },

    class_: function(name, parent, block, context) {
        this._newline();
        this._line('class ' + name + ': ' + parent + '(');
        new Builder(this, name)._indent(block, context);
        this._line('}')
    },

    constructor_: function(args, block, context) {
        this._line('val text: String,');
        this._line('val offset: Int,');
        this._line('val elements: List<TreeNode>');
        this._line('): TreeNode(text, offset, elements) {');
        this._indent(function(builder) {
            builder._line('init {');
            builder._indent(function(builder) {
                block.call(context, builder);
            });
            builder._line('}');
        });
    },

    method_: function(name, args, block, context) {
        this._newline();
        this._line('fun ' + name + '(): TreeNode {');
        new Builder(this)._indent(block, context);
        this._line('}');
    },

    cache_: function(name, block, context) {
        var builder = this;
        while (builder._parent) builder = builder._parent;
        builder._labels[name] = true;

        var temp    = this.localVars_({address: this.nullNode_(), index: 'offset'}),
            address = temp.address,
            offset  = temp.index;

        this.assign_('val rule', 'cache[Label.' + name + ']');
        this.if_('rule == null', function(builder) {
            builder.assign_('rule', 'mutableMapOf<Integer, CacheRecord>()');
            builder._line('cache[Label.' + name + '] = rule');
        });
        this.if_('offset in rule', function(builder) {
            builder.assign_(address, 'rule[offset].node');
            builder.assign_('offset', 'rule[offset].tail');
        }, function(builder) {
            block.call(context, builder, address);
            builder._line('rule[' + offset + '] = CacheRecord(' + address + ', offset)');
        });
        this.return_(address);
    },

    attributes_: function() {},

    attribute_: function(name, value) {
        var builder = this;
        while (builder._parent) builder = builder._parent;
        builder._labels[name] = true;
        this._line('labelled[Label.' + name + '] = ' + value);
    },

    localVars_: function(vars) {
        var names = {}, code = [], varName;
        for (var name in vars)
        names[name] = this.localVar_(name, vars[name]);
        return names;
    },

    localVar_: function(name, value) {
        this._varIndex[name] = this._varIndex[name] || 0;
        var varName = name + this._varIndex[name];
        this._varIndex[name] += 1;
        this.assign_('var ' + name, (value === undefined) ? this.nullNode_() : value);
        return varName;
    },

    chunk_: function(length) {
        var chunk = this.localVar_('chunk', this.null_()), input = 'input', of = 'offset';
        this.if_(of + ' < inputSize', function(builder) {
        builder._line(chunk + ' = ' + input + '.substring(' + of + ', ' +
            'Math.min(' + of + ' + ' + length + ', ' +
            input + '.length()' + '))');
        });
        return chunk;
    },

    syntaxNode_: function(address, start, end, elements, action, nodeClass) {
        var args;

        if (action) {
        action = 'actions.' + action;
        args   = ['input', start, end];
        } else {
        action = (nodeClass || 'TreeNode');
        args   = ['input.substring(' + start + ', ' + end + ')', start];
        }
        if (elements) args.push(elements);

        this.assign_(address, action + '(' + args.join(', ') + ')');
        this.assign_('offset', end);
    },

    ifNode_: function(address, block, else_, context) {
        this.if_(address + ' != ' + this.nullNode_(), block, else_, context);
    },

    unlessNode_: function(address, block, else_, context) {
        this.if_(address + ' == ' + this.nullNode_(), block, else_, context);
    },

    ifNull_: function(elements, block, else_, context) {
        this.if_(elements + ' == null', block, else_, context);
    },

    extendNode_: function(address, nodeType) {
        if (!nodeType) return;
        // TODO
    },

    failure_: function(address, expected) {
        expected = this._quote(expected);
        this.assign_(address, this.nullNode_());

        this.if_('offset > failure', function(builder) {
            builder.assign_('failure', 'offset');
            builder.assign_('expected', 'ArrayList<String>()');
        });
        this.if_('offset == failure', function(builder) {
            builder.append_('expected', expected);
        });
    },

    assign_: function(name, value) {
        this._line(name + ' = ' + value);
    },

    jump_: function(address, rule) {
        this.assign_(address, '_read_' + rule + '()');
    },

    conditional_: function(kwd, condition, block, else_, context) {
        if (typeof else_ !== 'function') {
        context = else_;
        else_   = null;
        }
        this._line(kwd + ' (' + condition + ') {', false);
        this._indent(block, context);
        if (else_) {
        this._line('} else {', false);
        this._indent(else_, context);
        }
        this._line('}', false);
    },

    if_: function(condition, block, else_, context) {
        this.conditional_('if', condition, block, else_, context);
    },

    whileNotNull_: function(expression, block, context) {
        this.conditional_('while', expression + ' != ' + this.nullNode_(), block, context);
    },

    stringMatch_: function(expression, string) {
        return expression + ' != null && ' + expression + '.equals(' + this._quote(string) + ')';
    },

    stringMatchCI_: function(expression, string) {
        return expression + ' != null && ' + expression + '.toLowerCase().equals(' + this._quote(string) + '.toLowerCase())';
    },

    regexMatch_: function(regex, string) {
        return string + ' != null && ' + regex + '.matcher(' + string + ').matches()';
    },

    return_: function(expression) {
        this._line('return ' + expression);
    },

    arrayLookup_: function(expression, offset) {
        return expression + '.get(' + offset + ')';
    },

    append_: function(list, value, index) {
        if (index === undefined)
        this._line(list + '.add(' + value + ')');
        else
        this._line(list + '.add(' + index + ', ' + value + ')');
    },

    decrement_: function(variable) {
        this._line('--' + variable);
    },

    isZero_: function(expression) {
        return expression + ' <= 0';
    },

    hasChars_: function() {
        return 'offset < inputSize';
    },

    nullNode_: function() {
        return 'FAILURE';
    },

    offset_: function() {
        return 'offset';
    },

    emptyList_: function(size) {
        return 'ArrayList<TreeNode>(' + (size ? size : '') + ')';
    },

    emptyString_: function() {
        return '""';
    },

    true_: function() {
        return 'TreeNode("", -1)';
    },

    null_: function() {
        return 'null';
    }
});

module.exports = Builder;