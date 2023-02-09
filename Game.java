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
        locations.add(new OutdoorsArea("Starting Location", "You're at the starting location", "", "sunny", true));
        locations.add(new OutdoorsArea("Plains", "You're at the plains", "You find yourself standing in the middle of some plains,\nthere is not much to see here.", "Sunny", true));
        locations.add(new OutdoorsArea("Cornfield", "You're at the cornfield", "You find yoursef in the middle of a field of some overgrown corn.", "Foggy", false));
        locations.add(new Room("Shed", "You're in the shed", "You find yourself inside a shed.\nit seems to be abandoned.", 3, Boolean.TRUE));
        locations.add(new Room("Troll room", "You're in the Troll room", "You enter a room which smells of troll \nthere are several bones scattered around the floor. ", 3, Boolean.FALSE));
        locations.add(new OutdoorsArea("Graveyard", "You're at the graveyard", "You enter what seems to be a graveyard. \nthere are tombstones all around you.", "cloudy", true));

        //north, south, west, east
        locations.get(0).setPaths(locations.get(1), locations.get(2), locations.get(3), locations.get(4));
        locations.get(1).setPaths(null, locations.get(0), null, locations.get(5));
        locations.get(2).setPaths(locations.get(0), null, null, null);
        locations.get(3).setPaths(null, null, null, locations.get(0));
        locations.get(4).setPaths(locations.get(5), null, locations.get(0), null);
        locations.get(5).setPaths(null, locations.get(4), locations.get(1), null);

        //items
        locations.get(0).addItem(new ElvenRobe(2, "Elven_Robe", 2));
        locations.get(3).addItem(new Shovel(3, "Shovel", 4));
        locations.get(5).addItem(new Torch(1, "Torch", 100));
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
            System.out.println("What do you want to do?");
            command = getCommand();
            separatedCommand = command.split(" "); //splitta den och skapa en array
            player.getLocation().doCommand(separatedCommand, player);
            player.doCommand(separatedCommand);
        }
    }
}