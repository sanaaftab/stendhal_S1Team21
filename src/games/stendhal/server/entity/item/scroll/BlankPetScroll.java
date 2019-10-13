package games.stendhal.server.entity.item.scroll;

import java.util.Map;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.creature.Pet;
import games.stendhal.server.entity.item.Item;
import games.stendhal.server.entity.player.Player;
//import games.stendhal.server.entity.player.PetOwner;;

/**
 * Represents an empty/blank pet scroll.
 */
public class BlankPetScroll extends Scroll {

	// private static final Logger logger = Logger.getLogger(EmptyScroll.class);

	/**
	 * Creates a new blank pet scroll.
	 *
	 * @param name
	 * @param clazz
	 * @param subclass
	 * @param attributes
	 */
	public BlankPetScroll(final String name, final String clazz, final String subclass,
			final Map<String, String> attributes) {
		super(name, clazz, subclass, attributes);
	}

	/**
	 * Copy constructor.
	 *
	 * @param item
	 *            item to copy
	 */
	public BlankPetScroll(final BlankPetScroll item) {
		super(item);
	}

	/**
	 * Use a blank pet scroll.
	 *
	 * @param player
	 * @return always true
	 */
	@Override
	protected boolean useScroll(final Player player) {
		final StendhalRPZone zone = player.getZone();
		final Pet pet = player.getPet();
		
		final String petType = pet.getName();
		final String petName = pet.getTitle();
		final int petXP = pet.getXP();
		final int petHP = pet.getHP();
		final int petBaseHP = pet.getBaseHP();
		final int petAtk = pet.getAtk();
		final int petDef = pet.getDef();
		final int petWeight = pet.getWeight();

		final String characteristics = new String(petType + " " + petName + " " + petXP + " " + petHP + " " + petBaseHP + " " + petAtk + " " + petDef + " " + petWeight);
		if (zone.isTeleportInAllowed(player.getX(), player.getY())) {
			final Item summonPetScroll = SingletonRepository.getEntityManager().getItem(
					"summon pet scroll");
			summonPetScroll.setInfoString(characteristics);
			player.equipOrPutOnGround(summonPetScroll);

			

			if (player.getPet() != null) {
				//petOwner.storePet(pet);
				player.removePet(pet);
				pet.getZone().remove(pet);				
				player.sendPrivateText("Amazingly your pet melds with the scroll. It just walked right into the page!");
			}

			return true;
		} else {
			player.sendPrivateText("The strong anti magic aura in this area prevents the scroll from working!");
			return false;
		}
	}

}