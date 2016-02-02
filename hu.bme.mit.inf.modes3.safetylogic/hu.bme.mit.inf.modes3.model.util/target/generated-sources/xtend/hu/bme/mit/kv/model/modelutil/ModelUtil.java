package hu.bme.mit.kv.model.modelutil;

import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ModelUtil {
  @Extension
  private static /* ModelFactory */Object factory /* Skipped initializer because of errors */;
  
  public static SectionModel loadReadySectionModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nSectionModel cannot be resolved to a type."
      + "\nEPackage.Registry cannot be resolved to a type."
      + "\nThe method or field ModelPackage is undefined"
      + "\nThe method or field ModelPackage is undefined"
      + "\nThe method or field Resource is undefined"
      + "\nResourceSetImpl cannot be resolved."
      + "\nThe method or field URI is undefined"
      + "\nRegistry cannot be resolved"
      + "\nINSTANCE cannot be resolved"
      + "\nput cannot be resolved"
      + "\neNS_URI cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\nFactory cannot be resolved"
      + "\nRegistry cannot be resolved"
      + "\nINSTANCE cannot be resolved"
      + "\ngetExtensionToFactoryMap cannot be resolved"
      + "\nput cannot be resolved"
      + "\ncreateResource cannot be resolved"
      + "\ncreateURI cannot be resolved"
      + "\nload cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\nhead cannot be resolved");
  }
  
  public static Object addTrain(final /* TrainModel */Object tm, final int id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field createTrain is undefined"
      + "\nid cannot be resolved"
      + "\ntrains cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public static Object createReadySectionModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field createSectionModel is undefined"
      + "\nThe method or field createTurnout is undefined"
      + "\nThe method or field createSection is undefined"
      + "\nThe method or field createBlindTrack is undefined"
      + "\nThe method or field createTurn is undefined"
      + "\nThe method or field createTurn is undefined"
      + "\nThe method or field createEnglishTurnout is undefined"
      + "\nid cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nid cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nid cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\ngetTurnoutByID cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nid cannot be resolved"
      + "\nid cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nid cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nnotConnectedClockwiseSection cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\ntwoSectionsInClockwiseDirection cannot be resolved"
      + "\nsections cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved");
  }
  
  public static Object createReadyTrainModel(final /* SectionModel */Object sectionModel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field createTrainModel is undefined"
      + "\nThe method or field createTrain is undefined"
      + "\nThe method or field createTrain is undefined"
      + "\nThe method or field createTrain is undefined"
      + "\nid cannot be resolved"
      + "\nid cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntrains cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ntrains cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ntrains cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public static String toGraphViz(final /* SectionModel */Object root) {
    throw new Error("Unresolved compilation problems:"
      + "\nTurnout cannot be resolved to a type."
      + "\nsections cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nisTwoSectionsInClockwiseDirection cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nid cannot be resolved"
      + "\ntoHexa cannot be resolved");
  }
  
  public static String toHexa(final int a) {
    return String.format("%X", Integer.valueOf(a));
  }
  
  public static Object connectSectionToTurnout(final /* SectionModel */Object model, final int turnoutID, final int topSection, final int straightSection, final int divergentsection, final boolean twoSectionsInClockwiseDirection) {
    throw new Error("Unresolved compilation problems:"
      + "\ntwoSectionsInClockwiseDirection cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nclockwise cannot be resolved");
  }
  
  public static Object getSectionByID(final /* SectionModel */Object model, final int id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field id is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nsections cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public static Turnout getTurnoutByID(final /* SectionModel */Object model, final int id) {
    throw new Error("Unresolved compilation problems:"
      + "\nTurnout cannot be resolved to a type."
      + "\nThe method or field id is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nsections cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public static Object connectSectionToSection(final /* SectionModel */Object model, final int clockwise, final int counterClockwise) {
    throw new Error("Unresolved compilation problems:"
      + "\nclockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved");
  }
  
  public static Object switchTurnout(final /* Turnout */Object t) {
    throw new Error("Unresolved compilation problems:"
      + "\ntwoSectionsInClockwiseDirection cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\ncounterClockwise cannot be resolved"
      + "\nnotConnectedSection cannot be resolved"
      + "\nnotConnectedSection cannot be resolved");
  }
  
  public static EnglishTurnout getEnglishTurnout(final /* SectionModel */Object model) {
    throw new Error("Unresolved compilation problems:"
      + "\nEnglishTurnout cannot be resolved to a type."
      + "\nThe method or field id is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nsections cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public static Object switchEnglishTurnout(final /* Turnout */Object turnout) {
    throw new Error("Unresolved compilation problems:"
      + "\nEnglishTurnout cannot be resolved to a type."
      + "\nclockwise cannot be resolved"
      + "\nclockwise cannot be resolved"
      + "\nnotConnectedClockwiseSection cannot be resolved"
      + "\nnotConnectedClockwiseSection cannot be resolved");
  }
}
