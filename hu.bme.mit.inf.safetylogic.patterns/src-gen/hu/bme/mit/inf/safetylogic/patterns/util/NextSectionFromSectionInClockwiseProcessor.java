package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.nextSectionFromSectionInClockwise pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NextSectionFromSectionInClockwiseProcessor implements IMatchProcessor<NextSectionFromSectionInClockwiseMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSection the value of pattern parameter section in the currently processed match
   * @param pNextSection the value of pattern parameter nextSection in the currently processed match
   * 
   */
  public abstract void process(final Section pSection, final Section pNextSection);
  
  @Override
  public void process(final NextSectionFromSectionInClockwiseMatch match) {
    process(match.getSection(), match.getNextSection());
  }
}
