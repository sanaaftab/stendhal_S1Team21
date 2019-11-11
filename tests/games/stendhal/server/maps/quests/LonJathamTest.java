package games.stendhal.server.maps.quests;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static utilities.SpeakerNPCTestHelper.getReply;


import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;
//Import statements for creating a Johnny the sexy thing
import games.stendhal.server.maps.deniran.InstituteProfessor;



public class LonJathamTest extends ZonePlayerAndNPCTestImpl{
	
	private Player player = null;
//	private SpeakerNPC npc = null;
//	private Engine en = null;
//
//	private String questSlot = null;

	private static final String ZONE_NAME = "int_deniran_institute";
	private static final String QUEST_SLOT = "lon_jatham_institute_of_tech";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME);
	}
	
	//CONSTRUCTOR
	public LonJathamTest() {
		setNpcNames("Lon Jatham");
		//CHANGE TO INSITUTE OF THECK IN DEHRIAN
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new InstituteProfessor(), ZONE_NAME);
		//Can be used as a stamp to create NPC to get signs from
//		addZoneConfigurator(new GreeterNPC(), ZONE_NAME);
		//This is actual construction of the zone so John will be able to talk to us and player will see him
//		addZoneConfigurator(new  KirdnehFishyMarketNPC(),"int_deniran_institute");
	}
	
	
//	@Before
//	@Override
//	public void setUp() throws Exception {
//		super.setUp();
//
//		new LonJatham().addToWorld();
//	}

	
	
	//TEST TIME
	//Give the test to the player
	@Test
	public void testQuestStartQuest() {
		SpeakerNPC npc = getNPC("Lon Jatham");
		Engine en = npc.getEngine();
		
		en.step(player, "hi");
		assertEquals("Bonjour! I am Lonny The Greatest. If you want to know about collusion - just ask me! Khem, I wanted to say, I want to enroll people "
				+ "to study in my university!", getReply(npc));
		en.step(player, "help");
		assertEquals("You can enjoy the view of the grey walls inside this dark UNIVERSITY", getReply(npc));
		en.step(player, "task");
		assertEquals("I want to make The Best Course In The World! But I need people to study on it.", getReply(npc));
		en.step(player, "sure");
		assertEquals("Find 3 people ready to sign this 3 prospectus! And their souls will be doooooomed! HAHAHAHA!", getReply(npc));
		//start the quest
		//assertEquals("start", player.getQuest(QUEST_SLOT));
		en.step(player, "bye");
		assertEquals("Au revoir.", getReply(npc));
	}
	
//	// Test with 1 signed prospectus
//	@Test
//	public void testQuestWithFirstSignedDoc() {
//		SpeakerNPC npc = SingletonRepository.getNPCList().get("Lon_Jatham");
//		Engine en = npc.getEngine();
//		player.setQuest(QUEST_SLOT, "start");
//		PlayerTestHelper.equipWithItem(player, "signed_prospectus");
//
//		en.step(player, "hi");
//		assertEquals("Bonjour! I am Lonny The Greatest. If you want to know about collusion - just ask me! Khem, I wanted to say, I want to enroll people "
//				+ "to study in my university!", getReply(npc));
//		en.step(player, "quest");
//		assertEquals("Okay, you found the first poor soul. 2 more to go!", getReply(npc));
//		en.step(player, "ok");
//		en.step(player, "task");
//		assertEquals("Yes, you need to finish the task - 2 more signatures!", getReply(npc));
//		en.step(player, "bye");
//		assertEquals("Au revoir.", getReply(npc));
//	}
//	
//	//test with 2 signed prospectus
//	@Test
//	public void testQuestWithTwoSignedDoc() {
//		SpeakerNPC npc = SingletonRepository.getNPCList().get("Lon_Jatham");
//		Engine en = npc.getEngine();
//		player.setQuest(QUEST_SLOT, "start");
//		PlayerTestHelper.equipWithItem(player, "signed_prospectus");
//
//		en.step(player, "hi");
//		assertEquals("Bonjour! I am Lonny The Greatest. If you want to know about collusion - just ask me! Khem, I wanted to say, I want to enroll people "
//				+ "to study in my university!", getReply(npc));
//		en.step(player, "quest");
//		assertEquals("Okay, you found the first poor soul. 2 more to go!", getReply(npc));
//		en.step(player, "ok");
//		en.step(player, "task");
//		assertEquals("Yes, you need to finish the task - 2 more signatures!", getReply(npc));
//		en.step(player, "bye");
//		assertEquals("Au revoir.", getReply(npc));
//	}
//	
//	//test with 3 signed prospectus
//	//get a reward
//	@Test
//	public void testQuestWithAllThreeSignedDocs() {
//		SpeakerNPC npc = SingletonRepository.getNPCList().get("Lon_Jatham");
//		Engine en = npc.getEngine();
//		player.setQuest(QUEST_SLOT, "start");
//		PlayerTestHelper.equipWithItem(player, "signed_prospectus");
//
//		en.step(player, "HI");
//		assertEquals("Hello! Welcome to Fado City! You can #learn about Fado from me.", getReply(npc));
//		en.step(player, "quest");
//		// [19:05] krupi earns 100 experience points.
//		assertEquals("Thank you ever so much! That's just what I wanted! Here, take these potions that Sarzina gave me - I hardly have use for them here.", getReply(npc));
//		en.step(player, "thanks");
//		en.step(player, "task");
//		assertEquals("Thank you, I don't need anything right now.", getReply(npc));
//		en.step(player, "water");
//		assertEquals("Thank you, I don't need anything right now.", getReply(npc));
//		en.step(player, "bye");
//		assertEquals("Bye.", getReply(npc));
//	}

}
