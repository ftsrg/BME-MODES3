package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.trainIsGoingToHit pattern,
 * to be used in conjunction with {@link TrainIsGoingToHitMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TrainIsGoingToHitMatcher
 * @see TrainIsGoingToHitProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TrainIsGoingToHitMatch extends BasePatternMatch {
  private Train fT1;
  
  private Train fT2;
  
  private static List<String> parameterNames = makeImmutableList("t1", "t2");
  
  private TrainIsGoingToHitMatch(final Train pT1, final Train pT2) {
    this.fT1 = pT1;
    this.fT2 = pT2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("t1".equals(parameterName)) return this.fT1;
    if ("t2".equals(parameterName)) return this.fT2;
    return null;
  }
  
  public Train getT1() {
    return this.fT1;
  }
  
  public Train getT2() {
    return this.fT2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("t1".equals(parameterName) ) {
    	this.fT1 = (Train) newValue;
    	return true;
    }
    if ("t2".equals(parameterName) ) {
    	this.fT2 = (Train) newValue;
    	return true;
    }
    return false;
  }
  
  public void setT1(final Train pT1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT1 = pT1;
  }
  
  public void setT2(final Train pT2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT2 = pT2;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.trainIsGoingToHit";
  }
  
  @Override
  public List<String> parameterNames() {
    return TrainIsGoingToHitMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fT1, fT2};
  }
  
  @Override
  public TrainIsGoingToHitMatch toImmutable() {
    return isMutable() ? newMatch(fT1, fT2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"t1\"=" + prettyPrintValue(fT1) + ", ");
    
    result.append("\"t2\"=" + prettyPrintValue(fT2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fT1 == null) ? 0 : fT1.hashCode());
    result = prime * result + ((fT2 == null) ? 0 : fT2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TrainIsGoingToHitMatch)) { // this should be infrequent
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
    TrainIsGoingToHitMatch other = (TrainIsGoingToHitMatch) obj;
    if (fT1 == null) {if (other.fT1 != null) return false;}
    else if (!fT1.equals(other.fT1)) return false;
    if (fT2 == null) {if (other.fT2 != null) return false;}
    else if (!fT2.equals(other.fT2)) return false;
    return true;
  }
  
  @Override
  public TrainIsGoingToHitQuerySpecification specification() {
    try {
    	return TrainIsGoingToHitQuerySpecification.instance();
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
  public static TrainIsGoingToHitMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TrainIsGoingToHitMatch newMutableMatch(final Train pT1, final Train pT2) {
    return new Mutable(pT1, pT2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pT1 the fixed value of pattern parameter t1, or null if not bound.
   * @param pT2 the fixed value of pattern parameter t2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TrainIsGoingToHitMatch newMatch(final Train pT1, final Train pT2) {
    return new Immutable(pT1, pT2);
  }
  
  private static final class Mutable extends TrainIsGoingToHitMatch {
    Mutable(final Train pT1, final Train pT2) {
      super(pT1, pT2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TrainIsGoingToHitMatch {
    Immutable(final Train pT1, final Train pT2) {
      super(pT1, pT2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
