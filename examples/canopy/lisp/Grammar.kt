/**
 * This file was generated from examples/canopy/lisp.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.lisp;

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

    val REGEX_1 = Pattern.compile("\\A[1-9]")
    val REGEX_2 = Pattern.compile("\\A[0-9]")
    val REGEX_3 = Pattern.compile("\\A[^\"]")
    val REGEX_4 = Pattern.compile("\\A[\\s]")

    fun _read_program(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.program]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.program] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var remaining = 1
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address1 != FAILURE) {
                address1 = _read_cell()
                if (address1 != FAILURE) {
                    elements0.add(address1)
                    --remaining0
                }
            }
            if (remaining0 <= 0) {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            } else {
                address0 = FAILURE
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_cell(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.cell]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.cell] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            var remaining = 0
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address2 != FAILURE) {
                address2 = _read_space()
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
                var index = offset
                address3 = _read_list()
                if (address3 == FAILURE) {
                    offset = index3
                    address3 = _read_atom()
                    if (address3 == FAILURE) {
                        offset = index3
                    }
                }
                if (address3 != FAILURE) {
                    elements0.add(1, address3)
                    var address = FAILURE
                    var remaining = 0
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address5 != FAILURE) {
                        address5 = _read_space()
                        if (address5 != FAILURE) {
                            elements2.add(address5)
                            --remaining1
                        }
                    }
                    if (remaining1 <= 0) {
                        address4 = TreeNode(input.substring(index4, offset), index4, elements2)
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
                address0 = TreeNode1(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_list(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.list]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.list] = rule
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
                var remaining = 1
                var index = offset
                var elements = ArrayList<TreeNode>()
                var address = TreeNode("", -1)
                while (address3 != FAILURE) {
                    address3 = _read_cell()
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
                        chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk1 != null && chunk1.equals(")")) {
                        address4 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address4 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\")\"")
                        }
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
                address0 = TreeNode2(input.substring(index1, offset), index1, elements0)
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
            address0 = _read_boolean_()
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_integer()
                if (address0 == FAILURE) {
                    offset = index1
                    address0 = _read_string()
                    if (address0 == FAILURE) {
                        offset = index1
                        address0 = _read_symbol()
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

    fun _read_boolean_(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.boolean_]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.boolean_] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 2, input.length()))
            }
            if (chunk0 != null && chunk0.equals("#t")) {
                address0 = TreeNode(input.substring(offset, offset + 2), offset)
                offset = offset + 2
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"#t\"")
                }
            }
            if (address0 == FAILURE) {
                offset = index1
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 2, input.length()))
                }
                if (chunk1 != null && chunk1.equals("#f")) {
                    address0 = TreeNode(input.substring(offset, offset + 2), offset)
                    offset = offset + 2
                } else {
                    address0 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"#f\"")
                    }
                }
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_integer(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.integer]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.integer] = rule
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
            if (chunk0 != null && REGEX_1.matcher(chunk0).matches()) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("[1-9]")
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
                    if (chunk1 != null && REGEX_2.matcher(chunk1).matches()) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("[0-9]")
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

    fun _read_string(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.string]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.string] = rule
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
                    expected.add("\"\\\"\"")
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
                                expected.add("[^\"]")
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
                            expected.add("\"\\\"\"")
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

    fun _read_symbol(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.symbol]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.symbol] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var remaining = 1
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address1 != FAILURE) {
                var index = offset
                var elements = ArrayList<TreeNode>(2)
                var address = FAILURE
                var index = offset
                address2 = _read_delimiter()
                offset = index3
                if (address2 == FAILURE) {
                    address2 = TreeNode(input.substring(offset, offset), offset)
                    offset = offset
                } else {
                    address2 = FAILURE
                }
                if (address2 != FAILURE) {
                    elements1.add(0, address2)
                    var address = FAILURE
                    if (offset < inputSize) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("<any char>")
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(1, address3)
                    } else {
                        elements1 = null
                        offset = index2
                    }
                } else {
                    elements1 = null
                    offset = index2
                }
                if (elements1 == null) {
                    address1 = FAILURE
                } else {
                    address1 = TreeNode(input.substring(index2, offset), index2, elements1)
                    offset = offset
                }
                if (address1 != FAILURE) {
                    elements0.add(address1)
                    --remaining0
                }
            }
            if (remaining0 <= 0) {
                address0 = TreeNode(input.substring(index1, offset), index1, elements0)
                offset = offset
            } else {
                address0 = FAILURE
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_space(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.space]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.space] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && REGEX_4.matcher(chunk0).matches()) {
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
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_paren(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.paren]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.paren] = rule
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
            if (chunk0 != null && chunk0.equals("(")) {
                address0 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"(\"")
                }
            }
            if (address0 == FAILURE) {
                offset = index1
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk1 != null && chunk1.equals(")")) {
                    address0 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address0 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\")\"")
                    }
                }
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_delimiter(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.delimiter]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.delimiter] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            address0 = _read_paren()
            if (address0 == FAILURE) {
                offset = index1
                address0 = _read_space()
                if (address0 == FAILURE) {
                    offset = index1
                }
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }
}
