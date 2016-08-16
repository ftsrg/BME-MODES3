/**
 * Generated from platform:/resource/hu.bme.mit.inf.safetylogic.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.trainHitsAnotherTrain pattern,
 * to be used in conjunction with {@link TrainHitsAnotherTrainMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TrainHitsAnotherTrainMatcher
 * @see TrainHitsAnotherTrainProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TrainHitsAnotherTrainMatch extends BasePatternMatch {
  private Train fOffender;
  
  private Train fVictim;
  
  private static List<String> parameterNames = makeImmutableList("Offender", "Victim");
  
  private TrainHitsAnotherTrainMatch(final Train pOffender, final Train pVictim) {
    this.fOffender = pOffender;
    this.fVictim = pVictim;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Offender".equals(parameterName)) return this.fOffender;
    if ("Victim".equals(parameterName)) return this.fVictim;
    return null;
  }
  
  public Train getOffender() {
    return this.fOffender;
  }
  
  public Train getVictim() {
    return this.fVictim;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Offender".equals(parameterName) ) {
    	this.fOffender = (Train) newValue;
    	return true;
    }
    if ("Victim".equals(parameterName) ) {
    	this.fVictim = (Train) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOffender(final Train pOffender) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOffender = pOffender;
  }
  
  public void setVictim(final Train pVictim) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVictim = pVictim;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.trainHitsAnotherTrain";
  }
  
  @Override
  public List<String> parameterNames() {
    return TrainHitsAnotherTrainMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOffender, fVictim};
  }
  
  @Override
  public TrainHitsAnotherTrainMatch toImmutable() {
    return isMutable() ? newMatch(fOffender, fVictim) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Offender\"=" + prettyPrintValue(fOffender) + ", ");
    
    result.append("\"Victim\"=" + prettyPrintValue(fVictim)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fOffender == null) ? 0 : fOffender.hashCode());
    result = prime * result + ((fVictim == null) ? 0 : fVictim.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof TrainHitsAnotherTrainMatch)) { // this should be infrequent
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
    TrainHitsAnotherTrainMatch other = (TrainHitsAnotherTrainMatch) obj;
    if (fOffender == null) {if (other.fOffender != null) return false;}
    else if (!fOffender.equals(other.fOffender)) return false;
    if (fVictim == null) {if (other.fVictim != null) return false;}
    else if (!fVictim.equals(other.fVictim)) return false;
    return true;
  }
  
  @Override
  public TrainHitsAnotherTrainQuerySpecification specification() {
    try {
    	return TrainHitsAnotherTrainQuerySpecification.instance();
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
  public static TrainHitsAnotherTrainMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static TrainHitsAnotherTrainMatch newMutableMatch(final Train pOffender, final Train pVictim) {
    return new Mutable(pOffender, pVictim);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOffender the fixed value of pattern parameter Offender, or null if not bound.
   * @param pVictim the fixed value of pattern parameter Victim, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static TrainHitsAnotherTrainMatch newMatch(final Train pOffender, final Train pVictim) {
    return new Immutable(pOffender, pVictim);
  }
  
  private static final class Mutable extends TrainHitsAnotherTrainMatch {
    Mutable(final Train pOffender, final Train pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TrainHitsAnotherTrainMatch {
    Immutable(final Train pOffender, final Train pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
