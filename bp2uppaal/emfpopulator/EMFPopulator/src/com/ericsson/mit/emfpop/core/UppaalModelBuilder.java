package com.ericsson.mit.emfpop.core;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.mit.emfpop.util.Util;

import de.uni_paderborn.uppaal.NTA;
import de.uni_paderborn.uppaal.UppaalFactory;
import de.uni_paderborn.uppaal.UppaalPackage;
import de.uni_paderborn.uppaal.declarations.ChannelVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.DataVariableDeclaration;
import de.uni_paderborn.uppaal.declarations.Declaration;
import de.uni_paderborn.uppaal.declarations.Parameter;
import de.uni_paderborn.uppaal.declarations.impl.DeclarationsFactoryImpl;
import de.uni_paderborn.uppaal.expressions.Expression;
import de.uni_paderborn.uppaal.expressions.IdentifierExpression;
import de.uni_paderborn.uppaal.expressions.impl.ExpressionsFactoryImpl;
import de.uni_paderborn.uppaal.templates.Edge;
import de.uni_paderborn.uppaal.templates.Location;
import de.uni_paderborn.uppaal.templates.LocationKind;
import de.uni_paderborn.uppaal.templates.Selection;
import de.uni_paderborn.uppaal.templates.Synchronization;
import de.uni_paderborn.uppaal.templates.SynchronizationKind;
import de.uni_paderborn.uppaal.templates.Template;
import de.uni_paderborn.uppaal.templates.impl.TemplatesFactoryImpl;

public class UppaalModelBuilder {

	private static UppaalModelBuilder instance = null;

	private NTA nta = UppaalFactory.eINSTANCE.createNTA();

	private List<Template> templates = new ArrayList<>();
	private List<Location> locations = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();

	protected UppaalModelBuilder() {
	}

	public static UppaalModelBuilder getInstance() {
		if (instance == null) {
			instance = new UppaalModelBuilder();
		}
		return instance;
	}

	/**
	 * Getter method for NTA
	 * 
	 */
	public NTA getNTA() {
		return nta;
	}

	/**
	 * Setter method for NTA
	 * 
	 * @param name
	 */
	public NTA setNTA(NTA nta) {
		return this.nta = nta;
	}

	/**
	 * NTA - nta name
	 * 
	 * @param name
	 */
	public void createNTA(final String name) {
		UppaalPackage.eINSTANCE.eClass();
		nta.setName(name);
		nta.setGlobalDeclarations(new DeclarationsFactoryImpl()
				.createGlobalDeclarations());
	}

	/**
	 * G_DECLARATION - globaldeclaration expression%broadcast (TRUE|FALSE)
	 * 
	 * @param arguments
	 */
	public void addGlobalDeclaration(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		String expression = arg[0];
		final String broadcast = arg[1];

		// If synchronization is named Initialized(?|!), replace it with
		// Initialized[id](?|!)
		if (expression.toLowerCase().startsWith(Util.INITIALIZED)) {
			expression = arg[0] + "[N]";
		}

		ChannelVariableDeclaration declaration = new DeclarationsFactoryImpl()
				.createChannelVariableDeclaration();
		// declaration.setBroadcast(broadcast);
		declaration.setExp(broadcast + expression.trim());
		nta.getGlobalDeclarations().getDeclaration().add(declaration);
	}

	/**
	 * L_DECLARATION - localdeclaration templateName%expression
	 * 
	 * @param arguments
	 *            - templateName,expression
	 */
	public void addLocalDeclaration(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		final String expression = arg[1];

		Template temp = (Template) findElement(Util.TEMPLATE, templateName);
		templates.remove(temp);
		Declaration declaration = new DeclarationsFactoryImpl()
				.createDataVariableDeclaration();
		declaration.setExp(expression);
		temp.getDeclarations().getDeclaration().add(declaration);
		templates.add(temp);
	}

