package hu.bme.mit.inf.kvcontrol.interfaces;

import hu.bme.mit.inf.kvcontrol.data.Relations;
import hu.bme.mit.inf.kvcontrol.exceptions.NotFoundException;

/**
 * Handles all turnout events and manage turnouts' status. To use this class,
 * you must know which turnouts are in the layout for more information
 *
 * @see Relations getTurnouts method
 * @author zsoltmazlo
 */
public interface ITurnoutController extends IController {

    /**
     * gives a boolean value about the turnout status. If it's setted to
     * divergent branch, then it returns with true, otherwise it returns with
     * false
     *
     * @param turnoutID which turnout we are curious about
     * <p>
     * @return true, if the turnout is setted on divergent branch
     * @throws NotFoundException if the turnout is not found in our set, then
     * throw an exception about that. Must see turnouts.ini to find out
     */
    public boolean isTurnoutDivergent(int turnoutID) throws NotFoundException;

    /**
     * gives a boolean value about the turnout status. If it's setted to
     * straight branch, then it returns with true, otherwise it returns with
     * false
     *
     * @param turnoutID which turnout we are curious about
     * <p>
     * @return true, if the turnout is setted on straight branch
     * @throws NotFoundException if the turnout is not found in our set, then
     * throw an exception about that. Must see turnouts.ini to find out
     */
    public boolean isTurnoutStraight(int turnoutID) throws NotFoundException;

}
