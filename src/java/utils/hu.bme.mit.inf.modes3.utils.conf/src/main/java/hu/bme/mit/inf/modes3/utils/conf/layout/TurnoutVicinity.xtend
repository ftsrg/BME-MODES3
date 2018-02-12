package hu.bme.mit.inf.modes3.utils.conf.layout

import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

@Data
class TurnoutVicinity {
	Set<Integer> straight
	Set<Integer> divergent
	Set<Integer> facing
}
