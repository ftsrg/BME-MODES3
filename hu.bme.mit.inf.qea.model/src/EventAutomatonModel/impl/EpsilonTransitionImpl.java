/**
 */
package EventAutomatonModel.impl;

import EventAutomatonModel.EpsilonTransition;
import EventAutomatonModel.EventAutomatonModelPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Epsilon Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EpsilonTransitionImpl extends AbstractTransitionImpl implements EpsilonTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EpsilonTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventAutomatonModelPackage.Literals.EPSILON_TRANSITION;
	}

} //EpsilonTransitionImpl
