package com.ericsson.mit.emfpop.serialization;

import com.ericsson.mit.emfpop.core.UppaalModelBuilder;
import com.ericsson.mit.emfpop.util.Util;
import com.google.common.base.Objects;
import de.uni_paderborn.uppaal.NTA;
import de.uni_paderborn.uppaal.declarations.Declaration;
import de.uni_paderborn.uppaal.declarations.GlobalDeclarations;
import de.uni_paderborn.uppaal.declarations.LocalDeclarations;
import de.uni_paderborn.uppaal.declarations.Parameter;
import de.uni_paderborn.uppaal.declarations.VariableDeclaration;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.IdentifierExpression;
import de.uni_paderborn.uppaal.templates.Edge;
import de.uni_paderborn.uppaal.templates.Location;
import de.uni_paderborn.uppaal.templates.LocationKind;
import de.uni_paderborn.uppaal.templates.Selection;
import de.uni_paderborn.uppaal.templates.Synchronization;
import de.uni_paderborn.uppaal.templates.Template;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * The class is responsible for serializing the UPPAAL model specified by the
 * UppaalModelBuilder, to an XML file, that can be loaded by the UPPAAL.
 * 
 * The class strongly depends on the UppaalModelBuilder, and its saveToXML
 * method should only be called, after the UPPAAL model transformation was done
 * by the UppaalModelBuilder and the ModelTraverser classes.
 * 
 * The serialization is done by specifying the format of the output in character
 * sequences, and each model element is inserted to its place.
 * 
 * The only limitation of the current implementation is that, it can only
 * serialize the first update statement for each edge(*), and it cannot
 * serialize the global declarations, since only the local declarations for the
 * specified Template has been stored.
 * 
 * (*) It was done because of the transformation: only one update for each
 * edge is stored, during the transformation. If there are multiple updates,
 * then multiple, sequential locations are created one after another, and each
 * one is connected with the next one by an edge, that has the current update
 * statement. This way multiple updates are cut in sequential pieces, that is
 * equivalent to the sequence of the statements within the Alf instance model.
 * 
 * The class has only static fields and methods, because it does not store
 * anything.
 * 
 * @author Benedek Horvath
 * @further_development Konnerth Raimund Andreas
 */
