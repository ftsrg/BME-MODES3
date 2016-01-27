package hu.bme.mit.ftsrg.ptregex

import java.util.LinkedList

class RegexTest {
	def public static void main(String[] input) {
		var left = new LinkedList<Integer>
		var right = new LinkedList<Integer>
		left.add(1)
		left.add(2)
		left.add(3)
		left.add(4)

		right.add(10)
		right.add(11)

//		println(RegexCompiler.generatePerm(left, right).length)
		RegexCompiler.generatePerm(left, right).forEach [
			it.forEach[print(it) print(', ')]
			println
		]

	}
}
