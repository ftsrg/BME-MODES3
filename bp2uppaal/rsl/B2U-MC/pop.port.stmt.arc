.function populate_port_statements
.param string JAVA_DIR
.param string DLMTR

.// Generate global declarations of interface event/signal statements
.select many p_stmts from instances of SPR_RS
	.for each p_stmt in p_stmts
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${p_stmt.Name}[N]${DLMTR}TRUE")				
	.end for
	
.// Generate global declarations of interface operation statements
.select many p_op_stmts from instances of SPR_RO
	.for each p_op_stmt in p_op_stmts
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} globaldeclaration ${p_op_stmt.Name}${DLMTR}TRUE")					
	.end for	
	
.end function