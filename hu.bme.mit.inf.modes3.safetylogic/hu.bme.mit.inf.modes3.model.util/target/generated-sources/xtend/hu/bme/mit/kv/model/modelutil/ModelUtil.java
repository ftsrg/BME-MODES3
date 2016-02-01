package hu.bme.mit.kv.model.modelutil;

import hu.bme.mit.kv.model.railroadmodel.BlindTrack;
import hu.bme.mit.kv.model.railroadmodel.EnglishTurnout;
import hu.bme.mit.kv.model.railroadmodel.ModelFactory;
import hu.bme.mit.kv.model.railroadmodel.ModelPackage;
import hu.bme.mit.kv.model.railroadmodel.Section;
import hu.bme.mit.kv.model.railroadmodel.SectionModel;
import hu.bme.mit.kv.model.railroadmodel.Train;
import hu.bme.mit.kv.model.railroadmodel.TrainModel;
import hu.bme.mit.kv.model.railroadmodel.Turn;
import hu.bme.mit.kv.model.railroadmodel.Turnout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ModelUtil {
  @Extension
  private static ModelFactory factory = ModelFactory.eINSTANCE;
  
  public static SectionModel loadReadySectionModel() {
    try {
      EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
      Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("kv", _xMIResourceFactoryImpl);
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      URI _createURI = URI.createURI("SectionModel.kv");
      final Resource resource = resourceSet.createResource(_createURI);
      InputStream _resourceAsStream = ModelUtil.class.getResourceAsStream("/SectionModel.kv");
      HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
      resource.load(_resourceAsStream, _hashMap);
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final SectionModel sectionModel = ((SectionModel) _head);
      return sectionModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static Train addTrain(final TrainModel tm, final int id) {
    Train train = ModelUtil.factory.createTrain();
    train.setId(id);
    EList<Train> _trains = tm.getTrains();
    _trains.add(train);
    return train;
  }
  
  public static SectionModel createReadySectionModel() {
    SectionModel sectionModel = ModelUtil.factory.createSectionModel();
    for (int i = 1; (i != 7); i++) {
      if (((i != 4) && (i != 9))) {
        Turnout turnout = ModelUtil.factory.createTurnout();
        turnout.setId(i);
        EList<Section> _sections = sectionModel.getSections();
        _sections.add(turnout);
      }
    }
    for (int i = 8; (i != 24); i++) {
      if ((((i != 0x12) && (i != 0xF)) && (i != 0x11))) {
        Section section = ModelUtil.factory.createSection();
        section.setId(i);
        EList<Section> _sections = sectionModel.getSections();
        _sections.add(section);
      }
    }
    BlindTrack blindTrack = ModelUtil.factory.createBlindTrack();
    blindTrack.setId(9);
    Turnout _turnoutByID = ModelUtil.getTurnoutByID(sectionModel, 1);
    blindTrack.setCounterClockwise(_turnoutByID);
    EList<Section> _sections = sectionModel.getSections();
    _sections.add(blindTrack);
    Turn turnerF = ModelUtil.factory.createTurn();
    turnerF.setId(0xF);
    Turn turner11 = ModelUtil.factory.createTurn();
    turner11.setId(0x11);
    EList<Section> _sections_1 = sectionModel.getSections();
    _sections_1.add(turnerF);
    EList<Section> _sections_2 = sectionModel.getSections();
    _sections_2.add(turner11);
    EnglishTurnout englishTurnout = ModelUtil.factory.createEnglishTurnout();
    englishTurnout.setId(4);
    Section section15 = ModelUtil.getSectionByID(sectionModel, 0x15);
    Section section10 = ModelUtil.getSectionByID(sectionModel, 0x10);
    Section sectionE = ModelUtil.getSectionByID(sectionModel, 0xE);
    Section section16 = ModelUtil.getSectionByID(sectionModel, 0x16);
    englishTurnout.setClockwise(section16);
    section16.setCounterClockwise(englishTurnout);
    englishTurnout.setCounterClockwise(section15);
    section15.setClockwise(englishTurnout);
    englishTurnout.setNotConnectedClockwiseSection(sectionE);
    sectionE.setCounterClockwise(englishTurnout);
    englishTurnout.setNotConnectedSection(section10);
    section10.setClockwise(englishTurnout);
    englishTurnout.setTwoSectionsInClockwiseDirection(false);
    EList<Section> _sections_3 = sectionModel.getSections();
    _sections_3.add(englishTurnout);
    ModelUtil.connectSectionToTurnout(sectionModel, 0x1, 0xE, 0x9, 0xD, true);
    ModelUtil.connectSectionToTurnout(sectionModel, 0x2, 0xC, 0x16, 0xF, false);
    ModelUtil.connectSectionToTurnout(sectionModel, 0x3, 0x8, 0xB, 0x17, true);
    ModelUtil.connectSectionToTurnout(sectionModel, 0x5, 0x10, 0xA, 0x11, false);
    ModelUtil.connectSectionToTurnout(sectionModel, 0x6, 0x15, 0x13, 0x14, false);
    ModelUtil.connectSectionToSection(sectionModel, 0xC, 0xA);
    ModelUtil.connectSectionToSection(sectionModel, 0xD, 0x8);
    ModelUtil.connectSectionToSection(sectionModel, 0x17, 0x14);
    ModelUtil.connectSectionToSection(sectionModel, 0xB, 0x13);
    Section sec11 = ModelUtil.getSectionByID(sectionModel, 0x11);
    Section secF = ModelUtil.getSectionByID(sectionModel, 0xF);
    sec11.setCounterClockwise(secF);
    secF.setCounterClockwise(sec11);
    return sectionModel;
  }
  
  public static TrainModel createReadyTrainModel(final SectionModel sectionModel) {
    TrainModel trainModel = ModelUtil.factory.createTrainModel();
    Train train1 = ModelUtil.factory.createTrain();
    Train train2 = ModelUtil.factory.createTrain();
    Train train3 = ModelUtil.factory.createTrain();
    train1.setId(0);
    train2.setId(1);
    train3.setId(2);
    EList<Train> _trains = trainModel.getTrains();
    _trains.add(train1);
    EList<Train> _trains_1 = trainModel.getTrains();
    _trains_1.add(train2);
    EList<Train> _trains_2 = trainModel.getTrains();
    _trains_2.add(train3);
    return trainModel;
  }
  
  public static String toGraphViz(final SectionModel root) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph{");
    _builder.newLine();
    {
      EList<Section> _sections = root.getSections();
      for(final Section sec : _sections) {
        _builder.append("\t");
        int _id = sec.getId();
        String _hexa = ModelUtil.toHexa(_id);
        _builder.append(_hexa, "\t");
        _builder.append(" -> ");
        Section _clockwise = sec.getClockwise();
        int _id_1 = 0;
        if (_clockwise!=null) {
          _id_1=_clockwise.getId();
        }
        String _hexa_1 = ModelUtil.toHexa(_id_1);
        _builder.append(_hexa_1, "\t");
        _builder.append("[label=\"clockwise\"];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        int _id_2 = sec.getId();
        String _hexa_2 = ModelUtil.toHexa(_id_2);
        _builder.append(_hexa_2, "\t");
        _builder.append(" -> ");
        Section _counterClockwise = sec.getCounterClockwise();
        int _id_3 = 0;
        if (_counterClockwise!=null) {
          _id_3=_counterClockwise.getId();
        }
        String _hexa_3 = ModelUtil.toHexa(_id_3);
        _builder.append(_hexa_3, "\t");
        _builder.append("[label=\"counterClockwise\"];");
        _builder.newLineIfNotEmpty();
        {
          if ((sec instanceof Turnout)) {
            {
              boolean _isTwoSectionsInClockwiseDirection = ((Turnout)sec).isTwoSectionsInClockwiseDirection();
              if (_isTwoSectionsInClockwiseDirection) {
                _builder.append("\t");
                int _id_4 = ((Turnout)sec).getId();
                String _hexa_4 = ModelUtil.toHexa(_id_4);
                _builder.append(_hexa_4, "\t");
                _builder.append(" -> ");
                Section _notConnectedSection = ((Turnout)sec).getNotConnectedSection();
                int _id_5 = _notConnectedSection.getId();
                String _hexa_5 = ModelUtil.toHexa(_id_5);
                _builder.append(_hexa_5, "\t");
                _builder.append("[label=\"currentlyNotConnectedClockwise\"]");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                int _id_6 = ((Turnout)sec).getId();
                String _hexa_6 = ModelUtil.toHexa(_id_6);
                _builder.append(_hexa_6, "\t");
                _builder.append(" -> ");
                Section _notConnectedSection_1 = ((Turnout)sec).getNotConnectedSection();
                int _id_7 = _notConnectedSection_1.getId();
                String _hexa_7 = ModelUtil.toHexa(_id_7);
                _builder.append(_hexa_7, "\t");
                _builder.append("[label=\"currentlyNotConnectedCounterclockwise\"]");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String toHexa(final int a) {
    return String.format("%X", Integer.valueOf(a));
  }
  
  public static void connectSectionToTurnout(final SectionModel model, final int turnoutID, final int topSection, final int straightSection, final int divergentsection, final boolean twoSectionsInClockwiseDirection) {
    Turnout turnout = ModelUtil.getTurnoutByID(model, turnoutID);
    Section top = ModelUtil.getSectionByID(model, topSection);
    Section straight = ModelUtil.getSectionByID(model, straightSection);
    Section divergent = ModelUtil.getSectionByID(model, divergentsection);
    turnout.setTwoSectionsInClockwiseDirection(twoSectionsInClockwiseDirection);
    if (twoSectionsInClockwiseDirection) {
      turnout.setCounterClockwise(top);
      top.setClockwise(turnout);
      turnout.setClockwise(straight);
      straight.setCounterClockwise(turnout);
      turnout.setNotConnectedSection(divergent);
      divergent.setCounterClockwise(turnout);
    } else {
      turnout.setClockwise(top);
      top.setCounterClockwise(turnout);
      turnout.setCounterClockwise(straight);
      straight.setClockwise(turnout);
      turnout.setNotConnectedSection(divergent);
      divergent.setClockwise(turnout);
    }
  }
  
  public static Section getSectionByID(final SectionModel model, final int id) {
    EList<Section> _sections = model.getSections();
    final Function1<Section, Boolean> _function = (Section sec) -> {
      int _id = sec.getId();
      return Boolean.valueOf((_id == id));
    };
    return IterableExtensions.<Section>findFirst(_sections, _function);
  }
  
  public static Turnout getTurnoutByID(final SectionModel model, final int id) {
    EList<Section> _sections = model.getSections();
    final Function1<Section, Boolean> _function = (Section sec) -> {
      int _id = sec.getId();
      return Boolean.valueOf((_id == id));
    };
    Section _findFirst = IterableExtensions.<Section>findFirst(_sections, _function);
    return ((Turnout) _findFirst);
  }
  
  public static void connectSectionToSection(final SectionModel model, final int clockwise, final int counterClockwise) {
    Section a = ModelUtil.getSectionByID(model, clockwise);
    Section b = ModelUtil.getSectionByID(model, counterClockwise);
    a.setClockwise(b);
    b.setCounterClockwise(a);
  }
  
  public static void switchTurnout(final Turnout t) {
    boolean _isTwoSectionsInClockwiseDirection = t.isTwoSectionsInClockwiseDirection();
    if (_isTwoSectionsInClockwiseDirection) {
      Section cw = t.getClockwise();
      Section _notConnectedSection = t.getNotConnectedSection();
      t.setClockwise(_notConnectedSection);
      t.setNotConnectedSection(cw);
    } else {
      Section ccw = t.getCounterClockwise();
      Section _notConnectedSection_1 = t.getNotConnectedSection();
      t.setCounterClockwise(_notConnectedSection_1);
      t.setNotConnectedSection(ccw);
    }
  }
  
  public static EnglishTurnout getEnglishTurnout(final SectionModel model) {
    EList<Section> _sections = model.getSections();
    final Function1<Section, Boolean> _function = (Section sec) -> {
      int _id = sec.getId();
      return Boolean.valueOf((_id == 4));
    };
    Section _findFirst = IterableExtensions.<Section>findFirst(_sections, _function);
    return ((EnglishTurnout) _findFirst);
  }
  
  public static void switchEnglishTurnout(final Turnout turnout) {
    EnglishTurnout englishTurnout = ((EnglishTurnout) turnout);
    Section temp = englishTurnout.getClockwise();
    Section _notConnectedClockwiseSection = englishTurnout.getNotConnectedClockwiseSection();
    englishTurnout.setClockwise(_notConnectedClockwiseSection);
    englishTurnout.setNotConnectedClockwiseSection(temp);
  }
}
