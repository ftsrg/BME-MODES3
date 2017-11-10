package hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson;

import java.util.Arrays;
import java.util.List;

public class LayoutConfiguration {

	protected ComponentLayoutConfiguration[] components;

	public LayoutConfiguration(ComponentLayoutConfiguration[] components) {
		this.components = components;
	}

	public List<ComponentLayoutConfiguration> getComponents() {
		return Arrays.asList(components);

	}

}
