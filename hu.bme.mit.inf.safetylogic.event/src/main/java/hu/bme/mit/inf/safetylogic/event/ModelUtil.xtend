package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class ModelUtil {
	
		def static loadSectionResource() {
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		RailRoadModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel", new XMIResourceFactoryImpl());

		val resourceSet = new ResourceSetImpl();
		val resource = resourceSet.createResource(URI.createURI("instance.railroadmodel"));
		val stream = ModelUtil.getResourceAsStream("/instance.railroadmodel")
		resource.load(stream, Collections.emptyMap)
		resource
	}
	
	def public static void main(String[] args){
		val resource = ModelUtil.loadSectionResource
		ModelUtil.createAllPaths(resource)
		val model = resource.getModelFromResource
		println("Sections length = " + model.sections.length)
		println("Paths length = " + model.paths.length) //TODO check if this is valid
		
	}
	
		def static createAllPaths(Resource modelResource){
		// get all matches of the pattern
		// initialization
		// phase 1: (managed) ViatraQueryEngine
		val ViatraQueryEngine engine = ViatraQueryEngine.on(new EMFScope(modelResource))
		// phase 2: the matcher itself
		val matcher = ThreeConnectedRailRoadPartsMatcher.on(engine)
		// get all matches of the pattern
		matcher.getAllMatches().forEach[
			val path = RailRoadModelFactory.eINSTANCE.createPath
			path.via = it.middle
			path.from = it.one
			path.to = it.other
			getModelFromResource(modelResource).paths.add(path)
		]
		
		
		return modelResource
	}
	
	//TODO this is a copy of the ModelHandler functions, this shouldn't be duplicated
	def static getModelFromResource(Resource resource){
		resource.contents.head as RailRoadModel
	}
}
