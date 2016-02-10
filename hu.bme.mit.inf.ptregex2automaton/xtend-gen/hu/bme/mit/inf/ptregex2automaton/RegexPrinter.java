package hu.bme.mit.inf.ptregex2automaton;

import hu.bme.mit.inf.parametricTimedRegularExpression.Alphabet;
import hu.bme.mit.inf.parametricTimedRegularExpression.And;
import hu.bme.mit.inf.parametricTimedRegularExpression.Any;
import hu.bme.mit.inf.parametricTimedRegularExpression.Choice;
import hu.bme.mit.inf.parametricTimedRegularExpression.Event;
import hu.bme.mit.inf.parametricTimedRegularExpression.Expression;
import hu.bme.mit.inf.parametricTimedRegularExpression.ExpressionDeclaration;
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor;
import hu.bme.mit.inf.parametricTimedRegularExpression.Inverse;
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel;
import hu.bme.mit.inf.parametricTimedRegularExpression.Sequence;
import hu.bme.mit.inf.parametricTimedRegularExpression.Star;
import hu.bme.mit.inf.parametricTimedRegularExpression.TimedExpression;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RegexPrinter {
  public static String regexToString(final RegexModel input) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Alphabet _alphabet = input.getAlphabet();
      EList<Functor> _functors = _alphabet.getFunctors();
      boolean _hasElements = false;
      for(final Functor letter : _functors) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("alphabet = {", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = letter.getName();
        _builder.append(_name, "");
      }
      if (_hasElements) {
        _builder.append("}", "");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<ExpressionDeclaration> _declarations = input.getDeclarations();
      boolean _hasElements_1 = false;
      for(final ExpressionDeclaration expression : _declarations) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append("expression", "");
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _printExpression = RegexPrinter.printExpression(expression);
        _builder.append(_printExpression, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private static String _printExpression(final ExpressionDeclaration declaration) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = declaration.getName();
    _builder.append(_name, "");
    _builder.append(" = ");
    Expression _body = declaration.getBody();
    String _printExpression = RegexPrinter.printExpression(_body);
    _builder.append(_printExpression, "");
    return _builder.toString();
  }
  
  private static String _printExpression(final TimedExpression timed) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    Expression _body = timed.getBody();
    String _printExpression = RegexPrinter.printExpression(_body);
    _builder.append(_printExpression, "");
    _builder.append(">[");
    int _timeout = timed.getTimeout();
    _builder.append(_timeout, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  private static String _printExpression(final Expression e) {
    Class<? extends Expression> _class = e.getClass();
    String _name = _class.getName();
    String _plus = ("PrintExpression is not valid for class " + _name);
    InputOutput.<String>println(_plus);
    throw new UnsupportedOperationException();
  }
  
  private static String _printExpression(final Any expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("S");
    return _builder.toString();
  }
  
  private static String _printExpression(final Inverse expression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Event> _excludes = expression.getExcludes();
      boolean _hasElements = false;
      for(final Event expr : _excludes) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("(S \\ ", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        Functor _functor = expr.getFunctor();
        String _name = _functor.getName();
        _builder.append(_name, "");
      }
      if (_hasElements) {
        _builder.append(")", "");
      }
    }
    return _builder.toString();
  }
  
  private static String _printExpression(final Event expression) {
    StringConcatenation _builder = new StringConcatenation();
    Functor _functor = expression.getFunctor();
    String _name = _functor.getName();
    _builder.append(_name, "");
    return _builder.toString();
  }
  
  private static String _printExpression(final Sequence expression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _elements = expression.getElements();
      boolean _hasElements = false;
      for(final Expression expr : _elements) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("(", "");
        } else {
          _builder.appendImmediate(" ", "");
        }
        String _printExpression = RegexPrinter.printExpression(expr);
        _builder.append(_printExpression, "");
      }
      if (_hasElements) {
        _builder.append(")", "");
      }
    }
    return _builder.toString();
  }
  
  private static String _printExpression(final Choice expression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _elements = expression.getElements();
      boolean _hasElements = false;
      for(final Expression expr : _elements) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("( ", "");
        } else {
          _builder.appendImmediate(")|(", "");
        }
        String _printExpression = RegexPrinter.printExpression(expr);
        _builder.append(_printExpression, "");
      }
      if (_hasElements) {
        _builder.append(" )", "");
      }
    }
    return _builder.toString();
  }
  
  private static String _printExpression(final And expression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _elements = expression.getElements();
      boolean _hasElements = false;
      for(final Expression expr : _elements) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("(", "");
        } else {
          _builder.appendImmediate(" & ", "");
        }
        String _printExpression = RegexPrinter.printExpression(expr);
        _builder.append(_printExpression, "");
      }
      if (_hasElements) {
        _builder.append(")", "");
      }
    }
    return _builder.toString();
  }
  
  private static String _printExpression(final Star expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Expression _body = expression.getBody();
    String _printExpression = RegexPrinter.printExpression(_body);
    _builder.append(_printExpression, "");
    _builder.append(")*");
    return _builder.toString();
  }
  
  private static String printExpression(final EObject expression) {
    if (expression instanceof And) {
      return _printExpression((And)expression);
    } else if (expression instanceof Any) {
      return _printExpression((Any)expression);
    } else if (expression instanceof Choice) {
      return _printExpression((Choice)expression);
    } else if (expression instanceof Event) {
      return _printExpression((Event)expression);
    } else if (expression instanceof Inverse) {
      return _printExpression((Inverse)expression);
    } else if (expression instanceof Sequence) {
      return _printExpression((Sequence)expression);
    } else if (expression instanceof Star) {
      return _printExpression((Star)expression);
    } else if (expression instanceof TimedExpression) {
      return _printExpression((TimedExpression)expression);
    } else if (expression instanceof Expression) {
      return _printExpression((Expression)expression);
    } else if (expression instanceof ExpressionDeclaration) {
      return _printExpression((ExpressionDeclaration)expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
