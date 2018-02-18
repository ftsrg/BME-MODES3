package hu.bme.mit.inf.modes3.components.occupancyquery

// FIXME reimplement this test with the new transport

public class SegmentOccupancyQueryComponentTest {
//	var SectionOccupancyQueryComponent uut
//
//	@Before
//	def void before() {
//		uut = new SectionOccupancyQueryComponent(CommunicationStackFactory::createLocalStack, new TestUARTReader, new NOPLoggerFactory)
//	}
//
//	@Test
//	def void segmentOccupancyQueryComponentTest() {
//		val map = new HashMap<Integer, SegmentOccupancy>
//		new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, new NOPLoggerFactory) => [
//			trackElementStateRegistry.segmentOccupancyChangeListener = new ISegmentOccupancyChangeListener() {
//				override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
//					map.put(id, newValue)
//				}
//			}
//		]
//		uut.process
//		Thread.sleep(200)
//		map.forEach [ id, state |
//			println('''ID: «id» Occupancy «IF state == SegmentOccupancy.FREE» FREE «ELSE» OCCUPIED «ENDIF»''')
//		]
//
//	// FIXME add asserts when we have a slightest clue about the bitorder
//	}
//
//	static class TestUARTReader implements IUARTReader {
//		override read() {
//			newByteArrayOfSize(4) => [set(0, 0xAA as byte); set(1, 0xAA as byte); set(2, 0xAA as byte); set(3, 0xAA as byte);]
//		}
//	}
}
