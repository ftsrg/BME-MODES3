/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression.impl;

import hu.bme.mit.ftsrg.ptregex.regularExpression.Event;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inverse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.impl.InverseImpl#getExcludes <em>Excludes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InverseImpl extends ExpressionImpl implements Inverse
{
  /**
   * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExcludes()
   * @generated
   * @ordered
   */
  protected EList<Event> excludes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InverseImpl()
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
    return RegularExpressionPackage.Literals.INVERSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Event> getExcludes()
  {
    if (excludes == null)
    {
      excludes = new EObjectContainmentEList<Event>(Event.class, this, RegularExpressionPackage.INVERSE__EXCLUDES);
    }
    return excludes;
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
      case RegularExpressionPackage.INVERSE__EXCLUDES:
        return ((InternalEList<?>)getExcludes()).basicRemove(otherEnd, msgs);
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
      case RegularExpressionPackage.INVERSE__EXCLUDES:
        return getExcludes();
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
      case RegularExpressionPackage.INVERSE__EXCLUDES:
        getExcludes().clear();
        getExcludes().addAll((Collection<? extends Event>)newValue);
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
      case RegularExpressionPackage.INVERSE__EXCLUDES:
        getExcludes().clear();
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
      case RegularExpressionPackage.INVERSE__EXCLUDES:
        return excludes != null && !excludes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InverseImpl
