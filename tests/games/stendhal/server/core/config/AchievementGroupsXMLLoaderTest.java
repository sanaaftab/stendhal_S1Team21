package games.stendhal.server.core.config;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
//import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import games.stendhal.server.core.rp.achievement.Achievement;
import games.stendhal.server.maps.MockStendlRPWorld;

public class AchievementGroupsXMLLoaderTest {

	@Before
	public void setUp() throws Exception {
		MockStendlRPWorld.get();
	}

	@After
	public void tearDown() throws Exception {
		MockStendlRPWorld.reset();
	}

	@Test
	public void testLoad() throws URISyntaxException, SAXException, IOException {
		AchievementGroupsXMLLoader loader = new AchievementGroupsXMLLoader(new URI("testachievementgroups.xml"));
		List<Achievement> list = loader.load();
		assertThat(Boolean.valueOf(list.isEmpty()), is(Boolean.FALSE));
		Achievement achievement = list.get(0);
		assertThat(achievement.getTitle(), is("Greenhorn"));
		assertThat(achievement.getCategory(), is("EXPERIENCE"));
		assertThat(achievement.getIdentifier(), is("xp.level.10"));
		assertThat(achievement.getDescription(), is("Reach level 10"));
		assertThat(achievement.getBaseScore(), is("1"));
		assertThat(achievement.isActive(), is(Boolean.TRUE));
		
	}

}
