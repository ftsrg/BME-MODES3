/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.safetylogic.rulepatterns.util.NoTrainOnStationQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.rulepatterns.noTrainOnStation pattern,
 * to be used in conjunction with {@link NoTrainOnStationMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NoTrainOnStationMatcher
 *  @see NoTrainOnStationProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NoTrainOnStationMatch extends BasePatternMatch {
  private static List<String> parameterNames = makeImmutableList();
  
  private NoTrainOnStationMatch() {
    
  }
  
  @Override
  public Object get(final String parameterName) {
    return null;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    return false;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.rulepatterns.noTrainOnStation";
  }
  
  @Override
  public List<String> parameterNames() {
    return NoTrainOnStationMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{};
  }
  
  @Override
  public NoTrainOnStationMatch toImmutable() {
    return isMutable() ? newMatch() : this;
  }
  
  @Override
  public String prettyPrint() {
    return "[]";
  }
  
  @Override
  public int hashCode() {
    return 42;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof NoTrainOnStationMatch)) {
        return true;
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
  public NoTrainOnStationQuerySpecification specification() {
    try {
        return NoTrainOnStationQuerySpecification.instance();
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
  public static NoTrainOnStationMatch newEmptyMatch() {
    return new Mutable();
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NoTrainOnStationMatch newMutableMatch() {
    return new Mutable();
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @return the (partial) match object.
   * 
   */
  public static NoTrainOnStationMatch newMatch() {
    return new Immutable();
  }
  
  private static final class Mutable extends NoTrainOnStationMatch {
    Mutable() {
      super();
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NoTrainOnStationMatch {
    Immutable() {
      super();
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
