package hu.bme.mit.inf.safetylogic.patterns.java

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import org.eclipse.emf.ecore.resource.Resource
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel

class ModelUtil {
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