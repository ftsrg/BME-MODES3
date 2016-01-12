package hu.bme.mit.inf.kvcontrol.entities;

/**
 * Turnout Entity class
 * <p>
 * @author zsoltmazlo
 */
public class Turnout {

    /**
     * The turnout's ID
     */
    private final int ID;

    /**
     * The controller's ID which is responsible for every communication with the
     * turnout.
     */
    private final int responsibleControllerID;

    /**
     * measured value on the divergent branch
     */
    private int onDivergentBranch;

    /**
     * measured value on the straight branch
     */
    private int onStraightBranch;

    /**
     *
     * @param ID turnout's ID
     * @param responsibleControllerID controller's ID which is responsible for
     * the turnout's
     */
    public Turnout(int ID, int responsibleControllerID) {
        this.ID = ID;
        this.responsibleControllerID = responsibleControllerID;
    }

    /**
     * set the measured values on both branches
     * <p>
     * @param onDivergentBranch measured value on divergent branch
     * @param onStraightBranch measured value on divergent branch
     */
    public void setMeasuredValues(int onDivergentBranch, int onStraightBranch) {
        this.onDivergentBranch = onDivergentBranch;
        this.onStraightBranch = onStraightBranch;
    }

    /**
     *
     * @return true if the turnout is setted to divergent branch
     */
    public boolean isDivergent() {
        return this.onDivergentBranch > this.onStraightBranch;
    }

    /**
     *
     * @return true if the turnout is setted to straight branch
     */
    public boolean isStraight() {
        return !this.isDivergent();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the responsibleControllerID
     */
    public int getResponsibleControllerID() {
        return responsibleControllerID;
    }

}
