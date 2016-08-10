package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatch;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.InSameRailroadPartQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.inSameRailroadPart pattern,
 * to be used in conjunction with {@link InSameRailroadPartMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see InSameRailroadPartMatcher
 * @see InSameRailroadPartProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class InSameRailroadPartMatch extends BasePatternMatch {
  private Section fSection;
  
  private Section fSomeSection;
  
  private static List<String> parameterNames = makeImmutableList("section", "someSection");
  
  private InSameRailroadPartMatch(final Section pSection, final Section pSomeSection) {
    this.fSection = pSection;
    this.fSomeSection = pSomeSection;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("section".equals(parameterName)) return this.fSection;
    if ("someSection".equals(parameterName)) return this.fSomeSection;
    return null;
  }
  
  public Section getSection() {
    return this.fSection;
  }
  
  public Section getSomeSection() {
    return this.fSomeSection;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("section".equals(parameterName) ) {
    	this.fSection = (Section) newValue;
    	return true;
    }
    if ("someSection".equals(parameterName) ) {
    	this.fSomeSection = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSection(final Section pSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSection = pSection;
  }
  
  public void setSomeSection(final Section pSomeSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSomeSection = pSomeSection;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.inSameRailroadPart";
  }
  
  @Override
  public List<String> parameterNames() {
    return InSameRailroadPartMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSection, fSomeSection};
  }
  
  @Override
  public InSameRailroadPartMatch toImmutable() {
    return isMutable() ? newMatch(fSection, fSomeSection) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"section\"=" + prettyPrintValue(fSection) + ", ");
    
    result.append("\"someSection\"=" + prettyPrintValue(fSomeSection)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSection == null) ? 0 : fSection.hashCode());
    result = prime * result + ((fSomeSection == null) ? 0 : fSomeSection.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof InSameRailroadPartMatch)) { // this should be infrequent
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
    InSameRailroadPartMatch other = (InSameRailroadPartMatch) obj;
    if (fSection == null) {if (other.fSection != null) return false;}
    else if (!fSection.equals(other.fSection)) return false;
    if (fSomeSection == null) {if (other.fSomeSection != null) return false;}
    else if (!fSomeSection.equals(other.fSomeSection)) return false;
    return true;
  }
  
  @Override
  public InSameRailroadPartQuerySpecification specification() {
    try {
    	return InSameRailroadPartQuerySpecification.instance();
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
  public static InSameRailroadPartMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static InSameRailroadPartMatch newMutableMatch(final Section pSection, final Section pSomeSection) {
    return new Mutable(pSection, pSomeSection);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @param pSomeSection the fixed value of pattern parameter someSection, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static InSameRailroadPartMatch newMatch(final Section pSection, final Section pSomeSection) {
    return new Immutable(pSection, pSomeSection);
  }
  
  private static final class Mutable extends InSameRailroadPartMatch {
    Mutable(final Section pSection, final Section pSomeSection) {
      super(pSection, pSomeSection);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends InSameRailroadPartMatch {
    Immutable(final Section pSection, final Section pSomeSection) {
      super(pSection, pSomeSection);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
