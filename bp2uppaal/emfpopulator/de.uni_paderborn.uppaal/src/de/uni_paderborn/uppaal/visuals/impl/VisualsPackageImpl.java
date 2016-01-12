/**
 */
package de.uni_paderborn.uppaal.visuals.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import de.uni_paderborn.uppaal.types.TypesPackage;
import de.uni_paderborn.uppaal.types.impl.TypesPackageImpl;
import de.uni_paderborn.uppaal.visuals.ColorKind;
import de.uni_paderborn.uppaal.visuals.ColoredElement;
import de.uni_paderborn.uppaal.visuals.LinearElement;
import de.uni_paderborn.uppaal.visuals.PlanarElement;
import de.uni_paderborn.uppaal.visuals.Point;
import de.uni_paderborn.uppaal.visuals.VisualsFactory;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualsPackageImpl extends EPackageImpl implements VisualsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coloredElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass planarElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linearElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum colorKindEEnum = null;

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
	 * @see de.uni_paderborn.uppaal.visuals.VisualsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisualsPackageImpl() {
		super(eNS_URI, VisualsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link VisualsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisualsPackage init() {
		if (isInited) return (VisualsPackage)EPackage.Registry.INSTANCE.getEPackage(VisualsPackage.eNS_URI);

		// Obtain or create and register package
		VisualsPackageImpl theVisualsPackage = (VisualsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisualsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisualsPackageImpl());

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
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);

		// Create package meta-data objects
		theVisualsPackage.createPackageContents();
		theUppaalPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theDeclarationsPackage.createPackageContents();
		theGlobalPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theTemplatesPackage.createPackageContents();
		theStatementsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();

		// Initialize created meta-data
		theVisualsPackage.initializePackageContents();
		theUppaalPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theDeclarationsPackage.initializePackageContents();
		theGlobalPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theTemplatesPackage.initializePackageContents();
		theStatementsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisualsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisualsPackage.eNS_URI, theVisualsPackage);
		return theVisualsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColoredElement() {
		return coloredElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColoredElement_Color() {
		return (EAttribute)coloredElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColoredElement_ColorCode() {
		return (EAttribute)coloredElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlanarElement() {
		return planarElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlanarElement_Position() {
		return (EReference)planarElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinearElement() {
		return linearElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinearElement_BendPoint() {
		return (EReference)linearElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPoint() {
		return pointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_X() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPoint_Y() {
		return (EAttribute)pointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getColorKind() {
		return colorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualsFactory getVisualsFactory() {
		return (VisualsFactory)getEFactoryInstance();
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
		coloredElementEClass = createEClass(COLORED_ELEMENT);
		createEAttribute(coloredElementEClass, COLORED_ELEMENT__COLOR);
		createEAttribute(coloredElementEClass, COLORED_ELEMENT__COLOR_CODE);

		planarElementEClass = createEClass(PLANAR_ELEMENT);
		createEReference(planarElementEClass, PLANAR_ELEMENT__POSITION);

		linearElementEClass = createEClass(LINEAR_ELEMENT);
		createEReference(linearElementEClass, LINEAR_ELEMENT__BEND_POINT);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);

		// Create enums
		colorKindEEnum = createEEnum(COLOR_KIND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(coloredElementEClass, ColoredElement.class, "ColoredElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColoredElement_Color(), this.getColorKind(), "color", null, 0, 1, ColoredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColoredElement_ColorCode(), ecorePackage.getEString(), "colorCode", null, 0, 1, ColoredElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(planarElementEClass, PlanarElement.class, "PlanarElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlanarElement_Position(), this.getPoint(), null, "position", null, 0, 1, PlanarElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linearElementEClass, LinearElement.class, "LinearElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinearElement_BendPoint(), this.getPoint(), null, "bendPoint", null, 0, -1, LinearElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointEClass, Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), ecorePackage.getEInt(), "x", "0", 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoint_Y(), ecorePackage.getEInt(), "y", "0", 1, 1, Point.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(colorKindEEnum, ColorKind.class, "ColorKind");
		addEEnumLiteral(colorKindEEnum, ColorKind.DEFAULT);
		addEEnumLiteral(colorKindEEnum, ColorKind.WHITE);
		addEEnumLiteral(colorKindEEnum, ColorKind.LIGHTGREY);
		addEEnumLiteral(colorKindEEnum, ColorKind.DARKGREY);
		addEEnumLiteral(colorKindEEnum, ColorKind.BLACK);
		addEEnumLiteral(colorKindEEnum, ColorKind.BLUE);
		addEEnumLiteral(colorKindEEnum, ColorKind.CYAN);
		addEEnumLiteral(colorKindEEnum, ColorKind.GREEN);
		addEEnumLiteral(colorKindEEnum, ColorKind.MAGENTA);
		addEEnumLiteral(colorKindEEnum, ColorKind.ORANGE);
		addEEnumLiteral(colorKindEEnum, ColorKind.PINK);
		addEEnumLiteral(colorKindEEnum, ColorKind.RED);
		addEEnumLiteral(colorKindEEnum, ColorKind.YELLOW);
		addEEnumLiteral(colorKindEEnum, ColorKind.SELF_DEFINED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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
	}

} //VisualsPackageImpl
