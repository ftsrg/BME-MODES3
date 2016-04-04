package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.sectionsInSameRailroadPartAsTrain pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SectionsInSameRailroadPartAsTrainProcessor implements IMatchProcessor<SectionsInSameRailroadPartAsTrainMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTrain the value of pattern parameter train in the currently processed match
   * @param pSection the value of pattern parameter section in the currently processed match
   * 
   */
  public abstract void process(final Train pTrain, final Section pSection);
  
  @Override
  public void process(final SectionsInSameRailroadPartAsTrainMatch match) {
    process(match.getTrain(), match.getSection());
  }
}
