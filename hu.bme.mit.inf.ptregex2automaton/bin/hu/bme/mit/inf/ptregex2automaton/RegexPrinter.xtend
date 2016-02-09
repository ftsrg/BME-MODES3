package hu.bme.mit.inf.ptregex2automaton

import hu.bme.mit.inf.parametricTimedRegularExpression.Any
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice
import hu.bme.mit.inf.parametricTimedRegularExpression.Event
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration
import hu.bme.mit.inf.parametricTimedRegularExpression.Inverse
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence
import hu.bme.mit.inf.parametricTimedRegularExpression.Star
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression
import hu.bme.mit.inf.parametricTimedRegularExpression.And

class RegexPrinter {
	def static public String printRegex(RegexModel input) {
		'''
			«FOR letter : input.alphabet.functors BEFORE 'alphabet = {' SEPARATOR ', ' AFTER '}'»«letter.name»«ENDFOR»
			«FOR expression : input.declarations BEFORE 'expression' SEPARATOR '\n'»«printExpression(expression)»«ENDFOR»
		'''
	}

	def static private dispatch String printExpression(ExpressionDeclaration declaration) {
		'''«declaration.name» = «printExpression(declaration.body)»'''
	}

	def static private dispatch String printExpression(TimedExpression timed) {
		'''<«printExpression(timed.body)»>[«timed.timeout»]'''
	}
	
	def static private dispatch String printExpression(Expression e){
		println('PrintExpression is not valid for class ' + e.class.name)
		throw new UnsupportedOperationException
	}
	
	def static private dispatch String printExpression(Any expression) {
		'''S'''
	}

	def static private dispatch String printExpression(Inverse expression) {
		'''«FOR expr : expression.excludes BEFORE '(S \\ ' SEPARATOR ', ' AFTER ')' »«expr.functor.name»«ENDFOR»'''
	}

	def static private dispatch String printExpression(Event expression) {
		'''«expression.functor.name»'''
	}

	def static private dispatch String printExpression(Sequence expression) {
		'''«FOR expr : expression.elements BEFORE '(' SEPARATOR ' ' AFTER ')'»«printExpression(expr)»«ENDFOR»'''
	}

	def static private dispatch String printExpression(Choice expression) {
		'''«FOR expr : expression.elements BEFORE '( ' SEPARATOR ')|(' AFTER ' )'»«printExpression(expr)»«ENDFOR»'''
	}
	
	def static private dispatch String printExpression(And expression){
		'''«FOR expr : expression.elements BEFORE '(' SEPARATOR ' & ' AFTER ')'»«printExpression(expr)»«ENDFOR»'''
	}

	def static private dispatch String printExpression(Star expression) {
		'''(«printExpression(expression.body)»)*'''
	}

}
