package hu.bme.mit.inf.modes3.components.dashboard.main;

import org.atmosphere.container.Jetty9AsyncSupportWithWebSocket;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereServlet;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.impl.SimpleLoggerFactory;

public class Main {
	
	private Server server;
	
	private static Logger logger;
	
	public Main() {
		server = new Server();
	}
	
	public static void main(String[] args) {
		SimpleLoggerFactory loggerFactory = new SimpleLoggerFactory();
		logger = loggerFactory.getLogger(Main.class.getName());
		
		Main server = new Main();
		try {
			server.start();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void start() throws Exception {
		ServerConnector http = new ServerConnector(server, new HttpConnectionFactory());
		http.setPort(80);
		http.setIdleTimeout(30000);

		server.setConnectors(new Connector[] { http });
		
		ServletHolder atmosphereServletHolder = new ServletHolder(AtmosphereServlet.class);
		atmosphereServletHolder.setInitParameter(ApplicationConfig.ANNOTATION_PACKAGE, "hu.bme.mit.inf.modes3.components.dashboard.service");
		atmosphereServletHolder.setInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
		atmosphereServletHolder.setInitParameter(ApplicationConfig.PROPERTY_COMET_SUPPORT, Jetty9AsyncSupportWithWebSocket.class.getName());

		atmosphereServletHolder.setAsyncSupported(true);
		
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContextHandler.setContextPath("/");
		
		servletContextHandler.addServlet(atmosphereServletHolder, "/ws/*");
		
		ResourceHandler cpr = new ResourceHandler();
		cpr.setBaseResource(Resource.newClassPathResource("/public_html/"));
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { cpr, servletContextHandler });

		server.setHandler(handlers);
		server.setStopAtShutdown(true);
		server.start();
		server.join();
	}
	
}
