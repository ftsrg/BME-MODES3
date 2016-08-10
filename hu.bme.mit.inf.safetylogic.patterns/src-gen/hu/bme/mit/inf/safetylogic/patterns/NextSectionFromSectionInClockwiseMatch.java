package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatch;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionFromSectionInClockwiseQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.nextSectionFromSectionInClockwise pattern,
 * to be used in conjunction with {@link NextSectionFromSectionInClockwiseMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see NextSectionFromSectionInClockwiseMatcher
 * @see NextSectionFromSectionInClockwiseProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class NextSectionFromSectionInClockwiseMatch extends BasePatternMatch {
  private Section fSection;
  
  private Section fNextSection;
  
  private static List<String> parameterNames = makeImmutableList("section", "nextSection");
  
  private NextSectionFromSectionInClockwiseMatch(final Section pSection, final Section pNextSection) {
    this.fSection = pSection;
    this.fNextSection = pNextSection;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("section".equals(parameterName)) return this.fSection;
    if ("nextSection".equals(parameterName)) return this.fNextSection;
    return null;
  }
  
  public Section getSection() {
    return this.fSection;
  }
  
  public Section getNextSection() {
    return this.fNextSection;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("section".equals(parameterName) ) {
    	this.fSection = (Section) newValue;
    	return true;
    }
    if ("nextSection".equals(parameterName) ) {
    	this.fNextSection = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSection(final Section pSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSection = pSection;
  }
  
  public void setNextSection(final Section pNextSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fNextSection = pNextSection;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.nextSectionFromSectionInClockwise";
  }
  
  @Override
  public List<String> parameterNames() {
    return NextSectionFromSectionInClockwiseMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSection, fNextSection};
  }
  
  @Override
  public NextSectionFromSectionInClockwiseMatch toImmutable() {
    return isMutable() ? newMatch(fSection, fNextSection) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"section\"=" + prettyPrintValue(fSection) + ", ");
    
    result.append("\"nextSection\"=" + prettyPrintValue(fNextSection)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSection == null) ? 0 : fSection.hashCode());
    result = prime * result + ((fNextSection == null) ? 0 : fNextSection.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof NextSectionFromSectionInClockwiseMatch)) { // this should be infrequent
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
    NextSectionFromSectionInClockwiseMatch other = (NextSectionFromSectionInClockwiseMatch) obj;
    if (fSection == null) {if (other.fSection != null) return false;}
    else if (!fSection.equals(other.fSection)) return false;
    if (fNextSection == null) {if (other.fNextSection != null) return false;}
    else if (!fNextSection.equals(other.fNextSection)) return false;
    return true;
  }
  
  @Override
  public NextSectionFromSectionInClockwiseQuerySpecification specification() {
    try {
    	return NextSectionFromSectionInClockwiseQuerySpecification.instance();
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
  public static NextSectionFromSectionInClockwiseMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static NextSectionFromSectionInClockwiseMatch newMutableMatch(final Section pSection, final Section pNextSection) {
    return new Mutable(pSection, pNextSection);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pNextSection the fixed value of pattern parameter nextSection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static NextSectionFromSectionInClockwiseMatch newMatch(final Section pSection, final Section pNextSection) {
    return new Immutable(pSection, pNextSection);
  }
  
  private static final class Mutable extends NextSectionFromSectionInClockwiseMatch {
    Mutable(final Section pSection, final Section pNextSection) {
      super(pSection, pNextSection);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends NextSectionFromSectionInClockwiseMatch {
    Immutable(final Section pSection, final Section pNextSection) {
      super(pSection, pNextSection);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
