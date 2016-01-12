.function populate_declarations
.param string JAVA_DIR
.param string DLMTR
.select many instance_state_machines from instances of SM_ISM
	.for each instance_state_machine in instance_state_machines
		.invoke eventSet = GetAllEvents(instance_state_machine)
		.assign events = eventSet.result
		.for each event in events
			.invoke evt = findNonPolymorphicEvent(instance_state_machine,event)
			.if (not evt.declared)
				.select many op_evt related by event->E_GSME[R707]->E_GES[R703]->E_ESS[R701]->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_OPB[R698]->O_TFR[R696]
				.if (not_empty op_evt)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${event.Mning}${DLMTR}TRUE")
				.else 
.//Section class events are broadcast and array type
.select one class related by instance_state_machine->O_OBJ[R518]
.if (class.Name == "Section")
	.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${event.Mning}[N]${DLMTR}TRUE")
.else 
	.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${event.Mning}${DLMTR}FALSE")
.end if
				.end if						
			.end if
			.if (evt.local)
				.select many op_evt related by event->E_GSME[R707]->E_GES[R703]->E_ESS[R701]->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_OPB[R698]->O_TFR[R696]
				.if (not_empty op_evt)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${event.Mning}${DLMTR}TRUE")
				.else
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${event.Mning}${DLMTR}FALSE")
				.end if	
			.end if
		.end for
	.end for
.end function
