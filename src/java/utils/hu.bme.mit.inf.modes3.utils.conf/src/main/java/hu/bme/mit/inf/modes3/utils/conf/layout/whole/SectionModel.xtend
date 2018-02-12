package hu.bme.mit.inf.modes3.utils.conf.layout.whole

import org.eclipse.xtend.lib.annotations.Data

@Data
class SectionModel {
	int occupancyId
	TrackElementModel cw
	TrackElementModel ccw
}
