.function populate_initial_locations
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
				.create object instance init_ref of SM_STATE
				.invoke stateSet = GetStates(instance_state_machine)
				.assign states = stateSet.result
				.for each state in states
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}${state.Name}${DLMTR}FALSE")
					.if (state.Numb == 1)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} initial ${class.Name}${DLMTR}${state.Name}")
					.end if	
				.end for

			.end if	
		.end for
	.end for
.end function


