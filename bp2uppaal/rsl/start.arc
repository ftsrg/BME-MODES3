.assign PATH = "C:\Users\eraikon\WorkspaceSandbox\PhoneX\gen\B2U-MC"
.assign JAVA_DIR = "C:\Users\eraikon\Desktop\BP2UPPAAL.jar"
.assign DELIMITER = "%"
.include "${PATH}\functions.arc"
.include "${PATH}\pop.global.declarations.arc"
.include "${PATH}\pop.templates.arc"
.include "${PATH}\pop.init.locations.arc"
.include "${PATH}\pop.instate.locations.arc"
.include "${PATH}\pop.edges.arc"
.include "${PATH}\pop.system.arc"
.include "${PATH}\pop.op.sm.arc"
.include "${PATH}\pop.port.stmt.arc"
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} nta Test")
.invoke declarations = populate_declarations(JAVA_DIR,DELIMITER)
.invoke templates = populate_templates(JAVA_DIR,DELIMITER)
.invoke SHELL_COMMAND("java -jar ${JAVA_DIR} generate uppaalPhoneX")