/**
 * This file was generated from examples/canopy/peg.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package examples.canopy.peg;

class ParseError(override val message: String): RuntimeException(message)
