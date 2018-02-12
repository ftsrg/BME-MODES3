package hu.bme.mit.inf.modes3.utils.conf.layout.whole

import org.eclipse.xtend.lib.annotations.Data

@Data
class TurnoutModel {
	int occupancyId
	TrackElementModel straight
	TrackElementModel divergent
	TrackElementModel top
}
