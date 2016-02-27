/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.piclient.util;

/**
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
