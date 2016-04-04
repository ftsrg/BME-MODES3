package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.util.TurnoutQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.turnout pattern,
 * to be used in conjunction with {@link TurnoutMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TurnoutMatcher
 * @see TurnoutProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TurnoutMatch extends BasePatternMatch {
  private Turnout fTurnout;
  
  private static List<String> parameterNames = makeImmutableList("turnout");
  
  private TurnoutMatch(final Turnout pTurnout) {
    this.fTurnout = pTurnout;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("turnout".equals(parameterName)) return this.fTurnout;
    return null;
  }
  
  public Turnout getTurnout() {
    return this.fTurnout;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("turnout".equals(parameterName) ) {
    	this.fTurnout = (Turnout) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTurnout(final Turnout pTurnout) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTurnout = pTurnout;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.turnout";
  }
  
  @Override
  public List<String> parameterNames() {
    return TurnoutMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTurnout};
  }
  
  @Override
  public TurnoutMatch toImmutable() {
    return isMutable() ? newMatch(fTurnout) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"turnout\"=" + prettyPrintValue(fTurnout)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTurnout == null) ? 0 : fTurnout.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TurnoutMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    TurnoutMatch other = (TurnoutMatch) obj;
    if (fTurnout == null) {if (other.fTurnout != null) return false;}
    else if (!fTurnout.equals(other.fTurnout)) return false;
    return true;
  }
  
  @Override
  public TurnoutQuerySpecification specification() {
    try {
    	return TurnoutQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static TurnoutMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TurnoutMatch newMutableMatch(final Turnout pTurnout) {
    return new Mutable(pTurnout);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTurnout the fixed value of pattern parameter turnout, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TurnoutMatch newMatch(final Turnout pTurnout) {
    return new Immutable(pTurnout);
  }
  
  private static final class Mutable extends TurnoutMatch {
    Mutable(final Turnout pTurnout) {
      super(pTurnout);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TurnoutMatch {
    Immutable(final Turnout pTurnout) {
      super(pTurnout);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
