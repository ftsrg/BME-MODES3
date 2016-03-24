package hu.bme.mit.inf.safetylogic.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatch;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.inSameRailroadPart pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InSameRailroadPartProcessor implements IMatchProcessor<InSameRailroadPartMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSection the value of pattern parameter section in the currently processed match
   * @param pSomeSection the value of pattern parameter someSection in the currently processed match
   * 
   */
  public abstract void process(final Section pSection, final Section pSomeSection);
  
  @Override
  public void process(final InSameRailroadPartMatch match) {
    process(match.getSection(), match.getSomeSection());
  }
}
