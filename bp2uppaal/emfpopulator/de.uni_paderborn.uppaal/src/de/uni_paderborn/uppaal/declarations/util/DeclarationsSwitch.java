/**
 */
package de.uni_paderborn.uppaal.declarations.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import de.uni_paderborn.uppaal.core.NamedElement;
import de.uni_paderborn.uppaal.declarations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uni_paderborn.uppaal.declarations.DeclarationsPackage
 * @generated
 */
public class DeclarationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DeclarationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationsSwitch() {
		if (modelPackage == null) {
			modelPackage = DeclarationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DeclarationsPackage.DECLARATIONS: {
				Declarations declarations = (Declarations)theEObject;
				T result = caseDeclarations(declarations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.GLOBAL_DECLARATIONS: {
				GlobalDeclarations globalDeclarations = (GlobalDeclarations)theEObject;
				T result = caseGlobalDeclarations(globalDeclarations);
				if (result == null) result = caseDeclarations(globalDeclarations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.LOCAL_DECLARATIONS: {
				LocalDeclarations localDeclarations = (LocalDeclarations)theEObject;
				T result = caseLocalDeclarations(localDeclarations);
				if (result == null) result = caseDeclarations(localDeclarations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.SYSTEM_DECLARATIONS: {
				SystemDeclarations systemDeclarations = (SystemDeclarations)theEObject;
				T result = caseSystemDeclarations(systemDeclarations);
				if (result == null) result = caseDeclarations(systemDeclarations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.DECLARATION: {
				Declaration declaration = (Declaration)theEObject;
				T result = caseDeclaration(declaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseDeclaration(variableDeclaration);
				if (result == null) result = caseVariableContainer(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.CHANNEL_VARIABLE_DECLARATION: {
				ChannelVariableDeclaration channelVariableDeclaration = (ChannelVariableDeclaration)theEObject;
				T result = caseChannelVariableDeclaration(channelVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(channelVariableDeclaration);
				if (result == null) result = caseDeclaration(channelVariableDeclaration);
				if (result == null) result = caseVariableContainer(channelVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.CLOCK_VARIABLE_DECLARATION: {
				ClockVariableDeclaration clockVariableDeclaration = (ClockVariableDeclaration)theEObject;
				T result = caseClockVariableDeclaration(clockVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(clockVariableDeclaration);
				if (result == null) result = caseDeclaration(clockVariableDeclaration);
				if (result == null) result = caseVariableContainer(clockVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.DATA_VARIABLE_DECLARATION: {
				DataVariableDeclaration dataVariableDeclaration = (DataVariableDeclaration)theEObject;
				T result = caseDataVariableDeclaration(dataVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(dataVariableDeclaration);
				if (result == null) result = caseDeclaration(dataVariableDeclaration);
				if (result == null) result = caseVariableContainer(dataVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.FUNCTION_DECLARATION: {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration)theEObject;
				T result = caseFunctionDeclaration(functionDeclaration);
				if (result == null) result = caseDeclaration(functionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = caseNamedElement(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.TYPE_DECLARATION: {
				TypeDeclaration typeDeclaration = (TypeDeclaration)theEObject;
				T result = caseTypeDeclaration(typeDeclaration);
				if (result == null) result = caseDeclaration(typeDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.INDEX: {
				Index index = (Index)theEObject;
				T result = caseIndex(index);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.VALUE_INDEX: {
				ValueIndex valueIndex = (ValueIndex)theEObject;
				T result = caseValueIndex(valueIndex);
				if (result == null) result = caseIndex(valueIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.TYPE_INDEX: {
				TypeIndex typeIndex = (TypeIndex)theEObject;
				T result = caseTypeIndex(typeIndex);
				if (result == null) result = caseIndex(typeIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.VARIABLE_CONTAINER: {
				VariableContainer variableContainer = (VariableContainer)theEObject;
				T result = caseVariableContainer(variableContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.INITIALIZER: {
				Initializer initializer = (Initializer)theEObject;
				T result = caseInitializer(initializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.EXPRESSION_INITIALIZER: {
				ExpressionInitializer expressionInitializer = (ExpressionInitializer)theEObject;
				T result = caseExpressionInitializer(expressionInitializer);
				if (result == null) result = caseInitializer(expressionInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DeclarationsPackage.ARRAY_INITIALIZER: {
				ArrayInitializer arrayInitializer = (ArrayInitializer)theEObject;
				T result = caseArrayInitializer(arrayInitializer);
				if (result == null) result = caseInitializer(arrayInitializer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declarations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclarations(Declarations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Declarations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalDeclarations(GlobalDeclarations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Declarations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalDeclarations(LocalDeclarations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Declarations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Declarations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemDeclarations(SystemDeclarations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelVariableDeclaration(ChannelVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClockVariableDeclaration(ClockVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataVariableDeclaration(DataVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDeclaration(FunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDeclaration(TypeDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndex(Index object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueIndex(ValueIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeIndex(TypeIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableContainer(VariableContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitializer(Initializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionInitializer(ExpressionInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Initializer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Initializer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayInitializer(ArrayInitializer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DeclarationsSwitch
