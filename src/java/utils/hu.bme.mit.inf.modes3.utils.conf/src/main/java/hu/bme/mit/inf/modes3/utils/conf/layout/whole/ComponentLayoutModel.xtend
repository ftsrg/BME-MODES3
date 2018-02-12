package hu.bme.mit.inf.modes3.utils.conf.layout.whole

import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

@Data
class ComponentLayoutModel {
	String componentName
	Set<TurnoutModel> turnouts
	Set<SectionModel> sections
}
