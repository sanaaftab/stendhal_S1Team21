/**
 * 
 */
package games.stendhal.server.entity.item;

import java.util.Map;

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

}
