/**
 */
package de.uni_paderborn.uppaal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uni_paderborn.uppaal.UppaalFactory;
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
import de.uni_paderborn.uppaal.statements.StatementsPackage;
import de.uni_paderborn.uppaal.statements.impl.StatementsPackageImpl;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import de.uni_paderborn.uppaal.templates.impl.TemplatesPackageImpl;
import de.uni_paderborn.uppaal.types.TypesPackage;
import de.uni_paderborn.uppaal.types.impl.TypesPackageImpl;
import de.uni_paderborn.uppaal.util.UppaalValidator;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;
import de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UppaalPackageImpl extends EPackageImpl implements UppaalPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ntaEClass = null;

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
	 * @see de.uni_paderborn.uppaal.UppaalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UppaalPackageImpl() {
		super(eNS_URI, UppaalFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UppaalPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UppaalPackage init() {
		if (isInited) return (UppaalPackage)EPackage.Registry.INSTANCE.getEPackage(UppaalPackage.eNS_URI);

		// Obtain or create and register package
		UppaalPackageImpl theUppaalPackage = (UppaalPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UppaalPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UppaalPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		DeclarationsPackageImpl theDeclarationsPackage = (DeclarationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) instanceof DeclarationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI) : DeclarationsPackage.eINSTANCE);
		GlobalPackageImpl theGlobalPackage = (GlobalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) instanceof GlobalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GlobalPackage.eNS_URI) : GlobalPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
		StatementsPackageImpl theStatementsPackage = (StatementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) instanceof StatementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI) : StatementsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		VisualsPackageImpl theVisualsPackage = (VisualsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) instanceof VisualsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI) : VisualsPackage.eINSTANCE);

		// Create package meta-data objects
		theUppaalPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theDeclarationsPackage.createPackageContents();
		theGlobalPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theTemplatesPackage.createPackageContents();
		theStatementsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theVisualsPackage.createPackageContents();

		// Initialize created meta-data
		theUppaalPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theDeclarationsPackage.initializePackageContents();
		theGlobalPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theTemplatesPackage.initializePackageContents();
		theStatementsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theVisualsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theUppaalPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return UppaalValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theUppaalPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UppaalPackage.eNS_URI, theUppaalPackage);
		return theUppaalPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNTA() {
		return ntaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_GlobalDeclarations() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Template() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_SystemDeclarations() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Int() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Bool() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Clock() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Chan() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNTA_Void() {
		return (EReference)ntaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UppaalFactory getUppaalFactory() {
		return (UppaalFactory)getEFactoryInstance();
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
		ntaEClass = createEClass(NTA);
		createEReference(ntaEClass, NTA__GLOBAL_DECLARATIONS);
		createEReference(ntaEClass, NTA__TEMPLATE);
		createEReference(ntaEClass, NTA__SYSTEM_DECLARATIONS);
		createEReference(ntaEClass, NTA__INT);
		createEReference(ntaEClass, NTA__BOOL);
		createEReference(ntaEClass, NTA__CLOCK);
		createEReference(ntaEClass, NTA__CHAN);
		createEReference(ntaEClass, NTA__VOID);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		DeclarationsPackage theDeclarationsPackage = (DeclarationsPackage)EPackage.Registry.INSTANCE.getEPackage(DeclarationsPackage.eNS_URI);
		TemplatesPackage theTemplatesPackage = (TemplatesPackage)EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI);
		StatementsPackage theStatementsPackage = (StatementsPackage)EPackage.Registry.INSTANCE.getEPackage(StatementsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		VisualsPackage theVisualsPackage = (VisualsPackage)EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCorePackage);
		getESubpackages().add(theTypesPackage);
		getESubpackages().add(theDeclarationsPackage);
		getESubpackages().add(theTemplatesPackage);
		getESubpackages().add(theStatementsPackage);
		getESubpackages().add(theExpressionsPackage);
		getESubpackages().add(theVisualsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ntaEClass.getESuperTypes().add(theCorePackage.getNamedElement());
		ntaEClass.getESuperTypes().add(theCorePackage.getCommentableElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(ntaEClass, de.uni_paderborn.uppaal.NTA.class, "NTA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNTA_GlobalDeclarations(), theDeclarationsPackage.getGlobalDeclarations(), null, "globalDeclarations", null, 0, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Template(), theTemplatesPackage.getTemplate(), null, "template", null, 1, -1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_SystemDeclarations(), theDeclarationsPackage.getSystemDeclarations(), null, "systemDeclarations", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Int(), theTypesPackage.getPredefinedType(), null, "int", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Bool(), theTypesPackage.getPredefinedType(), null, "bool", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Clock(), theTypesPackage.getPredefinedType(), null, "clock", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Chan(), theTypesPackage.getPredefinedType(), null, "chan", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNTA_Void(), theTypesPackage.getPredefinedType(), null, "void", null, 1, 1, de.uni_paderborn.uppaal.NTA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

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
		  (ntaEClass, 
		   source, 
		   new String[] {
			 "constraints", "MatchingIntDetails MatchingBoolDetails MatchingClockDetails MatchingChanDetails MatchingVoidDetails UniqueTemplateNames"
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
		  (ntaEClass, 
		   source, 
		   new String[] {
			 "name", "NTA",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNTA_GlobalDeclarations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "globalDeclarations"
		   });	
		addAnnotation
		  (getNTA_Template(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "template"
		   });	
		addAnnotation
		  (getNTA_SystemDeclarations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "systemDeclarations"
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
		  (ntaEClass, 
		   source, 
		   new String[] {
			 "MatchingIntDetails", "(not self.int.oclIsUndefined())\r\nimplies\r\n((self.int.type = types::BuiltInType::INT) and (self.int.name.equalsIgnoreCase(\'int\')))",
			 "MatchingBoolDetails", "(not self.bool.oclIsUndefined())\r\nimplies\r\n((self.bool.type = types::BuiltInType::BOOL) and (self.bool.name.equalsIgnoreCase(\'bool\')))",
			 "MatchingClockDetails", "(not self.clock.oclIsUndefined())\r\nimplies\r\n((self.clock.type = types::BuiltInType::CLOCK) and (self.clock.name.equalsIgnoreCase(\'clock\')))",
			 "MatchingChanDetails", "(not self.chan.oclIsUndefined())\r\nimplies\r\n((self.chan.type = types::BuiltInType::CHAN) and (self.chan.name.equalsIgnoreCase(\'chan\')))",
			 "MatchingVoidDetails", "(not self.void.oclIsUndefined())\r\nimplies\r\n((self.void.type = types::BuiltInType::VOID) and (self.void.name.equalsIgnoreCase(\'void\')))",
			 "UniqueTemplateNames", "self.template->isUnique(name)"
		   });
	}

} //UppaalPackageImpl
