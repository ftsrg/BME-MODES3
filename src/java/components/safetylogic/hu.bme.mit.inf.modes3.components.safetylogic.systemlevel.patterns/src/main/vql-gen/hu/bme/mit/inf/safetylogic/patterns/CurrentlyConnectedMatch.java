/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.util.CurrentlyConnectedQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.currentlyConnected pattern,
 * to be used in conjunction with {@link CurrentlyConnectedMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CurrentlyConnectedMatcher
 * @see CurrentlyConnectedProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CurrentlyConnectedMatch extends BasePatternMatch {
  private RailRoadElement fThis;
  
  private RailRoadElement fConnectedTo;
  
  private static List<String> parameterNames = makeImmutableList("This", "connectedTo");
  
  private CurrentlyConnectedMatch(final RailRoadElement pThis, final RailRoadElement pConnectedTo) {
    this.fThis = pThis;
    this.fConnectedTo = pConnectedTo;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("This".equals(parameterName)) return this.fThis;
    if ("connectedTo".equals(parameterName)) return this.fConnectedTo;
    return null;
  }
  
  public RailRoadElement getThis() {
    return this.fThis;
  }
  
  public RailRoadElement getConnectedTo() {
    return this.fConnectedTo;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("This".equals(parameterName) ) {
    	this.fThis = (RailRoadElement) newValue;
    	return true;
    }
    if ("connectedTo".equals(parameterName) ) {
    	this.fConnectedTo = (RailRoadElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setThis(final RailRoadElement pThis) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fThis = pThis;
  }
  
  public void setConnectedTo(final RailRoadElement pConnectedTo) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fConnectedTo = pConnectedTo;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.currentlyConnected";
  }
  
  @Override
  public List<String> parameterNames() {
    return CurrentlyConnectedMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fThis, fConnectedTo};
  }
  
  @Override
  public CurrentlyConnectedMatch toImmutable() {
    return isMutable() ? newMatch(fThis, fConnectedTo) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"This\"=" + prettyPrintValue(fThis) + ", ");
    
    result.append("\"connectedTo\"=" + prettyPrintValue(fConnectedTo)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fThis == null) ? 0 : fThis.hashCode());
    result = prime * result + ((fConnectedTo == null) ? 0 : fConnectedTo.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CurrentlyConnectedMatch)) { // this should be infrequent
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
    CurrentlyConnectedMatch other = (CurrentlyConnectedMatch) obj;
    if (fThis == null) {if (other.fThis != null) return false;}
    else if (!fThis.equals(other.fThis)) return false;
    if (fConnectedTo == null) {if (other.fConnectedTo != null) return false;}
    else if (!fConnectedTo.equals(other.fConnectedTo)) return false;
    return true;
  }
  
  @Override
  public CurrentlyConnectedQuerySpecification specification() {
    try {
    	return CurrentlyConnectedQuerySpecification.instance();
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
  public static CurrentlyConnectedMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CurrentlyConnectedMatch newMutableMatch(final RailRoadElement pThis, final RailRoadElement pConnectedTo) {
    return new Mutable(pThis, pConnectedTo);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CurrentlyConnectedMatch newMatch(final RailRoadElement pThis, final RailRoadElement pConnectedTo) {
    return new Immutable(pThis, pConnectedTo);
  }
  
  private static final class Mutable extends CurrentlyConnectedMatch {
    Mutable(final RailRoadElement pThis, final RailRoadElement pConnectedTo) {
      super(pThis, pConnectedTo);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CurrentlyConnectedMatch {
    Immutable(final RailRoadElement pThis, final RailRoadElement pConnectedTo) {
      super(pThis, pConnectedTo);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
