/*
 * @(#) src/games/stendhal/server/config/ZoneGroupsXMLLoader.java
 *
 * $Id$
 */

package games.stendhal.server.core.config;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import games.stendhal.server.core.rule.defaultruleset.DefaultCreature;

/**
 * Load and configure creatures via an XML configuration file.
 */
public class AchievementGroupsXMLLoader extends DefaultHandler {
	
	private static final Logger LOGGER = Logger.getLogger(AchievementGroupsXMLLoader.class);

	/** The main zone configuration file. */
	protected URI uri;

	/**
	 * Create an xml based loader of creature groups.
	 *
	 * @param uri
	 *            The location of the configuration file.
	 */
}