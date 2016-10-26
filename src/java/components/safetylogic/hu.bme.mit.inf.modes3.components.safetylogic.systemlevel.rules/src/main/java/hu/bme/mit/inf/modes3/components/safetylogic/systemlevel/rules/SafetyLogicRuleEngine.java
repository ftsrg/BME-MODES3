package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.addon.querybasedfeatures.runtime.QueryBasedFeatureSettingDelegateFactory;
import org.eclipse.viatra.cep.core.api.engine.CEPEngine;
import org.eclipse.viatra.cep.core.metamodels.automaton.AutomatonPackage;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.derived.DerivedFeatures;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.query.runtime.base.comprehension.WellbehavingDerivedFeatureRegistry;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.extensibility.SingletonQueryGroupProvider;
import org.eclipse.viatra.query.runtime.registry.QuerySpecificationRegistry;
import org.eclipse.viatra.query.runtime.registry.connector.QueryGroupProviderSourceConnector;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.mapping.QueryEngine2ViatraCep;

public class SafetyLogicRuleEngine {
	
	public final static String VIATRA_QBF = "org.eclipse.viatra.query.querybasedfeature"; 
	
	private static final String CONNECTOR_ID = "org.eclipse.viatra.cep.metamodels.standalone.connector";
	
	private ResourceSet resourceSet;
	
	private CEPEngine cepEngine;
	
	private EventStream eventStream;
	
	private QueryEngine2ViatraCep mapping;
	
	public SafetyLogicRuleEngine(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
		cepEngine = CEPEngine.newEngine().eventContext(EventContext.CHRONICLE).rules(CepFactory.getInstance().allRules()).prepare();
		eventStream = cepEngine.getStreamManager().newEventStream();
	}
	
	public void start() {
		mapping  = QueryEngine2ViatraCep.register(this.resourceSet, eventStream);
	}
	
	public void stop() {
		mapping.dispose();
	}
	
	public static void standaloneSetup() throws ViatraQueryException {
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.put(VIATRA_QBF, new QueryBasedFeatureSettingDelegateFactory());
		AutomatonPackage.eINSTANCE.getClass();
		
		WellbehavingDerivedFeatureRegistry.registerWellbehavingDerivedPackage(AutomatonPackage.eINSTANCE);
		
	    SingletonQueryGroupProvider groupProvider = new SingletonQueryGroupProvider(DerivedFeatures.instance());
        QueryGroupProviderSourceConnector sourceConnector = new QueryGroupProviderSourceConnector(CONNECTOR_ID, groupProvider, true);
        QuerySpecificationRegistry.getInstance().addSource(sourceConnector);
		
	}
}
