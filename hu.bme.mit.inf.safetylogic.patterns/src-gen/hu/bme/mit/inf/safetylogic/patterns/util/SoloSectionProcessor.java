package hu.bme.mit.inf.safetylogic.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.SoloSectionMatch;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.soloSection pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SoloSectionProcessor implements IMatchProcessor<SoloSectionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSection the value of pattern parameter section in the currently processed match
   * 
   */
  public abstract void process(final Section pSection);
  
  @Override
  public void process(final SoloSectionMatch match) {
    process(match.getSection());
  }
}
