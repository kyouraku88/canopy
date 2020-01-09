/**
 * This file was generated from examples/canopy/peg.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.peg;

class TreeNode: Iterable<TreeNode>(
    val text = "",
    val offset = 0,
    val elements = mutableListOf<TreeNode>(),
    val labelled = mutableMapOf<Label, TreeNode>()
) {

    fun get(Label key): TreeNode? = labelled[key]

    override fun iterator() = elements.iterator()
}

class TreeNode1: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.grammar_name to elements.get(1)
        Label.rules to elements.get(2)
    ))

class TreeNode2: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.grammar_rule to elements.get(1)
    ))

class TreeNode3: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.object_identifier to elements.get(3)
    ))

class TreeNode4: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(0)
        Label.assignment to elements.get(1)
        Label.parsing_expression to elements.get(2)
    ))

class TreeNode5: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.parsing_expression to elements.get(2)
    ))

class TreeNode6: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.first_part to elements.get(0)
        Label.choice_part to elements.get(0)
        Label.rest to elements.get(1)
    ))

class TreeNode7: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.expression to elements.get(3)
        Label.choice_part to elements.get(3)
    ))

class TreeNode8: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.type_tag to elements.get(1)
    ))

class TreeNode9: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.actionable_expression to elements.get(0)
        Label.action_tag to elements.get(2)
    ))

class TreeNode10: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.actionable_expression to elements.get(2)
    ))

class TreeNode11: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(1)
    ))

class TreeNode12: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.object_identifier to elements.get(1)
    ))

class TreeNode13: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.first_part to elements.get(0)
        Label.sequence_part to elements.get(0)
        Label.rest to elements.get(1)
    ))

class TreeNode14: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.expression to elements.get(1)
        Label.sequence_part to elements.get(1)
    ))

class TreeNode15: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.expression to elements.get(1)
    ))

class TreeNode16: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.atom to elements.get(0)
    ))

class TreeNode17: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.atom to elements.get(0)
        Label.quantifier to elements.get(1)
    ))

class TreeNode18: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.predicate to elements.get(0)
        Label.atom to elements.get(1)
    ))

class TreeNode19: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(0)
    ))

class TreeNode20: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(0)
    ))

class TreeNode21: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(0)
    ))

class TreeNode22: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.identifier to elements.get(1)
    ))
