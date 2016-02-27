package hu.bme.mit.inf.kvcontrol.interfaces;

import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;

/**
 * Handles all section events and manage section' status. To use this class, you
 * must know which sections are in the layout, for more information
 *
 * @see Relations getSections method
 * @author zsoltmazlo, benedekh
 */
public interface ISectionController extends IController {

    /**
     * Sets the selected section enabled.
     * <p>
     *
     * @param sectionID the selected section's ID.
     * <p>
     * @throws NotFoundException if the selected section was not found.
     */
    public void setSectionEnabled(int sectionID) throws NotFoundException;

    /**
     * Sets the selected section disabled.
     * <p>
     *
     * @param sectionID the selected section's ID.
     * <p>
     * @throws NotFoundException if the selected section was not found.
     */
    public void setSectionDisabled(int sectionID) throws NotFoundException;

    /**
     * Returns, whether the selected section is enabled.
     * <p>
     *
     * @param sectionID the selected section's ID.
     * <p>
     * @return true, if the selected section is enabled, false otherwise.
     * @throws NotFoundException if the selected section was not found.
     */
    public boolean isSectionEnabled(int sectionID) throws NotFoundException;

}
