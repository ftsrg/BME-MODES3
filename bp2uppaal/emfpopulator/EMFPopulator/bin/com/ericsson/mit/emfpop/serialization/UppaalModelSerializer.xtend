package com.ericsson.mit.emfpop.serialization

import com.ericsson.mit.emfpop.core.UppaalModelBuilder
import com.ericsson.mit.emfpop.util.Util
import java.io.FileWriter
import java.io.IOException
import java.util.Calendar
import java.text.DateFormat
import java.text.SimpleDateFormat

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
 * 
 */
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
	def static saveToXML(String filename) {
		val dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		try {
			var fw = new FileWriter(Util.rootDirectory + filename + dateFormat.format(Calendar.getInstance().time) + ".xml")
			fw.write(createHeader + createDeclaration.toString + createTemplate.toString + createFooter)
			fw.close
		} catch (IOException ex) {
			System.err.println("An error has occurred, while creating the XML file. " + ex.message)
		}
	}
	
	/**
	 * Create the header and the beginning of the XML file, that contains 
	 * the declaration of the top-level UPPAAL module (NTA) and the global 
	 * declarations as well.
	 * 
	 * @return The header of the XML file in a char sequence.
	 */
	def static createHeader() '''
		<?xml version="1.0" encoding="utf-8"?>
		<!DOCTYPE nta PUBLIC '-//Uppaal Team//DTD Flat System 1.1//EN' 'http://www.it.uu.se/research/group/darts/uppaal/flat-1_1.dtd'>
		<nta>
	'''
	
	/**
	 * Create the global declarations.
	 * 
	 * @return The declaration part of the XML file in a char sequence.
	 */
	def static createDeclaration() '''
		<declaration>//Global declarations
		const int N = 3;
		
		//Channel declarations
		«FOR declaration : UppaalModelBuilder.instance.NTA.globalDeclarations.declaration SEPARATOR "\n"»
			«IF declaration.exp.startsWith("TRUE")»broadcast chan «declaration.exp.substring(4)»;«ELSE»
			chan «declaration.exp.substring(5)»;«ENDIF»
		«ENDFOR»
		</declaration>
	'''
	
	/**
	 * Create the main part of the XML file: the Template, and locations and the 
	 * edges within the Template. All the data for the serialization are fetched 
	 * from the UppaalModelBuilder.
	 * 
	 * @return The main part of the XML file in a char sequence.
	 */
	def static createTemplate() '''
		«FOR template : UppaalModelBuilder.instance.NTA.template»
			<template>
			<name>«template.name»</name>
			<parameter>«FOR parameter: template.parameter SEPARATOR "\n"»
			int «parameter.variableDeclaration.exp»
			«ENDFOR»</parameter>
			<declaration>«FOR declaration : template.declarations.declaration SEPARATOR "\n"»
			int «declaration.exp»;
			«ENDFOR»</declaration>
				
			«FOR location : template.location SEPARATOR "\n"»
			<location id="«location.name»">
			<name>«location.name»</name>
			«IF (location.locationTimeKind.toString.contentEquals("COMMITED"))»<committed/>«ENDIF»
			</location>
			«ENDFOR»
			<init ref="«template?.init?.name»"/>
			«FOR transition : template.edge SEPARATOR "\n"»
			<transition>
			<source ref="«transition?.source?.name»"/>
			<target ref="«transition?.target?.name»"/>
			«IF (transition.selection.length == 1)»<label kind="select">«transition.selection.get(0).selectStatement»</label>«ENDIF»
			«IF !(transition.guard == null)»<label kind="guard">«transition.guard.exp»</label>«ENDIF»
			«IF !(transition.synchronization == null)»<label kind="synchronisation">«transition.synchronization.channelExpression.exp»</label>«ENDIF»
			«IF (transition.update.length == 1)»<label kind="assignment">«transition.update.get(0).exp»</label>«ENDIF»
			</transition>
			«ENDFOR»
			</template>
		«ENDFOR»
	'''

	/**
	 * Create the footer of the XML file, which contains the instantiation of 
	 * the recently created Template. The instance of the Template is called
	 * "Process" in this implementation.
	 * 
	 * @return The footer of the XML file in a char sequence.
	 
	def static createFooter() '''
		<system>//Template instantiations
		«FOR template : UppaalModelBuilder.instance.NTA.template»«template.name.toLowerCase»_inst = «template.name»(1);
		«ENDFOR»
		
		//System composed of the following processes
		system «FOR template : UppaalModelBuilder.instance.NTA.template SEPARATOR ","»«template.name.toLowerCase»_inst«ENDFOR»;
		</system>
		</nta>
	'''
	* 
	*/
	def static createFooter() '''
		<system>//Template instantiations
		FreeDiv = FREESECTION(0);
		FreeStr = FREESECTION(1);
		FreeTop = FREESECTION(2);

		OccupiedDiv = OCCUPIEDSECTION(0);
		OccupiedStr = OCCUPIEDSECTION(1);
		OccupiedTop = OCCUPIEDSECTION(2);

		DivTurnout = DIVERGENTTURNOUT(0);  
		StrTurnout = STRAIGHTTURNOUT(0);
		SendSectionLock = SENDSECTIONLOCK(0);
		SendPassingDenied = SENDPASSINGDENIED(0);
		SendPassingAllowed = SENDPASSINGALLOWED(0);

		test = INIT();
		
		//System composed of the following processes
		system 
		FreeDiv
		,FreeStr
		,FreeTop
		,OccupiedDiv
		,OccupiedStr
		,OccupiedTop
		,DivTurnout
		,StrTurnout
		,SendSectionLock
		,SendPassingDenied
		,SendPassingAllowed
		,test
		;
		</system>
		</nta>
	'''

}
