package games.stendhal.server.maps.deniran.castle;

import java.util.Map;

import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.StendhalRPZone;

import java.util.LinkedList;
import java.util.List;

import games.stendhal.server.core.pathfinder.FixedPath;
import games.stendhal.server.core.pathfinder.Node;
import games.stendhal.server.entity.npc.SpeakerNPC;

public class RentStallNPC implements ZoneConfigurator {

	@Override
	public void configureZone(StendhalRPZone zone, Map<String, String> attributes) {
		// TODO Auto-generated method stub
		buildNPC(zone);
	}
	

	private void buildNPC(final StendhalRPZone zone) {
		final SpeakerNPC renterNPC = new SpeakerNPC("Steve") {

			@Override
			protected void createPath() {
				final List<Node> nodes = new LinkedList<Node>();
				nodes.add(new Node(25, 13));
				nodes.add(new Node(25, 18));
				nodes.add(new Node(20, 18));
				nodes.add(new Node(19, 16));
				setPath(new FixedPath(nodes, true));
			}

			@Override
			protected void createDialog() {
				addJob("Interested in selling your items?");
				addHelp("To rent a stall for 6 months you need to be at least level 20, have 5000 coins in your inventory and have at lest 30 items");
				addOffer("You don't have the cash. Come back later.");
				addQuest("Sorry, I have no quest for you");
				addGoodbye("Byeeeee.");
			}
		};

		renterNPC.setEntityClass("oldcowboynpc");
		renterNPC.setPosition(25, 13);
		renterNPC.initHP(100);
		renterNPC.setDescription("You see Steve, go to him to find out about selling your items.");
		zone.add(renterNPC);
	}

}
