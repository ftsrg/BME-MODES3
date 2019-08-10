package hu.bme.mit.inf.modes3.utils.conf.layout

/**
 *                        DIVERGENT
 *                          /
 *                         /
 *                        /
 *  FACING (TOP) -----TURNOUT_ITSELF------  STRAIGHT
 * 
 * The enum to describe the possible connection directions of segments to a turnout
 * 
 * @author benedekh
 */
enum SegmentDirection {
	STRAIGHT,
	DIVERGENT,
	FACING,
	TURNOUT_ITSELF
}
