package hu.bme.mit.inf.master.mqtt.client.handlers;

import java.io.IOException;

import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ChronicleQueueBuilder;
import net.openhft.chronicle.ExcerptAppender;
import net.openhft.chronicle.ExcerptTailer;

public abstract class Handler {
	ExcerptAppender appender;
	ExcerptTailer reader;
	
	Handler(String handlerName) throws IOException {
		String basePath = System.getProperty("java.io.tmpdir") + handlerName;
		Chronicle chronicle = ChronicleQueueBuilder.indexed(basePath).build();
		
		appender = chronicle.createAppender();
		reader = chronicle.createTailer();
	} 
	
	public void handleWithoutResponse(String content) {
		appender.startExcerpt(content.getBytes().length);
		appender.write(content.getBytes());
		appender.finish();
	}

	public String handleWithResponse(String content) {
		handleWithoutResponse(content);
		
		while(!reader.nextIndex());
		return reader.asString().toString();
	}
}
