package hu.bme.mit.inf.modes3.utils.conf.layout

import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

/**
 * A data class to store the IDs of the segments that connect to a turnout 
 * from the possible directions (see {@link SegmentDirection}).
 */
@Data
class TurnoutVicinity {
	Set<Integer> straight // the ID of the segments connecting from the STRAIGHT direction to the turnout
	Set<Integer> divergent // the ID of the segments connecting from the DIVERGENT direction to the turnout
	Set<Integer> facing // the ID of the segments connecting from the FACING direction to the turnout
}
