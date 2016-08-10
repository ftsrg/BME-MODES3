package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatch;
import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionsInSameRailroadPartAsTrainQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.sectionsInSameRailroadPartAsTrain pattern,
 * to be used in conjunction with {@link SectionsInSameRailroadPartAsTrainMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SectionsInSameRailroadPartAsTrainMatcher
 * @see SectionsInSameRailroadPartAsTrainProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SectionsInSameRailroadPartAsTrainMatch extends BasePatternMatch {
  private Train fTrain;
  
  private Section fSection;
  
  private static List<String> parameterNames = makeImmutableList("train", "section");
  
  private SectionsInSameRailroadPartAsTrainMatch(final Train pTrain, final Section pSection) {
    this.fTrain = pTrain;
    this.fSection = pSection;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("train".equals(parameterName)) return this.fTrain;
    if ("section".equals(parameterName)) return this.fSection;
    return null;
  }
  
  public Train getTrain() {
    return this.fTrain;
  }
  
  public Section getSection() {
    return this.fSection;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("train".equals(parameterName) ) {
    	this.fTrain = (Train) newValue;
    	return true;
    }
    if ("section".equals(parameterName) ) {
    	this.fSection = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setTrain(final Train pTrain) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTrain = pTrain;
  }
  
  public void setSection(final Section pSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSection = pSection;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.sectionsInSameRailroadPartAsTrain";
  }
  
  @Override
  public List<String> parameterNames() {
    return SectionsInSameRailroadPartAsTrainMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fTrain, fSection};
  }
  
  @Override
  public SectionsInSameRailroadPartAsTrainMatch toImmutable() {
    return isMutable() ? newMatch(fTrain, fSection) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"train\"=" + prettyPrintValue(fTrain) + ", ");
    
    result.append("\"section\"=" + prettyPrintValue(fSection)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fTrain == null) ? 0 : fTrain.hashCode());
    result = prime * result + ((fSection == null) ? 0 : fSection.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SectionsInSameRailroadPartAsTrainMatch)) { // this should be infrequent
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
    SectionsInSameRailroadPartAsTrainMatch other = (SectionsInSameRailroadPartAsTrainMatch) obj;
    if (fTrain == null) {if (other.fTrain != null) return false;}
    else if (!fTrain.equals(other.fTrain)) return false;
    if (fSection == null) {if (other.fSection != null) return false;}
    else if (!fSection.equals(other.fSection)) return false;
    return true;
  }
  
  @Override
  public SectionsInSameRailroadPartAsTrainQuerySpecification specification() {
    try {
    	return SectionsInSameRailroadPartAsTrainQuerySpecification.instance();
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
  public static SectionsInSameRailroadPartAsTrainMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SectionsInSameRailroadPartAsTrainMatch newMutableMatch(final Train pTrain, final Section pSection) {
    return new Mutable(pTrain, pSection);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pTrain the fixed value of pattern parameter train, or null if not bound.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SectionsInSameRailroadPartAsTrainMatch newMatch(final Train pTrain, final Section pSection) {
    return new Immutable(pTrain, pSection);
  }
  
  private static final class Mutable extends SectionsInSameRailroadPartAsTrainMatch {
    Mutable(final Train pTrain, final Section pSection) {
      super(pTrain, pSection);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SectionsInSameRailroadPartAsTrainMatch {
    Immutable(final Train pTrain, final Section pSection) {
      super(pTrain, pSection);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
