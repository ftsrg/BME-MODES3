.function populate_edges
.param string JAVA_DIR
.param string DLMTR
.assign dummyId = 0
.assign N = 3
.assign stateNrIdx = 1
		.select many classes from instances of O_OBJ
			.for each class in classes
.assign hasInnerStateActions = FALSE
.//Selecting all instance state machines from system (State Machine package - Instance State Machine SM_ISM)
.//Checking if instance state machine belongs to the current class.
				.select many instance_state_machines from instances of SM_ISM where (selected.Obj_ID == class.Obj_ID)
				.for each instance_state_machine in instance_state_machines
					.invoke sm = DecideIfStateMachineIsEmpty(instance_state_machine)
					.if (not sm.isEmpty)
						.assign stateNrIdx = 1
						.invoke stateSet = GetStates(instance_state_machine)
						.assign states = stateSet.result
						.assign stateNr = cardinality states
						.while (stateNrIdx <= stateNr)
							.invoke s = GetStateByIdx(instance_state_machine,stateNrIdx)
							.assign state = s.result							
							.//assign reference_state = state.Name
							.invoke locations_entry_actions = populate_insate_locations(JAVA_DIR,DLMTR,state,dummyId,class)
							.assign new_dummyId = locations_entry_actions.dummyId
							.if (not (dummyId == new_dummyId))
							.assign hasInnerStateActions = TRUE
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}${state.Name}${DLMTR}dedicated${dummyId}")
								.//assign reference_state = "dedicated${dummyId}"
							.end if
							.assign dummyId = new_dummyId+1
							.invoke stateTransitionSet = GetStateTransitions(state)
							.assign stateTransitions = stateTransitionSet.result
							.for each stateTransition in stateTransitions
								.invoke stateTransitionAction = GetStateTransitionAction(stateTransition)
								.assign transitionAction = stateTransitionAction.result
								.if (transitionAction.Action_Semantics != "")							
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}TRUE")								
									.select one sourceState related by stateTransition->SM_SEME[R504]->SM_STATE[R503]
									.invoke stateTransitionName = GetStateTransitionName(stateTransition)
									.assign transitionName = stateTransitionName.result
									.invoke sourceStateFunc = GetStateById(instance_state_machine,stateTransition)
									.assign sourceState = sourceStateFunc.result
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}${sourceState.Name}${DLMTR}dummy${dummyId}${DLMTR}${transitionName.Mning}?")				
.// Populate generate statements
									.select many gen_stmts from instances of E_GSME
									.for each gen_stmt in gen_stmts
										.select one stmt related by gen_stmt->E_GES[R703]->E_ESS[R701]->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_TAB[R698]->SM_ACT[R688]->SM_AH[R514]->SM_TAH[R513]->SM_TXN[R530]->SM_NSTXN[R507] where (selected.Trans_ID == stateTransition.Trans_ID)
										.if (not_empty stmt)
											.select one result related by gen_stmt->SM_EVT[R707]
											.select one gen_stmt_target related by gen_stmt->E_GEN[R705]->V_VAR[R712]
											.assign dummyIdold = dummyId
											.assign dummyId = dummyId + 1
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${result.Mning}!${DLMTR}${gen_stmt_target.Name}")					
										.end if			
									.end for

.// Populate operation invocation statements		
									.select many op_stmts from instances of ACT_TFM
									.for each op_stmt in op_stmts
										.select one op related by op_stmt->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_TAB[R698]->SM_ACT[R688]->SM_AH[R514]->SM_TAH[R513]->SM_TXN[R530]->SM_NSTXN[R507] where (selected.Trans_ID == stateTransition.Trans_ID)
										.if (not_empty op)
											.select one result related by op_stmt->O_TFR[R673]
											.assign dummyIdold = dummyId
											.assign dummyId = dummyId + 1
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}FALSE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}TRUE")
//.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${result.Name}[id]!")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${result.Name}!")
										.end if
									.end for
							
.// Populate interface event/signal statements
									.select many port_stmts from instances of ACT_SGN
									.for each port_stmt in port_stmts
										.select one p_stmt related by port_stmt->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_TAB[R698]->SM_ACT[R688]->SM_AH[R514]->SM_TAH[R513]->SM_TXN[R530]->SM_NSTXN[R507] where (selected.Trans_ID == stateTransition.Trans_ID)
										.if (not_empty p_stmt)
											.select one signal_name related by port_stmt->SPR_RS[R660]
											.select any signal_param related by port_stmt->V_PAR[R662]->V_VAL[R800]->V_AVL[R801]->O_ATTR[R806]
											.assign dummyIdold = dummyId
											.assign dummyId = dummyId + 1
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}TRUE")
											.if (empty signal_param)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${signal_name.Name}!")					
											.else
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${signal_name.Name}[${signal_param.Name}]!")
											.end if
										.end if			
									.end for

.// Populate interface operation statements
									.select many port_op_stmts from instances of ACT_IOP
									.for each port_op_stmt in port_op_stmts
										.select one p_stmt related by port_op_stmt->ACT_SMT[R603]->ACT_BLK[R602]->ACT_ACT[R601]->ACT_TAB[R698]->SM_ACT[R688]->SM_AH[R514]->SM_TAH[R513]->SM_TXN[R530]->SM_NSTXN[R507] where (selected.Trans_ID == stateTransition.Trans_ID)
										.if (not_empty p_stmt)
											.select one op_name related by port_op_stmt->SPR_RO[R657]
											.select one op_param related by port_stmt->V_PAR[R679]->V_VAL[R800]->V_AVL[R801]->O_ATTR[R806]
											.assign dummyIdold = dummyId
											.assign dummyId = dummyId + 1
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyIdold}${DLMTR}dummy${dummyId}${DLMTR}${op_name.Name}[${op_param.Name}]!")					
										.end if										
									.end for

.// Connects last dummy state to target state.																																		
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dummy${dummyId}${DLMTR}${state.Name}")										
									.assign dummyId = dummyId + 1
									
								.else 
.// If transition action is empty
									.select one sourceState related by stateTransition->SM_SEME[R504]->SM_STATE[R503]
									.invoke stateTransitionName = GetStateTransitionName(stateTransition)
									.assign transitionName = stateTransitionName.result
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}${sourceState.Name}${DLMTR}${state.Name}${DLMTR}${transitionName.Mning}?")
								.end if
							.end for
						.assign stateNrIdx = stateNrIdx + 1
						.end while
					.end if	
				.end for
// Connect last state (FINAL state) back to START with edge synchronization Initialized[id]!)

				.if (hasInnerStateActions)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} rearrangelocations ${class.Name}")
//.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} completemodel ${class.Name}")
				.end if
			.end for
.end function

