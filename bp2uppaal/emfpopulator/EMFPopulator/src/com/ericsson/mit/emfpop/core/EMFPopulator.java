package com.ericsson.mit.emfpop.core;

import java.util.logging.Level;

import com.ericsson.mit.emfpop.serialization.UppaalModelSerializer;
import com.ericsson.mit.emfpop.util.Util;

public class EMFPopulator {

	public static void main(String[] args) {

		/**
		 * Input language for creating the components. Multiple elements are
		 * separated with commas. The commands must be specified as the program
		 * arguments.
		 * 
		 * NTA - nta name
		 * TEMPLATE - template name 
		 * DECLARATION - globaldeclaration expression
		 * LOCATION - location templateName,name,true|false <- last parameter if committed or not. 
		 * INITIAL LOCATION- initial templateName,name
		 * EDGE - transition templateName,source,target,labelSynchronization,labelGuard,labelUpdate
		 * 
		 * SYSTEM -system template1,template2,...
		 * 
		 */
		if (args.length > 0) {
			switch (args[0].toUpperCase()) {
			case Util.NTA: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().createNTA(args[1]);
					Util.fileLogger.log(Level.INFO, "NTA added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.G_DECLARATION: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().addGlobalDeclaration(args[1]);
					Util.fileLogger.log(Level.INFO, "Declaration added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.L_DECLARATION: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().addLocalDeclaration(args[1]);
					Util.fileLogger.log(Level.INFO, "Declaration added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.SYSTEM: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().createSystem(args[1]);
					Util.fileLogger.log(Level.INFO, "System instantiation added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.TEMPLATE: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().createTemplate(args[1]);
					Util.fileLogger.log(Level.INFO, "Template added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.LOCATION: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().createLocation(args[1]);
					Util.fileLogger.log(Level.INFO, "Location added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.LOCATIONTYPECHANGE: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().changeLocationType(args[1]);
					Util.fileLogger.log(Level.INFO, "Location changed.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.INITIAL: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance()
							.setInitialLocation(args[1]);
					Util.fileLogger.log(Level.INFO, "Initial location set.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.REARRANGELOCATIONS: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().rearrangeTemplateLocations(args[1]);
					Util.fileLogger.log(Level.INFO, "Locations arranged.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			
			case Util.COMPLETEMODEL: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().completeModel(args[1]);
					Util.fileLogger.log(Level.INFO, args[1] + " model transformation completed.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}

			case Util.EDGE: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().createEdge(args[1]);
					Util.fileLogger.log(Level.INFO, "Edge added.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case Util.GENERATE: {
				try {
					Util.fileLogger.log(Level.INFO, "Executing command: " + args[0] + " " + args[1]);
					UppaalModelBuilder.getInstance().setNTA(UppaalModelSaver.loadResource(Util.inputFileName,
							Util.fileExtension));
					UppaalModelSerializer.saveToXML(args[1]);
					Util.fileLogger.log(Level.INFO, "UPPAAL input file generated.");
				} catch (Exception e) {
					Util.fileLogger.log(Level.SEVERE,
							"Something went wrong when executing command: " + args[0] + " " + args[1] + "\n" + e.getMessage());
				}
				break;
			}
			case "PRINT": {
				Util.fileLogger.log(Level.INFO, "Executing command: " + args[0]);
				UppaalModelBuilder.getInstance().printAll();
				break;
			}
			default: {
				Util.fileLogger.log(Level.WARNING, "No argument definition found" + " " + (args[0]));
			}
			}
			
			UppaalModelSaver.saveUppaalModel(Util.outputFileName,
					Util.fileExtension);
		} else {
			System.err.println("No arguments detected!");
		}
	}
}
