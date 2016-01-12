package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

/**
 *
 * @author benedekh 
 */
public interface IYakinduKVController {

    public void revokeLock();

    public void sectionIsFree(int sectionId);

    public void sectionIsOccupied(int sectionId);

    public void turnoutIsFree();

    public void turnoutIsOccupied();

    public void turnoutIsDivergent();

    public void turnoutIsStraight();

    public void remSectionLock(Direction from);

    public void remShortSectionLock(Direction from);

    public void remPassageAllowed(Direction from);

    public void remPassageDenied(Direction from);

    public void simulateStatemachine();

}
