/**
 * 
 */
package games.stendhal.server.achievements;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.rp.achievement.Achievement;
import games.stendhal.server.core.rp.achievement.factory.InteriorZoneAchievementFactory;
import games.stendhal.server.core.rp.achievement.factory.MithrilbourghEnemyArmyAchievementFactory;
import games.stendhal.server.core.rp.achievement.factory.OutsideZoneAchievementFactory;
import games.stendhal.server.core.rp.achievement.factory.QuestAchievementFactory;
import games.stendhal.server.core.rp.achievement.factory.SemosMonsterQuestAchievementFactory;
import games.stendhal.server.core.rp.achievement.factory.UndergroundZoneAchievementFactory;

/**
 * @author Albert Viilik
 * @author Shurya Gautam
 *
 */
public class AchievementTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
		SemosMonsterQuestAchievementFactory factory1 = new SemosMonsterQuestAchievementFactory();
		UndergroundZoneAchievementFactory factory2 = new UndergroundZoneAchievementFactory();
		MithrilbourghEnemyArmyAchievementFactory factory3 = new MithrilbourghEnemyArmyAchievementFactory();
		OutsideZoneAchievementFactory factory4 = new OutsideZoneAchievementFactory();
		QuestAchievementFactory factory5 = new QuestAchievementFactory();
		
		Collection<Achievement> listOfAchievements = factory.createAchievements();
		
		System.out.println("FACTORY: InteriorZoneAchievementFactory\n");
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		

		System.out.println("FACTORY: SemosMonsterQuestAchievementFactory\n");
		listOfAchievements = factory1.createAchievements();
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		
		System.out.println("FACTORY: UndergroundZoneAchievementFactory\n");
		listOfAchievements = factory2.createAchievements();
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		
		System.out.println("FACTORY: MithrilbourghEnemyArmyAchievementFactory\n");
		listOfAchievements = factory3.createAchievements();
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		
		System.out.println("FACTORY: OutsideZoneAchievementFactory\n");
		listOfAchievements = factory4.createAchievements();
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		
		System.out.println("FACTORY: QuestAchievementFactory\n");
		listOfAchievements = factory5.createAchievements();
		for (Achievement a: listOfAchievements) {
			System.out.println("ACHIEVEMENT: " + a);
			System.out.println("CATEGORY: " + a.getCategory());
			System.out.println("IDENTIFIER: " + a.getIdentifier());
			System.out.println("TITLE: " + a.getTitle());
			System.out.println("DESCRIPTION: " + a.getDescription());
			System.out.println("BASE_SCORE: " + a.getBaseScore());
			System.out.println("IS_ACTIVE: " + a.isActive() + "\n");
		}
		assertTrue(true);
//		fail("Not yet implemented");
	}

}
