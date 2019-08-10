package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory

/**
 * Estimates the nearest {@link RailRoadElement} to given coordinates.
 * 
 * @author baloghlaszlo
 */
class ComputerVisionEstimator {

	val IModelInteractor model

	/**
	 * @param model the model of the railway track
	 */
	new(IModelInteractor model) {
		this.model = model
	}
	
	/**
	 * @param x the coordinate on the X axis
	 * @param y the coordinate on the Y axis
	 * 
	 * @return the railroad element that is nearest to the given coordinates
	 */
	def RailRoadElement getElementByCoordinates(double x, double y) {
		val turnouts = model.turnouts
		val segments = model.segments
		val tp = RailRoadModelFactory.eINSTANCE.createPoint => [
			it.x = x
			it.y = y
		]

		val matchingTurnout = turnouts.findFirst [
			rectangle.origin.x < x && x < rectangle.size.width + rectangle.origin.x &&
			rectangle.origin.y < y && y < rectangle.size.height + rectangle.origin.y 
		]
		if (matchingTurnout !== null) {
			return matchingTurnout
		}
		
		segments.minBy[
			it.points.map[distance(it, tp)].min
		]
	}
	
	/**
	 * @param one the first point
	 * @param other the second point
	 * @return the Euclidean distance between the two points
	 */
	def static double distance(Point one, Point other) {
		return Math.sqrt((one.x - other.x) * (one.x - other.x) + (one.y - other.y) * (one.y - other.y))
	}
}
