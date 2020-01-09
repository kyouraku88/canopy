/**
 * This file was generated from examples/canopy/peg.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.peg;

import java.util.regex.Pattern

abstract class Grammar(
    val inputSize
    var offset = 0
    var failure = 0
    open val input: String
    var expected: mutableListOf<String>()
    val cache: mutableMapOf<Label, Map<Integer, CacheRecord>>()
    open val actions: Actions
) {

    val FAILURE = TreeNode()

    val REGEX_1 = Pattern.compile("\\A[^\"]")
    val REGEX_2 = Pattern.compile("\\A[^']")
    val REGEX_3 = Pattern.compile("\\A[^`]")
    val REGEX_4 = Pattern.compile("\\A[^\\]]")
    val REGEX_5 = Pattern.compile("\\A[a-zA-Z_]")
    val REGEX_6 = Pattern.compile("\\A[a-zA-Z0-9_]")
    val REGEX_7 = Pattern.compile("\\A[\\s]")
    val REGEX_8 = Pattern.compile("\\A[^\\n]")

    fun _read_grammar(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.grammar]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.grammar] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(4)
            var address = FAILURE
            var remaining = 0
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address2 != FAILURE) {
                address2 = _read___()
                if (address2 != FAILURE) {
                    elements1.add(address2)
                    --remaining0
                }
            }
            if (remaining0 <= 0) {
                address1 = TreeNode(input.substring(index2, offset), index2, elements1)
                offset = offset
            } else {
                address1 = FAILURE
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address3 = _read_grammar_name()
                if (address3 != FAILURE) {
                    elements0.add(1, address3)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address5 != FAILURE) {
                        var index = offset
                        var elements = ArrayList<TreeNode>(2)
                        var address = FAILURE
                        var remaining = 0
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address7 != FAILURE) {
                            address7 = _read___()
                            if (address7 != FAILURE) {
                                elements4.add(address7)
                                --remaining2
                            }
                        }
                        if (remaining2 <= 0) {
                            address6 = TreeNode(input.substring(index5, offset), index5, elements4)
                            offset = offset
                        } else {
                            address6 = FAILURE
                        }
                        if (address6 != FAILURE) {
                            elements3.add(0, address6)
                            var address = FAILURE
                            address8 = _read_grammar_rule()
                            if (address8 != FAILURE) {
                                elements3.add(1, address8)
                            } else {
                                elements3 = null
                                offset = index4
                            }
                        } else {
                            elements3 = null
                            offset = index4
                        }
                        if (elements3 == null) {
                            address5 = FAILURE
                        } else {
                            address5 = TreeNode2(input.substring(index4, offset), index4, elements3)
                            offset = offset
                        }
                        if (address5 != FAILURE) {
                            elements2.add(address5)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address4 = TreeNode(input.substring(index3, offset), index3, elements2)
                        offset = offset
                    } else {
                        address4 = FAILURE
                    }
                    if (address4 != FAILURE) {
                        elements0.add(2, address4)
                        var address = FAILURE
                        var remaining = 0
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address10 != FAILURE) {
                            address10 = _read___()
                            if (address10 != FAILURE) {
                                elements5.add(address10)
                                --remaining3
                            }
                        }
                        if (remaining3 <= 0) {
                            address9 = TreeNode(input.substring(index6, offset), index6, elements5)
                            offset = offset
                        } else {
                            address9 = FAILURE
                        }
                        if (address9 != FAILURE) {
                            elements0.add(3, address9)
                        } else {
                            elements0 = null
                            offset = index1
                        }
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode1(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_grammar_name(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.grammar_name]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.grammar_name] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(4)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 7, input.length()))
            }
            if (chunk0 != null && chunk0.toLowerCase().equals("grammar".toLowerCase())) {
                address1 = TreeNode(input.substring(offset, offset + 7), offset)
                offset = offset + 7
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("`grammar`")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk1 != null && chunk1.equals(":")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\":\"")
                    }
                }
                if (address2 == FAILURE) {
                    address2 = TreeNode(input.substring(index2, index2), index2)
                    offset = index2
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address4 != FAILURE) {
                        address4 = _read___()
                        if (address4 != FAILURE) {
                            elements1.add(address4)
                            --remaining0
                        }
                    }
                    if (remaining0 <= 0) {
                        address3 = TreeNode(input.substring(index3, offset), index3, elements1)
                        offset = offset
                    } else {
                        address3 = FAILURE
                    }
                    if (address3 != FAILURE) {
                        elements0.add(2, address3)
                        var address = FAILURE
                        address5 = _read_object_identifier()
                        if (address5 != FAILURE) {
                            elements0.add(3, address5)
                        } else {
                            elements0 = null
                            offset = index1
                        }
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode3(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_grammar_rule(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.grammar_rule]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.grammar_rule] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            address1 = _read_identifier()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_assignment()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address3 = _read_parsing_expression()
                    if (address3 != FAILURE) {
                        elements0.add(2, address3)
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode4(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_assignment(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.assignment]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.assignment] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            var remaining = 1
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address2 != FAILURE) {
                address2 = _read___()
                if (address2 != FAILURE) {
                    elements1.add(address2)
                    --remaining0
                }
            }
            if (remaining0 <= 0) {
                address1 = TreeNode(input.substring(index2, offset), index2, elements1)
                offset = offset
            } else {
                address1 = FAILURE
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk0 = input.substring(offset, Math.min(offset + 2, input.length()))
                }
                if (chunk0 != null && chunk0.equals("<-")) {
                    address3 = TreeNode(input.substring(offset, offset + 2), offset)
                    offset = offset + 2
                } else {
                    address3 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"<-\"")
                    }
                }
                if (address3 != FAILURE) {
                    elements0.add(1, address3)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address5 != FAILURE) {
                        address5 = _read___()
                        if (address5 != FAILURE) {
                            elements2.add(address5)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address4 = TreeNode(input.substring(index3, offset), index3, elements2)
                        offset = offset
                    } else {
                        address4 = FAILURE
                    }
                    if (address4 != FAILURE) {
                        elements0.add(2, address4)
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_parsing_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.parsing_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.parsing_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            address0 = _read_choice_expression()
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_choice_part()
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_parenthesised_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.parenthesised_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.parenthesised_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(5)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("(")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"(\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    address3 = _read___()
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address4 = _read_parsing_expression()
                    if (address4 != FAILURE) {
                        elements0.add(2, address4)
                        var address = FAILURE
                        var remaining = 0
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address6 != FAILURE) {
                            address6 = _read___()
                            if (address6 != FAILURE) {
                                elements2.add(address6)
                                --remaining1
                            }
                        }
                        if (remaining1 <= 0) {
                            address5 = TreeNode(input.substring(index3, offset), index3, elements2)
                            offset = offset
                        } else {
                            address5 = FAILURE
                        }
                        if (address5 != FAILURE) {
                            elements0.add(3, address5)
                            var address = FAILURE
                            var chunk = null
                            if (offset < inputSize) {
                                chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk1 != null && chunk1.equals(")")) {
                                address7 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address7 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("\")\"")
                                }
                            }
                            if (address7 != FAILURE) {
                                elements0.add(4, address7)
                            } else {
                                elements0 = null
                                offset = index1
                            }
                        } else {
                            elements0 = null
                            offset = index1
                        }
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode5(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_choice_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.choice_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.choice_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_choice_part()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 1
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var index = offset
                    var elements = ArrayList<TreeNode>(4)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address5 != FAILURE) {
                        address5 = _read___()
                        if (address5 != FAILURE) {
                            elements3.add(address5)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address4 = TreeNode(input.substring(index4, offset), index4, elements3)
                        offset = offset
                    } else {
                        address4 = FAILURE
                    }
                    if (address4 != FAILURE) {
                        elements2.add(0, address4)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk0 != null && chunk0.equals("/")) {
                            address6 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address6 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"/\"")
                            }
                        }
                        if (address6 != FAILURE) {
                            elements2.add(1, address6)
                            var address = FAILURE
                            var remaining = 1
                            var index = offset
                            var elements = ArrayList<TreeNode>()
                            var address = TreeNode("", -1)
                            while (address8 != FAILURE) {
                                address8 = _read___()
                                if (address8 != FAILURE) {
                                    elements4.add(address8)
                                    --remaining2
                                }
                            }
                            if (remaining2 <= 0) {
                                address7 = TreeNode(input.substring(index5, offset), index5, elements4)
                                offset = offset
                            } else {
                                address7 = FAILURE
                            }
                            if (address7 != FAILURE) {
                                elements2.add(2, address7)
                                var address = FAILURE
                                address9 = _read_choice_part()
                                if (address9 != FAILURE) {
                                    elements2.add(3, address9)
                                } else {
                                    elements2 = null
                                    offset = index3
                                }
                            } else {
                                elements2 = null
                                offset = index3
                            }
                        } else {
                            elements2 = null
                            offset = index3
                        }
                    } else {
                        elements2 = null
                        offset = index3
                    }
                    if (elements2 == null) {
                        address3 = FAILURE
                    } else {
                        address3 = TreeNode7(input.substring(index3, offset), index3, elements2)
                        offset = offset
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode6(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_choice_part(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.choice_part]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.choice_part] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var index = offset
            address1 = _read_action_expression()
            if (address1 == FAILURE) {
                offset = index2
                address1 = _read_sequence_expression()
                if (address1 == FAILURE) {
                    offset = index2
                    address1 = _read_sequence_part()
                    if (address1 == FAILURE) {
                        offset = index2
                    }
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                var index = offset
                var elements = ArrayList<TreeNode>(2)
                var address = FAILURE
                var remaining = 1
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address4 != FAILURE) {
                    address4 = _read___()
                    if (address4 != FAILURE) {
                        elements2.add(address4)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address3 = TreeNode(input.substring(index5, offset), index5, elements2)
                    offset = offset
                } else {
                    address3 = FAILURE
                }
                if (address3 != FAILURE) {
                    elements1.add(0, address3)
                    var address = FAILURE
                    address5 = _read_type_tag()
                    if (address5 != FAILURE) {
                        elements1.add(1, address5)
                    } else {
                        elements1 = null
                        offset = index4
                    }
                } else {
                    elements1 = null
                    offset = index4
                }
                if (elements1 == null) {
                    address2 = FAILURE
                } else {
                    address2 = TreeNode8(input.substring(index4, offset), index4, elements1)
                    offset = offset
                }
                if (address2 == FAILURE) {
                    address2 = TreeNode(input.substring(index3, index3), index3)
                    offset = index3
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_action_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.action_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.action_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            address1 = _read_actionable_expression()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 1
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    address3 = _read___()
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address4 = _read_action_tag()
                    if (address4 != FAILURE) {
                        elements0.add(2, address4)
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode9(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_actionable_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.actionable_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.actionable_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var index = offset
            var elements = ArrayList<TreeNode>(5)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("(")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"(\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    address3 = _read___()
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index3, offset), index3, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address4 = _read_actionable_expression()
                    if (address4 != FAILURE) {
                        elements0.add(2, address4)
                        var address = FAILURE
                        var remaining = 0
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address6 != FAILURE) {
                            address6 = _read___()
                            if (address6 != FAILURE) {
                                elements2.add(address6)
                                --remaining1
                            }
                        }
                        if (remaining1 <= 0) {
                            address5 = TreeNode(input.substring(index4, offset), index4, elements2)
                            offset = offset
                        } else {
                            address5 = FAILURE
                        }
                        if (address5 != FAILURE) {
                            elements0.add(3, address5)
                            var address = FAILURE
                            var chunk = null
                            if (offset < inputSize) {
                                chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk1 != null && chunk1.equals(")")) {
                                address7 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address7 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("\")\"")
                                }
                            }
                            if (address7 != FAILURE) {
                                elements0.add(4, address7)
                            } else {
                                elements0 = null
                                offset = index2
                            }
                        } else {
                            elements0 = null
                            offset = index2
                        }
                    } else {
                        elements0 = null
                        offset = index2
                    }
                } else {
                    elements0 = null
                    offset = index2
                }
            } else {
                elements0 = null
                offset = index2
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode10(input.substring(index2, offset), index2, elements0)
                offset = offset
            }
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_sequence_expression()
                if (address0 == FAILURE) {
                    offset = index1
                    address0 = _read_repeated_atom()
                    if (address0 == FAILURE) {
                        offset = index1
                        address0 = _read_terminal_node()
                        if (address0 == FAILURE) {
                            offset = index1
                        }
                    }
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_action_tag(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.action_tag]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.action_tag] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("%")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"%\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_identifier()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode11(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_type_tag(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.type_tag]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.type_tag] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("<")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"<\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_object_identifier()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && chunk1.equals(">")) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\">\"")
                        }
                    }
                    if (address3 != FAILURE) {
                        elements0.add(2, address3)
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode12(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_sequence_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.sequence_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.sequence_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_sequence_part()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 1
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address5 != FAILURE) {
                        address5 = _read___()
                        if (address5 != FAILURE) {
                            elements3.add(address5)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address4 = TreeNode(input.substring(index4, offset), index4, elements3)
                        offset = offset
                    } else {
                        address4 = FAILURE
                    }
                    if (address4 != FAILURE) {
                        elements2.add(0, address4)
                        var address = FAILURE
                        address6 = _read_sequence_part()
                        if (address6 != FAILURE) {
                            elements2.add(1, address6)
                        } else {
                            elements2 = null
                            offset = index3
                        }
                    } else {
                        elements2 = null
                        offset = index3
                    }
                    if (elements2 == null) {
                        address3 = FAILURE
                    } else {
                        address3 = TreeNode14(input.substring(index3, offset), index3, elements2)
                        offset = offset
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode13(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_sequence_part(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.sequence_part]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.sequence_part] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var index = offset
            address1 = _read_label()
            if (address1 == FAILURE) {
                address1 = TreeNode(input.substring(index2, index2), index2)
                offset = index2
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                address2 = _read_maybe_atom()
                if (address2 == FAILURE) {
                    offset = index3
                    address2 = _read_repeated_atom()
                    if (address2 == FAILURE) {
                        offset = index3
                        address2 = _read_atom()
                        if (address2 == FAILURE) {
                            offset = index3
                        }
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode15(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_maybe_atom(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.maybe_atom]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.maybe_atom] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_atom()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk0 != null && chunk0.equals("?")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"?\"")
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode16(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_repeated_atom(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.repeated_atom]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.repeated_atom] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_atom()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                var chunk = null
                if (offset < inputSize) {
                    chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk0 != null && chunk0.equals("*")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"*\"")
                    }
                }
                if (address2 == FAILURE) {
                    offset = index2
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && chunk1.equals("+")) {
                        address2 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address2 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\"+\"")
                        }
                    }
                    if (address2 == FAILURE) {
                        offset = index2
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode17(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_atom(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.atom]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.atom] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            address0 = _read_parenthesised_expression()
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_predicated_atom()
                if (address0 == FAILURE) {
                    offset = index1
                    address0 = _read_reference_expression()
                    if (address0 == FAILURE) {
                        offset = index1
                        address0 = _read_terminal_node()
                        if (address0 == FAILURE) {
                            offset = index1
                        }
                    }
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_terminal_node(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.terminal_node]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.terminal_node] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            address0 = _read_string_expression()
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_ci_string_expression()
                if (address0 == FAILURE) {
                    offset = index1
                    address0 = _read_char_class_expression()
                    if (address0 == FAILURE) {
                        offset = index1
                        address0 = _read_any_char_expression()
                        if (address0 == FAILURE) {
                            offset = index1
                        }
                    }
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_predicated_atom(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.predicated_atom]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.predicated_atom] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var index = offset
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("&")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"&\"")
                }
            }
            if (address1 == FAILURE) {
                offset = index2
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk1 != null && chunk1.equals("!")) {
                    address1 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address1 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"!\"")
                    }
                }
                if (address1 == FAILURE) {
                    offset = index2
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_atom()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode18(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_reference_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.reference_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.reference_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_identifier()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                address2 = _read_assignment()
                offset = index2
                if (address2 == FAILURE) {
                    address2 = TreeNode(input.substring(offset, offset), offset)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode19(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_string_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.string_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.string_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("\"")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("'\"'")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var index = offset
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && chunk1.equals("\\")) {
                        address4 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address4 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\"\\\\\"")
                        }
                    }
                    if (address4 != FAILURE) {
                        elements2.add(0, address4)
                        var address = FAILURE
                        if (offset < inputSize) {
                            address5 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address5 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("<any char>")
                            }
                        }
                        if (address5 != FAILURE) {
                            elements2.add(1, address5)
                        } else {
                            elements2 = null
                            offset = index5
                        }
                    } else {
                        elements2 = null
                        offset = index5
                    }
                    if (elements2 == null) {
                        address3 = FAILURE
                    } else {
                        address3 = TreeNode(input.substring(index5, offset), index5, elements2)
                        offset = offset
                    }
                    if (address3 == FAILURE) {
                        offset = index4
                        var chunk = null
                        if (offset < inputSize) {
                            chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk2 != null && REGEX_1.matcher(chunk2).matches()) {
                            address3 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address3 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("[^\"]")
                            }
                        }
                        if (address3 == FAILURE) {
                            offset = index4
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index3, offset), index3, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk3 != null && chunk3.equals("\"")) {
                        address6 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address6 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("'\"'")
                        }
                    }
                    if (address6 != FAILURE) {
                        elements0.add(2, address6)
                    } else {
                        elements0 = null
                        offset = index2
                    }
                } else {
                    elements0 = null
                    offset = index2
                }
            } else {
                elements0 = null
                offset = index2
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index2, offset), index2, elements0)
                offset = offset
            }
            if (address0 == FAILURE) {
                offset = index1
                var index = offset
                var elements = ArrayList<TreeNode>(3)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk4 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk4 != null && chunk4.equals("'")) {
                    address7 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address7 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"'\"")
                    }
                }
                if (address7 != FAILURE) {
                    elements3.add(0, address7)
                    var address = FAILURE
                    var remaining = 0
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address9 != FAILURE) {
                        var index = offset
                        var index = offset
                        var elements = ArrayList<TreeNode>(2)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk5 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk5 != null && chunk5.equals("\\")) {
                            address10 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address10 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"\\\\\"")
                            }
                        }
                        if (address10 != FAILURE) {
                            elements5.add(0, address10)
                            var address = FAILURE
                            if (offset < inputSize) {
                                address11 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address11 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("<any char>")
                                }
                            }
                            if (address11 != FAILURE) {
                                elements5.add(1, address11)
                            } else {
                                elements5 = null
                                offset = index9
                            }
                        } else {
                            elements5 = null
                            offset = index9
                        }
                        if (elements5 == null) {
                            address9 = FAILURE
                        } else {
                            address9 = TreeNode(input.substring(index9, offset), index9, elements5)
                            offset = offset
                        }
                        if (address9 == FAILURE) {
                            offset = index8
                            var chunk = null
                            if (offset < inputSize) {
                                chunk6 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk6 != null && REGEX_2.matcher(chunk6).matches()) {
                                address9 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address9 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("[^']")
                                }
                            }
                            if (address9 == FAILURE) {
                                offset = index8
                            }
                        }
                        if (address9 != FAILURE) {
                            elements4.add(address9)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address8 = TreeNode(input.substring(index7, offset), index7, elements4)
                        offset = offset
                    } else {
                        address8 = FAILURE
                    }
                    if (address8 != FAILURE) {
                        elements3.add(1, address8)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk7 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk7 != null && chunk7.equals("'")) {
                            address12 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address12 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"'\"")
                            }
                        }
                        if (address12 != FAILURE) {
                            elements3.add(2, address12)
                        } else {
                            elements3 = null
                            offset = index6
                        }
                    } else {
                        elements3 = null
                        offset = index6
                    }
                } else {
                    elements3 = null
                    offset = index6
                }
                if (elements3 == null) {
                    address0 = FAILURE
                } else {
                    address0 = TreeNode(input.substring(index6, offset), index6, elements3)
                    offset = offset
                }
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_ci_string_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.ci_string_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.ci_string_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("`")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"`\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var index = offset
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && chunk1.equals("\\")) {
                        address4 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address4 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\"\\\\\"")
                        }
                    }
                    if (address4 != FAILURE) {
                        elements2.add(0, address4)
                        var address = FAILURE
                        if (offset < inputSize) {
                            address5 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address5 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("<any char>")
                            }
                        }
                        if (address5 != FAILURE) {
                            elements2.add(1, address5)
                        } else {
                            elements2 = null
                            offset = index4
                        }
                    } else {
                        elements2 = null
                        offset = index4
                    }
                    if (elements2 == null) {
                        address3 = FAILURE
                    } else {
                        address3 = TreeNode(input.substring(index4, offset), index4, elements2)
                        offset = offset
                    }
                    if (address3 == FAILURE) {
                        offset = index3
                        var chunk = null
                        if (offset < inputSize) {
                            chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk2 != null && REGEX_3.matcher(chunk2).matches()) {
                            address3 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address3 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("[^`]")
                            }
                        }
                        if (address3 == FAILURE) {
                            offset = index3
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk3 != null && chunk3.equals("`")) {
                        address6 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address6 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\"`\"")
                        }
                    }
                    if (address6 != FAILURE) {
                        elements0.add(2, address6)
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_any_char_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.any_char_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.any_char_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals(".")) {
                address0 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\".\"")
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_char_class_expression(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.char_class_expression]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.char_class_expression] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(4)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("[")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"[\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk1 != null && chunk1.equals("^")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"^\"")
                    }
                }
                if (address2 == FAILURE) {
                    address2 = TreeNode(input.substring(index2, index2), index2)
                    offset = index2
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var remaining = 1
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address4 != FAILURE) {
                        var index = offset
                        var index = offset
                        var elements = ArrayList<TreeNode>(2)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk2 != null && chunk2.equals("\\")) {
                            address5 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address5 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"\\\\\"")
                            }
                        }
                        if (address5 != FAILURE) {
                            elements2.add(0, address5)
                            var address = FAILURE
                            if (offset < inputSize) {
                                address6 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address6 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("<any char>")
                                }
                            }
                            if (address6 != FAILURE) {
                                elements2.add(1, address6)
                            } else {
                                elements2 = null
                                offset = index5
                            }
                        } else {
                            elements2 = null
                            offset = index5
                        }
                        if (elements2 == null) {
                            address4 = FAILURE
                        } else {
                            address4 = TreeNode(input.substring(index5, offset), index5, elements2)
                            offset = offset
                        }
                        if (address4 == FAILURE) {
                            offset = index4
                            var chunk = null
                            if (offset < inputSize) {
                                chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk3 != null && REGEX_4.matcher(chunk3).matches()) {
                                address4 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address4 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("[^\\]]")
                                }
                            }
                            if (address4 == FAILURE) {
                                offset = index4
                            }
                        }
                        if (address4 != FAILURE) {
                            elements1.add(address4)
                            --remaining0
                        }
                    }
                    if (remaining0 <= 0) {
                        address3 = TreeNode(input.substring(index3, offset), index3, elements1)
                        offset = offset
                    } else {
                        address3 = FAILURE
                    }
                    if (address3 != FAILURE) {
                        elements0.add(2, address3)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk4 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk4 != null && chunk4.equals("]")) {
                            address7 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address7 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"]\"")
                            }
                        }
                        if (address7 != FAILURE) {
                            elements0.add(3, address7)
                        } else {
                            elements0 = null
                            offset = index1
                        }
                    } else {
                        elements0 = null
                        offset = index1
                    }
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_label(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.label]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.label] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_identifier()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk0 != null && chunk0.equals(":")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\":\"")
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode20(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_object_identifier(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.object_identifier]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.object_identifier] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            address1 = _read_identifier()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk0 != null && chunk0.equals(".")) {
                        address4 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address4 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\".\"")
                        }
                    }
                    if (address4 != FAILURE) {
                        elements2.add(0, address4)
                        var address = FAILURE
                        address5 = _read_identifier()
                        if (address5 != FAILURE) {
                            elements2.add(1, address5)
                        } else {
                            elements2 = null
                            offset = index3
                        }
                    } else {
                        elements2 = null
                        offset = index3
                    }
                    if (elements2 == null) {
                        address3 = FAILURE
                    } else {
                        address3 = TreeNode22(input.substring(index3, offset), index3, elements2)
                        offset = offset
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode21(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_identifier(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.identifier]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.identifier] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && REGEX_5.matcher(chunk0).matches()) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("[a-zA-Z_]")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && REGEX_6.matcher(chunk1).matches()) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("[a-zA-Z0-9_]")
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read___(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.__]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.__] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && REGEX_7.matcher(chunk0).matches()) {
                address0 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("[\\s]")
                }
            }
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_comment()
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_comment(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.comment]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.comment] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(2)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("#")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"#\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var remaining = 0
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    var chunk = null
                    if (offset < inputSize) {
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && REGEX_8.matcher(chunk1).matches()) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("[^\\n]")
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3)
                        --remaining0
                    }
                }
                if (remaining0 <= 0) {
                    address2 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                } else {
                    elements0 = null
                    offset = index1
                }
            } else {
                elements0 = null
                offset = index1
            }
            if (elements0 == null) {
                address0 = FAILURE
            } else {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }
}
