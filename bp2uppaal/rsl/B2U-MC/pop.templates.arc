.function populate_templates
.param string JAVA_DIR
.param string DLMTR
.//Selecting classes (Subsystem package - Model Class O_OBJ)
.select many classes from instances of O_OBJ
	.for each class in classes
.//Selecting all instance state machines from system (State Machine package - Instance State Machine SM_ISM)
.//Checking if instance state machine belongs to the current class.
		.select many instance_state_machines from instances of SM_ISM where (selected.Obj_ID == class.Obj_ID)
			.for each instance_state_machine in instance_state_machines
				.invoke sm = DecideIfStateMachineIsEmpty(instance_state_machine)
				.if (not sm.isEmpty)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} template ${class.Name}")
				.end if
			.end for
	.end for
//.invoke op_sm = populate_operation_statemachines(JAVA_DIR,DLMTR)
.invoke port_stmt = populate_port_statements(JAVA_DIR,DLMTR)
.invoke locations = populate_initial_locations(JAVA_DIR,DLMTR)
.invoke edges = populate_edges(JAVA_DIR,DLMTR)
.end function