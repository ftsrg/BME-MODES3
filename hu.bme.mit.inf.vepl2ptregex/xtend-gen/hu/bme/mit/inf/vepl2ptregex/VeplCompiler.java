package hu.bme.mit.inf.vepl2ptregex;

import com.google.common.base.Objects;
import hu.bme.mit.inf.parametricTimedRegularExpression.Alphabet;
import hu.bme.mit.inf.parametricTimedRegularExpression.And;
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice;
import hu.bme.mit.inf.parametricTimedRegularExpression.Event;
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression;
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration;
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor;
import hu.bme.mit.inf.parametricTimedRegularExpression.ParametricTimedRegularExpressionFactory;
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel;
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence;
import hu.bme.mit.inf.parametricTimedRegularExpression.Star;
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.cep.vepl.vepl.AbstractMultiplicity;
import org.eclipse.viatra.cep.vepl.vepl.AndOperator;
import org.eclipse.viatra.cep.vepl.vepl.AtLeastOne;
import org.eclipse.viatra.cep.vepl.vepl.Atom;
import org.eclipse.viatra.cep.vepl.vepl.AtomicEventPattern;
import org.eclipse.viatra.cep.vepl.vepl.BinaryOperator;
import org.eclipse.viatra.cep.vepl.vepl.ChainedExpression;
import org.eclipse.viatra.cep.vepl.vepl.ComplexEventExpression;
import org.eclipse.viatra.cep.vepl.vepl.ComplexEventPattern;
import org.eclipse.viatra.cep.vepl.vepl.ContextEnum;
import org.eclipse.viatra.cep.vepl.vepl.EventModel;
import org.eclipse.viatra.cep.vepl.vepl.EventPattern;
import org.eclipse.viatra.cep.vepl.vepl.FollowsOperator;
import org.eclipse.viatra.cep.vepl.vepl.Infinite;
import org.eclipse.viatra.cep.vepl.vepl.ModelElement;
import org.eclipse.viatra.cep.vepl.vepl.Multiplicity;
import org.eclipse.viatra.cep.vepl.vepl.NegOperator;
import org.eclipse.viatra.cep.vepl.vepl.OrOperator;
import org.eclipse.viatra.cep.vepl.vepl.ParameterizedPatternCall;
import org.eclipse.viatra.cep.vepl.vepl.Timewindow;
import org.eclipse.viatra.cep.vepl.vepl.VeplFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class VeplCompiler {
  @Extension
  private static ParametricTimedRegularExpressionFactory factory = ParametricTimedRegularExpressionFactory.eINSTANCE;
  
  private final RegexModel retvalue = VeplCompiler.factory.createRegexModel();
  
  private final HashMap<AtomicEventPattern, Functor> inputEventTrace = new HashMap<AtomicEventPattern, Functor>();
  
  public VeplCompiler() {
    Alphabet _createAlphabet = VeplCompiler.factory.createAlphabet();
    this.retvalue.setAlphabet(_createAlphabet);
  }
  
  public RegexModel compile(final EventModel input) {
    InputOutput.<String>println("Building Alphabet");
    EList<ModelElement> _modelElements = input.getModelElements();
    final Function1<ModelElement, Boolean> _function = (ModelElement it) -> {
      return Boolean.valueOf((it instanceof AtomicEventPattern));
    };
    Iterable<ModelElement> _filter = IterableExtensions.<ModelElement>filter(_modelElements, _function);
    final Consumer<ModelElement> _function_1 = (ModelElement it) -> {
      Functor newFunctor = VeplCompiler.factory.createFunctor();
      String _name = it.getName();
      newFunctor.setName(_name);
      Alphabet _alphabet = this.retvalue.getAlphabet();
      EList<Functor> _functors = _alphabet.getFunctors();
      _functors.add(newFunctor);
      this.inputEventTrace.put(((AtomicEventPattern) it), newFunctor);
      InputOutput.<String>println("\tletter added to the alphabet");
    };
    _filter.forEach(_function_1);
    InputOutput.<String>println("Compiling Expressions");
    EList<ModelElement> _modelElements_1 = input.getModelElements();
    final Function1<ModelElement, Boolean> _function_2 = (ModelElement it) -> {
      return Boolean.valueOf((it instanceof ComplexEventPattern));
    };
    Iterable<ModelElement> _filter_1 = IterableExtensions.<ModelElement>filter(_modelElements_1, _function_2);
    final Consumer<ModelElement> _function_3 = (ModelElement it) -> {
      ExpressionDeclaration newDeclaration = VeplCompiler.factory.createExpressionDeclaration();
      ComplexEventPattern pattern = ((ComplexEventPattern) it);
      String _name = pattern.getName();
      String _plus = ("expression " + _name);
      InputOutput.<String>println(_plus);
      String _name_1 = pattern.getName();
      newDeclaration.setName(_name_1);
      ComplexEventExpression _complexEventExpression = pattern.getComplexEventExpression();
      ContextEnum _context = pattern.getContext();
      Expression _compileComplexEventExpression = this.compileComplexEventExpression(_complexEventExpression, _context);
      newDeclaration.setBody(_compileComplexEventExpression);
      EList<ExpressionDeclaration> _declarations = this.retvalue.getDeclarations();
      _declarations.add(newDeclaration);
      InputOutput.<String>println("\tdeclaration added");
    };
    _filter_1.forEach(_function_3);
    InputOutput.<String>println("Adding Sigma* to the prefix of all patterns");
    Alphabet _alphabet = this.retvalue.getAlphabet();
    EList<Functor> _functors = _alphabet.getFunctors();
    int _length = ((Object[])Conversions.unwrapArray(_functors, Object.class)).length;
    String _plus = ("number of lettes = " + Integer.valueOf(_length));
    InputOutput.<String>println(_plus);
    EList<ExpressionDeclaration> _declarations = this.retvalue.getDeclarations();
    int _length_1 = ((Object[])Conversions.unwrapArray(_declarations, Object.class)).length;
    String _plus_1 = ("number of declarations = " + Integer.valueOf(_length_1));
    InputOutput.<String>println(_plus_1);
    return this.retvalue;
  }
  
  public Expression compileComplexEventPattern(final ComplexEventPattern pattern) {
    ComplexEventExpression _complexEventExpression = pattern.getComplexEventExpression();
    ContextEnum _context = pattern.getContext();
    return this.compileComplexEventExpression(_complexEventExpression, _context);
  }
  
  protected Expression _compileComplexEventExpression(final ComplexEventExpression expression, final ContextEnum context) {
    ComplexEventExpression _left = expression.getLeft();
    Expression compiledLeft = this.compileComplexEventExpression(_left, context);
    EList<ChainedExpression> _right = expression.getRight();
    List<ChainedExpression> notCompiledRight = IterableExtensions.<ChainedExpression>toList(_right);
    while ((!Objects.equal(IterableExtensions.<ChainedExpression>head(notCompiledRight), null))) {
      {
        ChainedExpression _head = IterableExtensions.<ChainedExpression>head(notCompiledRight);
        ComplexEventExpression _expression = _head.getExpression();
        Expression rightCompiled = this.compileComplexEventExpression(_expression, context);
        ChainedExpression _head_1 = IterableExtensions.<ChainedExpression>head(notCompiledRight);
        BinaryOperator _operator = _head_1.getOperator();
        Expression _operate = this.operate(compiledLeft, rightCompiled, _operator, context);
        compiledLeft = _operate;
        Iterable<ChainedExpression> _tail = IterableExtensions.<ChainedExpression>tail(notCompiledRight);
        List<ChainedExpression> _list = IterableExtensions.<ChainedExpression>toList(_tail);
        notCompiledRight = _list;
      }
    }
    Expression _applyUnaryOperators = this.applyUnaryOperators(compiledLeft, expression, context);
    compiledLeft = _applyUnaryOperators;
    return compiledLeft;
  }
  
  protected Expression _compileComplexEventExpression(final Atom expression, final ContextEnum context) {
    Expression retvalue = null;
    ParameterizedPatternCall _patternCall = expression.getPatternCall();
    EventPattern _eventPattern = _patternCall.getEventPattern();
    if ((_eventPattern instanceof AtomicEventPattern)) {
      Event newEvent = VeplCompiler.factory.createEvent();
      ParameterizedPatternCall _patternCall_1 = expression.getPatternCall();
      EventPattern _eventPattern_1 = _patternCall_1.getEventPattern();
      Functor _get = this.inputEventTrace.get(((AtomicEventPattern) _eventPattern_1));
      newEvent.setFunctor(_get);
      retvalue = newEvent;
    } else {
      ParameterizedPatternCall _patternCall_2 = expression.getPatternCall();
      EventPattern _eventPattern_2 = _patternCall_2.getEventPattern();
      if ((_eventPattern_2 instanceof ComplexEventPattern)) {
        ParameterizedPatternCall _patternCall_3 = expression.getPatternCall();
        EventPattern _eventPattern_3 = _patternCall_3.getEventPattern();
        Expression _compileComplexEventPattern = this.compileComplexEventPattern(((ComplexEventPattern) _eventPattern_3));
        retvalue = _compileComplexEventPattern;
      }
    }
    Expression _applyUnaryOperators = this.applyUnaryOperators(retvalue, expression, context);
    retvalue = _applyUnaryOperators;
    return retvalue;
  }
  
  public Expression applyUnaryOperators(final Expression expression, final ComplexEventExpression unaries, final ContextEnum context) {
    Expression retvalue = EcoreUtil.<Expression>copy(expression);
    AbstractMultiplicity _multiplicity = unaries.getMultiplicity();
    boolean _notEquals = (!Objects.equal(_multiplicity, null));
    if (_notEquals) {
      AbstractMultiplicity multiplicity = unaries.getMultiplicity();
      if ((multiplicity instanceof Infinite)) {
        Star star = VeplCompiler.factory.createStar();
        star.setBody(retvalue);
        retvalue = star;
      } else {
        if ((multiplicity instanceof AtLeastOne)) {
          Sequence sequence = VeplCompiler.factory.createSequence();
          Star star_1 = VeplCompiler.factory.createStar();
          Expression _copy = EcoreUtil.<Expression>copy(retvalue);
          star_1.setBody(_copy);
          EList<Expression> _elements = sequence.getElements();
          _elements.add(star_1);
          Expression _copy_1 = EcoreUtil.<Expression>copy(retvalue);
          FollowsOperator _createFollowsOperator = VeplFactory.eINSTANCE.createFollowsOperator();
          Expression _operate = this.operate(sequence, _copy_1, _createFollowsOperator, context);
          retvalue = _operate;
        } else {
          if ((multiplicity instanceof Multiplicity)) {
            Sequence sequence_1 = VeplCompiler.factory.createSequence();
            for (int i = 0; (i != ((Multiplicity)multiplicity).getValue()); i++) {
              Expression _copy_2 = EcoreUtil.<Expression>copy(retvalue);
              FollowsOperator _createFollowsOperator_1 = VeplFactory.eINSTANCE.createFollowsOperator();
              Expression _operate_1 = this.operate(sequence_1, _copy_2, _createFollowsOperator_1, context);
              sequence_1 = ((Sequence) _operate_1);
            }
            retvalue = sequence_1;
          }
        }
      }
    }
    Timewindow _timewindow = unaries.getTimewindow();
    boolean _notEquals_1 = (!Objects.equal(_timewindow, null));
    if (_notEquals_1) {
      TimedExpression timedExpression = VeplCompiler.factory.createTimedExpression();
      timedExpression.setBody(retvalue);
      Timewindow _timewindow_1 = unaries.getTimewindow();
      int _length = _timewindow_1.getLength();
      timedExpression.setTimeout(_length);
    }
    NegOperator _negOperator = unaries.getNegOperator();
    boolean _notEquals_2 = (!Objects.equal(_negOperator, null));
    if (_notEquals_2) {
      throw new UnsupportedOperationException();
    }
    return retvalue;
  }
  
  protected Expression _operate(final Expression left, final Expression right, final FollowsOperator operator, final ContextEnum context) {
    Sequence retvalue = VeplCompiler.factory.createSequence();
    EList<Expression> _elements = retvalue.getElements();
    _elements.add(left);
    boolean _equals = Objects.equal(context, ContextEnum.CHRONICLE);
    if (_equals) {
    }
    EList<Expression> _elements_1 = retvalue.getElements();
    _elements_1.add(right);
    return retvalue;
  }
  
  protected Expression _operate(final Sequence left, final Expression right, final FollowsOperator operator, final ContextEnum context) {
    boolean _equals = Objects.equal(context, ContextEnum.CHRONICLE);
    if (_equals) {
    }
    EList<Expression> _elements = left.getElements();
    _elements.add(right);
    return left;
  }
  
  protected Expression _operate(final Expression left, final Expression right, final OrOperator operator, final ContextEnum context) {
    Choice retvalue = VeplCompiler.factory.createChoice();
    EList<Expression> _elements = retvalue.getElements();
    _elements.add(left);
    EList<Expression> _elements_1 = retvalue.getElements();
    _elements_1.add(right);
    return retvalue;
  }
  
  protected Expression _operate(final Choice left, final Expression right, final OrOperator operator, final ContextEnum context) {
    EList<Expression> _elements = left.getElements();
    _elements.add(right);
    return left;
  }
  
  protected Expression _operate(final Expression left, final Expression right, final AndOperator operator, final ContextEnum context) {
    And retvalue = VeplCompiler.factory.createAnd();
    EList<Expression> _elements = retvalue.getElements();
    _elements.add(left);
    EList<Expression> _elements_1 = retvalue.getElements();
    _elements_1.add(right);
    return retvalue;
  }
  
  protected Expression _operate(final And left, final Expression right, final AndOperator operator, final ContextEnum context) {
    EList<Expression> _elements = left.getElements();
    _elements.add(right);
    return left;
  }
  
  public Expression compileComplexEventExpression(final ComplexEventExpression expression, final ContextEnum context) {
    if (expression instanceof Atom) {
      return _compileComplexEventExpression((Atom)expression, context);
    } else if (expression != null) {
      return _compileComplexEventExpression(expression, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression, context).toString());
    }
  }
  
  public Expression operate(final Expression left, final Expression right, final BinaryOperator operator, final ContextEnum context) {
    if (left instanceof And
         && operator instanceof AndOperator) {
      return _operate((And)left, right, (AndOperator)operator, context);
    } else if (left instanceof Choice
         && operator instanceof OrOperator) {
      return _operate((Choice)left, right, (OrOperator)operator, context);
    } else if (left instanceof Sequence
         && operator instanceof FollowsOperator) {
      return _operate((Sequence)left, right, (FollowsOperator)operator, context);
    } else if (left != null
         && operator instanceof AndOperator) {
      return _operate(left, right, (AndOperator)operator, context);
    } else if (left != null
         && operator instanceof FollowsOperator) {
      return _operate(left, right, (FollowsOperator)operator, context);
    } else if (left != null
         && operator instanceof OrOperator) {
      return _operate(left, right, (OrOperator)operator, context);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right, operator, context).toString());
    }
  }
}
