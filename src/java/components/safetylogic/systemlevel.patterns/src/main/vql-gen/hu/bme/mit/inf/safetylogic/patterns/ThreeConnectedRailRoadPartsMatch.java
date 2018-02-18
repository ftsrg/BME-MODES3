/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/PathBuildingHelperQueries.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.util.ThreeConnectedRailRoadPartsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.threeConnectedRailRoadParts pattern,
 * to be used in conjunction with {@link ThreeConnectedRailRoadPartsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ThreeConnectedRailRoadPartsMatcher
 *  @see ThreeConnectedRailRoadPartsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ThreeConnectedRailRoadPartsMatch extends BasePatternMatch {
  private RailRoadElement fOne;
  
  private RailRoadElement fMiddle;
  
  private RailRoadElement fOther;
  
  private static List<String> parameterNames = makeImmutableList("one", "middle", "other");
  
  private ThreeConnectedRailRoadPartsMatch(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther) {
    this.fOne = pOne;
    this.fMiddle = pMiddle;
    this.fOther = pOther;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("one".equals(parameterName)) return this.fOne;
    if ("middle".equals(parameterName)) return this.fMiddle;
    if ("other".equals(parameterName)) return this.fOther;
    return null;
  }
  
  public RailRoadElement getOne() {
    return this.fOne;
  }
  
  public RailRoadElement getMiddle() {
    return this.fMiddle;
  }
  
  public RailRoadElement getOther() {
    return this.fOther;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("one".equals(parameterName) ) {
        this.fOne = (RailRoadElement) newValue;
        return true;
    }
    if ("middle".equals(parameterName) ) {
        this.fMiddle = (RailRoadElement) newValue;
        return true;
    }
    if ("other".equals(parameterName) ) {
        this.fOther = (RailRoadElement) newValue;
        return true;
    }
    return false;
  }
  
  public void setOne(final RailRoadElement pOne) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOne = pOne;
  }
  
  public void setMiddle(final RailRoadElement pMiddle) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fMiddle = pMiddle;
  }
  
  public void setOther(final RailRoadElement pOther) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fOther = pOther;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.threeConnectedRailRoadParts";
  }
  
  @Override
  public List<String> parameterNames() {
    return ThreeConnectedRailRoadPartsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fOne, fMiddle, fOther};
  }
  
  @Override
  public ThreeConnectedRailRoadPartsMatch toImmutable() {
    return isMutable() ? newMatch(fOne, fMiddle, fOther) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"one\"=" + prettyPrintValue(fOne) + ", ");
    result.append("\"middle\"=" + prettyPrintValue(fMiddle) + ", ");
    result.append("\"other\"=" + prettyPrintValue(fOther));
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash (fOne, fMiddle, fOther);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
        return true;
    if (obj == null) {
        return false;
    }
    if ((obj instanceof ThreeConnectedRailRoadPartsMatch)) {
        ThreeConnectedRailRoadPartsMatch other = (ThreeConnectedRailRoadPartsMatch) obj;
        return Objects.equals(fOne, other.fOne) && Objects.equals(fMiddle, other.fMiddle) && Objects.equals(fOther, other.fOther);
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
  public ThreeConnectedRailRoadPartsQuerySpecification specification() {
    try {
        return ThreeConnectedRailRoadPartsQuerySpecification.instance();
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
  public static ThreeConnectedRailRoadPartsMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ThreeConnectedRailRoadPartsMatch newMutableMatch(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther) {
    return new Mutable(pOne, pMiddle, pOther);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pOne the fixed value of pattern parameter one, or null if not bound.
   * @param pMiddle the fixed value of pattern parameter middle, or null if not bound.
   * @param pOther the fixed value of pattern parameter other, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ThreeConnectedRailRoadPartsMatch newMatch(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther) {
    return new Immutable(pOne, pMiddle, pOther);
  }
  
  private static final class Mutable extends ThreeConnectedRailRoadPartsMatch {
    Mutable(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther) {
      super(pOne, pMiddle, pOther);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ThreeConnectedRailRoadPartsMatch {
    Immutable(final RailRoadElement pOne, final RailRoadElement pMiddle, final RailRoadElement pOther) {
      super(pOne, pMiddle, pOther);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
