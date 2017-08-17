package hu.bme.mit.inf.modes3.components.touchboard

import javafx.scene.Node
import javafx.application.Platform

class ThreadSafeNode {

	val Node node
	val int id

	new(Node node, int id) {
		this.node = node
		this.id = id
	}

	def void addCssClass(String cls) {
		Platform.runLater(new Runnable() {
			override run() {
				node.styleClass.add(cls)
			}
		})
	}

	def void removeCssClass(String cls) {
		Platform.runLater(new Runnable() {
			override run() {
				node.styleClass.remove(cls)
			}
		})
	}
	
	def getNodeId(){
		return id
	}
}
