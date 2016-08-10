package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.SoloClockwiseBlindTrackMatch;
import hu.bme.mit.inf.safetylogic.patterns.SoloClockwiseBlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloClockwiseBlindTrackQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.soloClockwiseBlindTrack pattern,
 * to be used in conjunction with {@link SoloClockwiseBlindTrackMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SoloClockwiseBlindTrackMatcher
 * @see SoloClockwiseBlindTrackProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SoloClockwiseBlindTrackMatch extends BasePatternMatch {
  private Section fSection;
  
  private static List<String> parameterNames = makeImmutableList("section");
  
  private SoloClockwiseBlindTrackMatch(final Section pSection) {
    this.fSection = pSection;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("section".equals(parameterName)) return this.fSection;
    return null;
  }
  
  public Section getSection() {
    return this.fSection;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("section".equals(parameterName) ) {
    	this.fSection = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSection(final Section pSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSection = pSection;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.soloClockwiseBlindTrack";
  }
  
  @Override
  public List<String> parameterNames() {
    return SoloClockwiseBlindTrackMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSection};
  }
  
  @Override
  public SoloClockwiseBlindTrackMatch toImmutable() {
    return isMutable() ? newMatch(fSection) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"section\"=" + prettyPrintValue(fSection)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSection == null) ? 0 : fSection.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SoloClockwiseBlindTrackMatch)) { // this should be infrequent
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
    SoloClockwiseBlindTrackMatch other = (SoloClockwiseBlindTrackMatch) obj;
    if (fSection == null) {if (other.fSection != null) return false;}
    else if (!fSection.equals(other.fSection)) return false;
    return true;
  }
  
  @Override
  public SoloClockwiseBlindTrackQuerySpecification specification() {
    try {
    	return SoloClockwiseBlindTrackQuerySpecification.instance();
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
  public static SoloClockwiseBlindTrackMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SoloClockwiseBlindTrackMatch newMutableMatch(final Section pSection) {
    return new Mutable(pSection);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SoloClockwiseBlindTrackMatch newMatch(final Section pSection) {
    return new Immutable(pSection);
  }
  
  private static final class Mutable extends SoloClockwiseBlindTrackMatch {
    Mutable(final Section pSection) {
      super(pSection);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SoloClockwiseBlindTrackMatch {
    Immutable(final Section pSection) {
      super(pSection);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
