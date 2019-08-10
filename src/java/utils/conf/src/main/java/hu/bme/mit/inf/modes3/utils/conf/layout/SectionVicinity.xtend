package hu.bme.mit.inf.modes3.utils.conf.layout

import org.eclipse.xtend.lib.annotations.Data

/**
 * Data class about the section's vicinity: which segment is connected from counter-/clockwise direction and which 
 * turnout is the owner of the section.
 * 
 * @author benedekh
 */
@Data
class SectionVicinity {
	Integer cw // the ID of the segment connecting from clockwise direction
	Integer ccw // the ID of the segment connecting from counterclockwise direction
	Integer ownerTurnout // the turnout to which the section belongs
}
