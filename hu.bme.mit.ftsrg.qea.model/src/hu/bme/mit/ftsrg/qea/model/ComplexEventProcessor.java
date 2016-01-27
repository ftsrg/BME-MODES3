/**
 */
package hu.bme.mit.ftsrg.qea.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor#getAutomata <em>Automata</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor#getSymbolicEvents <em>Symbolic Events</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getComplexEventProcessor()
 * @model
 * @generated
 */
public interface ComplexEventProcessor extends EObject {
	/**
	 * Returns the value of the '<em><b>Automata</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.Automaton}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Automata</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Automata</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getComplexEventProcessor_Automata()
	 * @model containment="true"
	 * @generated
	 */
	EList<Automaton> getAutomata();

	/**
	 * Returns the value of the '<em><b>Symbolic Events</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.ftsrg.qea.model.SymbolicInputEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbolic Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbolic Events</em>' containment reference list.
	 * @see hu.bme.mit.ftsrg.qea.model.ModelPackage#getComplexEventProcessor_SymbolicEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<SymbolicInputEvent> getSymbolicEvents();

} // ComplexEventProcessor
