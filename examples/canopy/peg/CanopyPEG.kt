/**
 * This file was generated from examples/canopy/peg.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.peg;

class CanopyPEG(
    override val input: String,
    override val actions: Actions
): Grammar(
    inputSize = input.length(),
    actions = actions,
    input = input
) {

    private fun formatError(input: String, offset: Int, expected: List<String>): String {
        val lines = input.split("\n")
        var lineNo = 0
        var position = 0
        while (position <= offset) {
            position += lines[lineNo].length() + 1
            lineNo += 1
        }
        var message = "Line $lineNo: expected $expected\n"
        val line = lines[lineNo - 1]
        message += line + "\n"
        position -= line.length() + 1
        while (position < offset) {
            message += " "
            position += 1
        }
        return "$message^"
    }

    @Throws(ParseError::class)
    private fun parse(): TreeNode {
        val tree = _read_grammar()
        if (tree !== FAILURE && offset === inputSize) {
            return tree
        }
        if (expected.isEmpty()) {
            failure = offset
            expected.add("<EOF>")
        }
        throw ParseError(formatError(input, failure, expected))
    }
}
