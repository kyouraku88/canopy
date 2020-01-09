/**
 * This file was generated from examples/canopy/lisp.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.lisp;

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
        Label.data to elements.get(1)
    ))

class TreeNode2: TreeNode(
    val text: String,
    val offset: Int,
    val elements: List<TreeNode>
    ): TreeNode(text, offset, elements, mapOf(
        Label.cells to elements.get(1)
    ))