	/**
	 * SYSTEM - system template1%template2%..
	 * 
	 * @param arguments
	 */
	public void createSystem(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}
		// if (arguments.isEmpty()) {
		// SystemDeclarations systemDeclaration = new
		// DeclarationsFactoryImpl().createSystemDeclarations();
		// de.uni_paderborn.uppaal.declarations.system.System system = new
		// SystemFactoryImpl().createSystem();
		// InstantiationList instance = new
		// SystemFactoryImpl().createInstantiationList();
		// instance.getTemplate().addAll(templates);
		// system.getInstantiationList().add(instance);
		// systemDeclaration.setSystem(system);
		// nta.setSystemDeclarations(systemDeclaration);
		// }
	}

	/**
	 * TEMPLATE - template name%parameter
	 * 
	 * @param arguments
	 */
	public void createTemplate(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		String param = "";
		if (arg.length > 1) {
			param = arg[1];
		} else {
			param = "id";
		}

		Template template = new TemplatesFactoryImpl().createTemplate();
		template.setName(templateName);
		template.setDeclarations(new DeclarationsFactoryImpl()
				.createLocalDeclarations());
		Parameter parameter = new DeclarationsFactoryImpl().createParameter();
		DataVariableDeclaration variable = new DeclarationsFactoryImpl()
				.createDataVariableDeclaration();
		variable.setExp(param);
		parameter.setVariableDeclaration(variable);
		template.getParameter().add(parameter);
		templates.add(template);
	}

	/**
	 * LOCATION - location templateName%name%true|false
	 * 
	 * @param arguments
	 */
	public void createLocation(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		final String name = arg[1];
		final boolean committed = Boolean.parseBoolean(arg[2]);

		Location location = new TemplatesFactoryImpl().createLocation();
		if (name.isEmpty()) {
			location.setName("id_" + this.locations.size());
		}
		location.setName(name);
		location.setParentTemplate((Template) findElement(Util.TEMPLATE,
				templateName));
		if (committed) {
			location.setLocationTimeKind(LocationKind.COMMITED);
		}
		this.locations.add(location);
	}

	/**
	 * LOCATION TYPE CHANGE - locationtypechange templateName%name%true|false
	 * 
	 * @param arguments
	 */
	public void changeLocationType(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		final String name = arg[1];
		final boolean committed = Boolean.parseBoolean(arg[2]);

		for (Location location : ((Template) findElement(Util.TEMPLATE,
				templateName)).getLocation()) {
			if (location.getName().contentEquals(name)) {
				if (committed) {
					location.setLocationTimeKind(LocationKind.COMMITED);
				} else {
					location.setLocationTimeKind(LocationKind.NORMAL);
				}
			}
		}
	}

	/**
	 * INITIAL LOCATION- initial templateName%name
	 * 
	 * @param arguments
	 */
	public void setInitialLocation(String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}
		for (Template template : templates) {
			for (Location location : template.getLocation()) {
				this.locations.add(location);
			}
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		final String name = arg[1];

		Template template = (Template) findElement(Util.TEMPLATE, templateName);
		template.setInit((Location) findElement(Util.LOCATION, name, template));
	}

	/**
	 * REARRANGE TEMPLATE LOCATIONS - rearrangelocations templateName
	 * 
	 * @param arguments
	 *            0-templateName
	 */
	public void rearrangeTemplateLocations(String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();

		Template template_ = (Template) findElement(Util.TEMPLATE, templateName);
		List<Location> locations_ = template_.getLocation();

		// Location initLocation = null;
		for (Location initLocation : locations_) {
			List<Location> dedicatedLocations = new ArrayList<>();
			if (!initLocation.getName().startsWith(Util.DEDICATED)
					/*&& !template_.getInit().equals(initLocation)*/) {
				for (Edge edge : getOutgoingEdges(template_, initLocation)) {
					if (edge.getTarget().getName().startsWith(Util.DEDICATED)) {
						dedicatedLocations.add(edge.getTarget());
						Location targetLocation = dedicatedLocations.get(0);
						List<Edge> outgoingEdges = getOutgoingEdges(template_,
								targetLocation);
						while (!outgoingEdges.isEmpty()
								&& outgoingEdges.get(0).getTarget().getName()
										.startsWith(Util.DEDICATED)) {
							Location newLocation = outgoingEdges.get(0)
									.getTarget();
							dedicatedLocations.add(newLocation);
							outgoingEdges = getOutgoingEdges(template_,
									newLocation);
						}
						break;
					}

				}
			}
			if (!dedicatedLocations.isEmpty()) {
				Location min = dedicatedLocations.get(0);
				Location max = dedicatedLocations
						.get(dedicatedLocations.size() - 1);

				List<Edge> fromInit = new ArrayList<>();
				List<Edge> toInit = new ArrayList<>();
				List<Edge> hooks = new ArrayList<>();

				for (Edge edge : template_.getEdge()) {
					if (edge.getSource() == initLocation
							&& edge.getTarget() == initLocation) {
						hooks.add(edge);
					} else if (edge.getSource() == initLocation) {
						fromInit.add(edge);
					} else if (edge.getTarget() == initLocation) {
						toInit.add(edge);
					}
				}

				for (Edge edge : fromInit) {
					// System.out.println("FromInit");
					// System.out.println("Source: " +
					// edge.getSource().getName());
					// System.out.println("Target: " +
					// edge.getTarget().getName());
					if (!dedicatedLocations.contains((Location) edge
							.getTarget())) {
						edge.setSource(max);
						edge.setTarget(edge.getTarget());
					}
				}

				for (Edge edge : toInit) {
					// System.out.println("ToInit");
					// System.out.println("Source: " +
					// edge.getSource().getName());
					// System.out.println("Target: " +
					// edge.getTarget().getName());
					// edge.setSource(edge.getSource());
					// edge.setTarget(min);
					// template_.getEdge().remove(edge);
					// template_.getEdge().add(temp);
				}

				for (Edge edge : hooks) {
					// System.out.println("Hooks");
					// System.out.println("Source: " +
					// edge.getSource().getName());
					// System.out.println("Target: " +
					// edge.getTarget().getName());
					edge.setSource(max);
					edge.setTarget(max);
				}

			}
		}

	}

	/**
	 * EDGE - transition
	 * templateName%source%target%labelSynchronization%labetSyncTarget
	 * %labelSelect %labelGuard%labelUpdate
	 * 
	 * @param arguments
	 *            0-templateName 1-source 2-target 3-labelSynchronization
	 *            4-labelSynchronizationTarget 5-labelSelect 6-labelGuard
	 *            7-labelUpdate
	 */
	public void createEdge(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}
		for (Template template : templates) {
			for (Location location : template.getLocation()) {
				this.locations.add(location);
			}
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();
		final String source = arg[1];
		final String target = arg[2];
		Util.Section labelSyncTarget;

		Edge edge = new TemplatesFactoryImpl().createEdge();
		Template template = (Template) findElement(Util.TEMPLATE, templateName);
		edge.setParentTemplate(template);
		edge = setEdgeSource(edge,
				(Location) findElement(Util.LOCATION, source, template));
		edge = setEdgeTarget(edge,
				(Location) findElement(Util.LOCATION, target, template));

		// Creates the Selection statement for edge. The Selections variable
		// type and boundary values and finally the variable name.
		if (arg.length - 1 > 2) {
			String labelSync = arg[3];
			// If synchronization is named Initialized(?|!), replace it with
			// Initialized[id](?|!)
			if (labelSync.toLowerCase().startsWith(Util.INITIALIZED)) {
				labelSync = arg[3].substring(0, arg[3].length() - 1)
						+ "[id]"
						+ arg[3].substring(arg[3].length() - 1, arg[3].length());
			}

			// If edge sync is part of Section, then the channel must be changed
			// to array type sync
			for (Declaration declaration : nta.getGlobalDeclarations()
					.getDeclaration()) {
				if (declaration.getExp().endsWith("[N]"))
					if (declaration.getExp().startsWith(
							"TRUE"
									+ labelSync.substring(0,
											arg[3].length() - 1))) {
						labelSync = arg[3].substring(0, arg[3].length() - 1)
								+ "[id]"
								+ arg[3].substring(arg[3].length() - 1,
										arg[3].length());
					}
			}

			// If sync is from a function call then check the ending
			// (DIV|STR|TOP) and
			// make it an array
			if (labelSync.toUpperCase().contains("From"+Util.Section.DIV.toString())
					|| labelSync.toUpperCase().contains("From"+
							Util.Section.STR.toString())
					|| labelSync.toUpperCase().contains("From"+
							Util.Section.TOP.toString())) {	
				labelSyncTarget = Util.Section.valueOf(labelSync.toUpperCase().substring(labelSync.length()-1-3,labelSync.length()-1));
				arg[3] = arg[3].substring(0,arg[3].length()-1-7)+ arg[3].substring(arg[3].length()-1,arg[3].length());
				labelSync = arg[3].substring(0, arg[3].length() - 1)
						+ "["
						+ labelSyncTarget.toString()
						+ "]"
						+ arg[3].substring(arg[3].length() - 1,
								arg[3].length());
			}
			
			if (arg.length - 1 > 3) {
				// If labelSynchronizationTarget is DIV|STR|TOP, make array
				// sync.
				if (arg[4].toUpperCase().contentEquals(
						Util.Section.DIV.toString())
						|| arg[4].toUpperCase().contentEquals(
								Util.Section.STR.toString())
						|| arg[4].toUpperCase().contentEquals(
								Util.Section.TOP.toString())) {
					labelSyncTarget = Util.Section.valueOf(arg[4]
							.toUpperCase().substring(0, 3));

					Declaration declaration = new DeclarationsFactoryImpl()
							.createDataVariableDeclaration();
					declaration.setExp(labelSyncTarget.toString() + "="
							+ labelSyncTarget.getValue());

					// Add local declaration to template if does not exist
					boolean containsDeclaration = false;
					for (Declaration tempDeclaration : edge.getParentTemplate()
							.getDeclarations().getDeclaration()) {
						if (tempDeclaration.getExp().contentEquals(
								declaration.getExp())) {
							containsDeclaration = true;
							break;
						}
					}
					if (!containsDeclaration) {
						edge.getParentTemplate().getDeclarations()
								.getDeclaration().add(declaration);
					}

					// Change global declaration of channel to array channel
					for (Declaration tempDeclaration : nta
							.getGlobalDeclarations().getDeclaration()) {
						if (tempDeclaration.getExp().endsWith(
								labelSync.substring(0, labelSync.length() - 1))) {
							tempDeclaration.setExp(tempDeclaration.getExp()
									+ "[N]");
						}
					}
					labelSync = arg[3].substring(0, arg[3].length() - 1)
							+ "["
							+ labelSyncTarget.toString()
							+ "]"
							+ arg[3].substring(arg[3].length() - 1,
									arg[3].length());
				}
			}
			Synchronization channel = new TemplatesFactoryImpl()
					.createSynchronization();
			if (labelSync.endsWith("?")) {
				channel.setKind(SynchronizationKind.RECEIVE);
			} else if (labelSync.endsWith("!")) {
				channel.setKind(SynchronizationKind.SEND);
			}
			IdentifierExpression expression = new ExpressionsFactoryImpl()
					.createIdentifierExpression();
			expression.setExp(labelSync);
			channel.setChannelExpression(expression);
			edge.setSynchronization(channel);
		}

		if (arg.length - 1 > 4) {
			final String labelSelection = arg[5];
			Selection selection = new TemplatesFactoryImpl().createSelection();
			selection.setSelectStatement(labelSelection);
			edge.getSelection().add(selection);
		}

		if (arg.length - 1 > 5) {
			final String labelGuard = arg[6];
			Expression expression = new ExpressionsFactoryImpl()
					.createIdentifierExpression();
			expression.setExp(labelGuard);
			edge.setGuard(expression);
		}

		if (arg.length - 1 > 6) {

			String labelUpdate = arg[7];
			if (labelUpdate.toUpperCase().endsWith(Util.Section.DIV.toString())
					|| labelUpdate.toUpperCase().contains(
							Util.Section.STR.toString())
					|| labelUpdate.toUpperCase().contains(
							Util.Section.TOP.toString())) {
				labelUpdate = arg[7].substring(0, arg[7].length() - 3)
						+ Util.Section.valueOf(
								arg[7].toUpperCase().substring(
										arg[7].length() - 3, arg[7].length()))
								.getValue();
			}
			Expression expression = new ExpressionsFactoryImpl()
					.createIdentifierExpression();
			expression.setExp(labelUpdate);
			edge.getUpdate().add(expression);
		}

		this.edges.add(edge);

	}

	public Edge setEdgeSource(Edge edge, Location source) {
		if (source != null) {
			edge.setSource(source);
		}
		return edge;
	}

	public Edge setEdgeTarget(Edge edge, Location target) {
		if (target != null) {
			edge.setTarget(target);
		}
		return edge;
	}

	/**
	 * Connect Final node to Start node - completemodel templateName
	 * 
	 * @param arguments
	 *            0-templateName
	 */
	public void completeModel(final String arguments) {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		if (templates.isEmpty()) {
			templates.addAll(nta.getTemplate());
		}

		String[] arg = arguments.split(Util.DELIMITER);
		final String templateName = arg[0].toUpperCase();

		Template template = (Template) findElement(Util.TEMPLATE, templateName);
		for (Location location : template.getLocation()) {
			if (getOutgoingEdges(template, location).isEmpty()) {
				Edge edge = getIncomingEdges(template, location).get(0);
				edge.setTarget(template.getInit());
				template.getLocation().remove(location);
				break;
			}
		}

	}

	public void buildModel() {
		for (Template template : templates) {
			for (Location location : locations) {
				if (location.getParentTemplate().equals(template)) {
					template.getLocation().add(location);
				}
			}
			for (Edge edge : edges) {
				if (edge.getParentTemplate().equals(template)) {
					template.getEdge().add(edge);
				}
			}
			nta.getTemplate().add(template);
		}
	}

	public void printAll() {
		nta = UppaalModelSaver.loadResource(Util.inputFileName,
				Util.fileExtension);
		System.out.println("NTA: " + nta.getName());
		for (Declaration declaration : nta.getGlobalDeclarations()
				.getDeclaration()) {
			System.out.println("NTA declaration: " + declaration.getExp());
		}
		for (Template template : nta.getTemplate()) {
			System.out.println("Template: " + template.getName());
			if (template.getInit() != null)
			System.out.println("Template initial location: "
					+ template.getInit().getName());
			for (Location location : template.getLocation()) {
				System.out.println("Location: " + location.getName() + " "
						+ location.getLocationTimeKind());
			}
			for (Edge edge : template.getEdge()) {
				if (edge.getSource() != null && edge.getTarget() != null)
				System.out.println("Edge: " + edge.getSource().getName() + " "
						+ edge.getTarget().getName() + " "
				// + edge.getSelection().get(0).getSelectStatement()
				// + edge.getSynchronization().getChannelExpression()
				// .getExp()
						);
			}
		}

	}

	private Object findElement(String type, String name) {
		switch (type) {
		case Util.TEMPLATE: {
			for (Template template : templates) {
				if (template.getName().contentEquals(name.toUpperCase())) {
					return template;
				}
			}
		}
		}
		return new Object();
	}

	private Object findElement(String type, String name, Template template) {
		switch (type) {
		case Util.LOCATION: {
			for (Location location : template.getLocation()) {
				if (location.getName().contentEquals(name)) {
					return location;
				}
			}
		}
		}
		return new Object();
	}

	private List<Edge> getOutgoingEdges(Template template, Location location) {

		List<Edge> edges = new ArrayList<>();
		for (Edge edge : template.getEdge()) {
			if (edge.getSource() == location) {
				edges.add(edge);
			}
		}
		return edges;
	}

	private List<Edge> getIncomingEdges(Template template, Location location) {

		List<Edge> edges = new ArrayList<>();
		for (Edge edge : template.getEdge()) {
			if (edge.getTarget() == location) {
				edges.add(edge);
			}
		}
		return edges;
	}

}
