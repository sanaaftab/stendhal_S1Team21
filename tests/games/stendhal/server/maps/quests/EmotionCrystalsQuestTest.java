/* $Id$ */

package games.stendhal.server.maps.quests;

import static org.junit.Assert.assertEquals;
import static utilities.SpeakerNPCTestHelper.getReply;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.maps.ados.snake_pit.PurpleCrystalNPC;
import games.stendhal.server.maps.ados.wall.GreeterSoldierNPC;
import games.stendhal.server.maps.fado.hut.BlueCrystalNPC;
import games.stendhal.server.maps.nalwor.forest.RedCrystalNPC;
import games.stendhal.server.maps.nalwor.river.PinkCrystalNPC;
import games.stendhal.server.maps.semos.mountain.YellowCrystalNPC;
//import utilities.PlayerTestHelper;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;

/**
 * Tests for EmotionCrystals
 *
 * @author James
 */
public class EmotionCrystalsQuestTest extends ZonePlayerAndNPCTestImpl {

	private static final String ZONE_NAME = "admin_test";
	private static final String QUEST_SLOT = "emotion_crystals";
	private EmotionCrystals myEmotionQuest = new EmotionCrystals();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME);
	}

	public EmotionCrystalsQuestTest() {
		setNpcNames("Julius", "Blue Crystal", "Red Crystal", "Pink Crystal", "Purple Crystal", "Yellow Crystal");
		//setNpcNames("Julius");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new GreeterSoldierNPC(), ZONE_NAME);
		addZoneConfigurator(new YellowCrystalNPC(), ZONE_NAME);
		addZoneConfigurator(new RedCrystalNPC(), ZONE_NAME);
		addZoneConfigurator(new BlueCrystalNPC(), ZONE_NAME);
		addZoneConfigurator(new PurpleCrystalNPC(), ZONE_NAME);
		addZoneConfigurator(new PinkCrystalNPC(), ZONE_NAME);
	}

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		//new EmotionCrystals().addToWorld();
		myEmotionQuest.addToWorld();
	}

	// Initialise Quest Test
	@Test
	public void testQuestStartQuest() {
		SpeakerNPC npc = SingletonRepository.getNPCList().get("Julius");
		Engine en = npc.getEngine();
		
		// Get and begin quest
		en.step(player, "hi");
		//String testReply = getReply(npc); < so getReply only gets most recent reply.. cool.
		en.step(player, "quest");
		assertEquals("I don't get to see my wife very often because I am so busy guarding this entrance. I would like to do something for her. Would you help me?", getReply(npc));
		en.step(player, "ok");
		assertEquals("Thank you. I would like to gather five #emotion #crystals as a gift for my wife. Please find all that you can and bring them to me.", getReply(npc));
		en.step(player, "bye");
		// Quest is now started
		
		//en.step(player, "hi");
		//assertEquals("Hello stranger, nice to meet you.", getReply(npc));
	}
	
	// MAIN TEST
	@Test
	public void crystalLogTest() {
		player.setQuest(QUEST_SLOT, "start");
		SpeakerNPC npc = SingletonRepository.getNPCList().get("Blue Crystal");
		Engine en = npc.getEngine();		
		
		en.step(player,"hi");
		assertEquals("Nice to meet you! This hut here is lovely.", getReply(npc));
		en.step(player, "riddle");
		assertEquals("I do not let things bother me. I never get overly energetic. Meditation is my forte. What am I?", getReply(npc));
		en.step(player, "peace");
		//reward item will be 'blue emotion crystal'
		assertEquals(player.isEquipped("blue emotion crystal"), true);
		// we have now 'found an emotion crystal'
		
		// Check quest state shows this..
		// Use EmotionCrystals.getHistory - which returns a list 'res'
		List<String> res = myEmotionQuest.getHistory(player);
		assertEquals("I have found the following crystals: blue emotion crystal", res.get(res.size() - 1));
		// remove the item from the bag
		player.drop("blue emotion crystal", 1);
		// now check that the log is still showing that we have 'found' the crystals
		res = myEmotionQuest.getHistory(player);
		assertEquals("I have found the following crystals: blue emotion crystal", res.get(res.size() - 1));
		
				
		// Put a call to update getHistory at the end of prepareRiddlesStep
		// Put logic in getHistory..
		
		
	}
	

	
}
