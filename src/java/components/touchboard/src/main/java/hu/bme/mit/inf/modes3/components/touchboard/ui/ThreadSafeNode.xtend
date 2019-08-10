package hu.bme.mit.inf.modes3.components.touchboard.ui

import javafx.scene.Node
import javafx.application.Platform

/**
 * A thread-safe wrapper over {@link Node}.
 * 
 * @author benedekh
 */
class ThreadSafeNode {

	val Node node
	val int id
	
	/**
	 * @param node a node on the UI
	 * @param id the ID of the node
	 */
	new(Node node, int id) {
		this.node = node
		this.id = id
	}

	/**
	 * Adds the CSS class to the node.
	 * 
	 * @param cls the name of the CSS class
	 */
	def void addCssClass(String cls) {
		Platform.runLater(new Runnable() {
			override run() {
				node.styleClass.add(cls)
			}
		})
	}

	/**
	 * Removes the CSS class from the node.
	 * 
	 * @param cls the name of the CSS class
	 */
	def void removeCssClass(String cls) {
		Platform.runLater(new Runnable() {
			override run() {
				node.styleClass.remove(cls)
			}
		})
	}
	
	/**
	 * @return the ID of the node
	 */
	def getNodeId(){
		return id
	}
}
