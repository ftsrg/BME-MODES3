package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

// FIXME: reimplement this test with the new transport

class SafetyLogicTest {

//	MessagingService mms
//	SafetyLogic sl
//	val sleepTime = 300
//
//	@Before
//	def init() {
//		val stack = CommunicationStackFactory::createLocalStack
//		mms = stack.mms
//		sl = new SafetyLogic(stack, new NOPLoggerFactory)
//		sl.run(); // The component will run on the main thread
//	}
//
//	@Test
//	def void safetyLogicRegressionTest() {
//		new TrackElementStateSender(mms, new NOPLoggerFactory) => [
//			assertOnlyBlocked(#[]) 
//			sendSegmentOccupation(15, SegmentOccupancy.OCCUPIED)
//			Thread.sleep(sleepTime)
//			
//			assertOnlyBlocked(#[]) 
//			sendSegmentOccupation(24, SegmentOccupancy.OCCUPIED)
//			Thread.sleep(sleepTime)
//
//			assertOnlyBlocked(#[])
//			sendSegmentOccupation(28, SegmentOccupancy.OCCUPIED)
//			Thread.sleep(sleepTime)
//
//			assertOnlyBlocked(#[24])		
//			sendSegmentOccupation(29, SegmentOccupancy.OCCUPIED)
//			Thread.sleep(sleepTime)
//	
//			assertOnlyBlocked(#[24, 29])		
//		]
//
//	}
//	
//	@Test
//	def void tooCloseWithoutMovingTest(){
//		new TrackElementStateSender(mms, new NOPLoggerFactory) => [
//			
//		]
//	}
//
//	def assertOnlyBlocked(List<Integer> integers) {
//		sl.model.sections.forEach [
//			if(it instanceof Segment) {
//				if(integers.contains(it.id)) {
//					Assert.assertEquals('''«it.id» Should be disabled but it is enabled''', false, it.isIsEnabled)
//				} else {
//					Assert.assertEquals('''«it.id» should be enabled, but it is disabled''', true, it.isIsEnabled)
//				}
//			}
//		]
//
//	}

}
