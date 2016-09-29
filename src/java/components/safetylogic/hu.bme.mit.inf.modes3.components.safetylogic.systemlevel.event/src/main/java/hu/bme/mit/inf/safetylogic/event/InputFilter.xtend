package hu.bme.mit.inf.safetylogic.event

class InputFilter implements IReader {
	var enabled = 0
	var disabled = 0
	val threshold = 10

	val IReader reader

	new(IReader reader) {
		this.reader = reader
	}
	
	override read(boolean isEnabled) {
		if(isEnabled) {
			enabled++
			disabled = 0
		} else {
			disabled++
			enabled = 0
		}

		if(disabled > threshold) {
			reader.read(false)
		} else if(enabled > threshold) {
			reader.read(true)
		}

	}

}
