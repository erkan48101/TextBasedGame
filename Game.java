import java.util.*;

public class Game {

    private Scanner keyboard;
    private ArrayList<Location> locations;
    private Player player;
    private Item item;

    public Game() {

        keyboard = new Scanner(System.in);
        locations = new ArrayList<Location>();

        //world
        locations.add(new OutdoorsArea("Forest", "You're back at the starting location", "You find yourself in a forest, theres trees all around you", "sunny"));
        locations.add(new OutdoorsArea("Plains", "You're back at the plains", "You find yourself standing in the middle of some plains,\nthere is not much to see here.", "Sunny"));
        locations.add(new OutdoorsArea("Cornfield", "You're back at the cornfield", "You find yoursef in the middle of a field of some overgrown corn.", "Foggy"));
        locations.add(new Room("Shed", "You're back in the shed", "You find yourself inside a shed.\nit seems to be abandoned.", 3));
        locations.add(new Room("Troll room", "You're back in the Troll room", "You enter a room which smells of troll \nthere are several bones scattered around the floor. ", 3));
        locations.add(new OutdoorsArea("Graveyard", "You're back at the graveyard", "You enter what seems to be a graveyard. \nthere are tombstones all around you.", "cloudy"));

        //north, south, west, east
        locations.get(0).setPaths(locations.get(1), locations.get(2), locations.get(3), locations.get(4));
        locations.get(1).setPaths(null, locations.get(0), null, locations.get(5));
        locations.get(2).setPaths(locations.get(0), null, null, null);
        locations.get(3).setPaths(null, null, null, locations.get(0));
        locations.get(4).setPaths(locations.get(5), null, locations.get(0), null);
        locations.get(5).setPaths(null, locations.get(4), locations.get(1), null);

        //items
        locations.get(0).addItem(new ElvenRobe(2, "ElvenRobe", 2));
    }

    public String getCommand () {
        return keyboard.nextLine();
    }

    public void run() {

        String name;
        System.out.println("Welcome to the adventure game! \n"
                + "What is your name?");
        name = keyboard.nextLine();
        player = new Player(name, locations.get(0));
        System.out.println("Hello " + name + ", welcome to this magical world of wonder!\nYou can move around by typing n/s/w/e.\nYou will have to learn more commands as you play the game! (Hint: there is a command \"help\").");

        while (true) {
            String command;
            String[] separatedCommand;
            player.getLocation().describeYourself();
            System.out.println("What do you want to do?");
            command = getCommand();
            separatedCommand = command.split(" "); //splitta den och skapa en array
            player.getLocation().doCommand(separatedCommand, player);
            player.doCommand(separatedCommand);

            //vi vill göra en for loop som går igenom alla items spelaren har och kollar om vi kan genomföra en docommand

        }
    }
}