/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface RegularExpressionPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "regularExpression";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.bme.hu/mit/ftsrg/ptregex/RegularExpression";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "regularExpression";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RegularExpressionPackage eINSTANCE = hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl.init();

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl <em>Regex Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getRegexModel()
   * @generated
   */
  int REGEX_MODEL = 0;

  /**
   * The feature id for the '<em><b>Alphabet</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGEX_MODEL__ALPHABET = 0;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGEX_MODEL__DECLARATIONS = 1;

  /**
   * The number of structural features of the '<em>Regex Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGEX_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AlphabetImpl <em>Alphabet</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AlphabetImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getAlphabet()
   * @generated
   */
  int ALPHABET = 1;

  /**
   * The feature id for the '<em><b>Functors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHABET__FUNCTORS = 0;

  /**
   * The number of structural features of the '<em>Alphabet</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHABET_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FunctorImpl <em>Functor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FunctorImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFunctor()
   * @generated
   */
  int FUNCTOR = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Arity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTOR__ARITY = 1;

  /**
   * The number of structural features of the '<em>Functor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionDeclarationImpl <em>Expression Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionDeclarationImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getExpressionDeclaration()
   * @generated
   */
  int EXPRESSION_DECLARATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Vars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_DECLARATION__VARS = 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_DECLARATION__BODY = 2;

  /**
   * The number of structural features of the '<em>Expression Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 4;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AnyImpl <em>Any</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AnyImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getAny()
   * @generated
   */
  int ANY = 5;

  /**
   * The number of structural features of the '<em>Any</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.InverseImpl <em>Inverse</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.InverseImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getInverse()
   * @generated
   */
  int INVERSE = 6;

  /**
   * The feature id for the '<em><b>Excludes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERSE__EXCLUDES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inverse</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVERSE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.TimedExpressionImpl <em>Timed Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.TimedExpressionImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getTimedExpression()
   * @generated
   */
  int TIMED_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION__TIMEOUT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Timed Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.EventImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 8;

  /**
   * The feature id for the '<em><b>Functor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__FUNCTOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT__PARAMETERS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 9;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixParameterImpl <em>Fix Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixParameter()
   * @generated
   */
  int FIX_PARAMETER = 10;

  /**
   * The number of structural features of the '<em>Fix Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIX_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixIntParameterImpl <em>Fix Int Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixIntParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixIntParameter()
   * @generated
   */
  int FIX_INT_PARAMETER = 11;

  /**
   * The feature id for the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIX_INT_PARAMETER__BODY = FIX_PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fix Int Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIX_INT_PARAMETER_FEATURE_COUNT = FIX_PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixStringParameterImpl <em>Fix String Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixStringParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixStringParameter()
   * @generated
   */
  int FIX_STRING_PARAMETER = 12;

  /**
   * The feature id for the '<em><b>Body</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIX_STRING_PARAMETER__BODY = FIX_PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fix String Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIX_STRING_PARAMETER_FEATURE_COUNT = FIX_PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarParameterImpl <em>Var Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getVarParameter()
   * @generated
   */
  int VAR_PARAMETER = 13;

  /**
   * The feature id for the '<em><b>Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_PARAMETER__VAR = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Var Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SingletonParameterImpl <em>Singleton Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SingletonParameterImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getSingletonParameter()
   * @generated
   */
  int SINGLETON_PARAMETER = 14;

  /**
   * The number of structural features of the '<em>Singleton Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarImpl <em>Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getVar()
   * @generated
   */
  int VAR = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR__NAME = 0;

  /**
   * The number of structural features of the '<em>Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ChoiceImpl <em>Choice</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ChoiceImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getChoice()
   * @generated
   */
  int CHOICE = 16;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Choice</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SequenceImpl <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SequenceImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 17;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__ELEMENTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.StarImpl <em>Star</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.StarImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getStar()
   * @generated
   */
  int STAR = 18;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAR__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Star</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.PlusImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 19;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.CardinalityImpl <em>Cardinality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.CardinalityImpl
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getCardinality()
   * @generated
   */
  int CARDINALITY = 20;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY__BODY = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY__N = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cardinality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CARDINALITY_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel <em>Regex Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Regex Model</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel
   * @generated
   */
  EClass getRegexModel();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getAlphabet <em>Alphabet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Alphabet</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getAlphabet()
   * @see #getRegexModel()
   * @generated
   */
  EReference getRegexModel_Alphabet();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getDeclarations <em>Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Declarations</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getDeclarations()
   * @see #getRegexModel()
   * @generated
   */
  EReference getRegexModel_Declarations();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet <em>Alphabet</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alphabet</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet
   * @generated
   */
  EClass getAlphabet();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet#getFunctors <em>Functors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functors</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet#getFunctors()
   * @see #getAlphabet()
   * @generated
   */
  EReference getAlphabet_Functors();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Functor <em>Functor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Functor</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Functor
   * @generated
   */
  EClass getFunctor();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Functor#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Functor#getName()
   * @see #getFunctor()
   * @generated
   */
  EAttribute getFunctor_Name();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Functor#getArity <em>Arity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Arity</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Functor#getArity()
   * @see #getFunctor()
   * @generated
   */
  EAttribute getFunctor_Arity();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration <em>Expression Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Declaration</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration
   * @generated
   */
  EClass getExpressionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getName()
   * @see #getExpressionDeclaration()
   * @generated
   */
  EAttribute getExpressionDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getVars <em>Vars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vars</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getVars()
   * @see #getExpressionDeclaration()
   * @generated
   */
  EReference getExpressionDeclaration_Vars();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration#getBody()
   * @see #getExpressionDeclaration()
   * @generated
   */
  EReference getExpressionDeclaration_Body();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Any <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Any
   * @generated
   */
  EClass getAny();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse <em>Inverse</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inverse</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse
   * @generated
   */
  EClass getInverse();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse#getExcludes <em>Excludes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Excludes</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse#getExcludes()
   * @see #getInverse()
   * @generated
   */
  EReference getInverse_Excludes();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression <em>Timed Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timed Expression</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression
   * @generated
   */
  EClass getTimedExpression();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression#getBody()
   * @see #getTimedExpression()
   * @generated
   */
  EReference getTimedExpression_Body();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression#getTimeout()
   * @see #getTimedExpression()
   * @generated
   */
  EAttribute getTimedExpression_Timeout();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getFunctor <em>Functor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Functor</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getFunctor()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_Functor();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Event#getParameters()
   * @see #getEvent()
   * @generated
   */
  EReference getEvent_Parameters();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.FixParameter <em>Fix Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fix Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.FixParameter
   * @generated
   */
  EClass getFixParameter();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.FixIntParameter <em>Fix Int Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fix Int Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.FixIntParameter
   * @generated
   */
  EClass getFixIntParameter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.FixIntParameter#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.FixIntParameter#getBody()
   * @see #getFixIntParameter()
   * @generated
   */
  EAttribute getFixIntParameter_Body();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.FixStringParameter <em>Fix String Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fix String Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.FixStringParameter
   * @generated
   */
  EClass getFixStringParameter();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.FixStringParameter#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.FixStringParameter#getBody()
   * @see #getFixStringParameter()
   * @generated
   */
  EAttribute getFixStringParameter_Body();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.VarParameter <em>Var Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.VarParameter
   * @generated
   */
  EClass getVarParameter();

  /**
   * Returns the meta object for the reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.VarParameter#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.VarParameter#getVar()
   * @see #getVarParameter()
   * @generated
   */
  EReference getVarParameter_Var();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.SingletonParameter <em>Singleton Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Singleton Parameter</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.SingletonParameter
   * @generated
   */
  EClass getSingletonParameter();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Var <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Var
   * @generated
   */
  EClass getVar();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Var#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Var#getName()
   * @see #getVar()
   * @generated
   */
  EAttribute getVar_Name();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Choice <em>Choice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Choice
   * @generated
   */
  EClass getChoice();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Choice#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Choice#getElements()
   * @see #getChoice()
   * @generated
   */
  EReference getChoice_Elements();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for the containment reference list '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence#getElements()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Elements();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Star <em>Star</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Star</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Star
   * @generated
   */
  EClass getStar();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Star#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Star#getBody()
   * @see #getStar()
   * @generated
   */
  EReference getStar_Body();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Plus#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Plus#getBody()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Body();

  /**
   * Returns the meta object for class '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cardinality</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality
   * @generated
   */
  EClass getCardinality();

  /**
   * Returns the meta object for the containment reference '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality#getBody()
   * @see #getCardinality()
   * @generated
   */
  EReference getCardinality_Body();

  /**
   * Returns the meta object for the attribute '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality#getN <em>N</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>N</em>'.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality#getN()
   * @see #getCardinality()
   * @generated
   */
  EAttribute getCardinality_N();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RegularExpressionFactory getRegularExpressionFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl <em>Regex Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getRegexModel()
     * @generated
     */
    EClass REGEX_MODEL = eINSTANCE.getRegexModel();

    /**
     * The meta object literal for the '<em><b>Alphabet</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGEX_MODEL__ALPHABET = eINSTANCE.getRegexModel_Alphabet();

    /**
     * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGEX_MODEL__DECLARATIONS = eINSTANCE.getRegexModel_Declarations();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AlphabetImpl <em>Alphabet</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AlphabetImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getAlphabet()
     * @generated
     */
    EClass ALPHABET = eINSTANCE.getAlphabet();

    /**
     * The meta object literal for the '<em><b>Functors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALPHABET__FUNCTORS = eINSTANCE.getAlphabet_Functors();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FunctorImpl <em>Functor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FunctorImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFunctor()
     * @generated
     */
    EClass FUNCTOR = eINSTANCE.getFunctor();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTOR__NAME = eINSTANCE.getFunctor_Name();

    /**
     * The meta object literal for the '<em><b>Arity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTOR__ARITY = eINSTANCE.getFunctor_Arity();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionDeclarationImpl <em>Expression Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionDeclarationImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getExpressionDeclaration()
     * @generated
     */
    EClass EXPRESSION_DECLARATION = eINSTANCE.getExpressionDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_DECLARATION__NAME = eINSTANCE.getExpressionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Vars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_DECLARATION__VARS = eINSTANCE.getExpressionDeclaration_Vars();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_DECLARATION__BODY = eINSTANCE.getExpressionDeclaration_Body();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ExpressionImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AnyImpl <em>Any</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.AnyImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getAny()
     * @generated
     */
    EClass ANY = eINSTANCE.getAny();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.InverseImpl <em>Inverse</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.InverseImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getInverse()
     * @generated
     */
    EClass INVERSE = eINSTANCE.getInverse();

    /**
     * The meta object literal for the '<em><b>Excludes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVERSE__EXCLUDES = eINSTANCE.getInverse_Excludes();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.TimedExpressionImpl <em>Timed Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.TimedExpressionImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getTimedExpression()
     * @generated
     */
    EClass TIMED_EXPRESSION = eINSTANCE.getTimedExpression();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_EXPRESSION__BODY = eINSTANCE.getTimedExpression_Body();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMED_EXPRESSION__TIMEOUT = eINSTANCE.getTimedExpression_Timeout();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.EventImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '<em><b>Functor</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__FUNCTOR = eINSTANCE.getEvent_Functor();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT__PARAMETERS = eINSTANCE.getEvent_Parameters();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixParameterImpl <em>Fix Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixParameter()
     * @generated
     */
    EClass FIX_PARAMETER = eINSTANCE.getFixParameter();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixIntParameterImpl <em>Fix Int Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixIntParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixIntParameter()
     * @generated
     */
    EClass FIX_INT_PARAMETER = eINSTANCE.getFixIntParameter();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIX_INT_PARAMETER__BODY = eINSTANCE.getFixIntParameter_Body();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixStringParameterImpl <em>Fix String Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.FixStringParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getFixStringParameter()
     * @generated
     */
    EClass FIX_STRING_PARAMETER = eINSTANCE.getFixStringParameter();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIX_STRING_PARAMETER__BODY = eINSTANCE.getFixStringParameter_Body();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarParameterImpl <em>Var Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getVarParameter()
     * @generated
     */
    EClass VAR_PARAMETER = eINSTANCE.getVarParameter();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_PARAMETER__VAR = eINSTANCE.getVarParameter_Var();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SingletonParameterImpl <em>Singleton Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SingletonParameterImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getSingletonParameter()
     * @generated
     */
    EClass SINGLETON_PARAMETER = eINSTANCE.getSingletonParameter();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarImpl <em>Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.VarImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getVar()
     * @generated
     */
    EClass VAR = eINSTANCE.getVar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR__NAME = eINSTANCE.getVar_Name();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ChoiceImpl <em>Choice</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.ChoiceImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getChoice()
     * @generated
     */
    EClass CHOICE = eINSTANCE.getChoice();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHOICE__ELEMENTS = eINSTANCE.getChoice_Elements();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.SequenceImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getSequence()
     * @generated
     */
    EClass SEQUENCE = eINSTANCE.getSequence();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__ELEMENTS = eINSTANCE.getSequence_Elements();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.StarImpl <em>Star</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.StarImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getStar()
     * @generated
     */
    EClass STAR = eINSTANCE.getStar();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAR__BODY = eINSTANCE.getStar_Body();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.PlusImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__BODY = eINSTANCE.getPlus_Body();

    /**
     * The meta object literal for the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.CardinalityImpl <em>Cardinality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.CardinalityImpl
     * @see hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionPackageImpl#getCardinality()
     * @generated
     */
    EClass CARDINALITY = eINSTANCE.getCardinality();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CARDINALITY__BODY = eINSTANCE.getCardinality_Body();

    /**
     * The meta object literal for the '<em><b>N</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CARDINALITY__N = eINSTANCE.getCardinality_N();

  }

} //RegularExpressionPackage
