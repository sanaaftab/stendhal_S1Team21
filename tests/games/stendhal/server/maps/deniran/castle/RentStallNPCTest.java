package games.stendhal.server.maps.deniran.castle;

import static org.junit.Assert.*;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import utilities.ZonePlayerAndNPCTestImpl;

public class RentStallNPCTest extends ZonePlayerAndNPCTestImpl {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setupZone("int_deniran_castle");
	}
	
	public RentStallNPCTest() {
		setNpcNames("Salinca");
		setZoneForPlayer("int_deniran_castle");
		addZoneConfigurator(new  RentStallNPC(),"int_deniran_castle");
	}

	@Test
	public void test() {
		
		final SpeakerNPC npc = getNPC("Salinca");
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi"));
		assertEquals("Hello there, welcome to the Deniran Castle!.", getReply(npc));

		assertTrue(en.step(player, "job"));
		assertEquals("Interested in selling your items?", getReply(npc));

		assertTrue(en.step(player, "bye"));
		assertEquals("Alright, see you around. ", getReply(npc));

	}

}
