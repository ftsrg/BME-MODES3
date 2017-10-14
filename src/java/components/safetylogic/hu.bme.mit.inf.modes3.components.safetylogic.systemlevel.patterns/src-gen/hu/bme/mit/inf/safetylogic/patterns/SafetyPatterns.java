/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainTrailingTurnoutMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainTrailingTurnoutQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all public patterns defined in SafetyPatterns.vql.
 * 
 * <p>Use the static instance as any {@link org.eclipse.viatra.query.runtime.api.IPatternGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file SafetyPatterns.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>nextSection</li>
 * <li>trainHitsAnotherTrain</li>
 * <li>trainTrailingTurnout</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class SafetyPatterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SafetyPatterns instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new SafetyPatterns();
    }
    return INSTANCE;
  }
  
  private static SafetyPatterns INSTANCE;
  
  private SafetyPatterns() throws ViatraQueryException {
    querySpecifications.add(NextSectionQuerySpecification.instance());
    querySpecifications.add(TrainHitsAnotherTrainQuerySpecification.instance());
    querySpecifications.add(TrainTrailingTurnoutQuerySpecification.instance());
  }
  
  public NextSectionQuerySpecification getNextSection() throws ViatraQueryException {
    return NextSectionQuerySpecification.instance();
  }
  
  public NextSectionMatcher getNextSection(final ViatraQueryEngine engine) throws ViatraQueryException {
    return NextSectionMatcher.on(engine);
  }
  
  public TrainHitsAnotherTrainQuerySpecification getTrainHitsAnotherTrain() throws ViatraQueryException {
    return TrainHitsAnotherTrainQuerySpecification.instance();
  }
  
  public TrainHitsAnotherTrainMatcher getTrainHitsAnotherTrain(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TrainHitsAnotherTrainMatcher.on(engine);
  }
  
  public TrainTrailingTurnoutQuerySpecification getTrainTrailingTurnout() throws ViatraQueryException {
    return TrainTrailingTurnoutQuerySpecification.instance();
  }
  
  public TrainTrailingTurnoutMatcher getTrainTrailingTurnout(final ViatraQueryEngine engine) throws ViatraQueryException {
    return TrainTrailingTurnoutMatcher.on(engine);
  }
}
