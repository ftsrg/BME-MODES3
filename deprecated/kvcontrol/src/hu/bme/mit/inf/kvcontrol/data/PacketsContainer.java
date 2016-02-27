package hu.bme.mit.inf.kvcontrol.data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A Holder class for UDP packets.
 * <p>
 * 
 * @author zsoltmazlo, benedekh
 */
public class PacketsContainer {

	/**
	 * All packets, which should handled by a TurnoutController are added to
	 * this queue.
	 * <p>
	 * only TurnoutController instances should send packets which will generate
	 * a response for TurnoutController instances!
	 */
	public static final BlockingQueue<byte[]> turnoutPackets = new LinkedBlockingQueue<byte[]>();

	/**
	 * All packets, which should handled by a SectionController are added to
	 * this queue.
	 * <p>
	 * only SectionController instances should send packets which will generate
	 * a response for SectionController instances!
	 */
	public static final BlockingQueue<byte[]> sectionPackets = new LinkedBlockingQueue<byte[]>();

	/**
	 * All packets, which should handled by a OccupancyController are added to
	 * this queue.
	 * <p>
	 * only OccupancyController instances should send packets which will
	 * generate a response for OccupancyController instances!
	 */
	public static final BlockingQueue<byte[]> occupancyPackets = new LinkedBlockingQueue<byte[]>();

}
