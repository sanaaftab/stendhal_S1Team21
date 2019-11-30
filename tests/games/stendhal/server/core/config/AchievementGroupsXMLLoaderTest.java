package games.stendhal.server.core.config;

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

import games.stendhal.server.core.rule.defaultruleset.DefaultSpell;
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
	public void test() throws URISyntaxException, SAXException, IOException{
		AchievementGroupsXMLLoader loader = new AchievementGroupsXMLLoader(new URI("testachiement.xml"));
		List<DefaultAchievement> list = loader.load();
	}

}
