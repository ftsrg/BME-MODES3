package hu.bme.mit.inf.ptregex2automaton.tests

import org.junit.Test

class Tests {
	
	@Test
	def test0(){
		TestUtils.testRegex('''
		alphabet = {A}
			expression eventExpression = A''',
		'''
		A *eventExpression
		''')
	}
	
	@Test
	def test10(){
		TestUtils.testRegex('''
		alphabet = {A,B}
			expression sequence = A B
		''','''
		A
		B *sequence
		''')
	}
	
	@Test
	def test1(){
		TestUtils.testRegex('''
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
		TestUtils.testRegex('''
		alphabet = {A,B,C}
		expression expr21 = S* (A | B) | C «/* --- Note that this is same as (S* (A | B)) | C --- */»
		''',
		'''
		C *expr21 A B *expr21 A B *expr21
		''')
	}
	
	@Test
	def andTest(){
		TestUtils.testRegex('''
		alphabet = {A,B,C}
			expression and1 = S* (A & B)
		''','''
			A
			B *and1
			C
			B
			A *and1
			
		''')
	}
	
	@Test
	def andTest2(){
		TestUtils.testRegex('''
			alphabet = {LeftSide, RightSide, Up, Down, Near, Far, NearGround}
				«/* expression and21 = ( (Down Up) & (Near) ) */»
				expression and31 = (LeftSide  RightSide) & (Down  Up)
		''','''
			LeftSide
			Down
			RightSide
			Up *and31
		''')
	}
	
	@Test
	def test3(){
		TestUtils.testVepl('''
			package tabletennis
			
			atomicEvent LeftSide
			atomicEvent RightSide
			atomicEvent Up
			atomicEvent Down
			atomicEvent Near
			atomicEvent Far
			atomicEvent NearGround
			
			complexEvent Bounce(){
				as Down -> Up
				context chronicle
			}
			
			complexEvent TableBounce(){
				as Bounce AND Near
			}
			
			complexEvent Transition(){
				as LeftSide AND RightSide
				context chronicle
			}
			
			complexEvent DoubleBounce(){
				as Bounce -> NOT Transition -> Bounce
				context strict
			}
			
			complexEvent GroundBounce(){
				as NearGround -> Up
				context strict
			}
			
			complexEvent EndGame(){
				as DoubleBounce OR GroundBounce
			}
		''',
		'''
			LeftSide 
			Down
			RightSide *Transition
			Up *Bounce
			Down
			NearGround
			Up *EndGame *GroundBounce
		''')
	}
}