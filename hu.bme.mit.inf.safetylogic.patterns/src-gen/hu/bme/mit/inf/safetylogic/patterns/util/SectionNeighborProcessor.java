package hu.bme.mit.inf.safetylogic.patterns.util;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.SectionNeighborMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.sectionNeighbor pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class SectionNeighborProcessor implements IMatchProcessor<SectionNeighborMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pS1 the value of pattern parameter s1 in the currently processed match
   * @param pS2 the value of pattern parameter s2 in the currently processed match
   * 
   */
  public abstract void process(final Section pS1, final Section pS2);
  
  @Override
  public void process(final SectionNeighborMatch match) {
    process(match.getS1(), match.getS2());
  }
}
