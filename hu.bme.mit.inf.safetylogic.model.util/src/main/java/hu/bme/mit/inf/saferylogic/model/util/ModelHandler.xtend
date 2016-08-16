package hu.bme.mit.inf.saferylogic.model.util

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import java.util.Collections
import hu.bme.mit.inf.safetylogic.patterns.java.ModelUtil

class ModelHandler {
	def static loadSectionResource() {
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		RailRoadModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel", new XMIResourceFactoryImpl());

		val resourceSet = new ResourceSetImpl();
		val resource = resourceSet.createResource(URI.createURI("instance.railroadmodel"));
		val stream = ModelHandler.getResourceAsStream("/instance.railroadmodel")
		resource.load(stream, Collections.emptyMap)
		resource
	}
	
	
	def static getModelFromResource(Resource resource){
		resource.contents.head as RailRoadModel
	}
	
	def public static void main(String[] args){
		val resource = ModelHandler.loadSectionResource
		ModelUtil.createAllPaths(resource)
		val model = resource.getModelFromResource
		println("Sections length = " + model.sections.length)
		println("Paths length = " + model.paths.length) //TODO check if this is valid
		

		
	}
}
