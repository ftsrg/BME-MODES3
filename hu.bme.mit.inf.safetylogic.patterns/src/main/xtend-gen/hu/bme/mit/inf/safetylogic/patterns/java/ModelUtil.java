package hu.bme.mit.inf.safetylogic.patterns.java;

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Path;
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement;
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel;
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory;
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatch;
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ModelUtil {
  public static Resource createAllPaths(final Resource modelResource) {
    try {
      EMFScope _eMFScope = new EMFScope(modelResource);
      final ViatraQueryEngine engine = ViatraQueryEngine.on(_eMFScope);
      final ThreeConnectedRailRoadPartsMatcher matcher = ThreeConnectedRailRoadPartsMatcher.on(engine);
      Collection<ThreeConnectedRailRoadPartsMatch> _allMatches = matcher.getAllMatches();
      final Consumer<ThreeConnectedRailRoadPartsMatch> _function = (ThreeConnectedRailRoadPartsMatch it) -> {
        final Path path = RailRoadModelFactory.eINSTANCE.createPath();
        RailRoadElement _middle = it.getMiddle();
        path.setVia(_middle);
        RailRoadElement _one = it.getOne();
        path.setFrom(_one);
        RailRoadElement _other = it.getOther();
        path.setTo(_other);
        RailRoadModel _modelFromResource = ModelUtil.getModelFromResource(modelResource);
        EList<Path> _paths = _modelFromResource.getPaths();
        _paths.add(path);
      };
      _allMatches.forEach(_function);
      return modelResource;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static RailRoadModel getModelFromResource(final Resource resource) {
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    return ((RailRoadModel) _head);
  }
}
