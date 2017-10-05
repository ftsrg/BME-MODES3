/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/SafetyPatterns.vql
 */
package hu.bme.mit.inf.safetylogic.patterns.internal;

import hu.bme.mit.inf.safetylogic.patterns.internal.NotNullQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainDerailsOnNextTurnoutQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainDerailsOnTurnoutNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainHitsAnotherTrainNextAfterNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainHitsAnotherTrainNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainHitsAnotherTrainNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.internal.TrainsAreTooCloseQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainHitsAnotherTrainQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainTrailingTurnoutQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

/**
 * A pattern group formed of all patterns defined in SafetyPatterns.vql.
 * 
 * <p>A private group that includes private patterns as well. Only intended use case is for pattern testing.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>notNull</li>
 * <li>nextSection</li>
 * <li>trainsAreTooClose</li>
 * <li>trainHitsAnotherTrainNextAfterNext</li>
 * <li>trainHitsAnotherTrainNextAfterNextAfterNext</li>
 * <li>trainHitsAnotherTrainNext</li>
 * <li>trainHitsAnotherTrain</li>
 * <li>trainDerailsOnNextTurnout</li>
 * <li>trainDerailsOnTurnoutNextAfterNext</li>
 * <li>trainTrailingTurnout</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class SafetyPatternsAll extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static SafetyPatternsAll instance() throws ViatraQueryException {
    if (INSTANCE == null) {
        INSTANCE = new SafetyPatternsAll();
    }
    return INSTANCE;
  }
  
  private static SafetyPatternsAll INSTANCE;
  
  private SafetyPatternsAll() throws ViatraQueryException {
    querySpecifications.add(NotNullQuerySpecification.instance());
    querySpecifications.add(NextSectionQuerySpecification.instance());
    querySpecifications.add(TrainsAreTooCloseQuerySpecification.instance());
    querySpecifications.add(TrainHitsAnotherTrainNextAfterNextQuerySpecification.instance());
    querySpecifications.add(TrainHitsAnotherTrainNextAfterNextAfterNextQuerySpecification.instance());
    querySpecifications.add(TrainHitsAnotherTrainNextQuerySpecification.instance());
    querySpecifications.add(TrainHitsAnotherTrainQuerySpecification.instance());
    querySpecifications.add(TrainDerailsOnNextTurnoutQuerySpecification.instance());
    querySpecifications.add(TrainDerailsOnTurnoutNextAfterNextQuerySpecification.instance());
    querySpecifications.add(TrainTrailingTurnoutQuerySpecification.instance());
  }
}
