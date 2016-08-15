/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/RailRoadQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.util.FooQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.foo pattern,
 * to be used in conjunction with {@link FooMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FooMatcher
 * @see FooProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FooMatch extends BasePatternMatch {
  private RailRoadElement fAsd;
  
  private static List<String> parameterNames = makeImmutableList("asd");
  
  private FooMatch(final RailRoadElement pAsd) {
    this.fAsd = pAsd;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("asd".equals(parameterName)) return this.fAsd;
    return null;
  }
  
  public RailRoadElement getAsd() {
    return this.fAsd;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("asd".equals(parameterName) ) {
    	this.fAsd = (RailRoadElement) newValue;
    	return true;
    }
    return false;
  }
  
  public void setAsd(final RailRoadElement pAsd) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fAsd = pAsd;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.foo";
  }
  
  @Override
  public List<String> parameterNames() {
    return FooMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAsd};
  }
  
  @Override
  public FooMatch toImmutable() {
    return isMutable() ? newMatch(fAsd) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"asd\"=" + prettyPrintValue(fAsd)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAsd == null) ? 0 : fAsd.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FooMatch)) { // this should be infrequent
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
    FooMatch other = (FooMatch) obj;
    if (fAsd == null) {if (other.fAsd != null) return false;}
    else if (!fAsd.equals(other.fAsd)) return false;
    return true;
  }
  
  @Override
  public FooQuerySpecification specification() {
    try {
    	return FooQuerySpecification.instance();
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
  public static FooMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FooMatch newMutableMatch(final RailRoadElement pAsd) {
    return new Mutable(pAsd);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pAsd the fixed value of pattern parameter asd, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static FooMatch newMatch(final RailRoadElement pAsd) {
    return new Immutable(pAsd);
  }
  
  private static final class Mutable extends FooMatch {
    Mutable(final RailRoadElement pAsd) {
      super(pAsd);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FooMatch {
    Immutable(final RailRoadElement pAsd) {
      super(pAsd);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
