package hu.bme.mit.inf.modes3.components.dashboard.main;

import java.io.IOException;
import java.util.Set;

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

import hu.bme.mit.inf.modes3.components.dashboard.comm.SensorsJsonDispatcher;
import hu.bme.mit.inf.modes3.components.dashboard.comm.SensorsMessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;

public class DashboardManager {

	public static final DashboardManager INSTANCE = new DashboardManager();

	private Server server;

	private static SimpleLoggerFactory loggerFactory;
	private static Logger logger;

	private ArgumentRegistry registry;

	private MessagingService trackMessagingService;
	private TrackCommunicationServiceLocator locator;

	private MessagingService sensorsMessagingService;
	private SensorsJsonDispatcher sensorsDispatcher;

	private DashboardManager() {
		server = new Server();
	}

	public static void main(String[] args) {
		loggerFactory = new SimpleLoggerFactory();
		logger = loggerFactory.getLogger(DashboardManager.class.getName());

		INSTANCE.parseArguments(args);

		try {
			INSTANCE.initialize();
			INSTANCE.startJetty();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void initialize() throws IOException {
		Set<String> topics = createTopics(true);
		trackMessagingService = MessagingServiceFactory.createStackForTopics(registry, loggerFactory, topics);
		locator = new TrackCommunicationServiceLocator(trackMessagingService, loggerFactory);

		String sensorsTopic = "/modes3/data";
		sensorsMessagingService = SensorsMessagingServiceFactory.createMQTTStackWithJSON(registry, loggerFactory,
				sensorsTopic);
		sensorsMessagingService.start();
		sensorsDispatcher = (SensorsJsonDispatcher) sensorsMessagingService.getDispatcher();
	}

	public void parseArguments(String[] args) {
		registry = new ArgumentRegistry(loggerFactory);
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<String>("address",
				"The address of the transport server", String.class));
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<Integer>("port",
				"The port used by the transport server", Integer.class));

		registry.parseArguments(args);
	}

	public void startJetty() throws Exception {
		ServerConnector http = new ServerConnector(server, new HttpConnectionFactory());
		http.setPort(8080);
		http.setIdleTimeout(30000);

		server.setConnectors(new Connector[] { http });

		ServletHolder atmosphereServletHolder = new ServletHolder(AtmosphereServlet.class);
		atmosphereServletHolder.setInitParameter(ApplicationConfig.ANNOTATION_PACKAGE,
				"hu.bme.mit.inf.modes3.components.dashboard.service");
		atmosphereServletHolder.setInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
		atmosphereServletHolder.setInitParameter(ApplicationConfig.PROPERTY_COMET_SUPPORT,
				Jetty9AsyncSupportWithWebSocket.class.getName());
		atmosphereServletHolder.setAsyncSupported(true);

		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContextHandler.setContextPath("/");
		servletContextHandler.addServlet(atmosphereServletHolder, "/ws/*");

		ResourceHandler cpr = new ResourceHandler();
		cpr.setBaseResource(Resource.newClassPathResource("/public_html/"));
		cpr.setDirectoriesListed(true);

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { cpr, servletContextHandler });

		server.setHandler(handlers);
		server.setStopAtShutdown(true);
		server.start();
		server.join();
	}

	public SimpleLoggerFactory getLoggerFactory() {
		return loggerFactory;
		
	}

	public TrackCommunicationServiceLocator getLocator() {
		return locator;
	}

	public SensorsJsonDispatcher getSensorsDispatcher() {
		return sensorsDispatcher;
	}

	private Set<String> createTopics(boolean useCVInsteadOfTraditionalOccupancies) {
		if (useCVInsteadOfTraditionalOccupancies) {
			return TopicFactory.createEveryTopicExcept("occupancy", "barrier/gate");
		} else {
			return TopicFactory.createEveryTopicExcept("cv", "barrier/gate");
		}
	}
}
