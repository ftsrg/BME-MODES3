/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainTrailingTurnoutQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.trainTrailingTurnout pattern,
 * to be used in conjunction with {@link TrainTrailingTurnoutMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see TrainTrailingTurnoutMatcher
 *  @see TrainTrailingTurnoutProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class TrainTrailingTurnoutMatch extends BasePatternMatch {
  private Train fOffender;
  
  private RailRoadElement fVictim;
  
  private static List<String> parameterNames = makeImmutableList("Offender", "Victim");
  
  private TrainTrailingTurnoutMatch(final Train pOffender, final RailRoadElement pVictim) {
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
  
  public RailRoadElement getVictim() {
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
        this.fVictim = (RailRoadElement) newValue;
        return true;
    }
    return false;
  }
  
  public void setOffender(final Train pOffender) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOffender = pOffender;
  }
  
  public void setVictim(final RailRoadElement pVictim) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fVictim = pVictim;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.trainTrailingTurnout";
  }
  
  @Override
  public List<String> parameterNames() {
    return TrainTrailingTurnoutMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOffender, fVictim};
  }
  
  @Override
  public TrainTrailingTurnoutMatch toImmutable() {
    return isMutable() ? newMatch(fOffender, fVictim) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"Offender\"=" + prettyPrintValue(fOffender) + ", ");
    result.append("\"Victim\"=" + prettyPrintValue(fVictim));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fOffender, fVictim);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof TrainTrailingTurnoutMatch)) {
        TrainTrailingTurnoutMatch other = (TrainTrailingTurnoutMatch) obj;
        return Objects.equals(fOffender, other.fOffender) && Objects.equals(fVictim, other.fVictim);
    } else {
        // this should be infrequent
        if (!(obj instanceof IPatternMatch)) {
            return false;
        }
        IPatternMatch otherSig  = (IPatternMatch) obj;
        return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
    }
  }
  
  @Override
  public TrainTrailingTurnoutQuerySpecification specification() {
    try {
        return TrainTrailingTurnoutQuerySpecification.instance();
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
  public static TrainTrailingTurnoutMatch newEmptyMatch() {
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
  public static TrainTrailingTurnoutMatch newMutableMatch(final Train pOffender, final RailRoadElement pVictim) {
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
  public static TrainTrailingTurnoutMatch newMatch(final Train pOffender, final RailRoadElement pVictim) {
    return new Immutable(pOffender, pVictim);
  }
  
  private static final class Mutable extends TrainTrailingTurnoutMatch {
    Mutable(final Train pOffender, final RailRoadElement pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends TrainTrailingTurnoutMatch {
    Immutable(final Train pOffender, final RailRoadElement pVictim) {
      super(pOffender, pVictim);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
