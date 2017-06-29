package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Point
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory

class ComputerVisionEstimator {

	val IModelInteractor model

	new(IModelInteractor model) {
		this.model = model
	}

	def RailRoadElement getElementByCoordinates(double x, double y) {
		val turnouts = model.turnouts
		val segments = model.segments
		val pointFromCoordinates = RailRoadModelFactory.eINSTANCE.createPoint => [
			it.x = x
			it.y = y
		]

		val matchingTurnout = turnouts.findFirst [
			it.rectangle.origin.x < x && x < it.rectangle.origin.x + it.rectangle.size.width && it.rectangle.origin.y < y && y < it.rectangle.origin.y + it.rectangle.size.height
		]

		if(matchingTurnout !== null) {
			return matchingTurnout
		}

		var closestSegment = segments.head
		var closestPoint = closestSegment.points.head

		for (segment : segments) {
			for (point : segment.points) {
				if(distance(point, pointFromCoordinates) < distance(point, closestPoint)) {
					closestPoint = point
					closestSegment = segment
				}
			}
		}
		return closestSegment
	}

	def static double distance(Point one, Point other) {
		return Math.sqrt((one.x - other.x) * (one.x - other.x) + (one.y - other.y) * (one.y - other.y))
	}
}
