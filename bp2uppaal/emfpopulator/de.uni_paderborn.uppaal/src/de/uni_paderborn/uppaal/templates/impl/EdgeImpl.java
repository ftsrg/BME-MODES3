/**
 */
package de.uni_paderborn.uppaal.templates.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uni_paderborn.uppaal.core.CommentableElement;
import de.uni_paderborn.uppaal.core.CorePackage;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.templates.Edge;
import de.uni_paderborn.uppaal.templates.Location;
import de.uni_paderborn.uppaal.templates.Selection;
import de.uni_paderborn.uppaal.templates.Synchronization;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.templates.TemplatesPackage;
import de.uni_paderborn.uppaal.visuals.ColorKind;
import de.uni_paderborn.uppaal.visuals.ColoredElement;
import de.uni_paderborn.uppaal.visuals.VisualsPackage;
import de.uni_paderborn.uppaal.visuals.impl.LinearElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getColor <em>Color</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getColorCode <em>Color Code</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getParentTemplate <em>Parent Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getSynchronization <em>Synchronization</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.templates.impl.EdgeImpl#getSelection <em>Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends LinearElementImpl implements Edge {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final ColorKind COLOR_EDEFAULT = ColorKind.DEFAULT;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected ColorKind color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorCode() <em>Color Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColorCode() <em>Color Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorCode()
	 * @generated
	 * @ordered
	 */
	protected String colorCode = COLOR_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Location source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Location target;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Expression guard;

	/**
	 * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdate()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> update;

	/**
	 * The cached value of the '{@link #getSynchronization() <em>Synchronization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynchronization()
	 * @generated
	 * @ordered
	 */
	protected Synchronization synchronization;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<Selection> selection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TemplatesPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorKind getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(ColorKind newColor) {
		ColorKind oldColor = color;
		color = newColor == null ? COLOR_EDEFAULT : newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorCode(String newColorCode) {
		String oldColorCode = colorCode;
		colorCode = newColorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__COLOR_CODE, oldColorCode, colorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Location)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatesPackage.EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Location newSource) {
		Location oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Location)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TemplatesPackage.EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Location basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Location newTarget) {
		Location oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getParentTemplate() {
		if (eContainerFeatureID() != TemplatesPackage.EDGE__PARENT_TEMPLATE) return null;
		return (Template)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentTemplate(Template newParentTemplate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentTemplate, TemplatesPackage.EDGE__PARENT_TEMPLATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentTemplate(Template newParentTemplate) {
		if (newParentTemplate != eInternalContainer() || (eContainerFeatureID() != TemplatesPackage.EDGE__PARENT_TEMPLATE && newParentTemplate != null)) {
			if (EcoreUtil.isAncestor(this, newParentTemplate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentTemplate != null)
				msgs = ((InternalEObject)newParentTemplate).eInverseAdd(this, TemplatesPackage.TEMPLATE__EDGE, Template.class, msgs);
			msgs = basicSetParentTemplate(newParentTemplate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__PARENT_TEMPLATE, newParentTemplate, newParentTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(Expression newGuard, NotificationChain msgs) {
		Expression oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Expression newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.EDGE__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.EDGE__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getUpdate() {
		if (update == null) {
			update = new EObjectContainmentEList<Expression>(Expression.class, this, TemplatesPackage.EDGE__UPDATE);
		}
		return update;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Synchronization getSynchronization() {
		return synchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSynchronization(Synchronization newSynchronization, NotificationChain msgs) {
		Synchronization oldSynchronization = synchronization;
		synchronization = newSynchronization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__SYNCHRONIZATION, oldSynchronization, newSynchronization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynchronization(Synchronization newSynchronization) {
		if (newSynchronization != synchronization) {
			NotificationChain msgs = null;
			if (synchronization != null)
				msgs = ((InternalEObject)synchronization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.EDGE__SYNCHRONIZATION, null, msgs);
			if (newSynchronization != null)
				msgs = ((InternalEObject)newSynchronization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TemplatesPackage.EDGE__SYNCHRONIZATION, null, msgs);
			msgs = basicSetSynchronization(newSynchronization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TemplatesPackage.EDGE__SYNCHRONIZATION, newSynchronization, newSynchronization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Selection> getSelection() {
		if (selection == null) {
			selection = new EObjectContainmentEList<Selection>(Selection.class, this, TemplatesPackage.EDGE__SELECTION);
		}
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentTemplate((Template)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				return basicSetParentTemplate(null, msgs);
			case TemplatesPackage.EDGE__GUARD:
				return basicSetGuard(null, msgs);
			case TemplatesPackage.EDGE__UPDATE:
				return ((InternalEList<?>)getUpdate()).basicRemove(otherEnd, msgs);
			case TemplatesPackage.EDGE__SYNCHRONIZATION:
				return basicSetSynchronization(null, msgs);
			case TemplatesPackage.EDGE__SELECTION:
				return ((InternalEList<?>)getSelection()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				return eInternalContainer().eInverseRemove(this, TemplatesPackage.TEMPLATE__EDGE, Template.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TemplatesPackage.EDGE__COMMENT:
				return getComment();
			case TemplatesPackage.EDGE__COLOR:
				return getColor();
			case TemplatesPackage.EDGE__COLOR_CODE:
				return getColorCode();
			case TemplatesPackage.EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case TemplatesPackage.EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				return getParentTemplate();
			case TemplatesPackage.EDGE__GUARD:
				return getGuard();
			case TemplatesPackage.EDGE__UPDATE:
				return getUpdate();
			case TemplatesPackage.EDGE__SYNCHRONIZATION:
				return getSynchronization();
			case TemplatesPackage.EDGE__SELECTION:
				return getSelection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TemplatesPackage.EDGE__COMMENT:
				setComment((String)newValue);
				return;
			case TemplatesPackage.EDGE__COLOR:
				setColor((ColorKind)newValue);
				return;
			case TemplatesPackage.EDGE__COLOR_CODE:
				setColorCode((String)newValue);
				return;
			case TemplatesPackage.EDGE__SOURCE:
				setSource((Location)newValue);
				return;
			case TemplatesPackage.EDGE__TARGET:
				setTarget((Location)newValue);
				return;
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				setParentTemplate((Template)newValue);
				return;
			case TemplatesPackage.EDGE__GUARD:
				setGuard((Expression)newValue);
				return;
			case TemplatesPackage.EDGE__UPDATE:
				getUpdate().clear();
				getUpdate().addAll((Collection<? extends Expression>)newValue);
				return;
			case TemplatesPackage.EDGE__SYNCHRONIZATION:
				setSynchronization((Synchronization)newValue);
				return;
			case TemplatesPackage.EDGE__SELECTION:
				getSelection().clear();
				getSelection().addAll((Collection<? extends Selection>)newValue);
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
			case TemplatesPackage.EDGE__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case TemplatesPackage.EDGE__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case TemplatesPackage.EDGE__COLOR_CODE:
				setColorCode(COLOR_CODE_EDEFAULT);
				return;
			case TemplatesPackage.EDGE__SOURCE:
				setSource((Location)null);
				return;
			case TemplatesPackage.EDGE__TARGET:
				setTarget((Location)null);
				return;
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				setParentTemplate((Template)null);
				return;
			case TemplatesPackage.EDGE__GUARD:
				setGuard((Expression)null);
				return;
			case TemplatesPackage.EDGE__UPDATE:
				getUpdate().clear();
				return;
			case TemplatesPackage.EDGE__SYNCHRONIZATION:
				setSynchronization((Synchronization)null);
				return;
			case TemplatesPackage.EDGE__SELECTION:
				getSelection().clear();
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
			case TemplatesPackage.EDGE__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case TemplatesPackage.EDGE__COLOR:
				return color != COLOR_EDEFAULT;
			case TemplatesPackage.EDGE__COLOR_CODE:
				return COLOR_CODE_EDEFAULT == null ? colorCode != null : !COLOR_CODE_EDEFAULT.equals(colorCode);
			case TemplatesPackage.EDGE__SOURCE:
				return source != null;
			case TemplatesPackage.EDGE__TARGET:
				return target != null;
			case TemplatesPackage.EDGE__PARENT_TEMPLATE:
				return getParentTemplate() != null;
			case TemplatesPackage.EDGE__GUARD:
				return guard != null;
			case TemplatesPackage.EDGE__UPDATE:
				return update != null && !update.isEmpty();
			case TemplatesPackage.EDGE__SYNCHRONIZATION:
				return synchronization != null;
			case TemplatesPackage.EDGE__SELECTION:
				return selection != null && !selection.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CommentableElement.class) {
			switch (derivedFeatureID) {
				case TemplatesPackage.EDGE__COMMENT: return CorePackage.COMMENTABLE_ELEMENT__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == ColoredElement.class) {
			switch (derivedFeatureID) {
				case TemplatesPackage.EDGE__COLOR: return VisualsPackage.COLORED_ELEMENT__COLOR;
				case TemplatesPackage.EDGE__COLOR_CODE: return VisualsPackage.COLORED_ELEMENT__COLOR_CODE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CommentableElement.class) {
			switch (baseFeatureID) {
				case CorePackage.COMMENTABLE_ELEMENT__COMMENT: return TemplatesPackage.EDGE__COMMENT;
				default: return -1;
			}
		}
		if (baseClass == ColoredElement.class) {
			switch (baseFeatureID) {
				case VisualsPackage.COLORED_ELEMENT__COLOR: return TemplatesPackage.EDGE__COLOR;
				case VisualsPackage.COLORED_ELEMENT__COLOR_CODE: return TemplatesPackage.EDGE__COLOR_CODE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", color: ");
		result.append(color);
		result.append(", colorCode: ");
		result.append(colorCode);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