@SuppressWarnings("all")
public class UppaalModelSerializer {
  /**
   * Save the UPPAAL model specified by the UppaalModelBuilder to an XML file,
   * denoted by its file path. The created XML file can be loaded by the
   * UPPAAL.
   * 
   * @param filepath
   *            The path for the output file. It contains the file name also,
   *            except for the file extension.
   */
  public static void saveToXML(final String filename) {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
    try {
      Calendar _instance = Calendar.getInstance();
      Date _time = _instance.getTime();
      String _format = dateFormat.format(_time);
      String _plus = ((Util.rootDirectory + filename) + _format);
      String _plus_1 = (_plus + ".xml");
      FileWriter fw = new FileWriter(_plus_1);
      CharSequence _createHeader = UppaalModelSerializer.createHeader();
      CharSequence _createDeclaration = UppaalModelSerializer.createDeclaration();
      String _string = _createDeclaration.toString();
      String _plus_2 = (_createHeader + _string);
      CharSequence _createTemplate = UppaalModelSerializer.createTemplate();
      String _string_1 = _createTemplate.toString();
      String _plus_3 = (_plus_2 + _string_1);
      CharSequence _createFooter = UppaalModelSerializer.createFooter();
      String _plus_4 = (_plus_3 + _createFooter);
      fw.write(_plus_4);
      fw.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ex = (IOException)_t;
        String _message = ex.getMessage();
        String _plus_5 = ("An error has occurred, while creating the XML file. " + _message);
        System.err.println(_plus_5);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Create the header and the beginning of the XML file, that contains
   * the declaration of the top-level UPPAAL module (NTA) and the global
   * declarations as well.
   * 
   * @return The header of the XML file in a char sequence.
   */
  public static CharSequence createHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    _builder.newLine();
    _builder.append("<!DOCTYPE nta PUBLIC \'-//Uppaal Team//DTD Flat System 1.1//EN\' \'http://www.it.uu.se/research/group/darts/uppaal/flat-1_1.dtd\'>");
    _builder.newLine();
    _builder.append("<nta>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Create the global declarations.
   * 
   * @return The declaration part of the XML file in a char sequence.
   */
  public static CharSequence createDeclaration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<declaration>//Global declarations");
    _builder.newLine();
    _builder.append("const int N = 3;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//Channel declarations");
    _builder.newLine();
    {
      UppaalModelBuilder _instance = UppaalModelBuilder.getInstance();
      NTA _nTA = _instance.getNTA();
      GlobalDeclarations _globalDeclarations = _nTA.getGlobalDeclarations();
      EList<Declaration> _declaration = _globalDeclarations.getDeclaration();
      boolean _hasElements = false;
      for(final Declaration declaration : _declaration) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        {
          String _exp = declaration.getExp();
          boolean _startsWith = _exp.startsWith("TRUE");
          if (_startsWith) {
            _builder.append("broadcast chan ");
            String _exp_1 = declaration.getExp();
            String _substring = _exp_1.substring(4);
            _builder.append(_substring, "");
            _builder.append(";");
          } else {
            _builder.newLineIfNotEmpty();
            _builder.append("chan ");
            String _exp_2 = declaration.getExp();
            String _substring_1 = _exp_2.substring(5);
            _builder.append(_substring_1, "");
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</declaration>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Create the main part of the XML file: the Template, and locations and the
   * edges within the Template. All the data for the serialization are fetched
   * from the UppaalModelBuilder.
   * 
   * @return The main part of the XML file in a char sequence.
   */
  public static CharSequence createTemplate() {
    StringConcatenation _builder = new StringConcatenation();
    {
      UppaalModelBuilder _instance = UppaalModelBuilder.getInstance();
      NTA _nTA = _instance.getNTA();
      EList<Template> _template = _nTA.getTemplate();
      for(final Template template : _template) {
        _builder.append("<template>");
        _builder.newLine();
        _builder.append("<name>");
        String _name = template.getName();
        _builder.append(_name, "");
        _builder.append("</name>");
        _builder.newLineIfNotEmpty();
        _builder.append("<parameter>");
        {
          EList<Parameter> _parameter = template.getParameter();
          boolean _hasElements = false;
          for(final Parameter parameter : _parameter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.newLineIfNotEmpty();
            _builder.append("int ");
            VariableDeclaration _variableDeclaration = parameter.getVariableDeclaration();
            String _exp = _variableDeclaration.getExp();
            _builder.append(_exp, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("</parameter>");
        _builder.newLineIfNotEmpty();
        _builder.append("<declaration>");
        {
          LocalDeclarations _declarations = template.getDeclarations();
          EList<Declaration> _declaration = _declarations.getDeclaration();
          boolean _hasElements_1 = false;
          for(final Declaration declaration : _declaration) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.newLineIfNotEmpty();
            _builder.append("int ");
            String _exp_1 = declaration.getExp();
            _builder.append(_exp_1, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("</declaration>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        {
          EList<Location> _location = template.getLocation();
          boolean _hasElements_2 = false;
          for(final Location location : _location) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.append("<location id=\"");
            String _name_1 = location.getName();
            _builder.append(_name_1, "");
            _builder.append("\">");
            _builder.newLineIfNotEmpty();
            _builder.append("<name>");
            String _name_2 = location.getName();
            _builder.append(_name_2, "");
            _builder.append("</name>");
            _builder.newLineIfNotEmpty();
            {
              LocationKind _locationTimeKind = location.getLocationTimeKind();
              String _string = _locationTimeKind.toString();
              boolean _contentEquals = _string.contentEquals("COMMITED");
              if (_contentEquals) {
                _builder.append("<committed/>");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("</location>");
            _builder.newLine();
          }
        }
        _builder.append("<init ref=\"");
        Location _init = null;
        if (template!=null) {
          _init=template.getInit();
        }
        String _name_3 = null;
        if (_init!=null) {
          _name_3=_init.getName();
        }
        _builder.append(_name_3, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        {
          EList<Edge> _edge = template.getEdge();
          boolean _hasElements_3 = false;
          for(final Edge transition : _edge) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate("\n", "");
            }
            _builder.append("<transition>");
            _builder.newLine();
            _builder.append("<source ref=\"");
            Location _source = null;
            if (transition!=null) {
              _source=transition.getSource();
            }
            String _name_4 = null;
            if (_source!=null) {
              _name_4=_source.getName();
            }
            _builder.append(_name_4, "");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("<target ref=\"");
            Location _target = null;
            if (transition!=null) {
              _target=transition.getTarget();
            }
            String _name_5 = null;
            if (_target!=null) {
              _name_5=_target.getName();
            }
            _builder.append(_name_5, "");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            {
              EList<Selection> _selection = transition.getSelection();
              int _length = ((Object[])Conversions.unwrapArray(_selection, Object.class)).length;
              boolean _equals = (_length == 1);
              if (_equals) {
                _builder.append("<label kind=\"select\">");
                EList<Selection> _selection_1 = transition.getSelection();
                Selection _get = _selection_1.get(0);
                String _selectStatement = _get.getSelectStatement();
                _builder.append(_selectStatement, "");
                _builder.append("</label>");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              Expression _guard = transition.getGuard();
              boolean _equals_1 = Objects.equal(_guard, null);
              boolean _not = (!_equals_1);
              if (_not) {
                _builder.append("<label kind=\"guard\">");
                Expression _guard_1 = transition.getGuard();
                String _exp_2 = _guard_1.getExp();
                _builder.append(_exp_2, "");
                _builder.append("</label>");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              Synchronization _synchronization = transition.getSynchronization();
              boolean _equals_2 = Objects.equal(_synchronization, null);
              boolean _not_1 = (!_equals_2);
              if (_not_1) {
                _builder.append("<label kind=\"synchronisation\">");
                Synchronization _synchronization_1 = transition.getSynchronization();
                IdentifierExpression _channelExpression = _synchronization_1.getChannelExpression();
                String _exp_3 = _channelExpression.getExp();
                _builder.append(_exp_3, "");
                _builder.append("</label>");
              }
            }
            _builder.newLineIfNotEmpty();
            {
              EList<Expression> _update = transition.getUpdate();
              int _length_1 = ((Object[])Conversions.unwrapArray(_update, Object.class)).length;
              boolean _equals_3 = (_length_1 == 1);
              if (_equals_3) {
                _builder.append("<label kind=\"assignment\">");
                EList<Expression> _update_1 = transition.getUpdate();
                Expression _get_1 = _update_1.get(0);
                String _exp_4 = _get_1.getExp();
                _builder.append(_exp_4, "");
                _builder.append("</label>");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("</transition>");
            _builder.newLine();
          }
        }
        _builder.append("</template>");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * Create the footer of the XML file, which contains the instantiation of
   * the recently created Template. The instance of the Template is called
   * "Process" in this implementation.
   * 
   * @return The footer of the XML file in a char sequence.
   * 
   * def static createFooter() '''
   * <system>//Template instantiations
   * «FOR template : UppaalModelBuilder.instance.NTA.template»«template.name.toLowerCase»_inst = «template.name»(1);
   * «ENDFOR»
   * 
   * //System composed of the following processes
   * system «FOR template : UppaalModelBuilder.instance.NTA.template SEPARATOR ","»«template.name.toLowerCase»_inst«ENDFOR»;
   * </system>
   * </nta>
   * '''
   */
  public static CharSequence createFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<system>//Template instantiations");
    _builder.newLine();
    _builder.append("FreeDiv = FREESECTION(0);");
    _builder.newLine();
    _builder.append("FreeStr = FREESECTION(1);");
    _builder.newLine();
    _builder.append("FreeTop = FREESECTION(2);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("OccupiedDiv = OCCUPIEDSECTION(0);");
    _builder.newLine();
    _builder.append("OccupiedStr = OCCUPIEDSECTION(1);");
    _builder.newLine();
    _builder.append("OccupiedTop = OCCUPIEDSECTION(2);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("DivTurnout = DIVERGENTTURNOUT(0);  ");
    _builder.newLine();
    _builder.append("StrTurnout = STRAIGHTTURNOUT(0);");
    _builder.newLine();
    _builder.append("SendSectionLock = SENDSECTIONLOCK(0);");
    _builder.newLine();
    _builder.append("SendPassingDenied = SENDPASSINGDENIED(0);");
    _builder.newLine();
    _builder.append("SendPassingAllowed = SENDPASSINGALLOWED(0);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("test = INIT();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//System composed of the following processes");
    _builder.newLine();
    _builder.append("system ");
    _builder.newLine();
    _builder.append("FreeDiv");
    _builder.newLine();
    _builder.append(",FreeStr");
    _builder.newLine();
    _builder.append(",FreeTop");
    _builder.newLine();
    _builder.append(",OccupiedDiv");
    _builder.newLine();
    _builder.append(",OccupiedStr");
    _builder.newLine();
    _builder.append(",OccupiedTop");
    _builder.newLine();
    _builder.append(",DivTurnout");
    _builder.newLine();
    _builder.append(",StrTurnout");
    _builder.newLine();
    _builder.append(",SendSectionLock");
    _builder.newLine();
    _builder.append(",SendPassingDenied");
    _builder.newLine();
    _builder.append(",SendPassingAllowed");
    _builder.newLine();
    _builder.append(",test");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.append("</system>");
    _builder.newLine();
    _builder.append("</nta>");
    _builder.newLine();
    return _builder;
  }
}
