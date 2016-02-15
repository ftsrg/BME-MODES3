package hu.bme.mit.inf.ptregex2automaton.tests

import org.junit.Test

class Tests {
	@Test
	def test1(){
		TestUtils.test('''
		alphabet = {A,B,C}
		expression expr1 = S* A B C
		expression expr2 = S* (A | B | C)
		expression expr3 = S* ((A B) | C)
		''',
		'''
		A *expr2 
		B *expr2 *expr3
		C *expr1 *expr2 *expr3''')
	}	
	
	@Test
	def test2(){
		TestUtils.test('''
		alphabet = {A,B,C}
		expression expr1 = S* (A | B) | C «/* --- Note that this is same as (S* (A | B)) | C --- */»
		''',
		'''
		C *expr1 A B *expr1 A B *expr1
		''')
	}
}