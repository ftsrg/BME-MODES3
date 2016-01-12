/**
 */
package de.uni_paderborn.uppaal;

import org.eclipse.emf.common.util.EList;

import de.uni_paderborn.uppaal.core.CommentableElement;
import de.uni_paderborn.uppaal.core.NamedElement;
import de.uni_paderborn.uppaal.declarations.GlobalDeclarations;
import de.uni_paderborn.uppaal.declarations.SystemDeclarations;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.types.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NTA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A 'Network of Timed Automata' as basic input to Uppaal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getGlobalDeclarations <em>Global Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getTemplate <em>Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getSystemDeclarations <em>System Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getInt <em>Int</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getBool <em>Bool</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getClock <em>Clock</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getChan <em>Chan</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.NTA#getVoid <em>Void</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA()
 * @model extendedMetaData="name='NTA' kind='elementOnly'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL MatchingIntDetails='(not self.int.oclIsUndefined())\r\nimplies\r\n((self.int.type = types::BuiltInType::INT) and (self.int.name.equalsIgnoreCase(\'int\')))' MatchingBoolDetails='(not self.bool.oclIsUndefined())\r\nimplies\r\n((self.bool.type = types::BuiltInType::BOOL) and (self.bool.name.equalsIgnoreCase(\'bool\')))' MatchingClockDetails='(not self.clock.oclIsUndefined())\r\nimplies\r\n((self.clock.type = types::BuiltInType::CLOCK) and (self.clock.name.equalsIgnoreCase(\'clock\')))' MatchingChanDetails='(not self.chan.oclIsUndefined())\r\nimplies\r\n((self.chan.type = types::BuiltInType::CHAN) and (self.chan.name.equalsIgnoreCase(\'chan\')))' MatchingVoidDetails='(not self.void.oclIsUndefined())\r\nimplies\r\n((self.void.type = types::BuiltInType::VOID) and (self.void.name.equalsIgnoreCase(\'void\')))' UniqueTemplateNames='self.template->isUnique(name)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MatchingIntDetails MatchingBoolDetails MatchingClockDetails MatchingChanDetails MatchingVoidDetails UniqueTemplateNames'"
 * @generated
 */
public interface NTA extends NamedElement, CommentableElement {
	/**
	 * Returns the value of the '<em><b>Global Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The global declarations for the NTA.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global Declarations</em>' containment reference.
	 * @see #setGlobalDeclarations(GlobalDeclarations)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_GlobalDeclarations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='globalDeclarations'"
	 * @generated
	 */
	GlobalDeclarations getGlobalDeclarations();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getGlobalDeclarations <em>Global Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Declarations</em>' containment reference.
	 * @see #getGlobalDeclarations()
	 * @generated
	 */
	void setGlobalDeclarations(GlobalDeclarations value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' containment reference list.
	 * The list contents are of type {@link de.uni_paderborn.uppaal.templates.Template}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Timed Automata templates of the NTA.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template</em>' containment reference list.
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Template()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='template'"
	 * @generated
	 */
	EList<Template> getTemplate();

	/**
	 * Returns the value of the '<em><b>System Declarations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The declarations of process instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Declarations</em>' containment reference.
	 * @see #setSystemDeclarations(SystemDeclarations)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_SystemDeclarations()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='systemDeclarations'"
	 * @generated
	 */
	SystemDeclarations getSystemDeclarations();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getSystemDeclarations <em>System Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Declarations</em>' containment reference.
	 * @see #getSystemDeclarations()
	 * @generated
	 */
	void setSystemDeclarations(SystemDeclarations value);

	/**
	 * Returns the value of the '<em><b>Int</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predefined type 'int'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Int</em>' containment reference.
	 * @see #setInt(PredefinedType)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Int()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PredefinedType getInt();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getInt <em>Int</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int</em>' containment reference.
	 * @see #getInt()
	 * @generated
	 */
	void setInt(PredefinedType value);

	/**
	 * Returns the value of the '<em><b>Bool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predefined type 'bool'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bool</em>' containment reference.
	 * @see #setBool(PredefinedType)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Bool()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PredefinedType getBool();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getBool <em>Bool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool</em>' containment reference.
	 * @see #getBool()
	 * @generated
	 */
	void setBool(PredefinedType value);

	/**
	 * Returns the value of the '<em><b>Clock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predefined type 'clock'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Clock</em>' containment reference.
	 * @see #setClock(PredefinedType)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Clock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PredefinedType getClock();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getClock <em>Clock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' containment reference.
	 * @see #getClock()
	 * @generated
	 */
	void setClock(PredefinedType value);

	/**
	 * Returns the value of the '<em><b>Chan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predefined type 'chan'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Chan</em>' containment reference.
	 * @see #setChan(PredefinedType)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Chan()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PredefinedType getChan();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getChan <em>Chan</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chan</em>' containment reference.
	 * @see #getChan()
	 * @generated
	 */
	void setChan(PredefinedType value);

	/**
	 * Returns the value of the '<em><b>Void</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The predefined dummy type 'void'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Void</em>' containment reference.
	 * @see #setVoid(PredefinedType)
	 * @see de.uni_paderborn.uppaal.UppaalPackage#getNTA_Void()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PredefinedType getVoid();

	/**
	 * Sets the value of the '{@link de.uni_paderborn.uppaal.NTA#getVoid <em>Void</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Void</em>' containment reference.
	 * @see #getVoid()
	 * @generated
	 */
	void setVoid(PredefinedType value);

} // NTA
