/**
 */
package de.uni_paderborn.uppaal.visuals;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Provides support for the visual representation of model elements.
 * <!-- end-model-doc -->
 * @see de.uni_paderborn.uppaal.visuals.VisualsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface VisualsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visuals";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.uni-paderborn.de/uppaal/visuals/0.4.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visuals";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualsPackage eINSTANCE = de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl <em>Colored Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl
	 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getColoredElement()
	 * @generated
	 */
	int COLORED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLORED_ELEMENT__COLOR = 0;

	/**
	 * The feature id for the '<em><b>Color Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLORED_ELEMENT__COLOR_CODE = 1;

	/**
	 * The number of structural features of the '<em>Colored Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLORED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Colored Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLORED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.visuals.impl.PlanarElementImpl <em>Planar Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.visuals.impl.PlanarElementImpl
	 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getPlanarElement()
	 * @generated
	 */
	int PLANAR_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANAR_ELEMENT__POSITION = 0;

	/**
	 * The number of structural features of the '<em>Planar Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANAR_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Planar Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANAR_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.visuals.impl.LinearElementImpl <em>Linear Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.visuals.impl.LinearElementImpl
	 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getLinearElement()
	 * @generated
	 */
	int LINEAR_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Bend Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_ELEMENT__BEND_POINT = 0;

	/**
	 * The number of structural features of the '<em>Linear Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Linear Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.visuals.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.visuals.impl.PointImpl
	 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uni_paderborn.uppaal.visuals.ColorKind <em>Color Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uni_paderborn.uppaal.visuals.ColorKind
	 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getColorKind()
	 * @generated
	 */
	int COLOR_KIND = 4;


	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.visuals.ColoredElement <em>Colored Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Colored Element</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.ColoredElement
	 * @generated
	 */
	EClass getColoredElement();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.ColoredElement#getColor()
	 * @see #getColoredElement()
	 * @generated
	 */
	EAttribute getColoredElement_Color();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.visuals.ColoredElement#getColorCode <em>Color Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color Code</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.ColoredElement#getColorCode()
	 * @see #getColoredElement()
	 * @generated
	 */
	EAttribute getColoredElement_ColorCode();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.visuals.PlanarElement <em>Planar Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Planar Element</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.PlanarElement
	 * @generated
	 */
	EClass getPlanarElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.uni_paderborn.uppaal.visuals.PlanarElement#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.PlanarElement#getPosition()
	 * @see #getPlanarElement()
	 * @generated
	 */
	EReference getPlanarElement_Position();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.visuals.LinearElement <em>Linear Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Element</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.LinearElement
	 * @generated
	 */
	EClass getLinearElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uni_paderborn.uppaal.visuals.LinearElement#getBendPoint <em>Bend Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bend Point</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.LinearElement#getBendPoint()
	 * @see #getLinearElement()
	 * @generated
	 */
	EReference getLinearElement_BendPoint();

	/**
	 * Returns the meta object for class '{@link de.uni_paderborn.uppaal.visuals.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.visuals.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link de.uni_paderborn.uppaal.visuals.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for enum '{@link de.uni_paderborn.uppaal.visuals.ColorKind <em>Color Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Color Kind</em>'.
	 * @see de.uni_paderborn.uppaal.visuals.ColorKind
	 * @generated
	 */
	EEnum getColorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisualsFactory getVisualsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl <em>Colored Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.visuals.impl.ColoredElementImpl
		 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getColoredElement()
		 * @generated
		 */
		EClass COLORED_ELEMENT = eINSTANCE.getColoredElement();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLORED_ELEMENT__COLOR = eINSTANCE.getColoredElement_Color();

		/**
		 * The meta object literal for the '<em><b>Color Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLORED_ELEMENT__COLOR_CODE = eINSTANCE.getColoredElement_ColorCode();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.visuals.impl.PlanarElementImpl <em>Planar Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.visuals.impl.PlanarElementImpl
		 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getPlanarElement()
		 * @generated
		 */
		EClass PLANAR_ELEMENT = eINSTANCE.getPlanarElement();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLANAR_ELEMENT__POSITION = eINSTANCE.getPlanarElement_Position();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.visuals.impl.LinearElementImpl <em>Linear Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.visuals.impl.LinearElementImpl
		 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getLinearElement()
		 * @generated
		 */
		EClass LINEAR_ELEMENT = eINSTANCE.getLinearElement();

		/**
		 * The meta object literal for the '<em><b>Bend Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINEAR_ELEMENT__BEND_POINT = eINSTANCE.getLinearElement_BendPoint();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.visuals.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.visuals.impl.PointImpl
		 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '{@link de.uni_paderborn.uppaal.visuals.ColorKind <em>Color Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uni_paderborn.uppaal.visuals.ColorKind
		 * @see de.uni_paderborn.uppaal.visuals.impl.VisualsPackageImpl#getColorKind()
		 * @generated
		 */
		EEnum COLOR_KIND = eINSTANCE.getColorKind();

	}

} //VisualsPackage
