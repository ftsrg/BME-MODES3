.function populate_operation_statemachines
.param string JAVA_DIR
.param string DLMTR
	.select many op_calls from instances of O_TFR
	.for each op_call in op_calls
.//MessageID should be reset in every cycle
.//MessageID 0 == div
.//MessageID 1 == str
.//MessageID 2 == top
		.assign messageID = 0
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${op_call.Name}[N]${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} template ${op_call.Name}")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} localdeclaration ${op_call.Name}${DLMTR}f=0")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${op_call.Name}${DLMTR}Init${DLMTR}FALSE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} initial ${op_call.Name}${DLMTR}Init")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${op_call.Name}${DLMTR}Send${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${op_call.Name}${DLMTR}Init${DLMTR}Send${DLMTR}${op_call.Name}[e]?${DLMTR}${DLMTR}e:int[0,2]${DLMTR}${DLMTR}f=e")

	.select many op_stmts from instances of ACT_SMT
	.for each op_stmt in op_stmts
		.select one op related by op_stmt->ACT_BLK[R602]->ACT_ACT[R601]->ACT_OPB[R698]->O_TFR[R696] where (selected.Tfr_ID == op_call.Tfr_ID)
		.if (not_empty op)
			.select one gen_stmt related by op_stmt->E_ESS[R603]->E_GES[R701]->E_GSME[R703]->SM_EVT[R707]
			.if (not_empty gen_stmt)
				.select one gen_stmt_target related by op_stmt->E_ESS[R603]->E_GES[R701]->E_GSME[R703]->E_GEN[R705]->V_VAR[R712]
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${op_call.Name}${DLMTR}Send${DLMTR}Init${DLMTR}${gen_stmt.Mning}!${DLMTR}${gen_stmt_target.Name}${DLMTR}${DLMTR}f==${messageID}")
				.assign messageID = messageID + 1
			.end if
		.end if 
	.end for
.end for
.end function