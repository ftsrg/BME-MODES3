/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import de.uni_paderborn.uppaal.declarations.impl.VariableContainerImpl;
import de.uni_paderborn.uppaal.templates.Selection;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.SelectionImpl#getSelectStatement <em>Select Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionImpl extends VariableContainerImpl implements Selection {
	/**
	 * The default value of the '{@link #getSelectStatement() <em>Select Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECT_STATEMENT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSelectStatement() <em>Select Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectStatement()
	 * @generated
	 * @ordered
	 */
	protected String selectStatement = SELECT_STATEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelectStatement() {
		return selectStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectStatement(String newSelectStatement) {
		String oldSelectStatement = selectStatement;
		selectStatement = newSelectStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.SELECTION__SELECT_STATEMENT, oldSelectStatement, selectStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatesPackage.SELECTION__SELECT_STATEMENT:
				return getSelectStatement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatesPackage.SELECTION__SELECT_STATEMENT:
				setSelectStatement((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TemplatesPackage.SELECTION__SELECT_STATEMENT:
				setSelectStatement(SELECT_STATEMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TemplatesPackage.SELECTION__SELECT_STATEMENT:
				return SELECT_STATEMENT_EDEFAULT == null ? selectStatement != null : !SELECT_STATEMENT_EDEFAULT.equals(selectStatement);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SelectStatement: ");
		result.append(selectStatement);
		result.append(')');
		return result.toString();
	}

} //SelectionImpl
