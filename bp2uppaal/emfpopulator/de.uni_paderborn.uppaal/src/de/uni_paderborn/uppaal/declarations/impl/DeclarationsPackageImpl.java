/**
 */
package de.uni_paderborn.uppaal.declarations.impl;

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
import de.uni_paderborn.uppaal.declarations.ArrayInitializer;
import de.uni_paderborn.uppaal.declarations.CallType;
import de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.ClockVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.DataVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.DataVariablePrefix;
import de.uni_paderborn.uppaal.declarations.Declaration;
import de.uni_paderborn.uppaal.declarations.Declarations;
import de.uni_paderborn.uppaal.declarations.DeclarationsFactory;
import de.uni_paderborn.uppaal.declarations.DeclarationsPackage;
import de.uni_paderborn.uppaal.declarations.ExpressionInitializer;
import de.uni_paderborn.uppaal.declarations.Function;
import de.uni_paderborn.uppaal.declarations.FunctionDeclaration;
import de.uni_paderborn.uppaal.declarations.GlobalDeclarations;
import de.uni_paderborn.uppaal.declarations.Index;
import de.uni_paderborn.uppaal.declarations.Initializer;
import de.uni_paderborn.uppaal.declarations.LocalDeclarations;
import de.uni_paderborn.uppaal.declarations.Parameter;
import de.uni_paderborn.uppaal.declarations.SystemDeclarations;
import de.uni_paderborn.uppaal.declarations.TypeDeclaration;
import de.uni_paderborn.uppaal.declarations.TypeIndex;
import de.uni_paderborn.uppaal.declarations.ValueIndex;
import de.uni_paderborn.uppaal.declarations.Variable;
import de.uni_paderborn.uppaal.declarations.VariableContainer;
import de.uni_paderborn.uppaal.declarations.VariableDeclaration;
import de.uni_paderborn.uppaal.declarations.global.GlobalPackage;
import de.uni_paderborn.uppaal.declarations.global.impl.GlobalPackageImpl;
import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.declarations.system.impl.SystemPackageImpl;
import de.uni_paderborn.uppaal.declarations.util.DeclarationsValidator;
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;
import de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl;
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
public class DeclarationsPackageImpl extends EPackageImpl implements DeclarationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalDeclarationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localDeclarationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemDeclarationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass channelVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayInitializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataVariablePrefixEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum callTypeEEnum = null;

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
	 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DeclarationsPackageImpl() {
		super(eNS_URI, DeclarationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DeclarationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DeclarationsPackage init() {
		if (isInited) return (DeclarationsPackage)EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI);

		// Obtain or create and register package
		DeclarationsPackageImpl theDeclarationsPackage = (DeclarationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DeclarationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DeclarationsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UppaalPackageImpl theUppaalPackage = (UppaalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) instanceof UppaalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) : UppaalPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		GlobalPackageImpl theGlobalPackage = (GlobalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) instanceof GlobalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) : GlobalPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
		StatementsPackageImpl theStatementsPackage = (StatementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) instanceof StatementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) : StatementsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		VisualsPackageImpl theVisualsPackage = (VisualsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) instanceof VisualsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) : VisualsPackage.eINSTANCE);

		// Create package meta-data objects
		theDeclarationsPackage.createPackageContents();
		theUppaalPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theGlobalPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theTemplatesPackage.createPackageContents();
		theStatementsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theVisualsPackage.createPackageContents();

		// Initialize created meta-data
		theDeclarationsPackage.initializePackageContents();
		theUppaalPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theGlobalPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theTemplatesPackage.initializePackageContents();
		theStatementsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theVisualsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDeclarationsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DeclarationsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDeclarationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DeclarationsPackage.eNS_URI, theDeclarationsPackage);
		return theDeclarationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclarations() {
		return declarationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarations_Declaration() {
		return (EReference)declarationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalDeclarations() {
		return globalDeclarationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalDeclarations_ChannelPriority() {
		return (EReference)globalDeclarationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalDeclarations() {
		return localDeclarationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemDeclarations() {
		return systemDeclarationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemDeclarations_System() {
		return (EReference)systemDeclarationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemDeclarations_ProgressMeasure() {
		return (EReference)systemDeclarationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaration() {
		return declarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeclaration_Exp() {
		return (EAttribute)declarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChannelVariableDeclaration() {
		return channelVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChannelVariableDeclaration_Urgent() {
		return (EAttribute)channelVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChannelVariableDeclaration_Broadcast() {
		return (EAttribute)channelVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClockVariableDeclaration() {
		return clockVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataVariableDeclaration() {
		return dataVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataVariableDeclaration_Prefix() {
		return (EAttribute)dataVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionDeclaration() {
		return functionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_Function() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_ReturnType() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Block() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Parameter() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDeclaration() {
		return typeDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeDeclaration_Type() {
		return (EReference)typeDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeDeclaration_TypeDefinition() {
		return (EReference)typeDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Index() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Container() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_TypeDefinition() {
		return (EReference)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Initializer() {
		return (EReference)variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndex() {
		return indexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueIndex() {
		return valueIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueIndex_SizeExpression() {
		return (EReference)valueIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeIndex() {
		return typeIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeIndex_TypeDefinition() {
		return (EReference)typeIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableContainer() {
		return variableContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableContainer_TypeDefinition() {
		return (EReference)variableContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableContainer_Variable() {
		return (EReference)variableContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_VariableDeclaration() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_CallType() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitializer() {
		return initializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionInitializer() {
		return expressionInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionInitializer_Expression() {
		return (EReference)expressionInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayInitializer() {
		return arrayInitializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayInitializer_Initializer() {
		return (EReference)arrayInitializerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataVariablePrefix() {
		return dataVariablePrefixEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCallType() {
		return callTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationsFactory getDeclarationsFactory() {
		return (DeclarationsFactory)getEFactoryInstance();
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
		declarationsEClass = createEClass(DECLARATIONS);
		createEReference(declarationsEClass, DECLARATIONS__DECLARATION);

		globalDeclarationsEClass = createEClass(GLOBAL_DECLARATIONS);
		createEReference(globalDeclarationsEClass, GLOBAL_DECLARATIONS__CHANNEL_PRIORITY);

		localDeclarationsEClass = createEClass(LOCAL_DECLARATIONS);

		systemDeclarationsEClass = createEClass(SYSTEM_DECLARATIONS);
		createEReference(systemDeclarationsEClass, SYSTEM_DECLARATIONS__SYSTEM);
		createEReference(systemDeclarationsEClass, SYSTEM_DECLARATIONS__PROGRESS_MEASURE);

		declarationEClass = createEClass(DECLARATION);
		createEAttribute(declarationEClass, DECLARATION__EXP);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);

		channelVariableDeclarationEClass = createEClass(CHANNEL_VARIABLE_DECLARATION);
		createEAttribute(channelVariableDeclarationEClass, CHANNEL_VARIABLE_DECLARATION__URGENT);
		createEAttribute(channelVariableDeclarationEClass, CHANNEL_VARIABLE_DECLARATION__BROADCAST);

		clockVariableDeclarationEClass = createEClass(CLOCK_VARIABLE_DECLARATION);

		dataVariableDeclarationEClass = createEClass(DATA_VARIABLE_DECLARATION);
		createEAttribute(dataVariableDeclarationEClass, DATA_VARIABLE_DECLARATION__PREFIX);

		functionDeclarationEClass = createEClass(FUNCTION_DECLARATION);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__FUNCTION);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__RETURN_TYPE);
		createEReference(functionEClass, FUNCTION__BLOCK);
		createEReference(functionEClass, FUNCTION__PARAMETER);

		typeDeclarationEClass = createEClass(TYPE_DECLARATION);
		createEReference(typeDeclarationEClass, TYPE_DECLARATION__TYPE);
		createEReference(typeDeclarationEClass, TYPE_DECLARATION__TYPE_DEFINITION);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__INDEX);
		createEReference(variableEClass, VARIABLE__CONTAINER);
		createEReference(variableEClass, VARIABLE__TYPE_DEFINITION);
		createEReference(variableEClass, VARIABLE__INITIALIZER);

		indexEClass = createEClass(INDEX);

		valueIndexEClass = createEClass(VALUE_INDEX);
		createEReference(valueIndexEClass, VALUE_INDEX__SIZE_EXPRESSION);

		typeIndexEClass = createEClass(TYPE_INDEX);
		createEReference(typeIndexEClass, TYPE_INDEX__TYPE_DEFINITION);

		variableContainerEClass = createEClass(VARIABLE_CONTAINER);
		createEReference(variableContainerEClass, VARIABLE_CONTAINER__TYPE_DEFINITION);
		createEReference(variableContainerEClass, VARIABLE_CONTAINER__VARIABLE);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__VARIABLE_DECLARATION);
		createEAttribute(parameterEClass, PARAMETER__CALL_TYPE);

		initializerEClass = createEClass(INITIALIZER);

		expressionInitializerEClass = createEClass(EXPRESSION_INITIALIZER);
		createEReference(expressionInitializerEClass, EXPRESSION_INITIALIZER__EXPRESSION);

		arrayInitializerEClass = createEClass(ARRAY_INITIALIZER);
		createEReference(arrayInitializerEClass, ARRAY_INITIALIZER__INITIALIZER);

		// Create enums
		dataVariablePrefixEEnum = createEEnum(DATA_VARIABLE_PREFIX);
		callTypeEEnum = createEEnum(CALL_TYPE);
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
		GlobalPackage theGlobalPackage = (GlobalPackage)EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI);
		SystemPackage theSystemPackage = (SystemPackage)EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		StatementsPackage theStatementsPackage = (StatementsPackage)EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGlobalPackage);
		getESubpackages().add(theSystemPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		globalDeclarationsEClass.getESuperTypes().add(this.getDeclarations());
		localDeclarationsEClass.getESuperTypes().add(this.getDeclarations());
		systemDeclarationsEClass.getESuperTypes().add(this.getDeclarations());
		variableDeclarationEClass.getESuperTypes().add(this.getDeclaration());
		variableDeclarationEClass.getESuperTypes().add(this.getVariableContainer());
		channelVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		clockVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		dataVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		functionDeclarationEClass.getESuperTypes().add(this.getDeclaration());
		functionEClass.getESuperTypes().add(theCorePackage.getNamedElement());
		typeDeclarationEClass.getESuperTypes().add(this.getDeclaration());
		variableEClass.getESuperTypes().add(theCorePackage.getNamedElement());
		valueIndexEClass.getESuperTypes().add(this.getIndex());
		typeIndexEClass.getESuperTypes().add(this.getIndex());
		expressionInitializerEClass.getESuperTypes().add(this.getInitializer());
		arrayInitializerEClass.getESuperTypes().add(this.getInitializer());

		// Initialize classes, features, and operations; add parameters
		initEClass(declarationsEClass, Declarations.class, "Declarations", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclarations_Declaration(), this.getDeclaration(), null, "declaration", null, 0, -1, Declarations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalDeclarationsEClass, GlobalDeclarations.class, "GlobalDeclarations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalDeclarations_ChannelPriority(), theGlobalPackage.getChannelPriority(), null, "channelPriority", null, 0, 1, GlobalDeclarations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localDeclarationsEClass, LocalDeclarations.class, "LocalDeclarations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemDeclarationsEClass, SystemDeclarations.class, "SystemDeclarations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemDeclarations_System(), theSystemPackage.getSystem(), null, "system", null, 1, 1, SystemDeclarations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemDeclarations_ProgressMeasure(), theSystemPackage.getProgressMeasure(), null, "progressMeasure", null, 0, 1, SystemDeclarations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declarationEClass, Declaration.class, "Declaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeclaration_Exp(), ecorePackage.getEString(), "exp", null, 0, 1, Declaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(channelVariableDeclarationEClass, ChannelVariableDeclaration.class, "ChannelVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChannelVariableDeclaration_Urgent(), ecorePackage.getEBoolean(), "urgent", "false", 1, 1, ChannelVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChannelVariableDeclaration_Broadcast(), ecorePackage.getEBoolean(), "broadcast", "false", 1, 1, ChannelVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clockVariableDeclarationEClass, ClockVariableDeclaration.class, "ClockVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataVariableDeclarationEClass, DataVariableDeclaration.class, "DataVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataVariableDeclaration_Prefix(), this.getDataVariablePrefix(), "prefix", null, 1, 1, DataVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionDeclarationEClass, FunctionDeclaration.class, "FunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionDeclaration_Function(), this.getFunction(), null, "function", null, 1, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_ReturnType(), theTypesPackage.getTypeDefinition(), null, "returnType", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Block(), theStatementsPackage.getBlock(), null, "block", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDeclarationEClass, TypeDeclaration.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeDeclaration_Type(), theTypesPackage.getDeclaredType(), theTypesPackage.getDeclaredType_TypeDeclaration(), "type", null, 1, -1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDeclaration_TypeDefinition(), theTypesPackage.getTypeDefinition(), null, "typeDefinition", null, 1, 1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_Index(), this.getIndex(), null, "index", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Container(), this.getVariableContainer(), this.getVariableContainer_Variable(), "container", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_TypeDefinition(), theTypesPackage.getTypeDefinition(), null, "typeDefinition", null, 1, 1, Variable.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Initializer(), this.getInitializer(), null, "initializer", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexEClass, Index.class, "Index", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueIndexEClass, ValueIndex.class, "ValueIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueIndex_SizeExpression(), theExpressionsPackage.getExpression(), null, "sizeExpression", null, 1, 1, ValueIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeIndexEClass, TypeIndex.class, "TypeIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeIndex_TypeDefinition(), theTypesPackage.getTypeDefinition(), null, "typeDefinition", null, 1, 1, TypeIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableContainerEClass, VariableContainer.class, "VariableContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableContainer_TypeDefinition(), theTypesPackage.getTypeDefinition(), null, "typeDefinition", null, 1, 1, VariableContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableContainer_Variable(), this.getVariable(), this.getVariable_Container(), "variable", null, 1, -1, VariableContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_VariableDeclaration(), this.getVariableDeclaration(), null, "variableDeclaration", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_CallType(), this.getCallType(), "callType", "CALL_BY_VALUE", 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initializerEClass, Initializer.class, "Initializer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionInitializerEClass, ExpressionInitializer.class, "ExpressionInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionInitializer_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 1, 1, ExpressionInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayInitializerEClass, ArrayInitializer.class, "ArrayInitializer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayInitializer_Initializer(), this.getInitializer(), null, "initializer", null, 1, -1, ArrayInitializer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dataVariablePrefixEEnum, DataVariablePrefix.class, "DataVariablePrefix");
		addEEnumLiteral(dataVariablePrefixEEnum, DataVariablePrefix.NONE);
		addEEnumLiteral(dataVariablePrefixEEnum, DataVariablePrefix.CONST);
		addEEnumLiteral(dataVariablePrefixEEnum, DataVariablePrefix.META);

		initEEnum(callTypeEEnum, CallType.class, "CallType");
		addEEnumLiteral(callTypeEEnum, CallType.CALL_BY_VALUE);
		addEEnumLiteral(callTypeEEnum, CallType.CALL_BY_REFERENCE);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
		  (declarationsEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueFunctionNames UniqueVariableNames UniqueTypeNames"
		   });	
		addAnnotation
		  (globalDeclarationsEClass, 
		   source, 
		   new String[] {
			 "constraints", "NoTemplateDeclarations"
		   });	
		addAnnotation
		  (localDeclarationsEClass, 
		   source, 
		   new String[] {
			 "constraints", "NoTemplateDeclarations NoChannelDeclarations"
		   });	
		addAnnotation
		  (systemDeclarationsEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueTemplateNames NoChannelDeclarations"
		   });	
		addAnnotation
		  (channelVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "constraints", "MatchingType"
		   });	
		addAnnotation
		  (clockVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "constraints", "MatchingType"
		   });	
		addAnnotation
		  (dataVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "constraints", "MatchingType"
		   });	
		addAnnotation
		  (functionEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidReturnType UniqueParameterNames"
		   });	
		addAnnotation
		  (typeDeclarationEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueTypeNames"
		   });	
		addAnnotation
		  (variableEClass, 
		   source, 
		   new String[] {
			 "constraints", "NoInitializerForClockAndChannelVariables"
		   });	
		addAnnotation
		  (typeIndexEClass, 
		   source, 
		   new String[] {
			 "constraints", "IntegerBasedIndex"
		   });	
		addAnnotation
		  (variableContainerEClass, 
		   source, 
		   new String[] {
			 "constraints", "NoVoidVariables UniqueVariableNames"
		   });	
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "constraints", "SingleVariable"
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (declarationsEClass, 
		   source, 
		   new String[] {
			 "name", "Declarations",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (variableDeclarationEClass, 
		   source, 
		   new String[] {
			 "name", "VariableDeclaration",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (variableEClass, 
		   source, 
		   new String[] {
			 "name", "Variable",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getVariableContainer_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable"
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
		  (declarationsEClass, 
		   source, 
		   new String[] {
			 "UniqueFunctionNames", "self.declaration->select(oclIsKindOf(FunctionDeclaration)).oclAsType(FunctionDeclaration)->collect(function)->isUnique(name)",
			 "UniqueVariableNames", "self.declaration->select(oclIsKindOf(VariableDeclaration)).oclAsType(VariableDeclaration)->collect(variable)->isUnique(name)",
			 "UniqueTypeNames", "self.declaration->select(oclIsKindOf(TypeDeclaration)).oclAsType(TypeDeclaration)->collect(type)->isUnique(name)"
		   });	
		addAnnotation
		  (globalDeclarationsEClass, 
		   source, 
		   new String[] {
			 "NoTemplateDeclarations", "not self.declaration->exists(oclIsKindOf(system::TemplateDeclaration))"
		   });	
		addAnnotation
		  (localDeclarationsEClass, 
		   source, 
		   new String[] {
			 "NoTemplateDeclarations", "not self.declaration->exists(oclIsKindOf(system::TemplateDeclaration))",
			 "NoChannelDeclarations", "not self.declaration->exists(oclIsKindOf(ChannelVariableDeclaration))"
		   });	
		addAnnotation
		  (systemDeclarationsEClass, 
		   source, 
		   new String[] {
			 "UniqueTemplateNames", "self.declaration->select(oclIsKindOf(system::TemplateDeclaration)).oclAsType(system::TemplateDeclaration)->collect(declaredTemplate)->isUnique(name)",
			 "NoChannelDeclarations", "not self.declaration->exists(oclIsKindOf(ChannelVariableDeclaration))"
		   });	
		addAnnotation
		  (channelVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "MatchingType", "(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::CHAN"
		   });	
		addAnnotation
		  (clockVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "MatchingType", "(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::CLOCK"
		   });	
		addAnnotation
		  (dataVariableDeclarationEClass, 
		   source, 
		   new String[] {
			 "MatchingType", "(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\n(self.typeDefinition.baseType <> types::BuiltInType::CHAN\r\nand\r\nself.typeDefinition.baseType <> types::BuiltInType::CLOCK)"
		   });	
		addAnnotation
		  (functionEClass, 
		   source, 
		   new String[] {
			 "ValidReturnType", "(not returnType.oclIsUndefined())\r\nimplies\r\n(returnType.baseType = types::BuiltInType::VOID or\r\n returnType.baseType = types::BuiltInType::INT or\r\n returnType.baseType = types::BuiltInType::BOOL)",
			 "UniqueParameterNames", "self.parameter->collect(variableDeclaration)->collect(variable)->isUnique(name)"
		   });	
		addAnnotation
		  (typeDeclarationEClass, 
		   source, 
		   new String[] {
			 "UniqueTypeNames", "self.type->isUnique(name)"
		   });	
		addAnnotation
		  (variableEClass, 
		   source, 
		   new String[] {
			 "NoInitializerForClockAndChannelVariables", "((not self.typeDefinition.oclIsUndefined()) and\r\n(self.typeDefinition.baseType = types::BuiltInType::CHAN or\r\n self.typeDefinition.baseType = types::BuiltInType::CLOCK))\r\n implies self.initializer.oclIsUndefined()"
		   });	
		addAnnotation
		  (getVariable_TypeDefinition(), 
		   source, 
		   new String[] {
			 "derivation", "if self.container.oclIsUndefined()\r\nthen null \r\nelse \r\nself.container.typeDefinition \r\nendif"
		   });	
		addAnnotation
		  (typeIndexEClass, 
		   source, 
		   new String[] {
			 "IntegerBasedIndex", "(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType = types::BuiltInType::INT"
		   });	
		addAnnotation
		  (variableContainerEClass, 
		   source, 
		   new String[] {
			 "NoVoidVariables", "(not self.typeDefinition.oclIsUndefined())\r\nimplies\r\nself.typeDefinition.baseType <> types::BuiltInType::VOID",
			 "UniqueVariableNames", "self.variable->isUnique(name)"
		   });	
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "SingleVariable", "(not self.variableDeclaration.oclIsUndefined())\r\nimplies\r\nself.variableDeclaration.variable->size() <= 1"
		   });
	}

} //DeclarationsPackageImpl
