/**
 */
package de.uni_paderborn.uppaal.declarations.system.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uni_paderborn.uppaal.declarations.system.InstantiationList;
import de.uni_paderborn.uppaal.declarations.system.ProgressMeasure;
import de.uni_paderborn.uppaal.declarations.system.SystemFactory;
import de.uni_paderborn.uppaal.declarations.system.SystemPackage;
import de.uni_paderborn.uppaal.declarations.system.TemplateDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemFactoryImpl extends EFactoryImpl implements SystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SystemFactory init() {
		try {
			SystemFactory theSystemFactory = (SystemFactory)EPackage.Registry.INSTANCE.getEFactory(SystemPackage.eNS_URI);
			if (theSystemFactory != null) {
				return theSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SystemPackage.TEMPLATE_DECLARATION: return createTemplateDeclaration();
			case SystemPackage.SYSTEM: return createSystem();
			case SystemPackage.INSTANTIATION_LIST: return createInstantiationList();
			case SystemPackage.PROGRESS_MEASURE: return createProgressMeasure();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateDeclaration createTemplateDeclaration() {
		TemplateDeclarationImpl templateDeclaration = new TemplateDeclarationImpl();
		return templateDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.uni_paderborn.uppaal.declarations.system.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationList createInstantiationList() {
		InstantiationListImpl instantiationList = new InstantiationListImpl();
		return instantiationList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgressMeasure createProgressMeasure() {
		ProgressMeasureImpl progressMeasure = new ProgressMeasureImpl();
		return progressMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPackage getSystemPackage() {
		return (SystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SystemPackage getPackage() {
		return SystemPackage.eINSTANCE;
	}

} //SystemFactoryImpl
