/**
 * This file was generated from examples/canopy/json.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.json;

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
        Label.__ to elements.get(2)
    ))

class TreeNode2: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.pair to elements.get(1)
    ))

class TreeNode3: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.pair to elements.get(1)
    ))

class TreeNode4: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.__ to elements.get(1)
    ))

class TreeNode5: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.__ to elements.get(2)
        Label.string to elements.get(1)
        Label.value to elements.get(4)
    ))

class TreeNode6: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.value to elements.get(1)
    ))

class TreeNode7: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.value to elements.get(1)
    ))

class TreeNode8: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.__ to elements.get(1)
    ))

class TreeNode9: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.__ to elements.get(2)
    ))
