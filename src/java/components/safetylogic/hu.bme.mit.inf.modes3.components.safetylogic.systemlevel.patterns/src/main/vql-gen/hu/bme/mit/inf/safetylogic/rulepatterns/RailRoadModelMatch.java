/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/rulepatterns/RulePatterns.vql
 */
package hu.bme.mit.inf.safetylogic.rulepatterns;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel;
import hu.bme.mit.inf.safetylogic.rulepatterns.util.RailRoadModelQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.rulepatterns.railRoadModel pattern,
 * to be used in conjunction with {@link RailRoadModelMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RailRoadModelMatcher
 * @see RailRoadModelProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RailRoadModelMatch extends BasePatternMatch {
  private RailRoadModel fModel;
  
  private static List<String> parameterNames = makeImmutableList("model");
  
  private RailRoadModelMatch(final RailRoadModel pModel) {
    this.fModel = pModel;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("model".equals(parameterName)) return this.fModel;
    return null;
  }
  
  public RailRoadModel getModel() {
    return this.fModel;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("model".equals(parameterName) ) {
    	this.fModel = (RailRoadModel) newValue;
    	return true;
    }
    return false;
  }
  
  public void setModel(final RailRoadModel pModel) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fModel = pModel;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.rulepatterns.railRoadModel";
  }
  
  @Override
  public List<String> parameterNames() {
    return RailRoadModelMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fModel};
  }
  
  @Override
  public RailRoadModelMatch toImmutable() {
    return isMutable() ? newMatch(fModel) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"model\"=" + prettyPrintValue(fModel)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fModel == null) ? 0 : fModel.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RailRoadModelMatch)) { // this should be infrequent
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
    RailRoadModelMatch other = (RailRoadModelMatch) obj;
    if (fModel == null) {if (other.fModel != null) return false;}
    else if (!fModel.equals(other.fModel)) return false;
    return true;
  }
  
  @Override
  public RailRoadModelQuerySpecification specification() {
    try {
    	return RailRoadModelQuerySpecification.instance();
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
  public static RailRoadModelMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RailRoadModelMatch newMutableMatch(final RailRoadModel pModel) {
    return new Mutable(pModel);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pModel the fixed value of pattern parameter model, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RailRoadModelMatch newMatch(final RailRoadModel pModel) {
    return new Immutable(pModel);
  }
  
  private static final class Mutable extends RailRoadModelMatch {
    Mutable(final RailRoadModel pModel) {
      super(pModel);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RailRoadModelMatch {
    Immutable(final RailRoadModel pModel) {
      super(pModel);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
