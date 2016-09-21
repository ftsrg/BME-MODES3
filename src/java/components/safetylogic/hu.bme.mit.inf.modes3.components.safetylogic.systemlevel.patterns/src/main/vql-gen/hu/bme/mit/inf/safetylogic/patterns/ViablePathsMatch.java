/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Path;
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.patterns.util.ViablePathsQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.viablePaths pattern,
 * to be used in conjunction with {@link ViablePathsMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ViablePathsMatcher
 * @see ViablePathsProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ViablePathsMatch extends BasePatternMatch {
  private RailRoadElement fThis;
  
  private Path fPath;
  
  private static List<String> parameterNames = makeImmutableList("This", "path");
  
  private ViablePathsMatch(final RailRoadElement pThis, final Path pPath) {
    this.fThis = pThis;
    this.fPath = pPath;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("This".equals(parameterName)) return this.fThis;
    if ("path".equals(parameterName)) return this.fPath;
    return null;
  }
  
  public RailRoadElement getThis() {
    return this.fThis;
  }
  
  public Path getPath() {
    return this.fPath;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("This".equals(parameterName) ) {
    	this.fThis = (RailRoadElement) newValue;
    	return true;
    }
    if ("path".equals(parameterName) ) {
    	this.fPath = (Path) newValue;
    	return true;
    }
    return false;
  }
  
  public void setThis(final RailRoadElement pThis) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fThis = pThis;
  }
  
  public void setPath(final Path pPath) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fPath = pPath;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.viablePaths";
  }
  
  @Override
  public List<String> parameterNames() {
    return ViablePathsMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fThis, fPath};
  }
  
  @Override
  public ViablePathsMatch toImmutable() {
    return isMutable() ? newMatch(fThis, fPath) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"This\"=" + prettyPrintValue(fThis) + ", ");
    
    result.append("\"path\"=" + prettyPrintValue(fPath)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fThis == null) ? 0 : fThis.hashCode());
    result = prime * result + ((fPath == null) ? 0 : fPath.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ViablePathsMatch)) { // this should be infrequent
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
    ViablePathsMatch other = (ViablePathsMatch) obj;
    if (fThis == null) {if (other.fThis != null) return false;}
    else if (!fThis.equals(other.fThis)) return false;
    if (fPath == null) {if (other.fPath != null) return false;}
    else if (!fPath.equals(other.fPath)) return false;
    return true;
  }
  
  @Override
  public ViablePathsQuerySpecification specification() {
    try {
    	return ViablePathsQuerySpecification.instance();
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
  public static ViablePathsMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ViablePathsMatch newMutableMatch(final RailRoadElement pThis, final Path pPath) {
    return new Mutable(pThis, pPath);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pPath the fixed value of pattern parameter path, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ViablePathsMatch newMatch(final RailRoadElement pThis, final Path pPath) {
    return new Immutable(pThis, pPath);
  }
  
  private static final class Mutable extends ViablePathsMatch {
    Mutable(final RailRoadElement pThis, final Path pPath) {
      super(pThis, pPath);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ViablePathsMatch {
    Immutable(final RailRoadElement pThis, final Path pPath) {
      super(pThis, pPath);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
