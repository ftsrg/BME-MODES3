/**
 */
package de.uni_paderborn.uppaal.types.impl;

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
import de.uni_paderborn.uppaal.expressions.ExpressionsPackage;
import de.uni_paderborn.uppaal.expressions.impl.ExpressionsPackageImpl;
import de.uni_paderborn.uppaal.impl.UppaalPackageImpl;
import de.uni_paderborn.uppaal.statements.StatementsPackage;
import de.uni_paderborn.uppaal.statements.impl.StatementsPackageImpl;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl;
import de.uni_paderborn.uppaal.types.BuiltInType;
import de.uni_paderborn.uppaal.types.DeclaredType;
import de.uni_paderborn.uppaal.types.IntegerBounds;
import de.uni_paderborn.uppaal.types.PredefinedType;
import de.uni_paderborn.uppaal.types.RangeTypeSpecification;
import de.uni_paderborn.uppaal.types.ScalarTypeSpecification;
import de.uni_paderborn.uppaal.types.StructTypeSpecification;
import de.uni_paderborn.uppaal.types.Type;
import de.uni_paderborn.uppaal.types.TypeDefinition;
import de.uni_paderborn.uppaal.types.TypeReference;
import de.uni_paderborn.uppaal.types.TypeSpecification;
import de.uni_paderborn.uppaal.types.TypesFactory;
import de.uni_paderborn.uppaal.types.TypesPackage;
import de.uni_paderborn.uppaal.types.util.TypesValidator;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;
import de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predefinedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerBoundsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum builtInTypeEEnum = null;

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
	 * @see de.uni_paderborn.uppaal.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UppaalPackageImpl theUppaalPackage = (UppaalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) instanceof UppaalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI) : UppaalPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		DeclarationsPackageImpl theDeclarationsPackage = (DeclarationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) instanceof DeclarationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) : DeclarationsPackage.eINSTANCE);
		GlobalPackageImpl theGlobalPackage = (GlobalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) instanceof GlobalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) : GlobalPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
		StatementsPackageImpl theStatementsPackage = (StatementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) instanceof StatementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) : StatementsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		VisualsPackageImpl theVisualsPackage = (VisualsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) instanceof VisualsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) : VisualsPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theUppaalPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theDeclarationsPackage.createPackageContents();
		theGlobalPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theTemplatesPackage.createPackageContents();
		theStatementsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theVisualsPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theUppaalPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theDeclarationsPackage.initializePackageContents();
		theGlobalPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theTemplatesPackage.initializePackageContents();
		theStatementsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theVisualsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTypesPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TypesValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Index() {
		return (EReference)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_BaseType() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredefinedType() {
		return predefinedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredefinedType_Type() {
		return (EAttribute)predefinedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaredType() {
		return declaredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclaredType_TypeDeclaration() {
		return (EReference)declaredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclaredType_TypeDefinition() {
		return (EReference)declaredTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDefinition() {
		return typeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeDefinition_BaseType() {
		return (EAttribute)typeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeReference() {
		return typeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeReference_ReferredType() {
		return (EReference)typeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeSpecification() {
		return typeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarTypeSpecification() {
		return scalarTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarTypeSpecification_SizeExpression() {
		return (EReference)scalarTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructTypeSpecification() {
		return structTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructTypeSpecification_Declaration() {
		return (EReference)structTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeTypeSpecification() {
		return rangeTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeTypeSpecification_Bounds() {
		return (EReference)rangeTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerBounds() {
		return integerBoundsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerBounds_LowerBound() {
		return (EReference)integerBoundsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerBounds_UpperBound() {
		return (EReference)integerBoundsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBuiltInType() {
		return builtInTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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
		typeEClass = createEClass(TYPE);
		createEReference(typeEClass, TYPE__INDEX);
		createEAttribute(typeEClass, TYPE__BASE_TYPE);

		predefinedTypeEClass = createEClass(PREDEFINED_TYPE);
		createEAttribute(predefinedTypeEClass, PREDEFINED_TYPE__TYPE);

		declaredTypeEClass = createEClass(DECLARED_TYPE);
		createEReference(declaredTypeEClass, DECLARED_TYPE__TYPE_DECLARATION);
		createEReference(declaredTypeEClass, DECLARED_TYPE__TYPE_DEFINITION);

		typeDefinitionEClass = createEClass(TYPE_DEFINITION);
		createEAttribute(typeDefinitionEClass, TYPE_DEFINITION__BASE_TYPE);

		typeReferenceEClass = createEClass(TYPE_REFERENCE);
		createEReference(typeReferenceEClass, TYPE_REFERENCE__REFERRED_TYPE);

		typeSpecificationEClass = createEClass(TYPE_SPECIFICATION);

		scalarTypeSpecificationEClass = createEClass(SCALAR_TYPE_SPECIFICATION);
		createEReference(scalarTypeSpecificationEClass, SCALAR_TYPE_SPECIFICATION__SIZE_EXPRESSION);

		structTypeSpecificationEClass = createEClass(STRUCT_TYPE_SPECIFICATION);
		createEReference(structTypeSpecificationEClass, STRUCT_TYPE_SPECIFICATION__DECLARATION);

		rangeTypeSpecificationEClass = createEClass(RANGE_TYPE_SPECIFICATION);
		createEReference(rangeTypeSpecificationEClass, RANGE_TYPE_SPECIFICATION__BOUNDS);

		integerBoundsEClass = createEClass(INTEGER_BOUNDS);
		createEReference(integerBoundsEClass, INTEGER_BOUNDS__LOWER_BOUND);
		createEReference(integerBoundsEClass, INTEGER_BOUNDS__UPPER_BOUND);

		// Create enums
		builtInTypeEEnum = createEEnum(BUILT_IN_TYPE);
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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		typeEClass.getESuperTypes().add(theCorePackage.getNamedElement());
		predefinedTypeEClass.getESuperTypes().add(this.getType());
		declaredTypeEClass.getESuperTypes().add(this.getType());
		typeReferenceEClass.getESuperTypes().add(this.getTypeDefinition());
		typeSpecificationEClass.getESuperTypes().add(this.getTypeDefinition());
		scalarTypeSpecificationEClass.getESuperTypes().add(this.getTypeSpecification());
		structTypeSpecificationEClass.getESuperTypes().add(this.getTypeSpecification());
		rangeTypeSpecificationEClass.getESuperTypes().add(this.getTypeSpecification());

		// Initialize classes, features, and operations; add parameters
		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType_Index(), theDeclarationsPackage.getIndex(), null, "index", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_BaseType(), this.getBuiltInType(), "baseType", null, 0, 1, Type.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(predefinedTypeEClass, PredefinedType.class, "PredefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPredefinedType_Type(), this.getBuiltInType(), "type", null, 1, 1, PredefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declaredTypeEClass, DeclaredType.class, "DeclaredType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclaredType_TypeDeclaration(), theDeclarationsPackage.getTypeDeclaration(), theDeclarationsPackage.getTypeDeclaration_Type(), "typeDeclaration", null, 1, 1, DeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeclaredType_TypeDefinition(), this.getTypeDefinition(), null, "typeDefinition", null, 1, 1, DeclaredType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeDefinition_BaseType(), this.getBuiltInType(), "baseType", null, 0, 1, TypeDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(typeReferenceEClass, TypeReference.class, "TypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeReference_ReferredType(), this.getType(), null, "referredType", null, 1, 1, TypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecificationEClass, TypeSpecification.class, "TypeSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scalarTypeSpecificationEClass, ScalarTypeSpecification.class, "ScalarTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScalarTypeSpecification_SizeExpression(), theExpressionsPackage.getExpression(), null, "sizeExpression", null, 1, 1, ScalarTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structTypeSpecificationEClass, StructTypeSpecification.class, "StructTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructTypeSpecification_Declaration(), theDeclarationsPackage.getDataVariableDeclaration(), null, "declaration", null, 1, -1, StructTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rangeTypeSpecificationEClass, RangeTypeSpecification.class, "RangeTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeTypeSpecification_Bounds(), this.getIntegerBounds(), null, "bounds", null, 1, 1, RangeTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerBoundsEClass, IntegerBounds.class, "IntegerBounds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegerBounds_LowerBound(), theExpressionsPackage.getExpression(), null, "lowerBound", null, 1, 1, IntegerBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntegerBounds_UpperBound(), theExpressionsPackage.getExpression(), null, "upperBound", null, 1, 1, IntegerBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(builtInTypeEEnum, BuiltInType.class, "BuiltInType");
		addEEnumLiteral(builtInTypeEEnum, BuiltInType.INT);
		addEEnumLiteral(builtInTypeEEnum, BuiltInType.CLOCK);
		addEEnumLiteral(builtInTypeEEnum, BuiltInType.CHAN);
		addEEnumLiteral(builtInTypeEEnum, BuiltInType.BOOL);
		addEEnumLiteral(builtInTypeEEnum, BuiltInType.VOID);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
		  (structTypeSpecificationEClass, 
		   source, 
		   new String[] {
			 "constraints", "UniqueFieldNames"
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
		  (getType_BaseType(), 
		   source, 
		   new String[] {
			 "derivation", "if self.oclIsKindOf(DeclaredType)\r\nthen \r\n\tif self.oclAsType(DeclaredType).typeDefinition.oclIsUndefined()\r\n\tthen null\r\n\telse self.oclAsType(DeclaredType).typeDefinition.baseType\r\n\tendif\r\nelse \r\n\tif self.oclIsKindOf(PredefinedType)\r\n\tthen self.oclAsType(PredefinedType).type\r\n\telse null\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (getDeclaredType_TypeDefinition(), 
		   source, 
		   new String[] {
			 "derivation", "if self.typeDeclaration.oclIsUndefined()\r\nthen null\r\nelse self.typeDeclaration.typeDefinition\r\nendif"
		   });	
		addAnnotation
		  (getTypeDefinition_BaseType(), 
		   source, 
		   new String[] {
			 "derivation", "if self.oclIsKindOf(TypeReference)\r\nthen \r\n\tif self.oclAsType(TypeReference).referredType.oclIsUndefined()\r\n\tthen null\r\n\telse self.oclAsType(TypeReference).referredType.baseType\r\n\tendif\r\nelse \r\n\tif self.oclIsKindOf(ScalarTypeSpecification) or self.oclIsKindOf(RangeTypeSpecification)\r\n\tthen BuiltInType::INT\r\n\telse null\r\n\tendif\r\nendif"
		   });	
		addAnnotation
		  (structTypeSpecificationEClass, 
		   source, 
		   new String[] {
			 "UniqueFieldNames", "self.declaration->collect(variable)->isUnique(name)"
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
		  (integerBoundsEClass, 
		   source, 
		   new String[] {
			 "name", "IntegerBounds",
			 "kind", "empty"
		   });
	}

} //TypesPackageImpl
