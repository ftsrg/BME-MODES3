# BP2UPPAAL

This is the source code of the [BridgePoint](http://xtuml.org) to [UPPAAL](http://uppaal.org) transformation which was designed for the publication presented at the Scientific Student's Conference at Budapest, 2014. The BridgePoint models are as at the end of year 2014.

-------------------------------------------------------------------

In order to run the BP-TO-UPPAAL transformation, do the following steps:

1. Import BridgePoint model from `model` folder.
2. After import locate the `rsl` folder and copy the contents of it to the `ControlSectionV5/gen/` folder.
3. Open the `start.arc` file from `ControlSectionV5/gen/B2U-MC/` with any text editor and change the first 2 rows:

	**PATH** = the full path of the project with `ControlSectionV5/gen/B2U-MC/` ending.
	
	**JAVA_DIR** = the full path of the `BP2UPPAAL.jar` file from `emfpopulator` folder.
	
4. Build the imported BridgePoint project.
5. The generated UPPAAL file will be saved under directory `C:\Users\%USER_NAME%\`
