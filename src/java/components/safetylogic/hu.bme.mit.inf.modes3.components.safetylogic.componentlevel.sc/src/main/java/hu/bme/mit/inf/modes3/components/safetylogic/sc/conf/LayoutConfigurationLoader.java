package hu.bme.mit.inf.modes3.components.safetylogic.sc.conf;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.ComponentLayoutConfiguration;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.LayoutConfiguration;

public class LayoutConfigurationLoader {

	public static LayoutConfiguration loadLayoutConfiguration(String pathInResources) throws IOException {
		try (InputStreamReader isr = new InputStreamReader(LayoutConfigurationLoader.class.getClassLoader().getResourceAsStream(pathInResources));
				JsonReader reader = new JsonReader(isr)) {
			return new Gson().fromJson(reader, LayoutConfiguration.class);
		}
	}

	public static ComponentLayoutConfiguration getLayoutConfigurationForComponent(LayoutConfiguration layoutConfiguration, String componentName)
			throws LayoutConfigurationException {
		List<ComponentLayoutConfiguration> components = layoutConfiguration.getComponents();
		if (components != null) {
			try {
				return components.stream().filter(conf -> {
					if (conf.getComponentName() != null) {
						return conf.getComponentName().equals(componentName);
					} else {
						return false;
					}
				}).findFirst().get();
			} catch (NoSuchElementException ex) {
				throw new LayoutConfigurationException("The referred component name (" + componentName + ") is not in the layout configuration.");
			}
		} else {
			throw new LayoutConfigurationException("Layout confiugration is null.");
		}

	}

}
