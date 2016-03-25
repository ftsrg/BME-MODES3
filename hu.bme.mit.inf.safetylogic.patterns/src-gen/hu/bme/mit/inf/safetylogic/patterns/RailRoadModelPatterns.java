package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.BlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.InSameRailroadPartMatcher;
import hu.bme.mit.inf.safetylogic.patterns.NextSectionFromSectionInClockwiseMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SectionNeighborMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SectionsInSameRailroadPartAsTrainMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SoloBlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SoloClockwiseBlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SoloCounterClockwiseBlindTrackMatcher;
import hu.bme.mit.inf.safetylogic.patterns.SoloSectionMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainGoingToCutTheTurnoutMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextAfterNextMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitNextMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TrainsNextTurnoutMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TurnoutMatcher;
import hu.bme.mit.inf.safetylogic.patterns.TwoTrainsInSameSectionMatcher;
import hu.bme.mit.inf.safetylogic.patterns.util.BlindTrackQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.InSameRailroadPartQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.NextSectionFromSectionInClockwiseQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionNeighborQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SectionsInSameRailroadPartAsTrainQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloBlindTrackQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloClockwiseBlindTrackQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloCounterClockwiseBlindTrackQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloSectionQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainGoingToCutTheTurnoutQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitNextAfterNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitNextQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainIsGoingToHitQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TrainsNextTurnoutQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TurnoutQuerySpecification;
import hu.bme.mit.inf.safetylogic.patterns.util.TwoTrainsInSameSectionQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in RailRoadModelPatterns.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file RailRoadModelPatterns.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.bme.mit.inf.safetylogic.patterns, the group contains the definition of the following patterns: <ul>
 * <li>turnout</li>
 * <li>sectionNeighbor</li>
 * <li>inSameRailroadPart</li>
 * <li>soloSection</li>
 * <li>blindTrack</li>
 * <li>soloBlindTrack</li>
 * <li>soloClockwiseBlindTrack</li>
 * <li>soloCounterClockwiseBlindTrack</li>
 * <li>trainsNextTurnout</li>
 * <li>sectionsInSameRailroadPartAsTrain</li>
 * <li>trainGoingToCutTheTurnout</li>
 * <li>twoTrainsInSameSection</li>
 * <li>trainIsGoingToHitNextAfterNext</li>
 * <li>trainIsGoingToHitNext</li>
 * <li>trainIsGoingToHit</li>
 * <li>nextSectionFromSectionInClockwise</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class RailRoadModelPatterns extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static RailRoadModelPatterns instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new RailRoadModelPatterns();
    }
    return INSTANCE;
  }
  
  private static RailRoadModelPatterns INSTANCE;
  
  private RailRoadModelPatterns() throws IncQueryException {
    querySpecifications.add(TurnoutQuerySpecification.instance());
    querySpecifications.add(SectionNeighborQuerySpecification.instance());
    querySpecifications.add(InSameRailroadPartQuerySpecification.instance());
    querySpecifications.add(SoloSectionQuerySpecification.instance());
    querySpecifications.add(BlindTrackQuerySpecification.instance());
    querySpecifications.add(SoloBlindTrackQuerySpecification.instance());
    querySpecifications.add(SoloClockwiseBlindTrackQuerySpecification.instance());
    querySpecifications.add(SoloCounterClockwiseBlindTrackQuerySpecification.instance());
    querySpecifications.add(TrainsNextTurnoutQuerySpecification.instance());
    querySpecifications.add(SectionsInSameRailroadPartAsTrainQuerySpecification.instance());
    querySpecifications.add(TrainGoingToCutTheTurnoutQuerySpecification.instance());
    querySpecifications.add(TwoTrainsInSameSectionQuerySpecification.instance());
    querySpecifications.add(TrainIsGoingToHitNextAfterNextQuerySpecification.instance());
    querySpecifications.add(TrainIsGoingToHitNextQuerySpecification.instance());
    querySpecifications.add(TrainIsGoingToHitQuerySpecification.instance());
    querySpecifications.add(NextSectionFromSectionInClockwiseQuerySpecification.instance());
  }
  
  public TurnoutQuerySpecification getTurnout() throws IncQueryException {
    return TurnoutQuerySpecification.instance();
  }
  
  public TurnoutMatcher getTurnout(final IncQueryEngine engine) throws IncQueryException {
    return TurnoutMatcher.on(engine);
  }
  
  public SectionNeighborQuerySpecification getSectionNeighbor() throws IncQueryException {
    return SectionNeighborQuerySpecification.instance();
  }
  
  public SectionNeighborMatcher getSectionNeighbor(final IncQueryEngine engine) throws IncQueryException {
    return SectionNeighborMatcher.on(engine);
  }
  
  public InSameRailroadPartQuerySpecification getInSameRailroadPart() throws IncQueryException {
    return InSameRailroadPartQuerySpecification.instance();
  }
  
  public InSameRailroadPartMatcher getInSameRailroadPart(final IncQueryEngine engine) throws IncQueryException {
    return InSameRailroadPartMatcher.on(engine);
  }
  
  public SoloSectionQuerySpecification getSoloSection() throws IncQueryException {
    return SoloSectionQuerySpecification.instance();
  }
  
  public SoloSectionMatcher getSoloSection(final IncQueryEngine engine) throws IncQueryException {
    return SoloSectionMatcher.on(engine);
  }
  
  public BlindTrackQuerySpecification getBlindTrack() throws IncQueryException {
    return BlindTrackQuerySpecification.instance();
  }
  
  public BlindTrackMatcher getBlindTrack(final IncQueryEngine engine) throws IncQueryException {
    return BlindTrackMatcher.on(engine);
  }
  
  public SoloBlindTrackQuerySpecification getSoloBlindTrack() throws IncQueryException {
    return SoloBlindTrackQuerySpecification.instance();
  }
  
  public SoloBlindTrackMatcher getSoloBlindTrack(final IncQueryEngine engine) throws IncQueryException {
    return SoloBlindTrackMatcher.on(engine);
  }
  
  public SoloClockwiseBlindTrackQuerySpecification getSoloClockwiseBlindTrack() throws IncQueryException {
    return SoloClockwiseBlindTrackQuerySpecification.instance();
  }
  
  public SoloClockwiseBlindTrackMatcher getSoloClockwiseBlindTrack(final IncQueryEngine engine) throws IncQueryException {
    return SoloClockwiseBlindTrackMatcher.on(engine);
  }
  
  public SoloCounterClockwiseBlindTrackQuerySpecification getSoloCounterClockwiseBlindTrack() throws IncQueryException {
    return SoloCounterClockwiseBlindTrackQuerySpecification.instance();
  }
  
  public SoloCounterClockwiseBlindTrackMatcher getSoloCounterClockwiseBlindTrack(final IncQueryEngine engine) throws IncQueryException {
    return SoloCounterClockwiseBlindTrackMatcher.on(engine);
  }
  
  public TrainsNextTurnoutQuerySpecification getTrainsNextTurnout() throws IncQueryException {
    return TrainsNextTurnoutQuerySpecification.instance();
  }
  
  public TrainsNextTurnoutMatcher getTrainsNextTurnout(final IncQueryEngine engine) throws IncQueryException {
    return TrainsNextTurnoutMatcher.on(engine);
  }
  
  public SectionsInSameRailroadPartAsTrainQuerySpecification getSectionsInSameRailroadPartAsTrain() throws IncQueryException {
    return SectionsInSameRailroadPartAsTrainQuerySpecification.instance();
  }
  
  public SectionsInSameRailroadPartAsTrainMatcher getSectionsInSameRailroadPartAsTrain(final IncQueryEngine engine) throws IncQueryException {
    return SectionsInSameRailroadPartAsTrainMatcher.on(engine);
  }
  
  public TrainGoingToCutTheTurnoutQuerySpecification getTrainGoingToCutTheTurnout() throws IncQueryException {
    return TrainGoingToCutTheTurnoutQuerySpecification.instance();
  }
  
  public TrainGoingToCutTheTurnoutMatcher getTrainGoingToCutTheTurnout(final IncQueryEngine engine) throws IncQueryException {
    return TrainGoingToCutTheTurnoutMatcher.on(engine);
  }
  
  public TwoTrainsInSameSectionQuerySpecification getTwoTrainsInSameSection() throws IncQueryException {
    return TwoTrainsInSameSectionQuerySpecification.instance();
  }
  
  public TwoTrainsInSameSectionMatcher getTwoTrainsInSameSection(final IncQueryEngine engine) throws IncQueryException {
    return TwoTrainsInSameSectionMatcher.on(engine);
  }
  
  public TrainIsGoingToHitNextAfterNextQuerySpecification getTrainIsGoingToHitNextAfterNext() throws IncQueryException {
    return TrainIsGoingToHitNextAfterNextQuerySpecification.instance();
  }
  
  public TrainIsGoingToHitNextAfterNextMatcher getTrainIsGoingToHitNextAfterNext(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitNextAfterNextMatcher.on(engine);
  }
  
  public TrainIsGoingToHitNextQuerySpecification getTrainIsGoingToHitNext() throws IncQueryException {
    return TrainIsGoingToHitNextQuerySpecification.instance();
  }
  
  public TrainIsGoingToHitNextMatcher getTrainIsGoingToHitNext(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitNextMatcher.on(engine);
  }
  
  public TrainIsGoingToHitQuerySpecification getTrainIsGoingToHit() throws IncQueryException {
    return TrainIsGoingToHitQuerySpecification.instance();
  }
  
  public TrainIsGoingToHitMatcher getTrainIsGoingToHit(final IncQueryEngine engine) throws IncQueryException {
    return TrainIsGoingToHitMatcher.on(engine);
  }
  
  public NextSectionFromSectionInClockwiseQuerySpecification getNextSectionFromSectionInClockwise() throws IncQueryException {
    return NextSectionFromSectionInClockwiseQuerySpecification.instance();
  }
  
  public NextSectionFromSectionInClockwiseMatcher getNextSectionFromSectionInClockwise(final IncQueryEngine engine) throws IncQueryException {
    return NextSectionFromSectionInClockwiseMatcher.on(engine);
  }
}
