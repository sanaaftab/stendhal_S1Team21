/**
 * 
 */
package games.stendhal.server.rp.achievements;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.rp.achievement.Achievement;

import games.stendhal.server.core.rp.achievement.factory.InteriorZoneAchievementFactory;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;
	
/**
 * @author Albert Viilik
 * @author Shurya Gautam
 *
 */
public class AchievementTest {
	private Player player;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MockStendlRPWorld.get();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MockStendlRPWorld.reset();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = PlayerTestHelper.createPlayer("testplayer");
		player.initReachedAchievements();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		InteriorZoneAchievementFactory factory = new InteriorZoneAchievementFactory();
//		SemosMonsterQuestAchievementFactory factory1 = new SemosMonsterQuestAchievementFactory();
//		UndergroundZoneAchievementFactory factory2 = new UndergroundZoneAchievementFactory();
//		MithrilbourghEnemyArmyAchievementFactory factory3 = new MithrilbourghEnemyArmyAchievementFactory();
//		OutsideZoneAchievementFactory factory4 = new OutsideZoneAchievementFactory();
//		QuestAchievementFactory factory5 = new QuestAchievementFactory();
		
		
		ArrayList<Achievement> achievements = new ArrayList<Achievement>(factory.createAchievements());
		System.out.println(achievements);
		assertEquals(achievements.get(0).getCategory().toString(), "INTERIOR_ZONE");
		assertEquals(achievements.get(0).getIdentifier().toString(), "zone.interior.semos");
		assertEquals(achievements.get(0).getTitle().toString(), "Home maker");
		assertEquals(achievements.get(0).getDescription().toString(), "Visit all interior zones in the Semos region");
		assertEquals(achievements.get(0).getBaseScore(), 2);
		assertTrue(achievements.get(0).isActive());
		
		player.addReachedAchievement("zone.interior.semos");
		assertTrue(achievements.get(0).isFulfilled(player));
		
		
//		assertTrue(true);
//		fail("Not yet implemented");
	}

}
