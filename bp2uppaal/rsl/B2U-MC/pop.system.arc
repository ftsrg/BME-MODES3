.function populate_systemBlock
.param string JAVA_DIR
.invoke systemBlock = GenerateSystemBlock()
${systemBlock.result}
.//invoke SHELL_COMMAND("java -cp ${JAVA_DIR} system system.txt")
.end function
