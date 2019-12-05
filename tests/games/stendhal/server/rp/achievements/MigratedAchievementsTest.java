/**
 * 
 */
package games.stendhal.server.rp.achievements;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import games.stendhal.server.core.config.AchievementsXMLLoader;
import games.stendhal.server.core.rp.achievement.Achievement;
import games.stendhal.server.core.rp.achievement.Category;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;
import utilities.PlayerTestHelper;


/**
 * @author James Evennett
 *
 */
public class MigratedAchievementsTest {
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
	public void testInteriorZoneAchievement() throws URISyntaxException, SAXException, IOException {
								
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/InteriorZoneAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Home maker"));
		assertThat(firstAchievement.getCategory(), is(Category.INTERIOR_ZONE));
		assertThat(firstAchievement.getIdentifier(), is("zone.interior.semos"));
		assertThat(firstAchievement.getDescription(), is("Visit all interior zones in the Semos region"));
		assertThat(firstAchievement.getBaseScore(), is(2));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}
	
	@Test
	public void testMithrilbourghEnemyArmyAchievement() throws URISyntaxException, SAXException, IOException {
								
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/MithrilbourghEnemyArmyAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Sergeant"));
		assertThat(firstAchievement.getCategory(), is(Category.QUEST_MITHRILBOURGH_ENEMY_ARMY));
		assertThat(firstAchievement.getIdentifier(), is("quest.special.kill_enemy_army.0005"));
		assertThat(firstAchievement.getDescription(), is("Finish Kill Enemy Army quest 5 times"));
		assertThat(firstAchievement.getBaseScore(), is(2));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}

	@Test
	public void testOutsideZoneAchievement() throws URISyntaxException, SAXException, IOException {
								
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/OutsideZoneAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Junior Explorer"));
		assertThat(firstAchievement.getCategory(), is(Category.OUTSIDE_ZONE));
		assertThat(firstAchievement.getIdentifier(), is("zone.outside.semos"));
		assertThat(firstAchievement.getDescription(), is("Visit all outside zones in the Semos region"));
		assertThat(firstAchievement.getBaseScore(), is(1));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}

	@Test
	public void testQuestAchievement() throws URISyntaxException, SAXException, IOException {
								
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/QuestAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Faiumoni's Casanova"));
		assertThat(firstAchievement.getCategory(), is(Category.QUEST));
		assertThat(firstAchievement.getIdentifier(), is("quest.special.elf_princess.0025"));
		assertThat(firstAchievement.getDescription(), is("Finish elf princess quest 25 times"));
		assertThat(firstAchievement.getBaseScore(), is(2));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}
	
	@Test
	public void testSemosMonsterQuestAchievement() throws URISyntaxException, SAXException, IOException {
								
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/SemosMonsterQuestAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Semos' Protector"));
		assertThat(firstAchievement.getCategory(), is(Category.QUEST_SEMOS_MONSTER));
		assertThat(firstAchievement.getIdentifier(), is("quest.special.daily.0010"));
		assertThat(firstAchievement.getDescription(), is("Finish daily monster quest 10 times"));
		assertThat(firstAchievement.getBaseScore(), is(1));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}
	
	@Test
	public void testUndergroundZoneAchievement() throws URISyntaxException, SAXException, IOException {
					
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> achievementList = loader.load(new URI("/data/conf/achievements/UndergroundZoneAchievement.xml"));

		Achievement firstAchievement = achievementList.get(0);
		System.out.println(achievementList);
		
		assertThat(firstAchievement.getTitle(), is("Canary"));
		assertThat(firstAchievement.getCategory(), is(Category.UNDERGROUND_ZONE));
		assertThat(firstAchievement.getIdentifier(), is("zone.underground.semos"));
		assertThat(firstAchievement.getDescription(), is("Visit all underground zones in the Semos region"));
		assertThat(firstAchievement.getBaseScore(), is(2));
		assertThat(firstAchievement.isActive(), is(Boolean.TRUE));
	}
}
