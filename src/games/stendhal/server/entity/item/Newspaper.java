/**
 * 
 */
package games.stendhal.server.entity.item;

import java.util.Map;

import games.stendhal.server.entity.RPEntity;
import games.stendhal.server.entity.item.behavior.UseBehavior;

/**
 * @author Shaurya Gautam
 *
 */
public class Newspaper extends Item {

	/**
	 * @param name
	 * @param clazz
	 * @param subclass
	 * @param attributes
	 */
	public Newspaper(String name, String clazz, String subclass, Map<String, String> attributes) {
		super(name, clazz, subclass, attributes);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param item
	 */
	public Newspaper(Item item) {
		super(item);
	}

	@Override
	public void setUseBehavior(UseBehavior behavior) {
		super.setUseBehavior(behavior);
	}

	@Override
	public boolean onUsed(RPEntity user) {
		user.sendPrivateText("You took a look at the contents of the newspaper.");
		return super.onUsed(user);
	}
	
}
