package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.BlindTrack;
import hu.bme.mit.inf.safetylogic.patterns.util.BlindTrackQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.blindTrack pattern,
 * to be used in conjunction with {@link BlindTrackMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see BlindTrackMatcher
 * @see BlindTrackProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class BlindTrackMatch extends BasePatternMatch {
  private BlindTrack fBlindTrack;
  
  private static List<String> parameterNames = makeImmutableList("blindTrack");
  
  private BlindTrackMatch(final BlindTrack pBlindTrack) {
    this.fBlindTrack = pBlindTrack;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("blindTrack".equals(parameterName)) return this.fBlindTrack;
    return null;
  }
  
  public BlindTrack getBlindTrack() {
    return this.fBlindTrack;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("blindTrack".equals(parameterName) ) {
    	this.fBlindTrack = (hu.bme.mit.inf.safetylogic.model.railroadmodel.BlindTrack) newValue;
    	return true;
    }
    return false;
  }
  
  public void setBlindTrack(final BlindTrack pBlindTrack) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fBlindTrack = pBlindTrack;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.blindTrack";
  }
  
  @Override
  public List<String> parameterNames() {
    return BlindTrackMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fBlindTrack};
  }
  
  @Override
  public BlindTrackMatch toImmutable() {
    return isMutable() ? newMatch(fBlindTrack) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"blindTrack\"=" + prettyPrintValue(fBlindTrack)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fBlindTrack == null) ? 0 : fBlindTrack.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof BlindTrackMatch)) { // this should be infrequent
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
    BlindTrackMatch other = (BlindTrackMatch) obj;
    if (fBlindTrack == null) {if (other.fBlindTrack != null) return false;}
    else if (!fBlindTrack.equals(other.fBlindTrack)) return false;
    return true;
  }
  
  @Override
  public BlindTrackQuerySpecification specification() {
    try {
    	return BlindTrackQuerySpecification.instance();
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
  public static BlindTrackMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pBlindTrack the fixed value of pattern parameter blindTrack, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static BlindTrackMatch newMutableMatch(final BlindTrack pBlindTrack) {
    return new Mutable(pBlindTrack);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pBlindTrack the fixed value of pattern parameter blindTrack, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static BlindTrackMatch newMatch(final BlindTrack pBlindTrack) {
    return new Immutable(pBlindTrack);
  }
  
  private static final class Mutable extends BlindTrackMatch {
    Mutable(final BlindTrack pBlindTrack) {
      super(pBlindTrack);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends BlindTrackMatch {
    Immutable(final BlindTrack pBlindTrack) {
      super(pBlindTrack);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
