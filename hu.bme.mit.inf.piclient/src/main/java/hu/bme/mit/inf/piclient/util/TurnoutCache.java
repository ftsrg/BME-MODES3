package hu.bme.mit.inf.piclient.util;

/**
 * A cache for storing the latest direction of the turnout (switch).
 *
 * @author zsoltmazlo
 */
public enum TurnoutCache {

    DIVERGENT,
    STRAIGHT,
    NOT_CONFIGURED;

    private TurnoutCache() {

    }

    public boolean isDivergent() {
        return this.equals(DIVERGENT);
    }

    public boolean isStraight() {
        return this.equals(STRAIGHT);
    }

}
