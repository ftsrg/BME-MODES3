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

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptorWithParameter;
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;

public class DashboardManager {

    private Server server;

    private static SimpleLoggerFactory loggerFactory;
    private static Logger logger;

    private ArgumentRegistry registry;

    private MessagingService messagingService;

    private TrackCommunicationServiceLocator locator;

    public static final DashboardManager INSTANCE = new DashboardManager();

    private DashboardManager() {
        server = new Server();
    }

    public static void main(String[] args) {
        loggerFactory = new SimpleLoggerFactory();
        logger = loggerFactory.getLogger(DashboardManager.class.getName());

        INSTANCE.parseArguments(args);

        INSTANCE.initialize();

        try {
            INSTANCE.startJetty();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void initialize() {
        messagingService = MessagingServiceFactory.createMQTTStack(registry, loggerFactory);
        locator = new TrackCommunicationServiceLocator(messagingService, loggerFactory);
    }

    public void parseArguments(String[] args) {
        registry = new ArgumentRegistry(loggerFactory);
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<String>("config", "The configuration used", String.class));
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<String>("id", "The ID of the component", String.class));
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<String>("address", "The address of the transport server", String.class));
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter<Integer>("port", "The oprt used by the transport server", Integer.class));
        
        registry.parseArguments(args);
    }

    public void startJetty() throws Exception {
        ServerConnector http = new ServerConnector(server, new HttpConnectionFactory());
        http.setPort(7070);
        http.setIdleTimeout(30000);

        server.setConnectors(new Connector[]{http});

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
        cpr.setDirectoriesListed(true);

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{cpr, servletContextHandler});

        server.setHandler(handlers);
        server.setStopAtShutdown(true);
        server.start();
        server.join();
    }

    public MessagingService getMessagingService() {
        return messagingService;
    }

    public SimpleLoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public Logger getLogger() {
        return logger;
    }

    public TrackCommunicationServiceLocator getLocator() {
        return locator;
    }
}
