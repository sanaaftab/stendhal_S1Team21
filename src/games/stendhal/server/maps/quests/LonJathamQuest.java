package games.stendhal.server.maps.quests;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
import java.util.List;

//import games.stendhal.common.parser.Sentence;
//import games.stendhal.server.core.engine.SingletonRepository;
//import games.stendhal.server.entity.item.Item;
//import games.stendhal.server.entity.npc.ChatAction;
import games.stendhal.server.entity.npc.ConversationPhrases;
import games.stendhal.server.entity.npc.ConversationStates;
import games.stendhal.server.entity.npc.SpeakerNPC;
//import games.stendhal.server.entity.npc.action.DropInfostringItemAction;
//import games.stendhal.server.entity.npc.action.DropItemAction;
//import games.stendhal.server.entity.npc.action.EquipItemAction;
//import games.stendhal.server.entity.npc.action.IncreaseKarmaAction;
//import games.stendhal.server.entity.npc.action.IncreaseXPAction;
//import games.stendhal.server.entity.npc.action.IncrementQuestAction;
//import games.stendhal.server.entity.npc.action.InflictStatusOnNPCAction;
//import games.stendhal.server.entity.npc.action.MultipleActions;
//import games.stendhal.server.entity.npc.action.SetQuestAction;
//import games.stendhal.server.entity.npc.action.SetQuestToTimeStampAction;
//import games.stendhal.server.entity.npc.condition.AndCondition;
//import games.stendhal.server.entity.npc.condition.NotCondition;
//import games.stendhal.server.entity.npc.condition.PlayerHasInfostringItemWithHimCondition;
//import games.stendhal.server.entity.npc.condition.PlayerHasItemWithHimCondition;
//import games.stendhal.server.entity.npc.condition.QuestActiveCondition;
//import games.stendhal.server.entity.npc.condition.QuestCompletedCondition;
//import games.stendhal.server.entity.npc.condition.QuestNotStartedCondition;
//import games.stendhal.server.entity.npc.condition.TimePassedCondition;
import games.stendhal.server.entity.player.Player;

/**
 * Quest to fetch water for a thirsty person.
 * You have to check it is clean with someone knowledgeable first
 *
 * @author Arinoid
 *
 *
 * QUEST: Lon Jatham at the Deniran Institute of Technology
 *
 * PARTICIPANTS:
 * <ul>
 * <li> Lon Jatham </li>
 * </ul>
 *
 * STEPS:
 * <ul>
 * <li> Ask Lon Jatham for a quest. </li>
 * <li> Find 3 NPC in order to collect their signatures on the documents. </li>
 * <li> Return to Lon and ask him to answer every of questions asked by potential students.</li>
 * <li> Return to students, give them answers and take their signatures. </li>
 * <li> Return to Lon to get your award as exp and 25 pizzas</li>
 * </ul>
 *
 * REWARD:
 * <ul>
 * <li> 500 XP </li>
 * <li> 25 pizzas </li>
 * </ul>
 
*/

public class LonJathamQuest extends AbstractQuest {
	
	// constants
		private static final String QUEST_SLOT = "lon_jatham_institute_of_tech";

		@Override
		public String getSlotName() {
			return QUEST_SLOT;
		}

		//Talk to Lon in order to get a quest
		public void prepareQuestStep() {
			final SpeakerNPC npc = npcs.get("Lon Jatham");

			// player asks about quest for first time 
			npc.add(ConversationStates.ATTENDING,
					ConversationPhrases.QUEST_MESSAGES,
					null,
					//new QuestNotStartedCondition(QUEST_SLOT),
					ConversationStates.QUEST_OFFERED,
					"I want to make The Best Course In The World! But I need people to study on it. HELP ME!",
					null);
			
			 npc.add(   ConversationStates.QUEST_OFFERED,
				        ConversationPhrases.YES_MESSAGES,
				        null,
				        ConversationStates.ATTENDING,
				        "Now let's do it! We will rock it!",
				        null);
			 
			 

		    // in state QUEST_OFFERED, accept "no" and go back to ATTENDING
		    npc.add(
		        ConversationStates.QUEST_OFFERED,
		        ConversationPhrases.NO_MESSAGES,
		        null,
		        ConversationStates.ATTENDING,
		        "HOW DARE YOU?!!!",
		        null);

			

}
		@Override
		public void addToWorld() {
			fillQuestInfo(
					"LonJathamQuest",
					"Lon Jatham wants to start a University course, nut he does't have students.",
					true);
			prepareQuestStep();
		}
		
		
		@Override
		public String getName() {
			return "LonJathamQuest";
		}
		
		@Override
		public List<String> getHistory(final Player player) {
			return new ArrayList<String>();
		}
		

		@Override
		public String getNPCName() {
			return "Lon Jatham";
		}
}	

