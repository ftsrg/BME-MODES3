package hu.bme.mit.inf.vepl2ptregex

import hu.bme.mit.inf.parametricTimedRegularExpression.And
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor
import hu.bme.mit.inf.parametricTimedRegularExpression.ParametricTimedRegularExpressionFactory
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence
import java.util.HashMap
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.viatra.cep.vepl.vepl.AndOperator
import org.eclipse.viatra.cep.vepl.vepl.AtLeastOne
import org.eclipse.viatra.cep.vepl.vepl.Atom
import org.eclipse.viatra.cep.vepl.vepl.AtomicEventPattern
import org.eclipse.viatra.cep.vepl.vepl.ComplexEventExpression
import org.eclipse.viatra.cep.vepl.vepl.ComplexEventPattern
import org.eclipse.viatra.cep.vepl.vepl.ContextEnum
import org.eclipse.viatra.cep.vepl.vepl.EventModel
import org.eclipse.viatra.cep.vepl.vepl.FollowsOperator
import org.eclipse.viatra.cep.vepl.vepl.Infinite
import org.eclipse.viatra.cep.vepl.vepl.Multiplicity
import org.eclipse.viatra.cep.vepl.vepl.OrOperator
import org.eclipse.viatra.cep.vepl.vepl.VeplFactory

class VeplCompiler {
	static extension var ParametricTimedRegularExpressionFactory factory = ParametricTimedRegularExpressionFactory.eINSTANCE;
	
	val retvalue = createRegexModel
	val inputEventTrace = new HashMap<AtomicEventPattern,Functor>
	
	new(){
		retvalue.alphabet = createAlphabet
	}
	
	def public RegexModel compile(EventModel input){
		
		println('Building Alphabet')
		input.modelElements.filter[it instanceof AtomicEventPattern].forEach[
			var newFunctor = createFunctor
			newFunctor.name = it.name
			retvalue.alphabet.functors.add(newFunctor)
			inputEventTrace.put(it as AtomicEventPattern, newFunctor)
			println('\tletter added to the alphabet')
		]
		
		println('Compiling Expressions')
		input.modelElements.filter[it instanceof ComplexEventPattern].forEach[

			var newDeclaration = createExpressionDeclaration
			var pattern = it as ComplexEventPattern
			println('expression ' + pattern.name)
			newDeclaration.name = pattern.name
			newDeclaration.body = compileComplexEventExpression(pattern.complexEventExpression, pattern.context)
			retvalue.declarations.add(newDeclaration)
			println('\tdeclaration added')
		]
		
		
		println('Adding Sigma* to the prefix of all patterns')
		
		println('number of lettes = '+ retvalue.alphabet.functors.length)
		println('number of declarations = ' + retvalue.declarations.length)
		
		return retvalue
	}
	
	def compileComplexEventPattern(ComplexEventPattern pattern) {
		return compileComplexEventExpression(pattern.complexEventExpression, pattern.context)
	}
	
	def dispatch Expression compileComplexEventExpression(ComplexEventExpression expression, ContextEnum context) {
		var compiledLeft = compileComplexEventExpression(expression.left, context)
		var notCompiledRight = expression.right.toList
		
		while(notCompiledRight.head != null){
			var rightCompiled = compileComplexEventExpression(notCompiledRight.head.expression, context)
			compiledLeft = operate(compiledLeft, rightCompiled, notCompiledRight.head.operator, context)
			notCompiledRight = notCompiledRight.tail.toList
		}
		
		compiledLeft = compiledLeft.applyUnaryOperators(expression, context)		
		
		return compiledLeft
	}
	
	
	
	def dispatch Expression compileComplexEventExpression(Atom expression, ContextEnum context){
		var Expression retvalue
		if(expression.patternCall.eventPattern instanceof AtomicEventPattern ){
			var newEvent = createEvent
			newEvent.functor = inputEventTrace.get(expression.patternCall.eventPattern as AtomicEventPattern)
			retvalue = newEvent
		}
		else if (expression.patternCall.eventPattern instanceof ComplexEventPattern){
			retvalue = compileComplexEventPattern(expression.patternCall.eventPattern as ComplexEventPattern)
		}
		
		retvalue = retvalue.applyUnaryOperators(expression, context)
		
		return retvalue
	}
	
	def Expression applyUnaryOperators(Expression expression, ComplexEventExpression unaries, ContextEnum context){
		var retvalue = EcoreUtil.copy(expression)
		
		if(unaries.multiplicity != null){
			var multiplicity = unaries.multiplicity
			if(multiplicity instanceof Infinite){
				var star = createStar
				star.body=retvalue
				retvalue = star
			}	
			else if(multiplicity instanceof AtLeastOne){
				var sequence = createSequence
				var star = createStar
				star.body = EcoreUtil.copy(retvalue)
				sequence.elements.add(star)
				retvalue = operate(sequence, EcoreUtil.copy(retvalue), VeplFactory.eINSTANCE.createFollowsOperator, context)
			}
			else if(multiplicity instanceof Multiplicity){
				var sequence = createSequence
				for(var i = 0; i!= multiplicity.value; i++){
					sequence = operate(sequence, EcoreUtil.copy(retvalue), VeplFactory.eINSTANCE.createFollowsOperator, context) as Sequence
				}
				retvalue = sequence
			}
		}
		if(unaries.timewindow != null){
			var timedExpression = createTimedExpression
			timedExpression.body = retvalue
			timedExpression.timeout = unaries.timewindow.length
			retvalue = timedExpression
		}
		if(unaries.negOperator != null){
//			throw new UnsupportedOperationException
			val negated = createNegExpression
			negated.body = retvalue
			retvalue = negated
		}
		
		return retvalue
	}
	
	
	def dispatch Expression operate(Expression left, Expression right, FollowsOperator operator, ContextEnum context) {
		var retvalue = createSequence
		retvalue.elements.add(left)
		if(context == ContextEnum.CHRONICLE){
			var star = createStar
			var anything = createAny
			star.body = anything
			retvalue.elements.add(star)
		}		
		retvalue.elements.add(right)
		return retvalue
	}

	def dispatch Expression operate(Sequence left, Expression right, FollowsOperator operator, ContextEnum context) {
		if(context == ContextEnum.CHRONICLE){
			var star = createStar
			var anything = createAny
			star.body = anything
			left.elements.add(star)
		}		
		left.elements.add(right)
		return left
	}

	def dispatch Expression operate(Expression left, Expression right, OrOperator operator, ContextEnum context) {
		var retvalue = createChoice
		retvalue.elements.add(left)
		retvalue.elements.add(right)
		return retvalue;
	}

	def dispatch Expression operate(Choice left, Expression right, OrOperator operator, ContextEnum context) {
		left.elements.add(right)
		return left
	}
	
	def dispatch Expression operate(Expression left, Expression right, AndOperator operator, ContextEnum context) {
		var retvalue = createAnd
		retvalue.elements.add(left)
		retvalue.elements.add(right)
		return retvalue;
	}

	def dispatch Expression operate(And left, Expression right, AndOperator operator, ContextEnum context) {
		left.elements.add(right)
		return left
	}	
}