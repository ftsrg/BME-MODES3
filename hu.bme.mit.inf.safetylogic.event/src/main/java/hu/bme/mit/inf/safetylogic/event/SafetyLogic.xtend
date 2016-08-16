package hu.bme.mit.inf.safetylogic.event


class SafetyLogic {
	
	def start(){
		val resource = ModelUtil.loadModel()
		val model = ModelUtil.getModelFromResource(resource)
		println(model.paths.length)
		println(model.sections.length)
	}

}
