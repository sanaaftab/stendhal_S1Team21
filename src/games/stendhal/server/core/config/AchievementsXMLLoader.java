/* $Id$ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.core.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URI;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import games.stendhal.server.core.rp.achievement.*;
import games.stendhal.server.entity.npc.ChatCondition;
//import games.stendhal.server.entity.npc.condition.LevelGreaterThanCondition;
//import games.stendhal.server.entity.npc.condition.LevelGreaterThanCondition;
//import games.stendhal.server.entity.npc.condition.PlayerHasKilledNumberOfCreaturesCondition;
//import games.stendhal.server.entity.npc.condition.PlayerHasKilledNumberOfCreaturesCondition;

public final class AchievementsXMLLoader extends DefaultHandler {

	/** the logger instance. */
	private static final Logger LOGGER = Logger.getLogger(AchievementsXMLLoader.class);


	/**
	 * The zone group file.
	 */
	//private final URI uri;

	/**
	 * Create an XML based loader of zones.
	 * @param uri the zone group file
	 */
//	public AchievementsXMLLoader(final URI uri) {
//		this.uri = uri;
//	}

	public static final int EASY_BASE_SCORE = 1;

	/** base score for achievements of medium difficulty */
	public static final int MEDIUM_BASE_SCORE = 2;

	/** base score for difficult achievements */
	public static final int HARD_BASE_SCORE = 5;

	private String identifier;

	private String title;

	private Category category;

	private String description;

	/** Attributes of the item. */
	private Map<String, String> attributes;

	private Map<String, String> attributeValues;

	private boolean attributeTagFound;

	private int baseScore;

	private List<Achievement> achievements;
	private boolean attributesTag; 

	/** is this achievement visible? */
	private boolean active;
	private String name;
	private boolean tag;
	private ChatCondition condtionObject;

	private Class<?> condition;
	private Object implementation;
	private Achievement achievement;
	private Object[] parameter_value;
	private Class<?>[] parameter_type;
	private int index;



	public List<Achievement> load( URI uri) throws SAXException {
		achievements = new LinkedList<Achievement>();
		// Use the default (non-validating) parser
		final SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// Parse the input
			final SAXParser saxParser = factory.newSAXParser();

			final InputStream is = AchievementsXMLLoader.class.getResourceAsStream(uri.getPath());

			if (is == null) {
				throw new FileNotFoundException("cannot find resource '" + uri
						+ "' in classpath");
			}
			try {
				saxParser.parse(is, this);
			} finally {
				is.close();
			}
		} catch (final ParserConfigurationException t) {
			LOGGER.error(t);
		} catch (final IOException e) {
			LOGGER.error(e);
			throw new SAXException(e);
		}

		return achievements;
	}

	@Override
	public void startDocument() {
		// do nothing
	}

	@Override
	public void endDocument() {
		// do nothing
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {

		if (qName.equals("achievement")) {
			name = attrs.getValue("name");
			attributes = new LinkedHashMap<String, String>();
			description = "";
			implementation = null;

		} else if (qName.equals("implementation")) {

			final String className = attrs.getValue("class-name");

			try {
				implementation = Class.forName(className).getConstructor().newInstance();
			} catch (final Exception ex) {
				LOGGER.error("Unable to load class: " + className);
			}
		} else if (qName.equals("identifier")) {
			identifier = attrs.getValue("value");
		} else if (qName.equals("title")) {
			title = attrs.getValue("value");
		} else if (qName.equals("description")) {
			description = attrs.getValue("value");
		} else if (qName.equals("baseScore")) {
			baseScore = Integer.parseInt(attrs.getValue("value"));
		} else if (qName.equals("category")) {
			category = Category.valueOf(attrs.getValue("value"));
		} else if (qName.equals("active")) {
			active = Boolean.parseBoolean(attrs.getValue("value"));
		} else if (qName.equals("condition")) {
			try {
			condition = Class.forName(attrs.getValue("class-name"));
			constructor = condition.getConstructors()[0];
			parameter_value = new Object[constructor.getParameterCount()];
			parameter_type = constructor.getParameterTypes();
			}
			catch(Exception ex){
				LOGGER.error("Unable to load class: " + condition);
			}
		}
		else if (qName.equals("parameter")) 
			tag = true;
		if (tag) {
			if(index < constructor.getParameterCount()) {
				try {
			if(parameter_type[index].equals(int.class) || parameter_type[index].equals(Integer.class)) {
			parameter_value[index] = Integer.parseInt((attrs.getValue("value")));
			index++;}
			else if(parameter_type[index].equals(boolean.class) || parameter_type[index].equals(Boolean.class)) {
				parameter_value[index] = Boolean.parseBoolean((attrs.getValue("value")));
				index++;}
			else if(parameter_type[index].equals(double.class)|| parameter_type[index].equals(Double.class)) {
				parameter_value[index] = Double.parseDouble((attrs.getValue("value")));
				index++;}
			else {
				parameter_value[index] = attrs.getValue("value");
				index++;}
				}catch(Exception ex){
				LOGGER.error("Unable to load class: " + parameter_value);
			}}
		else 
			index = 0;
		}}
		
	
	private Constructor<?> constructor; 
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if(qName.equals("achievement")) {
			try {

			condtionObject = (ChatCondition)constructor.newInstance(parameter_value);
		     }
			catch(Exception ex){
				LOGGER.error("Unable to load class: " + condtionObject);
			}
			achievements.add(new Achievement(identifier, title, category,description, baseScore, active,condtionObject));
		}			
	}
}

