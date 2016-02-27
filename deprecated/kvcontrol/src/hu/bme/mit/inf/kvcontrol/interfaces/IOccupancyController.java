package hu.bme.mit.inf.kvcontrol.interfaces;

import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;

/**
 * Handles all sections' occupancy. To use this class, you must know which
 * sections are in the layout, for more information
 * 
 * @see Relations getSections method
 * @author zsoltmazlo, benedekh
 */
public interface IOccupancyController extends IController {

	/**
	 * gives a boolean value about the section status. If it's occupied, then
	 * returns true, otherwise returns false
	 * <p>
	 * 
	 * @param sectionID
	 *            which turnout we are curious about
	 *            <p>
	 * @return If it's occupied, then returns true, otherwise returns false
	 * @throws NotFoundException
	 *             if section is not handled by this class
	 */
	public boolean isSectionOccupied(int sectionID) throws NotFoundException;

	/**
	 * Returns the whole occupancy vector, which contains all the sections'
	 * occupancies.
	 * 
	 * @return the occupancy vector
	 */
	public int getOccupancyVector();
}
