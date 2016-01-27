/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression.impl;

import hu.bme.mit.ftsrg.ptregex.regularExpression.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RegularExpressionFactoryImpl extends EFactoryImpl implements RegularExpressionFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RegularExpressionFactory init()
  {
    try
    {
      RegularExpressionFactory theRegularExpressionFactory = (RegularExpressionFactory)EPackage.Registry.INSTANCE.getEFactory(RegularExpressionPackage.eNS_URI);
      if (theRegularExpressionFactory != null)
      {
        return theRegularExpressionFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RegularExpressionFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularExpressionFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case RegularExpressionPackage.REGEX_MODEL: return createRegexModel();
      case RegularExpressionPackage.ALPHABET: return createAlphabet();
      case RegularExpressionPackage.FUNCTOR: return createFunctor();
      case RegularExpressionPackage.EXPRESSION_DECLARATION: return createExpressionDeclaration();
      case RegularExpressionPackage.EXPRESSION: return createExpression();
      case RegularExpressionPackage.ANY: return createAny();
      case RegularExpressionPackage.INVERSE: return createInverse();
      case RegularExpressionPackage.TIMED_EXPRESSION: return createTimedExpression();
      case RegularExpressionPackage.EVENT: return createEvent();
      case RegularExpressionPackage.PARAMETER: return createParameter();
      case RegularExpressionPackage.FIX_PARAMETER: return createFixParameter();
      case RegularExpressionPackage.FIX_INT_PARAMETER: return createFixIntParameter();
      case RegularExpressionPackage.FIX_STRING_PARAMETER: return createFixStringParameter();
      case RegularExpressionPackage.VAR_PARAMETER: return createVarParameter();
      case RegularExpressionPackage.SINGLETON_PARAMETER: return createSingletonParameter();
      case RegularExpressionPackage.VAR: return createVar();
      case RegularExpressionPackage.CHOICE: return createChoice();
      case RegularExpressionPackage.SEQUENCE: return createSequence();
      case RegularExpressionPackage.STAR: return createStar();
      case RegularExpressionPackage.PLUS: return createPlus();
      case RegularExpressionPackage.CARDINALITY: return createCardinality();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegexModel createRegexModel()
  {
    RegexModelImpl regexModel = new RegexModelImpl();
    return regexModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alphabet createAlphabet()
  {
    AlphabetImpl alphabet = new AlphabetImpl();
    return alphabet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Functor createFunctor()
  {
    FunctorImpl functor = new FunctorImpl();
    return functor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDeclaration createExpressionDeclaration()
  {
    ExpressionDeclarationImpl expressionDeclaration = new ExpressionDeclarationImpl();
    return expressionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Any createAny()
  {
    AnyImpl any = new AnyImpl();
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Inverse createInverse()
  {
    InverseImpl inverse = new InverseImpl();
    return inverse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimedExpression createTimedExpression()
  {
    TimedExpressionImpl timedExpression = new TimedExpressionImpl();
    return timedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixParameter createFixParameter()
  {
    FixParameterImpl fixParameter = new FixParameterImpl();
    return fixParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixIntParameter createFixIntParameter()
  {
    FixIntParameterImpl fixIntParameter = new FixIntParameterImpl();
    return fixIntParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FixStringParameter createFixStringParameter()
  {
    FixStringParameterImpl fixStringParameter = new FixStringParameterImpl();
    return fixStringParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarParameter createVarParameter()
  {
    VarParameterImpl varParameter = new VarParameterImpl();
    return varParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingletonParameter createSingletonParameter()
  {
    SingletonParameterImpl singletonParameter = new SingletonParameterImpl();
    return singletonParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Var createVar()
  {
    VarImpl var = new VarImpl();
    return var;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Choice createChoice()
  {
    ChoiceImpl choice = new ChoiceImpl();
    return choice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence createSequence()
  {
    SequenceImpl sequence = new SequenceImpl();
    return sequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Star createStar()
  {
    StarImpl star = new StarImpl();
    return star;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plus createPlus()
  {
    PlusImpl plus = new PlusImpl();
    return plus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cardinality createCardinality()
  {
    CardinalityImpl cardinality = new CardinalityImpl();
    return cardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularExpressionPackage getRegularExpressionPackage()
  {
    return (RegularExpressionPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RegularExpressionPackage getPackage()
  {
    return RegularExpressionPackage.eINSTANCE;
  }

} //RegularExpressionFactoryImpl
