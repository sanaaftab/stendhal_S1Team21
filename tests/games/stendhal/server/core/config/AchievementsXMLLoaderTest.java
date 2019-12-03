package games.stendhal.server.core.config;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URI;
//import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import java.util.List;

import games.stendhal.server.core.rp.achievement.Achievement;
import games.stendhal.server.core.rp.achievement.Category;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.server.game.db.DatabaseFactory;

public class AchievementsXMLLoaderTest {

	@Before
	public void setUp() throws Exception {
		MockStendlRPWorld.get();
		new DatabaseFactory().initializeDatabase();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @throws IOException  
	 */
	@Test
	public void testReadAchievement() throws URISyntaxException, SAXException, IOException {
		AchievementsXMLLoader loader = new AchievementsXMLLoader();
		List<Achievement> list = loader.load(new URI("testachievement.xml"));
		assertThat(Boolean.valueOf(list.isEmpty()), is(Boolean.FALSE));
		Achievement achievement = list.get(0);
		assertThat(achievement.getTitle(), is("Greenhorn"));
		assertThat(achievement.getCategory(), is(Category.EXPERIENCE));
		assertThat(achievement.getIdentifier(), is("xp.level.10"));
		assertThat(achievement.getDescription(), is("Reach level 10"));
		assertThat(achievement.getBaseScore(), is(1));
		assertThat(achievement.isActive(), is(Boolean.TRUE));
		
	}

}
