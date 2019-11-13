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
package games.stendhal.server.entity.creature;

//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
//import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.item.StackableItem;
//import games.stendhal.server.entity.mapstuff.spawner.SheepFood;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
//import marauroa.common.Log4J;
//import marauroa.common.game.RPObject;
import utilities.PlayerTestHelper;
import utilities.RPClass.NinjaMonkeyTestHelper;

public class NinjaMonkeyTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		NinjaMonkeyTestHelper.generateRPClasses();
		MockStendlRPWorld.get();
	}

	// Tests for Ninja Monkey:
	
	// Tests Ninja Monkey exists 
	@Test
	public void testNinjaMonkey() {
		new NinjaMonkey();
	}
	
	@Test
	public void testNinjaMonkeyExist() {
		final StendhalRPZone zone = new StendhalRPZone("testzone", 10, 10);
		MockStendlRPWorld.get().addRPZone(zone);

		final Player bob = PlayerTestHelper.createPlayer("bob");
		zone.add(bob);

		final NinjaMonkey ninMonk = new NinjaMonkey();
		zone.add(ninMonk);
		assertEquals("Im a monkey", ninMonk.getMonkeyType());

	}

	// Tests for Ninja Monkey Player
	
	// Tests Ninja Monkey can have an owner
	@Test
	public void testNinjaMonkeyPlayer() {

		final StendhalRPZone zone = new StendhalRPZone("zone");
		final Player jaime = PlayerTestHelper.createPlayer("jaime");
		zone.add(jaime);
		final NinjaMonkey ninjaChicken = new NinjaMonkey(jaime);

		assertEquals(jaime, ninjaChicken.getOwner());
	}
	
	//Tests for Ninja Monkey steal functionality
	@Test
	public void testItemsStolenFromTarget() {
		// Create a player with a pet and one withit
		final StendhalRPZone zone = new StendhalRPZone("testzone", 5, 5);
		final Player jaime = PlayerTestHelper.createPlayer("jaime");
		final Player jaime2 = PlayerTestHelper.createPlayer("jaime2");
		StackableItem stolen_item = (StackableItem) SingletonRepository.getEntityManager().getItem("money");
		stolen_item.setQuantity(1);
    	jaime.equip("bag", stolen_item);
		
		zone.add(jaime);
		zone.add(jaime2);
		final NinjaMonkey ninjaChicken = new NinjaMonkey(jaime2);
		zone.add(ninjaChicken);
		
		// Given the 16% chance of stealing each stealable item, this loop will run the logic 25 time, thus making the probability of a successful steal ~100%.
		for (int i = 0; i <= 150; i++)
			ninjaChicken.logic();

		
		// BY this point jaime should have no money and jaime2 should have 1 money.
		assertFalse(jaime.drop("money", 1));
		assertTrue(jaime2.drop("money", 1));
	}
	

}
