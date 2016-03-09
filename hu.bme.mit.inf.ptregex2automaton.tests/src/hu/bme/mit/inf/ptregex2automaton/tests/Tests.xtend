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
				expression and31 = (LeftSide  RightSide) & (Down  Up)
		''','''
			LeftSide
			Down
			RightSide
			Up *and31
		''')
	}
	
	@Test(expected = AssertionError)
	def regexCompilationError(){
		TestUtils.testRegex(
		'''
		foo bar qux''',
		'''
		«/* This should be a parsing error which is detected with an assertion */»
		''')
	}
	
	@Test(expected = AssertionError)
	def veplCompilationError(){
		TestUtils.testVepl(
		'''
		foo bar qux''',
		'''
		«/* This should be a compilation error which is detected with an assertion */»
		''')
	}
	
	@Test
	def timerTest(){
		TestUtils.testRegex(
		'''
		alphabet = {A, B}
			expression timed = <(A B)>[1000]
		''',
		'''
		A
		B *timed
		''')
	}
	
	@Test
	def iot(){
		TestUtils.testVepl('''
		package hu.bme.mit.inf.train
		
		atomicEvent TrainsFar(Train1 : int, Train2 : int)
		atomicEvent TrainsNear(Train1 : int, Train2 : int)
		atomicEvent TrainsClose(Train1: int, Train2 : int)
		
		complexEvent Warning(){
			as TrainsFar(t1, t2) -> (TrainsNear(t1,t2) OR TrainsNear(t2,t1))
			context strict
		}
		
		complexEvent Error(){
			as TrainsNear(t1,t2) -> (TrainsClose(t1,t2) OR TrainsClose(t2,t1))
		}
		
		rule ShutDown on Error{
			TrainSystem.shutdown()
		}
		
		rule WarningMsg on Warning{
			System.out.println("WARNING! THE TRAINS ARE TOO CLOSE")
		}''','''
		« /* this is just a compilation test */»
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
				as TableBounce -> NOT Transition -> TableBounce
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