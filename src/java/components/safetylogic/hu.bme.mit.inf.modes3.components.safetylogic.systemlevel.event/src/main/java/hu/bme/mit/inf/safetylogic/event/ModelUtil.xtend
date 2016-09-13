package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement

class ModelUtil {

	def private static loadSectionResource() {
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		RailRoadModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel", new XMIResourceFactoryImpl());

		val resourceSet = new ResourceSetImpl();
		resourceSet.getResource(URI.createURI("instance.railroadmodel"),true);
	}

	def static loadModel() {
		val resource = ModelUtil.loadSectionResource
		ModelUtil.createAllPaths(resource)
		return resource;

	}

	def private static createAllPaths(Resource modelResource) {
		// get all matches of the pattern
		// initialization
		// phase 1: (managed) ViatraQueryEngine
		val ViatraQueryEngine engine = ViatraQueryEngine.on(new EMFScope(modelResource))
		// phase 2: the matcher itself
		val matcher = ThreeConnectedRailRoadPartsMatcher.on(engine)
		
		val paths = getModelFromResource(modelResource).paths
		// get all matches of the pattern
		matcher.getAllMatches().forEach [
			val path = RailRoadModelFactory.eINSTANCE.createPath
			path.via = it.middle as RailRoadElement //TODO Viatra-ticket
			path.from = it.one as RailRoadElement
			path.to = it.other as RailRoadElement
			paths.add(path)
		]

		return modelResource
	}

	def static getModelFromResource(Resource resource) {
		resource.contents.head as RailRoadModel
	}
}

