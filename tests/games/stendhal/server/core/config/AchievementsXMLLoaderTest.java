package games.stendhal.server.core.config;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
//import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.maps.MockStendlRPWorld;
import marauroa.common.game.IRPZone;
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

	@Test
	public void testReadAchievement() throws URISyntaxException, SAXException, IOException {
		AchievementsXMLLoader loader = new AchievementsXMLLoader(new URI("testachievement.xml"));
		loader.load();
		
	}

}
