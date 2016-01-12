/**
 */
package de.uni_paderborn.uppaal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uni_paderborn.uppaal.NTA;
import de.uni_paderborn.uppaal.UppaalPackage;
import de.uni_paderborn.uppaal.core.CommentableElement;
import de.uni_paderborn.uppaal.core.CorePackage;
import de.uni_paderborn.uppaal.core.impl.NamedElementImpl;
import de.uni_paderborn.uppaal.declarations.GlobalDeclarations;
import de.uni_paderborn.uppaal.declarations.SystemDeclarations;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.types.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NTA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getGlobalDeclarations <em>Global Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getSystemDeclarations <em>System Declarations</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getInt <em>Int</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getBool <em>Bool</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getClock <em>Clock</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getChan <em>Chan</em>}</li>
 *   <li>{@link de.uni_paderborn.uppaal.impl.NTAImpl#getVoid <em>Void</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NTAImpl extends NamedElementImpl implements NTA {
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
	 * The cached value of the '{@link #getGlobalDeclarations() <em>Global Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalDeclarations()
	 * @generated
	 * @ordered
	 */
	protected GlobalDeclarations globalDeclarations;

	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected EList<Template> template;

	/**
	 * The cached value of the '{@link #getSystemDeclarations() <em>System Declarations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemDeclarations()
	 * @generated
	 * @ordered
	 */
	protected SystemDeclarations systemDeclarations;

	/**
	 * The cached value of the '{@link #getInt() <em>Int</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInt()
	 * @generated
	 * @ordered
	 */
	protected PredefinedType int_;

	/**
	 * The cached value of the '{@link #getBool() <em>Bool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBool()
	 * @generated
	 * @ordered
	 */
	protected PredefinedType bool;

	/**
	 * The cached value of the '{@link #getClock() <em>Clock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClock()
	 * @generated
	 * @ordered
	 */
	protected PredefinedType clock;

	/**
	 * The cached value of the '{@link #getChan() <em>Chan</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChan()
	 * @generated
	 * @ordered
	 */
	protected PredefinedType chan;

	/**
	 * The cached value of the '{@link #getVoid() <em>Void</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoid()
	 * @generated
	 * @ordered
	 */
	protected PredefinedType void_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NTAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UppaalPackage.Literals.NTA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalDeclarations getGlobalDeclarations() {
		return globalDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGlobalDeclarations(GlobalDeclarations newGlobalDeclarations, NotificationChain msgs) {
		GlobalDeclarations oldGlobalDeclarations = globalDeclarations;
		globalDeclarations = newGlobalDeclarations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__GLOBAL_DECLARATIONS, oldGlobalDeclarations, newGlobalDeclarations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalDeclarations(GlobalDeclarations newGlobalDeclarations) {
		if (newGlobalDeclarations != globalDeclarations) {
			NotificationChain msgs = null;
			if (globalDeclarations != null)
				msgs = ((InternalEObject)globalDeclarations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__GLOBAL_DECLARATIONS, null, msgs);
			if (newGlobalDeclarations != null)
				msgs = ((InternalEObject)newGlobalDeclarations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__GLOBAL_DECLARATIONS, null, msgs);
			msgs = basicSetGlobalDeclarations(newGlobalDeclarations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__GLOBAL_DECLARATIONS, newGlobalDeclarations, newGlobalDeclarations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Template> getTemplate() {
		if (template == null) {
			template = new EObjectContainmentEList<Template>(Template.class, this, UppaalPackage.NTA__TEMPLATE);
		}
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemDeclarations getSystemDeclarations() {
		return systemDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystemDeclarations(SystemDeclarations newSystemDeclarations, NotificationChain msgs) {
		SystemDeclarations oldSystemDeclarations = systemDeclarations;
		systemDeclarations = newSystemDeclarations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__SYSTEM_DECLARATIONS, oldSystemDeclarations, newSystemDeclarations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemDeclarations(SystemDeclarations newSystemDeclarations) {
		if (newSystemDeclarations != systemDeclarations) {
			NotificationChain msgs = null;
			if (systemDeclarations != null)
				msgs = ((InternalEObject)systemDeclarations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__SYSTEM_DECLARATIONS, null, msgs);
			if (newSystemDeclarations != null)
				msgs = ((InternalEObject)newSystemDeclarations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__SYSTEM_DECLARATIONS, null, msgs);
			msgs = basicSetSystemDeclarations(newSystemDeclarations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__SYSTEM_DECLARATIONS, newSystemDeclarations, newSystemDeclarations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedType getInt() {
		return int_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInt(PredefinedType newInt, NotificationChain msgs) {
		PredefinedType oldInt = int_;
		int_ = newInt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__INT, oldInt, newInt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInt(PredefinedType newInt) {
		if (newInt != int_) {
			NotificationChain msgs = null;
			if (int_ != null)
				msgs = ((InternalEObject)int_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__INT, null, msgs);
			if (newInt != null)
				msgs = ((InternalEObject)newInt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__INT, null, msgs);
			msgs = basicSetInt(newInt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__INT, newInt, newInt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedType getBool() {
		return bool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBool(PredefinedType newBool, NotificationChain msgs) {
		PredefinedType oldBool = bool;
		bool = newBool;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__BOOL, oldBool, newBool);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBool(PredefinedType newBool) {
		if (newBool != bool) {
			NotificationChain msgs = null;
			if (bool != null)
				msgs = ((InternalEObject)bool).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__BOOL, null, msgs);
			if (newBool != null)
				msgs = ((InternalEObject)newBool).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__BOOL, null, msgs);
			msgs = basicSetBool(newBool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__BOOL, newBool, newBool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedType getClock() {
		return clock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClock(PredefinedType newClock, NotificationChain msgs) {
		PredefinedType oldClock = clock;
		clock = newClock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__CLOCK, oldClock, newClock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClock(PredefinedType newClock) {
		if (newClock != clock) {
			NotificationChain msgs = null;
			if (clock != null)
				msgs = ((InternalEObject)clock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__CLOCK, null, msgs);
			if (newClock != null)
				msgs = ((InternalEObject)newClock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__CLOCK, null, msgs);
			msgs = basicSetClock(newClock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__CLOCK, newClock, newClock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedType getChan() {
		return chan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChan(PredefinedType newChan, NotificationChain msgs) {
		PredefinedType oldChan = chan;
		chan = newChan;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__CHAN, oldChan, newChan);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChan(PredefinedType newChan) {
		if (newChan != chan) {
			NotificationChain msgs = null;
			if (chan != null)
				msgs = ((InternalEObject)chan).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__CHAN, null, msgs);
			if (newChan != null)
				msgs = ((InternalEObject)newChan).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__CHAN, null, msgs);
			msgs = basicSetChan(newChan, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__CHAN, newChan, newChan));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedType getVoid() {
		return void_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVoid(PredefinedType newVoid, NotificationChain msgs) {
		PredefinedType oldVoid = void_;
		void_ = newVoid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__VOID, oldVoid, newVoid);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoid(PredefinedType newVoid) {
		if (newVoid != void_) {
			NotificationChain msgs = null;
			if (void_ != null)
				msgs = ((InternalEObject)void_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__VOID, null, msgs);
			if (newVoid != null)
				msgs = ((InternalEObject)newVoid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UppaalPackage.NTA__VOID, null, msgs);
			msgs = basicSetVoid(newVoid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UppaalPackage.NTA__VOID, newVoid, newVoid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UppaalPackage.NTA__GLOBAL_DECLARATIONS:
				return basicSetGlobalDeclarations(null, msgs);
			case UppaalPackage.NTA__TEMPLATE:
				return ((InternalEList<?>)getTemplate()).basicRemove(otherEnd, msgs);
			case UppaalPackage.NTA__SYSTEM_DECLARATIONS:
				return basicSetSystemDeclarations(null, msgs);
			case UppaalPackage.NTA__INT:
				return basicSetInt(null, msgs);
			case UppaalPackage.NTA__BOOL:
				return basicSetBool(null, msgs);
			case UppaalPackage.NTA__CLOCK:
				return basicSetClock(null, msgs);
			case UppaalPackage.NTA__CHAN:
				return basicSetChan(null, msgs);
			case UppaalPackage.NTA__VOID:
				return basicSetVoid(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UppaalPackage.NTA__COMMENT:
				return getComment();
			case UppaalPackage.NTA__GLOBAL_DECLARATIONS:
				return getGlobalDeclarations();
			case UppaalPackage.NTA__TEMPLATE:
				return getTemplate();
			case UppaalPackage.NTA__SYSTEM_DECLARATIONS:
				return getSystemDeclarations();
			case UppaalPackage.NTA__INT:
				return getInt();
			case UppaalPackage.NTA__BOOL:
				return getBool();
			case UppaalPackage.NTA__CLOCK:
				return getClock();
			case UppaalPackage.NTA__CHAN:
				return getChan();
			case UppaalPackage.NTA__VOID:
				return getVoid();
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
			case UppaalPackage.NTA__COMMENT:
				setComment((String)newValue);
				return;
			case UppaalPackage.NTA__GLOBAL_DECLARATIONS:
				setGlobalDeclarations((GlobalDeclarations)newValue);
				return;
			case UppaalPackage.NTA__TEMPLATE:
				getTemplate().clear();
				getTemplate().addAll((Collection<? extends Template>)newValue);
				return;
			case UppaalPackage.NTA__SYSTEM_DECLARATIONS:
				setSystemDeclarations((SystemDeclarations)newValue);
				return;
			case UppaalPackage.NTA__INT:
				setInt((PredefinedType)newValue);
				return;
			case UppaalPackage.NTA__BOOL:
				setBool((PredefinedType)newValue);
				return;
			case UppaalPackage.NTA__CLOCK:
				setClock((PredefinedType)newValue);
				return;
			case UppaalPackage.NTA__CHAN:
				setChan((PredefinedType)newValue);
				return;
			case UppaalPackage.NTA__VOID:
				setVoid((PredefinedType)newValue);
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
			case UppaalPackage.NTA__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case UppaalPackage.NTA__GLOBAL_DECLARATIONS:
				setGlobalDeclarations((GlobalDeclarations)null);
				return;
			case UppaalPackage.NTA__TEMPLATE:
				getTemplate().clear();
				return;
			case UppaalPackage.NTA__SYSTEM_DECLARATIONS:
				setSystemDeclarations((SystemDeclarations)null);
				return;
			case UppaalPackage.NTA__INT:
				setInt((PredefinedType)null);
				return;
			case UppaalPackage.NTA__BOOL:
				setBool((PredefinedType)null);
				return;
			case UppaalPackage.NTA__CLOCK:
				setClock((PredefinedType)null);
				return;
			case UppaalPackage.NTA__CHAN:
				setChan((PredefinedType)null);
				return;
			case UppaalPackage.NTA__VOID:
				setVoid((PredefinedType)null);
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
			case UppaalPackage.NTA__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case UppaalPackage.NTA__GLOBAL_DECLARATIONS:
				return globalDeclarations != null;
			case UppaalPackage.NTA__TEMPLATE:
				return template != null && !template.isEmpty();
			case UppaalPackage.NTA__SYSTEM_DECLARATIONS:
				return systemDeclarations != null;
			case UppaalPackage.NTA__INT:
				return int_ != null;
			case UppaalPackage.NTA__BOOL:
				return bool != null;
			case UppaalPackage.NTA__CLOCK:
				return clock != null;
			case UppaalPackage.NTA__CHAN:
				return chan != null;
			case UppaalPackage.NTA__VOID:
				return void_ != null;
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
				case UppaalPackage.NTA__COMMENT: return CorePackage.COMMENTABLE_ELEMENT__COMMENT;
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
				case CorePackage.COMMENTABLE_ELEMENT__COMMENT: return UppaalPackage.NTA__COMMENT;
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
		result.append(')');
		return result.toString();
	}

} //NTAImpl
