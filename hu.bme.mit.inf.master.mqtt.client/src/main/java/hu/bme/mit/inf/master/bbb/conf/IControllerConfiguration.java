package hu.bme.mit.inf.master.bbb.conf;

import hu.bme.mit.inf.mqtt.common.data.Section;
import hu.bme.mit.inf.mqtt.common.data.Turnout;

public interface IControllerConfiguration {
	public boolean controllerManagesTurnout(Turnout turnout);
	public boolean controllerManagesSection(Section section);
}