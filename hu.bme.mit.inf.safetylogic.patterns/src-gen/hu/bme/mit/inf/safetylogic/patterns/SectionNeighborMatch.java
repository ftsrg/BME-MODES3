package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionNeighborQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.sectionNeighbor pattern,
 * to be used in conjunction with {@link SectionNeighborMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SectionNeighborMatcher
 * @see SectionNeighborProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SectionNeighborMatch extends BasePatternMatch {
  private Section fS1;
  
  private Section fS2;
  
  private static List<String> parameterNames = makeImmutableList("s1", "s2");
  
  private SectionNeighborMatch(final Section pS1, final Section pS2) {
    this.fS1 = pS1;
    this.fS2 = pS2;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("s1".equals(parameterName)) return this.fS1;
    if ("s2".equals(parameterName)) return this.fS2;
    return null;
  }
  
  public Section getS1() {
    return this.fS1;
  }
  
  public Section getS2() {
    return this.fS2;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("s1".equals(parameterName) ) {
    	this.fS1 = (Section) newValue;
    	return true;
    }
    if ("s2".equals(parameterName) ) {
    	this.fS2 = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setS1(final Section pS1) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS1 = pS1;
  }
  
  public void setS2(final Section pS2) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fS2 = pS2;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.sectionNeighbor";
  }
  
  @Override
  public List<String> parameterNames() {
    return SectionNeighborMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fS1, fS2};
  }
  
  @Override
  public SectionNeighborMatch toImmutable() {
    return isMutable() ? newMatch(fS1, fS2) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"s1\"=" + prettyPrintValue(fS1) + ", ");
    
    result.append("\"s2\"=" + prettyPrintValue(fS2)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fS1 == null) ? 0 : fS1.hashCode());
    result = prime * result + ((fS2 == null) ? 0 : fS2.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SectionNeighborMatch)) { // this should be infrequent
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
    SectionNeighborMatch other = (SectionNeighborMatch) obj;
    if (fS1 == null) {if (other.fS1 != null) return false;}
    else if (!fS1.equals(other.fS1)) return false;
    if (fS2 == null) {if (other.fS2 != null) return false;}
    else if (!fS2.equals(other.fS2)) return false;
    return true;
  }
  
  @Override
  public SectionNeighborQuerySpecification specification() {
    try {
    	return SectionNeighborQuerySpecification.instance();
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
  public static SectionNeighborMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pS1 the fixed value of pattern parameter s1, or null if not bound.
   * @param pS2 the fixed value of pattern parameter s2, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SectionNeighborMatch newMutableMatch(final Section pS1, final Section pS2) {
    return new Mutable(pS1, pS2);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pS1 the fixed value of pattern parameter s1, or null if not bound.
   * @param pS2 the fixed value of pattern parameter s2, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SectionNeighborMatch newMatch(final Section pS1, final Section pS2) {
    return new Immutable(pS1, pS2);
  }
  
  private static final class Mutable extends SectionNeighborMatch {
    Mutable(final Section pS1, final Section pS2) {
      super(pS1, pS2);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SectionNeighborMatch {
    Immutable(final Section pS1, final Section pS2) {
      super(pS1, pS2);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
