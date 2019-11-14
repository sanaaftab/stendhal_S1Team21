package games.stendhal.server.entity.item;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import games.stendhal.server.core.engine.SingletonRepository;

/**
 * @author Albert Viilik
 * @author Shaurya Gautam
 */
public class DailyPostTest {

	/**
	 * 
	 */
	@Test
	public void checkIfNewspaperItemExists() {
		final Item newspaper = SingletonRepository.getEntityManager().getItem("newspaper");
		assertTrue(newspaper != null);
	}
}
