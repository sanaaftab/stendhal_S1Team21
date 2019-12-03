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
package games.stendhal.server.core.rp.achievement;

//import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

//import games.stendhal.common.constants.Nature;
//import games.stendhal.server.core.rule.defaultruleset.DefaultSpell;
import games.stendhal.server.core.rule.defaultruleset.creator.AbstractCreator;
//import games.stendhal.server.core.rule.defaultruleset.creator.FullSpellCreator;
import games.stendhal.server.entity.npc.ChatCondition;
import games.stendhal.server.entity.player.Player;
//import games.stendhal.server.entity.spell.Spell;
/**
 * An Achievement a player can reach while playing the game.
 * Achievements are given for example for doing a certain number of quests or killing a number of special creatures
 *
 * @author madmetzger
 */
public class Achievement {
	
	private AbstractCreator<Achievement> creator;

	
	private static final Logger logger = Logger.getLogger(Achievement.class);
	
	private String name;

	/** base score for easy achievements */
	public static final int EASY_BASE_SCORE = 1;

	/** base score for achievements of medium difficulty */
	public static final int MEDIUM_BASE_SCORE = 2;

	/** base score for difficult achievements */
	public static final int HARD_BASE_SCORE = 5;
	
	private Class<?> implementationClass;

	private  String identifier;

	private  String title;

	private Category category;

	private String description;

	private int baseScore;

	/** is this achievement visible? */
	private  boolean active;

	private ChatCondition condition;



	/**
	 * create a new achievement
	 *
	 * @param identifier
	 * @param title
	 * @param category
	 * @param description
	 * @param baseScore
	 * @param active
	 * @param condition
	 * 
	 * 
	 * 
	 */
	
	
	public Achievement(String identifier, String title, Category category, String description, int baseScore, boolean active, ChatCondition condition) {
		this.identifier = identifier;
		this.title = title;
		this.category = category;
		this.condition = condition;
		this.description = description;
		this.baseScore = baseScore;
		this.active = active;
	}

	/**
	 * @return the category of this achievement
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return the identifying string
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @return the title a player gets awarded for this achievement
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the description of what to do to get this achievement
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the base score for this achievement
	 */
	public int getBaseScore() {
		return this.baseScore;
	}

	/**
	 * @return true if the achievement is visible, false otherwise
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Check if a player has fulfilled this achievement
	 * @param p the player to check
	 * @return true iff this achievement's condition evaluates to true
	 */
	public boolean isFulfilled(Player p) {
		return condition.fire(p, null, null);
	}

	@Override
	public String toString() {
		return "Achievement<id: "+identifier+", title: "+title+">";
	}
	
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	public void setIdentifier(String identifier) {
//		this.identifier = identifier;
//	}
//	
//	public void setScore(String baseScore) {
//		this.baseScore = Integer.parseInt(baseScore);
//	}
//	
//	public void setActive(String active) {
//		this.active = Boolean.parseBoolean(active);
//	}
//	
//	public void setCategory(Category category){
//		 this.category = category;
//	}
//
//	public void setCondition(ChatCondition condition) {
//		this.condition = condition;
//		// TODO Auto-generated method stub
//		
//	}
	

}
