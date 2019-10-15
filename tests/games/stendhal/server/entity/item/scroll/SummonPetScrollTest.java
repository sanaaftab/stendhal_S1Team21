package games.stendhal.server.entity.item.scroll;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;


import games.stendhal.server.maps.MockStendlRPWorld;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.entity.creature.Cat;
import games.stendhal.server.entity.item.scroll.BlankPetScroll;
import games.stendhal.server.entity.item.scroll.SummonPetScroll;
import games.stendhal.server.core.engine.StendhalRPZone;
import utilities.PlayerTestHelper;
import utilities.RPClass.ItemTestHelper;


public class SummonPetScrollTest {
	
	private static StendhalRPZone zone;
	private Player bob;
	private Cat catBob;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		zone = new StendhalRPZone("zoneOfDeath") {
		
		@Override
		public boolean isInProtectionArea(final Entity entity)
		{
			return false;
		}
		};
		MockStendlRPWorld.get().addRPZone(zone);
		ItemTestHelper.generateRPClasses();
		
		
	}
	
	@Before
	public void setUp() throws Exception
	{
		
		bob = PlayerTestHelper.createPlayer("bob");
				
		zone.add(bob);
		
		catBob = new Cat(bob);
		
		
		bob.setPet(catBob);
		
		//Now let's change the characteristics of Bob's cat
		catBob.setTitle("lala");
		catBob.setXP(300);
		catBob.setHP(678);
		catBob.setBaseHP(123);
		catBob.setAtk(13);
		catBob.setDef(175);
		catBob.setWeight(45);
		
		PlayerTestHelper.equipWithItem(bob, "blank pet scroll");
		BlankPetScroll bps = new BlankPetScroll((BlankPetScroll) bob.getFirstEquipped("blank pet scroll"));
		bps.useScroll(bob);
		
		
		SummonPetScroll sps = (SummonPetScroll) bob.getFirstEquipped("summon pet scroll");
		sps.useScroll(bob);
	}


	@Test
	public void testCharacteristicsPreservation() {

		
		assertEquals("lala", catBob.getTitle());
		assertEquals(300, catBob.getXP());
		assertEquals(678, catBob.getHP());	
		assertEquals(123, catBob.getBaseHP());	
		assertEquals(13, catBob.getAtk());	
		assertEquals(175, catBob.getDef());	
		assertEquals(45, catBob.getWeight());	

	}
	

}
