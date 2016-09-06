/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.util.TrainCutsTurnoutQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.trainCutsTurnout pattern,
 * to be used in conjunction with {@link TrainCutsTurnoutMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TrainCutsTurnoutMatcher
 * @see TrainCutsTurnoutProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TrainCutsTurnoutMatch extends BasePatternMatch {
  private EObject fOffender;
  
  private EObject fVictim;
  
  private static List<String> parameterNames = makeImmutableList("Offender", "Victim");
  
  private TrainCutsTurnoutMatch(final EObject pOffender, final EObject pVictim) {
    this.fOffender = pOffender;
    this.fVictim = pVictim;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("Offender".equals(parameterName)) return this.fOffender;
    if ("Victim".equals(parameterName)) return this.fVictim;
    return null;
  }
  
  public EObject getOffender() {
    return this.fOffender;
  }
  
  public EObject getVictim() {
    return this.fVictim;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("Offender".equals(parameterName) ) {
    	this.fOffender = (EObject) newValue;
    	return true;
    }
    if ("Victim".equals(parameterName) ) {
    	this.fVictim = (EObject) newValue;
    	return true;
    }
    return false;
  }
  
  public void setOffender(final EObject pOffender) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOffender = pOffender;
  }
  
  public void setVictim(final EObject pVictim) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVictim = pVictim;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.trainCutsTurnout";
  }
  
  @Override
  public List<String> parameterNames() {
    return TrainCutsTurnoutMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOffender, fVictim};
  }
  
  @Override
  public TrainCutsTurnoutMatch toImmutable() {
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
    if (!(obj instanceof TrainCutsTurnoutMatch)) { // this should be infrequent
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
    TrainCutsTurnoutMatch other = (TrainCutsTurnoutMatch) obj;
    if (fOffender == null) {if (other.fOffender != null) return false;}
    else if (!fOffender.equals(other.fOffender)) return false;
    if (fVictim == null) {if (other.fVictim != null) return false;}
    else if (!fVictim.equals(other.fVictim)) return false;
    return true;
  }
  
  @Override
  public TrainCutsTurnoutQuerySpecification specification() {
    try {
    	return TrainCutsTurnoutQuerySpecification.instance();
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
  public static TrainCutsTurnoutMatch newEmptyMatch() {
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
  public static TrainCutsTurnoutMatch newMutableMatch(final EObject pOffender, final EObject pVictim) {
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
  public static TrainCutsTurnoutMatch newMatch(final EObject pOffender, final EObject pVictim) {
    return new Immutable(pOffender, pVictim);
  }
  
  private static final class Mutable extends TrainCutsTurnoutMatch {
    Mutable(final EObject pOffender, final EObject pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TrainCutsTurnoutMatch {
    Immutable(final EObject pOffender, final EObject pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
