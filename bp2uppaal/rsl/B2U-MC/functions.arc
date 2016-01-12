.function find_first_statement
.param inst_ref p_mm_block_inst
	.select any mm_stmt_inst related by p_mm_block_inst->TE_BLK[R2016]->TE_SMT[R2014]
	.select one mm_prev_stmt_inst related by mm_stmt_inst->TE_SMT[R2012.'succeeds']
	.while(not_empty mm_prev_stmt_inst)
		.assign mm_stmt_inst = mm_prev_stmt_inst
		.select one mm_prev_stmt_inst related by mm_stmt_inst->TE_SMT[R2012.'succeeds']
	.end while
	.assign attr_result = mm_prev_stmt_inst
.end function
.//============================================================================
.function DecideIfStateMachineIsEmpty
.param inst_ref instance_sm_inst
.assign attr_isEmpty = FALSE
	.select many states related by instance_sm_inst->SM_SM[R517]->SM_STATE[R501]
	.if (empty states)
		.assign attr_isEmpty = TRUE
	.end if
.end function
.//============================================================================
.function GetAllEvents
.param inst_ref instance_sm_inst
	.select many events related by instance_sm_inst->SM_SM[R517]->SM_EVT[R502]
	.assign attr_result = events
.end function
.//============================================================================
.function findNonPolymorphicEvent
.param inst_ref instance_sm_inst
.param inst_ref event_inst
.assign attr_local = FALSE
.assign attr_declared = FALSE
	.select many evtLocal related by instance_sm_inst->SM_SM[R517]->SM_EVT[R502]->SM_SEVT[R525]->SM_LEVT[R526] where (selected.SMevt_ID == event_inst.SMevt_ID)
	.assign nrLocal = cardinality evtLocal
	.select many evtDeclared related by instance_sm_inst->SM_SM[R517]->SM_EVT[R502]->SM_SEVT[R525] where (selected.SMevt_ID == event_inst.SMevt_ID)
	.assign nrDeclared = cardinality evtDeclared
	.if (nrLocal > 0)
	.assign attr_local = TRUE
	.end if
	.if (nrDeclared > 0)
	.assign attr_declared = TRUE
	.end if
.end function
.//============================================================================
.function GetStateByIdx
.param inst_ref instance_sm_inst
.param integer idx
	.select any state related by instance_sm_inst->SM_SM[R517]->SM_STATE[R501] where (selected.Numb == idx)
	.assign attr_result = state
.end function
.//============================================================================
.function GetStateById
.param inst_ref instance_sm_inst
.param inst_ref stateTransition_inst
	.select any state related by instance_sm_inst->SM_SM[R517]->SM_STATE[R501] where (selected.SMstt_ID == stateTransition_inst.SMstt_ID)
	.assign attr_result = state
.end function
.//============================================================================
.function GetStates
.param inst_ref instance_sm_inst
	.select many states related by instance_sm_inst->SM_SM[R517]->SM_STATE[R501]
	.assign attr_result = states
.end function
.//============================================================================
.function GetStateTransitions
.param inst_ref state_inst
.//Navigate across associations from state to outgoing transitions target state (through New State Transition ->State Event Matrix Entry)
	.select many transitions related by state_inst->SM_TXN[R506]->SM_NSTXN[R507]
	.assign attr_result = transitions
.end function
.//============================================================================
.function GetStateTransitionName
.param inst_ref state_transition_inst
	.select one name related by state_transition_inst->SM_SEME[R504]->SM_SEVT[R503]->SM_EVT[R525]
	.assign attr_result = name
.end function
.//============================================================================
.function GetStateTransitionAction
.param inst_ref state_transition_inst
	.select one action related by state_transition_inst->SM_TXN[R507]->SM_TAH[R530]->SM_AH[R513]->SM_ACT[R514]
	.assign attr_result = action
.end function
.//============================================================================
.function GetClassNumberWithStates
.assign count = -1
.select many classes from instances of O_OBJ
.for each class in classes
.select many instance_state_machines from instances of SM_ISM where (selected.Obj_ID == class.Obj_ID)
	.for each instance_state_machine in instance_state_machines
.//Checking if instance state machine belongs to the current class.
.//If it does, navigate through the generalization of the instance state machine to the super SM_SM State Machine					
			.invoke stateSet = GetStates(instance_state_machine)
.//If it contains states create the UPPAAL location declaration					
			.if (not_empty stateSet.result)
				.assign count = count + 1
			.end if
	.end for
.end for
.assign attr_result = count
.end function
.//============================================================================
.function GenerateSystemBlock
.assign attr_result = ""
.select many classes from instances of O_OBJ
.for each class in classes
	.select many instance_state_machines from instances of SM_ISM where (selected.Obj_ID == class.Obj_ID)
	.for each instance_state_machine in instance_state_machines
.//If it does, navigate through the generalization of the instance state machine to the super SM_SM State Machine					
		.invoke stateSet = GetStates(instance_state_machine)
.//If it contains states create the UPPAAL location declaration					
			.if (not_empty stateSet.result)
				.assign attr_result = attr_result + "${class.Name}"
				.assign attr_result = attr_result + "\n"
			.end if
	.end for
.end for
.end function