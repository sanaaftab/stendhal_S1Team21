/**
 * 
 */
package games.stendhal.server.achievements;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.rp.achievement.AchievementNotifier;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;

/**
 * @author Albert Viilik
 *
 */
public class AchievementNotifierTest {
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

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#get()}.
	 */
	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#initialize()}.
	 */
	@Test
	public void testInitialize() {
		AchievementNotifier an = AchievementNotifier.get();
		an.initialize();
		assertTrue(an.getAchievements().size() > 0);
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onLevelChange(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnLevelChange() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onKill(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnKill() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onFinishQuest(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnFinishQuest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onZoneEnter(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnZoneEnter() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onAge(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnAge() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onItemLoot(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnItemLoot() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onProduction(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnProduction() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onObtain(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnObtain() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#awardAchievementIfNotYetReached(games.stendhal.server.entity.player.Player, java.lang.String)}.
	 */
	@Test
	public void testAwardAchievementIfNotYetReached() {
		AchievementNotifier an = AchievementNotifier.get();
		an.initialize();
		an.awardAchievementIfNotYetReached(player, "zone.interior.semos");
		assertTrue(player.hasReachedAchievement("zone.interior.semos"));
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#onLogin(games.stendhal.server.entity.player.Player)}.
	 */
	@Test
	public void testOnLogin() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link games.stendhal.server.core.rp.achievement.AchievementNotifier#getAchievements()}.
	 */
	@Test
	public void testGetAchievements() {
		fail("Not yet implemented");
	}

}
