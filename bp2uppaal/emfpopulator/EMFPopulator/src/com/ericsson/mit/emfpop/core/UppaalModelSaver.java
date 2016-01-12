package com.ericsson.mit.emfpop.core;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.ericsson.mit.emfpop.util.Util;

import de.uni_paderborn.uppaal.NTA;
import de.uni_paderborn.uppaal.UppaalPackage;

public class UppaalModelSaver {

	/**
	 * Save the UPPAAL model to a given file, with extension "uppaal".
	 * 
	 * @param NTA
	 *            The model to be saved.
	 * @param filename
	 *            The path and the name of the output file.
	 */
	public static void saveUppaalModel(String filename, String fileExtension) {
		
		// the name and the path of the output file
		String outputFileName = Util.rootDirectory + filename + "." + fileExtension;

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> map = reg.getExtensionToFactoryMap();
		map.put(fileExtension, new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		// create a resource
		Resource resource = resSet
				.createResource(URI.createFileURI(outputFileName));
		
		// Build XML structure of the model.
		UppaalModelBuilder.getInstance().buildModel();
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.getContents().add(UppaalModelBuilder.getInstance().getNTA());

		// now save the content.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static NTA loadResource(String inputFile, String fileExtension) {
		
		String inputFileName = Util.rootDirectory + inputFile + "." + fileExtension;
		
		UppaalPackage.eINSTANCE.eClass();
	
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> map = reg.getExtensionToFactoryMap();
		map.put(fileExtension, new XMIResourceFactoryImpl());

		ResourceSet resourceSet = new ResourceSetImpl();

		Resource resource = resourceSet.getResource(URI.createFileURI(inputFileName), true);

		return (NTA)resource.getContents().get(0);
	}

}
