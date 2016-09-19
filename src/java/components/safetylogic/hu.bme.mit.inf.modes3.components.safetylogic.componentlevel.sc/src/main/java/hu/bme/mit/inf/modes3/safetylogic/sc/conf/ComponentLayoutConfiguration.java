package hu.bme.mit.inf.modes3.safetylogic.sc.conf;

import java.util.Arrays;
import java.util.List;

public class ComponentLayoutConfiguration {

	protected String componentName;

	protected TurnoutConfiguration[] turnouts;

	protected SectionConfiguration[] sections;

	public ComponentLayoutConfiguration(String componentName, TurnoutConfiguration[] turnouts, SectionConfiguration[] sections) {
		this.componentName = componentName;
		this.turnouts = turnouts;
		this.sections = sections;
	}

	public String getComponentName() {
		return componentName;
	}

	public List<TurnoutConfiguration> getTurnouts() {
		return Arrays.asList(turnouts);
	}

	public List<SectionConfiguration> getSections() {
		return Arrays.asList(sections);
	}

}
