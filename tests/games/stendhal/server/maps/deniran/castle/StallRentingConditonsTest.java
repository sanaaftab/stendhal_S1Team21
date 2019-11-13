package games.stendhal.server.maps.deniran.castle;

import static org.junit.Assert.*;
//import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertThat;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.deniran.castle.RentStallNPC;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;

public class StallRentingConditonsTest {

	private Player player;
	private SpeakerNPC npc;
	private Engine en;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
	}

	@Before
	public void setUp() {
		final StendhalRPZone zone = new StendhalRPZone("admin_test");
		new RentStallNPC().configureZone(zone, null);


		player = PlayerTestHelper.createPlayer("bob");
		zone.add(player);
	}
	


	@After
	public void tearDown() {
		PlayerTestHelper.removeNPC("Steve");
	}

	@Test
	public void test() {

		npc = SingletonRepository.getNPCList().get("Steve");
		assertNotNull(npc);
		en = npc.getEngine();

        //player is not interested
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "no");
		assertEquals("Ok then. Have a good day!", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		// player finds out info but does not want to buy
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("You can rent a stall if you want. just say #buy #stall.", getReply(npc));
		en.step(player, "help");
		assertEquals("To rent a stall for 6 months you need to be at least level 20, have 5000 coins in your inventory and have at lest 30 items", getReply(npc));
		en.step(player, "buy");
		assertEquals("A stall will cost 5000. Do you want to buy it?", getReply(npc));
		en.step(player, "no");
		assertEquals("Ok, how else may I help you?", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		assertFalse(player.isEquipped("stall"));
		assertFalse(player.isEquipped("money"));

		// player doesn't  have money
		
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("You can rent a stall if you want. just say #buy #stall.", getReply(npc));
		en.step(player, "buy");
		assertEquals("A stall will cost 5000. Do you want to buy it?", getReply(npc));
		en.step(player, "yes");
		assertEquals("Sorry, you don't have enough money!", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		
		
		PlayerTestHelper.equipWithMoney(player, 5000);
		
        //players has everything required
		
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("You can rent a stall if you want. just say #buy #stall.", getReply(npc));
		en.step(player, "buy");
		assertEquals("A stall will cost 5000. Do you want to buy it?", getReply(npc));
		en.step(player, "yes");
		assertEquals("Congratulations! Here is your stall!", getReply(npc));
		
		assertFalse(player.isEquipped("money"));
		assertTrue(player.isEquipped("stall"));
		
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

	}

}

