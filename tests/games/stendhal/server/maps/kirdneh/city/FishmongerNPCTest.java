package games.stendhal.server.maps.kirdneh.city;

import static org.junit.Assert.*;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
//import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;

public class FishmongerNPCTest extends ZonePlayerAndNPCTestImpl {
	
	//private static final String ZONE_NAME = "0_kirdneh_city";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setupZone("0_kirdneh_city");
	}
	
	public FishmongerNPCTest() {
		setNpcNames("Fishmonger");
		setZoneForPlayer("0_kirdneh_city");
		addZoneConfigurator(new  KirdnehFishyMarketNPC(),"0_kirdneh_city");
	}

	@Test
	public void test() {
		
		final SpeakerNPC npc = getNPC("Fishmonger");
		final Engine en = npc.getEngine();

		assertTrue(en.step(player, "hi"));
		assertEquals("Ahoy, me hearty! Back from yer swashbucklin, ah see.", getReply(npc));

		assertTrue(en.step(player, "job"));
		assertEquals("By the Powers! I be buyin. You be sellin?", getReply(npc));

		assertTrue(en.step(player, "yes"));
		assertEquals("Well, shiver me timbers! Check out that blackboard o'er thar fer me prices an' what i be buyin", getReply(npc));
		
		assertTrue(en.step(player, "aye"));
		assertEquals("Well, shiver me timbers! Check out that blackboard o'er thar fer me prices an' what i be buyin", getReply(npc));

		// equip with lionfish to sell it
		assertTrue(equipWithItem(player, "red lionfish"));
		assertTrue(en.step(player, "sell red lionfish"));
		assertEquals("A red lionfish is worth 120. Do you want to sell it?", getReply(npc));
		assertTrue(en.step(player, "yes"));
		assertEquals("Thanks! Here is your money.", getReply(npc));
		
		assertTrue(player.isEquipped("money",120));

	}

}
