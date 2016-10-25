/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.DivergentTurnoutQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.rulepatterns.divergentTurnout pattern,
 * to be used in conjunction with {@link DivergentTurnoutMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DivergentTurnoutMatcher
 * @see DivergentTurnoutProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DivergentTurnoutMatch extends BasePatternMatch {
  private Turnout fT;
  
  private static List<String> parameterNames = makeImmutableList("t");
  
  private DivergentTurnoutMatch(final Turnout pT) {
    this.fT = pT;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("t".equals(parameterName)) return this.fT;
    return null;
  }
  
  public Turnout getT() {
    return this.fT;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("t".equals(parameterName) ) {
    	this.fT = (Turnout) newValue;
    	return true;
    }
    return false;
  }
  
  public void setT(final Turnout pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.rulepatterns.divergentTurnout";
  }
  
  @Override
  public List<String> parameterNames() {
    return DivergentTurnoutMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT};
  }
  
  @Override
  public DivergentTurnoutMatch toImmutable() {
    return isMutable() ? newMatch(fT) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"t\"=" + prettyPrintValue(fT)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT == null) ? 0 : fT.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DivergentTurnoutMatch)) { // this should be infrequent
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
    DivergentTurnoutMatch other = (DivergentTurnoutMatch) obj;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    return true;
  }
  
  @Override
  public DivergentTurnoutQuerySpecification specification() {
    try {
    	return DivergentTurnoutQuerySpecification.instance();
    } catch (ViatraQueryException ex) {
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
  public static DivergentTurnoutMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static DivergentTurnoutMatch newMutableMatch(final Turnout pT) {
    return new Mutable(pT);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static DivergentTurnoutMatch newMatch(final Turnout pT) {
    return new Immutable(pT);
  }
  
  private static final class Mutable extends DivergentTurnoutMatch {
    Mutable(final Turnout pT) {
      super(pT);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends DivergentTurnoutMatch {
    Immutable(final Turnout pT) {
      super(pT);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
