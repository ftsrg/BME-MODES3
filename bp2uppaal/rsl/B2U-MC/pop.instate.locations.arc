.function populate_insate_locations
.param string JAVA_DIR
.param string DLMTR
.param inst_ref state
.param integer dummyId
.param inst_ref class
.assign attr_dummyId = dummyId
.assign hasInnerStateActions = FALSE
.// Populate operation invocation statements
.select many op_stmts related by state->SM_MOAH[R511]->SM_AH[R513]->SM_ACT[R514]->ACT_SAB[R691]->ACT_ACT[R698]->ACT_BLK[R666]->ACT_SMT[R602]->ACT_TFM[R603]->O_TFR[R673]
	.if (not_empty op_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}${state.Name}${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
.assign hasInnerStateActions = TRUE
		.for each op_stmt in op_stmts
			.assign dummyIdold = dummyId
			.assign dummyId = dummyId + 1
			.assign attr_dummyId = dummyId
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
//.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${op_stmt.Name}[id]!")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${op_stmt.Name}!")
		.end for
	.end if

.// Populate generate statements
.select many gen_stmts related by state->SM_MOAH[R511]->SM_AH[R513]->SM_ACT[R514]->ACT_SAB[R691]->ACT_ACT[R698]->ACT_BLK[R666]->ACT_SMT[R602]->E_ESS[R603]->E_GES[R701]->E_GSME[R703]->SM_EVT[R707]
	.if (not_empty gen_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}${state.Name}${DLMTR}TRUE")
.assign hasInnerStateActions = TRUE
		.if (empty op_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
		.end if
		.for each gen_stmt in gen_stmts
			.select any gen_stmt_target related by gen_stmt->E_GSME[R707]->E_GEN[R705]->V_VAR[R712]
			.assign dummyIdold = dummyId
			.assign dummyId = dummyId + 1
			.assign attr_dummyId = dummyId
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${gen_stmt.Mning}!${DLMTR}${gen_stmt_target.Name}")					 
		.end for
	.end if
	
	
.// Populate interface event/signal statements
.select many p_stmts related by state->SM_MOAH[R511]->SM_AH[R513]->SM_ACT[R514]->ACT_SAB[R691]->ACT_ACT[R698]->ACT_BLK[R666]->ACT_SMT[R602]->ACT_SGN[R603]->SPR_RS[R660]
	.if (not_empty p_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}${state.Name}${DLMTR}TRUE")
.assign hasInnerStateActions = TRUE
	.if (empty gen_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
	.end if
		.for each p_stmt in p_stmts
			.assign dummyIdold = dummyId
			.assign dummyId = dummyId + 1
			.assign attr_dummyId = dummyId
			.select any signal_param related by p_stmt->ACT_SGN[R660]->V_PAR[R662]->V_VAL[R800]->V_AVL[R801]->O_ATTR[R806]
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
			.if (empty signal_param)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${p_stmt.Name}!")					
			.else
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${p_stmt.Name}[${signal_param.Name}]!")					
			.end if
		.end for
	.end if
	
.// Populate interface operation statements
.select many p_op_stmts related by state->SM_MOAH[R511]->SM_AH[R513]->SM_ACT[R514]->ACT_SAB[R691]->ACT_ACT[R698]->ACT_BLK[R666]->ACT_SMT[R602]->ACT_IOP[R603]->SPR_RO[R657]
	.if (not_empty p_op_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}${state.Name}${DLMTR}TRUE")
.assign hasInnerStateActions = TRUE
	.if (empty p_stmts)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
	.end if
		.for each p_op_stmt in p_op_stmts
			.assign dummyIdold = dummyId
			.assign dummyId = dummyId + 1
			.assign attr_dummyId = dummyId
			.select any op_param related by port_stmt->ACT_IOP[R657]->V_PAR[R679]->V_VAL[R800]->V_AVL[R801]->O_ATTR[R806]
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} location ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}TRUE")
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} edge ${class.Name}${DLMTR}dedicated${dummyIdold}${DLMTR}dedicated${dummyId}${DLMTR}${p_op_stmt.Name}[${op_param.Name}]!")					
		.end for
	.end if	

.if (hasInnerStateActions)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} locationtypechange ${class.Name}${DLMTR}dedicated${dummyId}${DLMTR}FALSE")
.end if

.end function
