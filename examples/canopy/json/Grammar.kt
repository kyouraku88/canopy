/**
 * This file was generated from examples/canopy/json.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.json;

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
    val REGEX_2 = Pattern.compile("\\A[1-9]")
    val REGEX_3 = Pattern.compile("\\A[0-9]")
    val REGEX_4 = Pattern.compile("\\A[0-9]")
    val REGEX_5 = Pattern.compile("\\A[0-9]")
    val REGEX_6 = Pattern.compile("\\A[\\s]")

    fun _read_document(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.document]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.document] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            address1 = _read___()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                address2 = _read_object()
                if (address2 == FAILURE) {
                    offset = index2
                    address2 = _read_array()
                    if (address2 == FAILURE) {
                        offset = index2
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address3 = _read___()
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
                address0 = TreeNode1(input.substring(index1, offset), index1, elements0)
                offset = offset
            }
            rule[index0] = CacheRecord(address0, offset)
        }
        return address0
    }

    fun _read_object(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.object]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.object] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var index = offset
            var elements = ArrayList<TreeNode>(4)
            var address = FAILURE
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("{")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"{\"")
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_pair()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var remaining = 0
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address4 != FAILURE) {
                        var index = offset
                        var elements = ArrayList<TreeNode>(2)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk1 != null && chunk1.equals(",")) {
                            address5 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address5 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\",\"")
                            }
                        }
                        if (address5 != FAILURE) {
                            elements2.add(0, address5)
                            var address = FAILURE
                            address6 = _read_pair()
                            if (address6 != FAILURE) {
                                elements2.add(1, address6)
                            } else {
                                elements2 = null
                                offset = index4
                            }
                        } else {
                            elements2 = null
                            offset = index4
                        }
                        if (elements2 == null) {
                            address4 = FAILURE
                        } else {
                            address4 = TreeNode3(input.substring(index4, offset), index4, elements2)
                            offset = offset
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
                            chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk2 != null && chunk2.equals("}")) {
                            address7 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address7 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"}\"")
                            }
                        }
                        if (address7 != FAILURE) {
                            elements0.add(3, address7)
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
                address0 = TreeNode2(input.substring(index2, offset), index2, elements0)
                offset = offset
            }
            if (address0 == FAILURE) {
                offset = index1
                var index = offset
                var elements = ArrayList<TreeNode>(3)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk3 != null && chunk3.equals("{")) {
                    address8 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address8 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"{\"")
                    }
                }
                if (address8 != FAILURE) {
                    elements3.add(0, address8)
                    var address = FAILURE
                    address9 = _read___()
                    if (address9 != FAILURE) {
                        elements3.add(1, address9)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk4 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk4 != null && chunk4.equals("}")) {
                            address10 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address10 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"}\"")
                            }
                        }
                        if (address10 != FAILURE) {
                            elements3.add(2, address10)
                        } else {
                            elements3 = null
                            offset = index5
                        }
                    } else {
                        elements3 = null
                        offset = index5
                    }
                } else {
                    elements3 = null
                    offset = index5
                }
                if (elements3 == null) {
                    address0 = FAILURE
                } else {
                    address0 = TreeNode4(input.substring(index5, offset), index5, elements3)
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

    fun _read_pair(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.pair]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.pair] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(5)
            var address = FAILURE
            address1 = _read___()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                address2 = _read_string()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address3 = _read___()
                    if (address3 != FAILURE) {
                        elements0.add(2, address3)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk0 != null && chunk0.equals(":")) {
                            address4 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address4 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\":\"")
                            }
                        }
                        if (address4 != FAILURE) {
                            elements0.add(3, address4)
                            var address = FAILURE
                            address5 = _read_value()
                            if (address5 != FAILURE) {
                                elements0.add(4, address5)
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

    fun _read_array(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.array]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.array] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
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
                address2 = _read_value()
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var remaining = 0
                    var index = offset
                    var elements = ArrayList<TreeNode>()
                    var address = TreeNode("", -1)
                    while (address4 != FAILURE) {
                        var index = offset
                        var elements = ArrayList<TreeNode>(2)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk1 != null && chunk1.equals(",")) {
                            address5 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address5 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\",\"")
                            }
                        }
                        if (address5 != FAILURE) {
                            elements2.add(0, address5)
                            var address = FAILURE
                            address6 = _read_value()
                            if (address6 != FAILURE) {
                                elements2.add(1, address6)
                            } else {
                                elements2 = null
                                offset = index4
                            }
                        } else {
                            elements2 = null
                            offset = index4
                        }
                        if (elements2 == null) {
                            address4 = FAILURE
                        } else {
                            address4 = TreeNode7(input.substring(index4, offset), index4, elements2)
                            offset = offset
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
                            chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk2 != null && chunk2.equals("]")) {
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
                address0 = TreeNode6(input.substring(index2, offset), index2, elements0)
                offset = offset
            }
            if (address0 == FAILURE) {
                offset = index1
                var index = offset
                var elements = ArrayList<TreeNode>(3)
                var address = FAILURE
                var chunk = null
                if (offset < inputSize) {
                    chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk3 != null && chunk3.equals("[")) {
                    address8 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address8 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"[\"")
                    }
                }
                if (address8 != FAILURE) {
                    elements3.add(0, address8)
                    var address = FAILURE
                    address9 = _read___()
                    if (address9 != FAILURE) {
                        elements3.add(1, address9)
                        var address = FAILURE
                        var chunk = null
                        if (offset < inputSize) {
                            chunk4 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk4 != null && chunk4.equals("]")) {
                            address10 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address10 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"]\"")
                            }
                        }
                        if (address10 != FAILURE) {
                            elements3.add(2, address10)
                        } else {
                            elements3 = null
                            offset = index5
                        }
                    } else {
                        elements3 = null
                        offset = index5
                    }
                } else {
                    elements3 = null
                    offset = index5
                }
                if (elements3 == null) {
                    address0 = FAILURE
                } else {
                    address0 = TreeNode8(input.substring(index5, offset), index5, elements3)
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

    fun _read_value(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.value]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.value] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(3)
            var address = FAILURE
            address1 = _read___()
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                address2 = _read_object()
                if (address2 == FAILURE) {
                    offset = index2
                    address2 = _read_array()
                    if (address2 == FAILURE) {
                        offset = index2
                        address2 = _read_string()
                        if (address2 == FAILURE) {
                            offset = index2
                            address2 = _read_number()
                            if (address2 == FAILURE) {
                                offset = index2
                                address2 = _read_boolean_()
                                if (address2 == FAILURE) {
                                    offset = index2
                                    address2 = _read_null_()
                                    if (address2 == FAILURE) {
                                        offset = index2
                                    }
                                }
                            }
                        }
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    address3 = _read___()
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
                address0 = TreeNode9(input.substring(index1, offset), index1, elements0)
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
                            expected.add("'\"'")
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

    fun _read_number(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.number]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.number] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var index = offset
            var elements = ArrayList<TreeNode>(4)
            var address = FAILURE
            var index = offset
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
            }
            if (chunk0 != null && chunk0.equals("-")) {
                address1 = TreeNode(input.substring(offset, offset + 1), offset)
                offset = offset + 1
            } else {
                address1 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"-\"")
                }
            }
            if (address1 == FAILURE) {
                address1 = TreeNode(input.substring(index2, index2), index2)
                offset = index2
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1)
                var address = FAILURE
                var index = offset
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk1 != null && chunk1.equals("0")) {
                    address2 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address2 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"0\"")
                    }
                }
                if (address2 == FAILURE) {
                    offset = index3
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk2 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk2 != null && REGEX_2.matcher(chunk2).matches()) {
                        address3 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address3 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("[1-9]")
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(0, address3)
                        var address = FAILURE
                        var remaining = 0
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address5 != FAILURE) {
                            var chunk = null
                            if (offset < inputSize) {
                                chunk3 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk3 != null && REGEX_3.matcher(chunk3).matches()) {
                                address5 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address5 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("[0-9]")
                                }
                            }
                            if (address5 != FAILURE) {
                                elements2.add(address5)
                                --remaining0
                            }
                        }
                        if (remaining0 <= 0) {
                            address4 = TreeNode(input.substring(index5, offset), index5, elements2)
                            offset = offset
                        } else {
                            address4 = FAILURE
                        }
                        if (address4 != FAILURE) {
                            elements1.add(1, address4)
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
                        address2 = TreeNode(input.substring(index4, offset), index4, elements1)
                        offset = offset
                    }
                    if (address2 == FAILURE) {
                        offset = index3
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2)
                    var address = FAILURE
                    var index = offset
                    var index = offset
                    var elements = ArrayList<TreeNode>(2)
                    var address = FAILURE
                    var chunk = null
                    if (offset < inputSize) {
                        chunk4 = input.substring(offset, Math.min(offset + 1, input.length()))
                    }
                    if (chunk4 != null && chunk4.equals(".")) {
                        address7 = TreeNode(input.substring(offset, offset + 1), offset)
                        offset = offset + 1
                    } else {
                        address7 = FAILURE
                        if (offset > failure) {
                            failure = offset
                            expected = ArrayList<String>()
                        }
                        if (offset == failure) {
                            expected.add("\".\"")
                        }
                    }
                    if (address7 != FAILURE) {
                        elements3.add(0, address7)
                        var address = FAILURE
                        var remaining = 1
                        var index = offset
                        var elements = ArrayList<TreeNode>()
                        var address = TreeNode("", -1)
                        while (address9 != FAILURE) {
                            var chunk = null
                            if (offset < inputSize) {
                                chunk5 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk5 != null && REGEX_4.matcher(chunk5).matches()) {
                                address9 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address9 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("[0-9]")
                                }
                            }
                            if (address9 != FAILURE) {
                                elements4.add(address9)
                                --remaining1
                            }
                        }
                        if (remaining1 <= 0) {
                            address8 = TreeNode(input.substring(index8, offset), index8, elements4)
                            offset = offset
                        } else {
                            address8 = FAILURE
                        }
                        if (address8 != FAILURE) {
                            elements3.add(1, address8)
                        } else {
                            elements3 = null
                            offset = index7
                        }
                    } else {
                        elements3 = null
                        offset = index7
                    }
                    if (elements3 == null) {
                        address6 = FAILURE
                    } else {
                        address6 = TreeNode(input.substring(index7, offset), index7, elements3)
                        offset = offset
                    }
                    if (address6 == FAILURE) {
                        address6 = TreeNode(input.substring(index6, index6), index6)
                        offset = index6
                    }
                    if (address6 != FAILURE) {
                        elements0.add(2, address6)
                        var address = FAILURE
                        var index = offset
                        var index = offset
                        var elements = ArrayList<TreeNode>(3)
                        var address = FAILURE
                        var index = offset
                        var chunk = null
                        if (offset < inputSize) {
                            chunk6 = input.substring(offset, Math.min(offset + 1, input.length()))
                        }
                        if (chunk6 != null && chunk6.equals("e")) {
                            address11 = TreeNode(input.substring(offset, offset + 1), offset)
                            offset = offset + 1
                        } else {
                            address11 = FAILURE
                            if (offset > failure) {
                                failure = offset
                                expected = ArrayList<String>()
                            }
                            if (offset == failure) {
                                expected.add("\"e\"")
                            }
                        }
                        if (address11 == FAILURE) {
                            offset = index11
                            var chunk = null
                            if (offset < inputSize) {
                                chunk7 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk7 != null && chunk7.equals("E")) {
                                address11 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address11 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("\"E\"")
                                }
                            }
                            if (address11 == FAILURE) {
                                offset = index11
                            }
                        }
                        if (address11 != FAILURE) {
                            elements5.add(0, address11)
                            var address = FAILURE
                            var index = offset
                            var chunk = null
                            if (offset < inputSize) {
                                chunk8 = input.substring(offset, Math.min(offset + 1, input.length()))
                            }
                            if (chunk8 != null && chunk8.equals("+")) {
                                address12 = TreeNode(input.substring(offset, offset + 1), offset)
                                offset = offset + 1
                            } else {
                                address12 = FAILURE
                                if (offset > failure) {
                                    failure = offset
                                    expected = ArrayList<String>()
                                }
                                if (offset == failure) {
                                    expected.add("\"+\"")
                                }
                            }
                            if (address12 == FAILURE) {
                                offset = index12
                                var chunk = null
                                if (offset < inputSize) {
                                    chunk9 = input.substring(offset, Math.min(offset + 1, input.length()))
                                }
                                if (chunk9 != null && chunk9.equals("-")) {
                                    address12 = TreeNode(input.substring(offset, offset + 1), offset)
                                    offset = offset + 1
                                } else {
                                    address12 = FAILURE
                                    if (offset > failure) {
                                        failure = offset
                                        expected = ArrayList<String>()
                                    }
                                    if (offset == failure) {
                                        expected.add("\"-\"")
                                    }
                                }
                                if (address12 == FAILURE) {
                                    offset = index12
                                    var chunk = null
                                    if (offset < inputSize) {
                                        chunk10 = input.substring(offset, Math.min(offset + 0, input.length()))
                                    }
                                    if (chunk10 != null && chunk10.equals("")) {
                                        address12 = TreeNode(input.substring(offset, offset + 0), offset)
                                        offset = offset + 0
                                    } else {
                                        address12 = FAILURE
                                        if (offset > failure) {
                                            failure = offset
                                            expected = ArrayList<String>()
                                        }
                                        if (offset == failure) {
                                            expected.add("\"\"")
                                        }
                                    }
                                    if (address12 == FAILURE) {
                                        offset = index12
                                    }
                                }
                            }
                            if (address12 != FAILURE) {
                                elements5.add(1, address12)
                                var address = FAILURE
                                var remaining = 1
                                var index = offset
                                var elements = ArrayList<TreeNode>()
                                var address = TreeNode("", -1)
                                while (address14 != FAILURE) {
                                    var chunk = null
                                    if (offset < inputSize) {
                                        chunk11 = input.substring(offset, Math.min(offset + 1, input.length()))
                                    }
                                    if (chunk11 != null && REGEX_5.matcher(chunk11).matches()) {
                                        address14 = TreeNode(input.substring(offset, offset + 1), offset)
                                        offset = offset + 1
                                    } else {
                                        address14 = FAILURE
                                        if (offset > failure) {
                                            failure = offset
                                            expected = ArrayList<String>()
                                        }
                                        if (offset == failure) {
                                            expected.add("[0-9]")
                                        }
                                    }
                                    if (address14 != FAILURE) {
                                        elements6.add(address14)
                                        --remaining2
                                    }
                                }
                                if (remaining2 <= 0) {
                                    address13 = TreeNode(input.substring(index13, offset), index13, elements6)
                                    offset = offset
                                } else {
                                    address13 = FAILURE
                                }
                                if (address13 != FAILURE) {
                                    elements5.add(2, address13)
                                } else {
                                    elements5 = null
                                    offset = index10
                                }
                            } else {
                                elements5 = null
                                offset = index10
                            }
                        } else {
                            elements5 = null
                            offset = index10
                        }
                        if (elements5 == null) {
                            address10 = FAILURE
                        } else {
                            address10 = TreeNode(input.substring(index10, offset), index10, elements5)
                            offset = offset
                        }
                        if (address10 == FAILURE) {
                            address10 = TreeNode(input.substring(index9, index9), index9)
                            offset = index9
                        }
                        if (address10 != FAILURE) {
                            elements0.add(3, address10)
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
                chunk0 = input.substring(offset, Math.min(offset + 4, input.length()))
            }
            if (chunk0 != null && chunk0.equals("true")) {
                address0 = TreeNode(input.substring(offset, offset + 4), offset)
                offset = offset + 4
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"true\"")
                }
            }
            if (address0 == FAILURE) {
                offset = index1
                var chunk = null
                if (offset < inputSize) {
                    chunk1 = input.substring(offset, Math.min(offset + 5, input.length()))
                }
                if (chunk1 != null && chunk1.equals("false")) {
                    address0 = TreeNode(input.substring(offset, offset + 5), offset)
                    offset = offset + 5
                } else {
                    address0 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("\"false\"")
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

    fun _read_null_(): TreeNode {
        var address = FAILURE
        var index = offset
        val rule = cache[Label.null_]
        if (rule == null) {
            rule = mutableMapOf<Integer, CacheRecord>()
            cache[Label.null_] = rule
        }
        if (offset in rule) {
            address0 = rule[offset].node
            offset = rule[offset].tail
        } else {
            var chunk = null
            if (offset < inputSize) {
                chunk0 = input.substring(offset, Math.min(offset + 4, input.length()))
            }
            if (chunk0 != null && chunk0.equals("null")) {
                address0 = TreeNode(input.substring(offset, offset + 4), offset)
                offset = offset + 4
            } else {
                address0 = FAILURE
                if (offset > failure) {
                    failure = offset
                    expected = ArrayList<String>()
                }
                if (offset == failure) {
                    expected.add("\"null\"")
                }
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
            var remaining = 0
            var index = offset
            var elements = ArrayList<TreeNode>()
            var address = TreeNode("", -1)
            while (address1 != FAILURE) {
                var chunk = null
                if (offset < inputSize) {
                    chunk0 = input.substring(offset, Math.min(offset + 1, input.length()))
                }
                if (chunk0 != null && REGEX_6.matcher(chunk0).matches()) {
                    address1 = TreeNode(input.substring(offset, offset + 1), offset)
                    offset = offset + 1
                } else {
                    address1 = FAILURE
                    if (offset > failure) {
                        failure = offset
                        expected = ArrayList<String>()
                    }
                    if (offset == failure) {
                        expected.add("[\\s]")
                    }
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
}
