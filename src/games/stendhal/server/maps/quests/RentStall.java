/* $Id$ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.maps.quests;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

//import games.stendhal.common.MathHelper;
//import games.stendhal.common.parser.Sentence;
//import games.stendhal.server.core.engine.SingletonRepository;
//import games.stendhal.server.core.events.LoginListener;
//import games.stendhal.server.entity.item.scroll.RainbowBeansScroll;
//import games.stendhal.server.entity.npc.ChatAction;
import games.stendhal.server.entity.npc.ConversationPhrases;
import games.stendhal.server.entity.npc.ConversationStates;
//import games.stendhal.server.entity.npc.EventRaiser;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.action.DropItemAction;
//import games.stendhal.server.entity.npc.action.EquipItemAction;
//import games.stendhal.server.entity.npc.action.MultipleActions;
//import games.stendhal.server.entity.npc.action.SayTimeRemainingAction;
//import games.stendhal.server.entity.npc.condition.AndCondition;
//import games.stendhal.server.entity.npc.condition.GreetingMatchesNameCondition;
//import games.stendhal.server.entity.npc.condition.LevelGreaterThanCondition;
//import games.stendhal.server.entity.npc.condition.LevelLessThanCondition;
//import games.stendhal.server.entity.npc.condition.NotCondition;
import games.stendhal.server.entity.npc.condition.PlayerHasItemWithHimCondition;
//import games.stendhal.server.entity.npc.condition.QuestNotStartedCondition;
//import games.stendhal.server.entity.npc.condition.QuestStartedCondition;
//import games.stendhal.server.entity.npc.condition.TimePassedCondition;
import games.stendhal.server.entity.player.Player;
//import games.stendhal.server.maps.Region;

public class RentStall extends AbstractQuest {

    public static final String QUEST_SLOT = "rent stall";
    public static final int REQUIRED_MONEY = 5000;

    @Override
    public String getSlotName() {
        return QUEST_SLOT;
    }

    @Override
    public String getName() {
        return "RentStall";
    }

    @Override
    public List<String> getHistory(final Player player) {
        final List<String> res = new ArrayList<String>();
        return res;
    }
    
    public void prepareQuestStep() {

        // get a reference to the npc
        SpeakerNPC npc = npcs.get("Steve");

        // add a reply on the trigger phrase "rent" to Hayunn
        npc.addReply("rent", "Oh are you interested in renting a stall?");
        
     // if the player asks for a quest, go to state QUEST_OFFERED
        npc.add(ConversationStates.ATTENDING,
            ConversationPhrases.QUEST_MESSAGES, 
            null,
            ConversationStates.QUEST_OFFERED, 
            "Well let's see if you have what you need",
            null);
        
     // in state QUEST_OFFERED, accept "no" and go back to ATTENDING
        npc.add(
            ConversationStates.QUEST_OFFERED,
            ConversationPhrases.NO_MESSAGES,
            null,
            ConversationStates.ATTENDING,
            "I'll see you around then",
            null);
        
        npc.add(ConversationStates.QUEST_OFFERED,
				ConversationPhrases.YES_MESSAGES,
				new PlayerHasItemWithHimCondition("money", REQUIRED_MONEY),
				ConversationStates.ATTENDING,
				"Alright. Your stall will show up in Deniran square and wll be managed by a shopkeeper",
				null);
				new DropItemAction("money", REQUIRED_MONEY);
		
				     
    }
    
    @Override
	public void addToWorld() {
		/* login notifier to teleport away players logging into the dream world.
		 * there is a note in TimedTeleportScroll that it should be done there or its subclass.
		 */
		fillQuestInfo(
				"Rent Stall",
				"Sell your stuff",
				false);
		prepareQuestStep();
		
		

	}
}