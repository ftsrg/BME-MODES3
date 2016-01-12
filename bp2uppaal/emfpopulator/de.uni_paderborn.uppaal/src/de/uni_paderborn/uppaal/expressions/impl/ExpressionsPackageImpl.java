/**
 */
package de.uni_paderborn.uppaal.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uni_paderborn.uppaal.UppaalPackage;
import de.uni_paderborn.uppaal.core.CorePackage;
import de.uni_paderborn.uppaal.core.impl.CorePackageImpl;
import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.global.GlobalPackage;
import de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl;
import de.uni_paderborn.uppaal.declarations.impl.DeclarationsPackageImpl;
import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl;
import de.uni_paderborn.uppaal.expressions.ArithmeticExpression;
import de.uni_paderborn.uppaal.expressions.ArithmeticOperator;
import de.uni_paderborn.uppaal.expressions.AssignmentExpression;
import de.uni_paderborn.uppaal.expressions.AssignmentOperator;
import de.uni_paderborn.uppaal.expressions.BinaryExpression;
import de.uni_paderborn.uppaal.expressions.BitShiftExpression;
import de.uni_paderborn.uppaal.expressions.BitShiftOperator;
import de.uni_paderborn.uppaal.expressions.BitwiseExpression;
import de.uni_paderborn.uppaal.expressions.BitwiseOperator;
import de.uni_paderborn.uppaal.expressions.CompareExpression;
import de.uni_paderborn.uppaal.expressions.CompareOperator;
import de.uni_paderborn.uppaal.expressions.ConditionExpression;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.ExpressionsFactory;
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;
import de.uni_paderborn.uppaal.expressions.FunctionCallExpression;
import de.uni_paderborn.uppaal.expressions.IdentifierExpression;
import de.uni_paderborn.uppaal.expressions.IncrementDecrementExpression;
import de.uni_paderborn.uppaal.expressions.IncrementDecrementOperator;
import de.uni_paderborn.uppaal.expressions.IncrementDecrementPosition;
import de.uni_paderborn.uppaal.expressions.LiteralExpression;
import de.uni_paderborn.uppaal.expressions.LogicalExpression;
import de.uni_paderborn.uppaal.expressions.LogicalOperator;
import de.uni_paderborn.uppaal.expressions.MinMaxExpression;
import de.uni_paderborn.uppaal.expressions.MinMaxOperator;
import de.uni_paderborn.uppaal.expressions.MinusExpression;
import de.uni_paderborn.uppaal.expressions.NegationExpression;
import de.uni_paderborn.uppaal.expressions.PlusExpression;
import de.uni_paderborn.uppaal.expressions.QuantificationExpression;
import de.uni_paderborn.uppaal.expressions.Quantifier;
import de.uni_paderborn.uppaal.expressions.ScopedIdentifierExpression;
import de.uni_paderborn.uppaal.expressions.util.ExpressionsValidator;
import de.uni_paderborn.uppaal.impl.UppaalPackageImpl;
import de.uni_paderborn.uppaal.statements.StatementsPackage;
import de.uni_paderborn.uppaal.statements.impl.StatementsPackageImpl;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl;
import de.uni_paderborn.uppaal.types.TypesPackage;
import de.uni_paderborn.uppaal.types.impl.TypesPackageImpl;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;
import de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass negationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plusExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minusExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithmeticExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionCallExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopedIdentifierExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quantificationExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incrementDecrementExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bitShiftExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minMaxExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bitwiseExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assignmentOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum arithmeticOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compareOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum quantifierEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum incrementDecrementOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum incrementDecrementPositionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bitShiftOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum minMaxOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bitwiseOperatorEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uni_paderborn.uppaal.expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UppaalPackageImpl theUppaalPackage = (UppaalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) instanceof UppaalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) : UppaalPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		DeclarationsPackageImpl theDeclarationsPackage = (DeclarationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) instanceof DeclarationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) : DeclarationsPackage.eINSTANCE);
		GlobalPackageImpl theGlobalPackage = (GlobalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) instanceof GlobalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) : GlobalPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
		StatementsPackageImpl theStatementsPackage = (StatementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) instanceof StatementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) : StatementsPackage.eINSTANCE);
		VisualsPackageImpl theVisualsPackage = (VisualsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) instanceof VisualsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) : VisualsPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theUppaalPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theDeclarationsPackage.createPackageContents();
		theGlobalPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theTemplatesPackage.createPackageContents();
		theStatementsPackage.createPackageContents();
		theVisualsPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theUppaalPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theDeclarationsPackage.initializePackageContents();
		theGlobalPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theTemplatesPackage.initializePackageContents();
		theStatementsPackage.initializePackageContents();
		theVisualsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExpressionsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExpressionsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Exp() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNegationExpression() {
		return negationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNegationExpression_NegatedExpression() {
		return (EReference)negationExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlusExpression() {
		return plusExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlusExpression_ConfirmedExpression() {
		return (EReference)plusExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinusExpression() {
		return minusExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMinusExpression_InvertedExpression() {
		return (EReference)minusExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_FirstExpr() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_SecondExpr() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignmentExpression() {
		return assignmentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignmentExpression_Operator() {
		return (EAttribute)assignmentExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierExpression() {
		return identifierExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierExpression_Identifier() {
		return (EReference)identifierExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierExpression_Index() {
		return (EReference)identifierExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralExpression() {
		return literalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteralExpression_Text() {
		return (EAttribute)literalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArithmeticExpression() {
		return arithmeticExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArithmeticExpression_Operator() {
		return (EAttribute)arithmeticExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalExpression() {
		return logicalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogicalExpression_Operator() {
		return (EAttribute)logicalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionCallExpression() {
		return functionCallExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionCallExpression_Function() {
		return (EReference)functionCallExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionCallExpression_Argument() {
		return (EReference)functionCallExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareExpression() {
		return compareExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompareExpression_Operator() {
		return (EAttribute)compareExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionExpression() {
		return conditionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionExpression_IfExpression() {
		return (EReference)conditionExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionExpression_ThenExpression() {
		return (EReference)conditionExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionExpression_ElseExpression() {
		return (EReference)conditionExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopedIdentifierExpression() {
		return scopedIdentifierExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopedIdentifierExpression_Scope() {
		return (EReference)scopedIdentifierExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopedIdentifierExpression_Identifier() {
		return (EReference)scopedIdentifierExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuantificationExpression() {
		return quantificationExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuantificationExpression_Quantifier() {
		return (EAttribute)quantificationExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuantificationExpression_Expression() {
		return (EReference)quantificationExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncrementDecrementExpression() {
		return incrementDecrementExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncrementDecrementExpression_Expression() {
		return (EReference)incrementDecrementExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementDecrementExpression_Position() {
		return (EAttribute)incrementDecrementExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncrementDecrementExpression_Operator() {
		return (EAttribute)incrementDecrementExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBitShiftExpression() {
		return bitShiftExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBitShiftExpression_Operator() {
		return (EAttribute)bitShiftExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinMaxExpression() {
		return minMaxExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMinMaxExpression_Operator() {
		return (EAttribute)minMaxExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBitwiseExpression() {
		return bitwiseExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBitwiseExpression_Operator() {
		return (EAttribute)bitwiseExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssignmentOperator() {
		return assignmentOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArithmeticOperator() {
		return arithmeticOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicalOperator() {
		return logicalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompareOperator() {
		return compareOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQuantifier() {
		return quantifierEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIncrementDecrementOperator() {
		return incrementDecrementOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIncrementDecrementPosition() {
		return incrementDecrementPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBitShiftOperator() {
		return bitShiftOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMinMaxOperator() {
		return minMaxOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBitwiseOperator() {
		return bitwiseOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__EXP);

		negationExpressionEClass = createEClass(NEGATION_EXPRESSION);
		createEReference(negationExpressionEClass, NEGATION_EXPRESSION__NEGATED_EXPRESSION);

		plusExpressionEClass = createEClass(PLUS_EXPRESSION);
		createEReference(plusExpressionEClass, PLUS_EXPRESSION__CONFIRMED_EXPRESSION);

		minusExpressionEClass = createEClass(MINUS_EXPRESSION);
		createEReference(minusExpressionEClass, MINUS_EXPRESSION__INVERTED_EXPRESSION);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__FIRST_EXPR);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__SECOND_EXPR);

		assignmentExpressionEClass = createEClass(ASSIGNMENT_EXPRESSION);
		createEAttribute(assignmentExpressionEClass, ASSIGNMENT_EXPRESSION__OPERATOR);

		identifierExpressionEClass = createEClass(IDENTIFIER_EXPRESSION);
		createEReference(identifierExpressionEClass, IDENTIFIER_EXPRESSION__IDENTIFIER);
		createEReference(identifierExpressionEClass, IDENTIFIER_EXPRESSION__INDEX);

		literalExpressionEClass = createEClass(LITERAL_EXPRESSION);
		createEAttribute(literalExpressionEClass, LITERAL_EXPRESSION__TEXT);

		arithmeticExpressionEClass = createEClass(ARITHMETIC_EXPRESSION);
		createEAttribute(arithmeticExpressionEClass, ARITHMETIC_EXPRESSION__OPERATOR);

		logicalExpressionEClass = createEClass(LOGICAL_EXPRESSION);
		createEAttribute(logicalExpressionEClass, LOGICAL_EXPRESSION__OPERATOR);

		functionCallExpressionEClass = createEClass(FUNCTION_CALL_EXPRESSION);
		createEReference(functionCallExpressionEClass, FUNCTION_CALL_EXPRESSION__FUNCTION);
		createEReference(functionCallExpressionEClass, FUNCTION_CALL_EXPRESSION__ARGUMENT);

		compareExpressionEClass = createEClass(COMPARE_EXPRESSION);
		createEAttribute(compareExpressionEClass, COMPARE_EXPRESSION__OPERATOR);

		conditionExpressionEClass = createEClass(CONDITION_EXPRESSION);
		createEReference(conditionExpressionEClass, CONDITION_EXPRESSION__IF_EXPRESSION);
		createEReference(conditionExpressionEClass, CONDITION_EXPRESSION__THEN_EXPRESSION);
		createEReference(conditionExpressionEClass, CONDITION_EXPRESSION__ELSE_EXPRESSION);

		scopedIdentifierExpressionEClass = createEClass(SCOPED_IDENTIFIER_EXPRESSION);
		createEReference(scopedIdentifierExpressionEClass, SCOPED_IDENTIFIER_EXPRESSION__SCOPE);
		createEReference(scopedIdentifierExpressionEClass, SCOPED_IDENTIFIER_EXPRESSION__IDENTIFIER);

		quantificationExpressionEClass = createEClass(QUANTIFICATION_EXPRESSION);
		createEAttribute(quantificationExpressionEClass, QUANTIFICATION_EXPRESSION__QUANTIFIER);
		createEReference(quantificationExpressionEClass, QUANTIFICATION_EXPRESSION__EXPRESSION);

		incrementDecrementExpressionEClass = createEClass(INCREMENT_DECREMENT_EXPRESSION);
		createEReference(incrementDecrementExpressionEClass, INCREMENT_DECREMENT_EXPRESSION__EXPRESSION);
		createEAttribute(incrementDecrementExpressionEClass, INCREMENT_DECREMENT_EXPRESSION__POSITION);
		createEAttribute(incrementDecrementExpressionEClass, INCREMENT_DECREMENT_EXPRESSION__OPERATOR);

		bitShiftExpressionEClass = createEClass(BIT_SHIFT_EXPRESSION);
		createEAttribute(bitShiftExpressionEClass, BIT_SHIFT_EXPRESSION__OPERATOR);

		minMaxExpressionEClass = createEClass(MIN_MAX_EXPRESSION);
		createEAttribute(minMaxExpressionEClass, MIN_MAX_EXPRESSION__OPERATOR);

		bitwiseExpressionEClass = createEClass(BITWISE_EXPRESSION);
		createEAttribute(bitwiseExpressionEClass, BITWISE_EXPRESSION__OPERATOR);

		// Create enums
		assignmentOperatorEEnum = createEEnum(ASSIGNMENT_OPERATOR);
		arithmeticOperatorEEnum = createEEnum(ARITHMETIC_OPERATOR);
		logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
		compareOperatorEEnum = createEEnum(COMPARE_OPERATOR);
		quantifierEEnum = createEEnum(QUANTIFIER);
		incrementDecrementOperatorEEnum = createEEnum(INCREMENT_DECREMENT_OPERATOR);
		incrementDecrementPositionEEnum = createEEnum(INCREMENT_DECREMENT_POSITION);
		bitShiftOperatorEEnum = createEEnum(BIT_SHIFT_OPERATOR);
		minMaxOperatorEEnum = createEEnum(MIN_MAX_OPERATOR);
		bitwiseOperatorEEnum = createEEnum(BITWISE_OPERATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		DeclarationsPackage theDeclarationsPackage = (DeclarationsPackage)EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		negationExpressionEClass.getESuperTypes().add(this.getExpression());
		plusExpressionEClass.getESuperTypes().add(this.getExpression());
		minusExpressionEClass.getESuperTypes().add(this.getExpression());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		assignmentExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		identifierExpressionEClass.getESuperTypes().add(this.getExpression());
		literalExpressionEClass.getESuperTypes().add(this.getExpression());
		arithmeticExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		logicalExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		functionCallExpressionEClass.getESuperTypes().add(this.getExpression());
		compareExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		conditionExpressionEClass.getESuperTypes().add(this.getExpression());
		scopedIdentifierExpressionEClass.getESuperTypes().add(this.getExpression());
		quantificationExpressionEClass.getESuperTypes().add(this.getExpression());
		quantificationExpressionEClass.getESuperTypes().add(theDeclarationsPackage.getVariableContainer());
		incrementDecrementExpressionEClass.getESuperTypes().add(this.getExpression());
		bitShiftExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		minMaxExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		bitwiseExpressionEClass.getESuperTypes().add(this.getBinaryExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_Exp(), ecorePackage.getEString(), "exp", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(negationExpressionEClass, NegationExpression.class, "NegationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNegationExpression_NegatedExpression(), this.getExpression(), null, "negatedExpression", null, 1, 1, NegationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plusExpressionEClass, PlusExpression.class, "PlusExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlusExpression_ConfirmedExpression(), this.getExpression(), null, "confirmedExpression", null, 1, 1, PlusExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(minusExpressionEClass, MinusExpression.class, "MinusExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMinusExpression_InvertedExpression(), this.getExpression(), null, "invertedExpression", null, 1, 1, MinusExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_FirstExpr(), this.getExpression(), null, "firstExpr", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_SecondExpr(), this.getExpression(), null, "secondExpr", null, 1, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentExpressionEClass, AssignmentExpression.class, "AssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignmentExpression_Operator(), this.getAssignmentOperator(), "operator", null, 1, 1, AssignmentExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierExpressionEClass, IdentifierExpression.class, "IdentifierExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierExpression_Identifier(), theCorePackage.getNamedElement(), null, "identifier", null, 1, 1, IdentifierExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifierExpression_Index(), this.getExpression(), null, "index", null, 0, -1, IdentifierExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalExpressionEClass, LiteralExpression.class, "LiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteralExpression_Text(), ecorePackage.getEString(), "text", null, 1, 1, LiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arithmeticExpressionEClass, ArithmeticExpression.class, "ArithmeticExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArithmeticExpression_Operator(), this.getArithmeticOperator(), "operator", null, 1, 1, ArithmeticExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalExpressionEClass, LogicalExpression.class, "LogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogicalExpression_Operator(), this.getLogicalOperator(), "operator", null, 1, 1, LogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionCallExpressionEClass, FunctionCallExpression.class, "FunctionCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCallExpression_Function(), theDeclarationsPackage.getFunction(), null, "function", null, 1, 1, FunctionCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionCallExpression_Argument(), this.getExpression(), null, "argument", null, 0, -1, FunctionCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compareExpressionEClass, CompareExpression.class, "CompareExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompareExpression_Operator(), this.getCompareOperator(), "operator", null, 1, 1, CompareExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionExpressionEClass, ConditionExpression.class, "ConditionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionExpression_IfExpression(), this.getExpression(), null, "ifExpression", null, 1, 1, ConditionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionExpression_ThenExpression(), this.getExpression(), null, "thenExpression", null, 1, 1, ConditionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionExpression_ElseExpression(), this.getExpression(), null, "elseExpression", null, 1, 1, ConditionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopedIdentifierExpressionEClass, ScopedIdentifierExpression.class, "ScopedIdentifierExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopedIdentifierExpression_Scope(), this.getExpression(), null, "scope", null, 1, 1, ScopedIdentifierExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopedIdentifierExpression_Identifier(), this.getIdentifierExpression(), null, "identifier", null, 1, 1, ScopedIdentifierExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quantificationExpressionEClass, QuantificationExpression.class, "QuantificationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuantificationExpression_Quantifier(), this.getQuantifier(), "quantifier", null, 1, 1, QuantificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuantificationExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, QuantificationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(incrementDecrementExpressionEClass, IncrementDecrementExpression.class, "IncrementDecrementExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncrementDecrementExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, IncrementDecrementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncrementDecrementExpression_Position(), this.getIncrementDecrementPosition(), "position", null, 1, 1, IncrementDecrementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncrementDecrementExpression_Operator(), this.getIncrementDecrementOperator(), "operator", null, 1, 1, IncrementDecrementExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bitShiftExpressionEClass, BitShiftExpression.class, "BitShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBitShiftExpression_Operator(), this.getBitShiftOperator(), "operator", null, 1, 1, BitShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(minMaxExpressionEClass, MinMaxExpression.class, "MinMaxExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMinMaxExpression_Operator(), this.getMinMaxOperator(), "operator", null, 1, 1, MinMaxExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bitwiseExpressionEClass, BitwiseExpression.class, "BitwiseExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBitwiseExpression_Operator(), this.getBitwiseOperator(), "operator", null, 1, 1, BitwiseExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(assignmentOperatorEEnum, AssignmentOperator.class, "AssignmentOperator");
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.PLUS_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MINUS_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.TIMES_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DIVIDE_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MODULO_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.BIT_AND_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.BIT_OR_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.BIT_LEFT_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.BIT_RIGHT_EQUAL);
		addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.BIT_XOR_EQUAL);

		initEEnum(arithmeticOperatorEEnum, ArithmeticOperator.class, "ArithmeticOperator");
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.ADD);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.SUBTRACT);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.MULTIPLICATE);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.DIVIDE);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.MODULO);

		initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);
		addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.IMPLY);

		initEEnum(compareOperatorEEnum, CompareOperator.class, "CompareOperator");
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.EQUAL);
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.GREATER);
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.GREATER_OR_EQUAL);
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.LESS);
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.LESS_OR_EQUAL);
		addEEnumLiteral(compareOperatorEEnum, CompareOperator.UNEQUAL);

		initEEnum(quantifierEEnum, Quantifier.class, "Quantifier");
		addEEnumLiteral(quantifierEEnum, Quantifier.EXISTENTIAL);
		addEEnumLiteral(quantifierEEnum, Quantifier.UNIVERSAL);

		initEEnum(incrementDecrementOperatorEEnum, IncrementDecrementOperator.class, "IncrementDecrementOperator");
		addEEnumLiteral(incrementDecrementOperatorEEnum, IncrementDecrementOperator.INCREMENT);
		addEEnumLiteral(incrementDecrementOperatorEEnum, IncrementDecrementOperator.DECREMENT);

		initEEnum(incrementDecrementPositionEEnum, IncrementDecrementPosition.class, "IncrementDecrementPosition");
		addEEnumLiteral(incrementDecrementPositionEEnum, IncrementDecrementPosition.PRE);
		addEEnumLiteral(incrementDecrementPositionEEnum, IncrementDecrementPosition.POST);

		initEEnum(bitShiftOperatorEEnum, BitShiftOperator.class, "BitShiftOperator");
		addEEnumLiteral(bitShiftOperatorEEnum, BitShiftOperator.LEFT);
		addEEnumLiteral(bitShiftOperatorEEnum, BitShiftOperator.RIGHT);

		initEEnum(minMaxOperatorEEnum, MinMaxOperator.class, "MinMaxOperator");
		addEEnumLiteral(minMaxOperatorEEnum, MinMaxOperator.MIN);
		addEEnumLiteral(minMaxOperatorEEnum, MinMaxOperator.MAX);

		initEEnum(bitwiseOperatorEEnum, BitwiseOperator.class, "BitwiseOperator");
		addEEnumLiteral(bitwiseOperatorEEnum, BitwiseOperator.AND);
		addEEnumLiteral(bitwiseOperatorEEnum, BitwiseOperator.XOR);
		addEEnumLiteral(bitwiseOperatorEEnum, BitwiseOperator.OR);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });	
		addAnnotation
		  (functionCallExpressionEClass, 
		   source, 
		   new String[] {
			 "constraints", "NumberOfArgumentsMatchesDeclaration"
		   });	
		addAnnotation
		  (quantificationExpressionEClass, 
		   source, 
		   new String[] {
			 "constraints", "SingleVariable"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";	
		addAnnotation
		  (functionCallExpressionEClass, 
		   source, 
		   new String[] {
			 "NumberOfArgumentsMatchesDeclaration", "(not self.function.oclIsUndefined())\r\nimplies\r\nself.argument->size() = self.function.parameter->size()"
		   });	
		addAnnotation
		  (quantificationExpressionEClass, 
		   source, 
		   new String[] {
			 "SingleVariable", "self.variable->size() <= 1"
		   });
	}

} //ExpressionsPackageImpl
