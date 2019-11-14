package games.stendhal.server.maps.deniran;


/*
 * Creates a new character - the glorious John Latham - legacy Professor of the university of Man(Deniran)chester! 
 * */
 
import games.stendhal.server.core.config.ZoneConfigurator;
//import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
//import games.stendhal.server.core.pathfinder.FixedPath;
import games.stendhal.server.entity.npc.NPC;
import games.stendhal.server.entity.npc.SpeakerNPC;

import java.util.Map;

public class InstituteProfessor extends NPC implements ZoneConfigurator {
 

	/**
	 * Configure a zone.
	 *
	 * @param	zone		The zone to be configured.
	 * @param	attributes	Configuration attributes.
	 */
	@Override
	public void configureZone(final StendhalRPZone zone, final Map<String, String> attributes) {
		buildNPC(zone);
	}
	
	  private void buildNPC(final StendhalRPZone zone) {
  	    final SpeakerNPC npc = new SpeakerNPC("Lon Jatham") {
  	    	@Override
  	    	protected void createPath() {
  	           // NPC does not move
  	           setPath(null);
  	       }
  	    	@Override
          protected void createDialog() {
              
              addGreeting("Bonjour! I am Lonny The Greatest. If you want to know about collusion - just ask me! Khem, I wanted to say, I want to enroll people "
      				+ "to study in my university!");
              // Lets the NPC reply when a player says "job"
              addJob("I give young starving minds what they really need - the Holy JAVA Graal!");
              // Lets the NPC reply when a player asks for help
              addHelp("You can enjoy the view of the grey walls inside this dark UNIVERSITY");
              addQuest("I want to make The Best Course In The World! But I need people to study on it. HELP ME!");
              // respond about a special trigger word
              addReply("uni","It will be the place of my glory! Khem, of course other people will get the piece of fame as well!");
              addReply("sure", "Now let's do it! We will rock it!");
              // use standard goodbye, but you can also set one inside the ()
              addGoodbye("Au revoir.");
          }
      };

      // This determines how the NPC will look like. welcomernpc.png is a picture in data/sprites/npc/
      npc.setEntityClass("amazoness_princessnpc");
      // set a description for when a player does 'Look'
      npc.setDescription("You see the most amazing person in this game - HE WILL GIVE YOU POWER!");
      npc.setPosition(54,120);
      npc.initHP(142);

      zone.add(npc);   
  }
}
	

