package games.stendhal.server.maps.quests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static utilities.SpeakerNPCTestHelper.getReply;

import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.ConversationStates;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.fsm.Engine;
import games.stendhal.server.entity.player.Player;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;
//Import statements for creating a Johnny the sexy thing
import games.stendhal.server.maps.deniran.InstituteProfessor;



public class LonJathamTest extends ZonePlayerAndNPCTestImpl{
	
	private Player player = null;

	private static final String ZONE_NAME = "int_deniran_institute";
	private static final String QUEST_SLOT = "lon_jatham_institute_of_tech";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME);
	}
	

	@Before
	@Override
	public void setUp() throws Exception{
		super.setUp();
		player = PlayerTestHelper.createPlayer("player");
		zone = new StendhalRPZone(ZONE_NAME);
		//SpeakerNPC npc;
		final LonJathamQuest lgt = new LonJathamQuest();
		lgt.addToWorld();
	}
	
	//CONSTRUCTOR
	public LonJathamTest() {
		setNpcNames("Lon Jatham");
		//CHANGE TO INSITUTE OF THECK IN DEHRIAN
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new InstituteProfessor(), ZONE_NAME);

	}
	

	
	
	//TEST TIME
	//Give the test to the player
	@Test
	public void testQuestStartQuest() {
		SpeakerNPC npc = getNPC("Lon Jatham");
		Engine en = npc.getEngine();
		
		en.step(player, "hi");
		assertEquals("Bonjour! I am Lonny The Greatest. If you want to know about collusion - just ask me! Khem, I wanted to say, I want to enroll people "
				+ "to study in my university!", getReply(npc));
		en.setCurrentState(ConversationStates.ATTENDING);
		
		en.step(player, "help");
		assertEquals("You can enjoy the view of the grey walls inside this dark UNIVERSITY", getReply(npc));
		en.step(player, "quest");
		assertEquals("I want to make The Best Course In The World! But I need people to study on it. HELP ME!", getReply(npc));
		//start the quest
		en.setCurrentState(ConversationStates.QUEST_OFFERED);
		assertEquals(ConversationStates.QUEST_OFFERED, en.getCurrentState());
		en.step(player, "yes");
		player.setQuest(new LonJathamQuest().getSlotName(), "start");
		assertEquals("start", player.getQuest(new LonJathamQuest().getSlotName()));
				
		en.step(player, "sure");
		assertEquals("Now let's do it! We will rock it!", getReply(npc));

		en.step(player, "bye");
		assertEquals("Au revoir.", getReply(npc));
	}
	

}
