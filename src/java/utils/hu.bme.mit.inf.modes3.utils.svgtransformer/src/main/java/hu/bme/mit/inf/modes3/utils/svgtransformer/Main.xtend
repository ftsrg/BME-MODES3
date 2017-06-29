package hu.bme.mit.inf.modes3.utils.svgtransformer

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import java.io.IOException
import java.util.Collections
import org.apache.batik.bridge.BridgeContext
import org.apache.batik.bridge.GVTBuilder
import org.apache.batik.bridge.UserAgentAdapter
import org.apache.batik.dom.svg.SAXSVGDocumentFactory
import org.apache.batik.dom.svg.SVGOMPathElement
import org.apache.batik.dom.svg.SVGOMRectElement
import org.apache.batik.util.XMLResourceDescriptor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

class Main {
	
	static val RATIO = 28.34f;
	
	def static void main(String[] args) {
		try {
			val parser = XMLResourceDescriptor.getXMLParserClassName()
			val sax = new SAXSVGDocumentFactory(parser)
			val doc = sax.createSVGDocument(Main.classLoader.getResource("layout-new-2.svg").toString)

			var UserAgentAdapter userAgent = new UserAgentAdapter()
			var GVTBuilder builder = new GVTBuilder()
			var BridgeContext ctx = new BridgeContext(userAgent)
			ctx.setDynamic(true)
			builder.build(ctx, doc)

			// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
			RailRoadModelPackage.eINSTANCE.class
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel",
				new XMIResourceFactoryImpl());

			println(Main.classLoader.getResource("base.railroadmodel").toString)
	
			val ResourceSet resourceSet = new ResourceSetImpl()
			val resource = resourceSet.getResource(
				URI.createURI(Main.classLoader.getResource("base.railroadmodel").toString), true);
			val model = resource.contents.get(0) as RailRoadModel

			val segmentGroup = doc.getElementById("segments")
			for (var i = 0; i < segmentGroup.childNodes.length; i++) {
				val svgElement = segmentGroup.childNodes.item(i);
				if (svgElement instanceof SVGOMPathElement) {
					val path = svgElement as SVGOMPathElement
					val id = Integer.parseInt(path.id.substring(1), 10);
					println(path.id.substring(1));
					println(path.totalLength);
					println("------------------")

					val modelElement = model.sections.findFirst[s|s.id == id] as Segment
					for (var p = 0.0; p <= path.totalLength; p += path.totalLength / 10.0) {
						val svgPoint = svgElement.getPointAtLength(p as float);
						println('''x: «svgPoint.x» y: «svgPoint.y»''')
						val modelPoint = RailRoadModelFactory.eINSTANCE.createPoint => [
							x = svgPoint.x / RATIO
							y = svgPoint.y / RATIO
						]
						modelElement.points += modelPoint
					}
					
					println("++++++++++++++++++")
				}
			}

			val turnoutGroup = doc.getElementById("turnouts")
			for (var i = 0; i < turnoutGroup.childNodes.length; i++) {
				val svgElement = turnoutGroup.childNodes.item(i);
				if (svgElement instanceof SVGOMRectElement) {
					val svgRectangle = svgElement as SVGOMRectElement
					val id = Integer.parseInt(svgRectangle.id.substring(1), 10);
					println(svgRectangle.id.substring(1));

					val modelElement = model.sections.findFirst[s|s.id == id] as Turnout
					modelElement.rectangle = RailRoadModelFactory.eINSTANCE.createRectangle => [
						origin = RailRoadModelFactory.eINSTANCE.createPoint => [
							x = svgRectangle.x.baseVal.value / RATIO
							y = svgRectangle.y.baseVal.value / RATIO
						]
						size = RailRoadModelFactory.eINSTANCE.createDimension => [
							width = svgRectangle.width.baseVal.value / RATIO
							height = svgRectangle.height.baseVal.value / RATIO
						]
					]
				}
			}

			var ResourceSet resSet = new ResourceSetImpl()
			var Resource outResource = resSet.createResource(URI.createURI("instance.railroadmodel"))
			outResource.getContents().add(model)
			try {
				outResource.save(Collections.EMPTY_MAP)
			} catch (IOException e) {
				e.printStackTrace()
			}

		} catch (IOException ex) {
			ex.printStackTrace
		}
	}
}
