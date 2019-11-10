package games.stendhal.server.maps.deniran.castle;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
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
		PlayerTestHelper.removeNPC("Salinca");
	}

	@Test
	public void test() {

		npc = SingletonRepository.getNPCList().get("Salinca");
		assertNotNull(npc);
		en = npc.getEngine();

        //player has not met the conditions
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("No way! Come back when you get your life together", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		// player was too low level last time. make them at least level 20
		player.addXP(99520);
		assertThat(player.getLevel(), greaterThanOrEqualTo(20));

		// not interested at first
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "no");
		assertEquals("OK... rude. Can I help you with anything else?", getReply(npc));
		en.step(player, "rent");
		assertEquals("To rent a stall for 6 months you need to be at least level 20, have 5000 coins in your inventory and have at lest 30 items", getReply(npc));
		en.step(player, "quest");
		assertEquals("Sorry, I have no quest for you", getReply(npc));
		en.step(player, "job");
		assertEquals("I think you already know what I do.", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		
		assertFalse(player.isEquipped("money"));

		// don't have money
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("You don't have the cash. Come back later", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));

		
		
		PlayerTestHelper.equipWithMoney(player, 5000);
		
		//not enough items
		

		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("Your items are not that impressive, come back when you have more (30)", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));


	
		PlayerTestHelper.equipWithStackableItem(player, "wood", 30);
		
        //players has everything required
		
		en.step(player, "hi");
		assertEquals("Hello there, welcome to the Deniran Castle!", getReply(npc));
		en.step(player, "job");
		assertEquals("Interested in selling your items?", getReply(npc));
		en.step(player, "yes");
		assertEquals("Alright, your stall will apear in the Deniran main square in the *NEXT RELEASE*. It will be handled by a shopkeeper.", getReply(npc));
		en.step(player, "bye");
		assertEquals("Byeeeee.", getReply(npc));
		assertFalse(player.isEquipped("money"));

	}

}
