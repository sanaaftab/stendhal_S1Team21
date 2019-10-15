package games.stendhal.server.entity.item;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;
import utilities.RPClass.ItemTestHelper;

public class EquipMithrilClaspToKeyringTest {

	@BeforeClass
	public static void setUpBeforeClass() {
		ItemTestHelper.generateRPClasses();
	}

	@Before
	public void setUp() {

	}

	@Test
	public void testEquippingMithrilClaspToKeyring() {
		final Item mithril_clasp = SingletonRepository.getEntityManager().getItem("mithril clasp");
		assertTrue(mithril_clasp.canBeEquippedIn("keyring"));
	}
}
