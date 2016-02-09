package com.ericsson.mit.emfpop.serialization;

import com.ericsson.mit.emfpop.util.Util;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.xtend2.lib.StringConcatenation;
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
    _builder.append("�FOR declaration : UppaalModelBuilder.instance.NTA.globalDeclarations.declaration SEPARATOR \"\\n\"�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF declaration.exp.startsWith(\"TRUE\")�broadcast chan �declaration.exp.substring(4)�;�ELSE�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("chan �declaration.exp.substring(5)�;�ENDIF�");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
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
    _builder.append("�FOR template : UppaalModelBuilder.instance.NTA.template�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<template>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>�template.name�</name>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<parameter>�FOR parameter: template.parameter SEPARATOR \"\\n\"�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int �parameter.variableDeclaration.exp�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�</parameter>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<declaration>�FOR declaration : template.declarations.declaration SEPARATOR \"\\n\"�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int �declaration.exp�;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�</declaration>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR location : template.location SEPARATOR \"\\n\"�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<location id=\"�location.name�\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>�location.name�</name>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF (location.locationTimeKind.toString.contentEquals(\"COMMITED\"))�<committed/>�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</location>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<init ref=\"�template?.init?.name�\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�FOR transition : template.edge SEPARATOR \"\\n\"�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<transition>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<source ref=\"�transition?.source?.name�\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<target ref=\"�transition?.target?.name�\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF (transition.selection.length == 1)�<label kind=\"select\">�transition.selection.get(0).selectStatement�</label>�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF !(transition.guard == null)�<label kind=\"guard\">�transition.guard.exp�</label>�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF !(transition.synchronization == null)�<label kind=\"synchronisation\">�transition.synchronization.channelExpression.exp�</label>�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�IF (transition.update.length == 1)�<label kind=\"assignment\">�transition.update.get(0).exp�</label>�ENDIF�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</transition>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</template>");
    _builder.newLine();
    _builder.append("�ENDFOR�");
    _builder.newLine();
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
   * �FOR template : UppaalModelBuilder.instance.NTA.template��template.name.toLowerCase�_inst = �template.name�(1);
   * �ENDFOR�
   * 
   * //System composed of the following processes
   * system �FOR template : UppaalModelBuilder.instance.NTA.template SEPARATOR ","��template.name.toLowerCase�_inst�ENDFOR�;
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
