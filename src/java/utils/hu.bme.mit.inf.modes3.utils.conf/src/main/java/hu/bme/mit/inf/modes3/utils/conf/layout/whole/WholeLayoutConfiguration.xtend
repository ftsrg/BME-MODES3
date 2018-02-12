package hu.bme.mit.inf.modes3.utils.conf.layout.whole

import hu.bme.mit.inf.modes3.utils.common.gson.GsonLoader

class WholeLayoutConfiguration {

	public static val INSTANCE = new WholeLayoutConfiguration
	private static val LAYOUT_CONFIG = "layout-whole.json"

	private val TrackLayoutModel layoutModel

	private new() {
		layoutModel = GsonLoader.loadTypeFromInputStream(TrackLayoutModel, class.classLoader.getResourceAsStream(LAYOUT_CONFIG))
	}

	def ComponentLayoutModel getLayoutConfigurationForComponent(String componentName) {
		layoutModel.components.findFirst[it.componentName == componentName]
	}
}
