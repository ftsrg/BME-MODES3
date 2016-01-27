/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression.impl;

import hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet;
import hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl#getAlphabet <em>Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegexModelImpl#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegexModelImpl extends MinimalEObjectImpl.Container implements RegexModel
{
  /**
   * The cached value of the '{@link #getAlphabet() <em>Alphabet</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlphabet()
   * @generated
   * @ordered
   */
  protected Alphabet alphabet;

  /**
   * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDeclarations()
   * @generated
   * @ordered
   */
  protected EList<ExpressionDeclaration> declarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RegexModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RegularExpressionPackage.Literals.REGEX_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alphabet getAlphabet()
  {
    return alphabet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlphabet(Alphabet newAlphabet, NotificationChain msgs)
  {
    Alphabet oldAlphabet = alphabet;
    alphabet = newAlphabet;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegularExpressionPackage.REGEX_MODEL__ALPHABET, oldAlphabet, newAlphabet);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlphabet(Alphabet newAlphabet)
  {
    if (newAlphabet != alphabet)
    {
      NotificationChain msgs = null;
      if (alphabet != null)
        msgs = ((InternalEObject)alphabet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegularExpressionPackage.REGEX_MODEL__ALPHABET, null, msgs);
      if (newAlphabet != null)
        msgs = ((InternalEObject)newAlphabet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegularExpressionPackage.REGEX_MODEL__ALPHABET, null, msgs);
      msgs = basicSetAlphabet(newAlphabet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegularExpressionPackage.REGEX_MODEL__ALPHABET, newAlphabet, newAlphabet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExpressionDeclaration> getDeclarations()
  {
    if (declarations == null)
    {
      declarations = new EObjectContainmentEList<ExpressionDeclaration>(ExpressionDeclaration.class, this, RegularExpressionPackage.REGEX_MODEL__DECLARATIONS);
    }
    return declarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGEX_MODEL__ALPHABET:
        return basicSetAlphabet(null, msgs);
      case RegularExpressionPackage.REGEX_MODEL__DECLARATIONS:
        return ((InternalEList<?>)getDeclarations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGEX_MODEL__ALPHABET:
        return getAlphabet();
      case RegularExpressionPackage.REGEX_MODEL__DECLARATIONS:
        return getDeclarations();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGEX_MODEL__ALPHABET:
        setAlphabet((Alphabet)newValue);
        return;
      case RegularExpressionPackage.REGEX_MODEL__DECLARATIONS:
        getDeclarations().clear();
        getDeclarations().addAll((Collection<? extends ExpressionDeclaration>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGEX_MODEL__ALPHABET:
        setAlphabet((Alphabet)null);
        return;
      case RegularExpressionPackage.REGEX_MODEL__DECLARATIONS:
        getDeclarations().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RegularExpressionPackage.REGEX_MODEL__ALPHABET:
        return alphabet != null;
      case RegularExpressionPackage.REGEX_MODEL__DECLARATIONS:
        return declarations != null && !declarations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RegexModelImpl
