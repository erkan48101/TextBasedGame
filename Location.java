import java.util.*;

public abstract class Location {
    private String name;
    private String shortDescription;
    private String longDescription;
    private Location[] paths = new Location[4];
    private int visitAmount = 0;
    private Location location;
    private ArrayList<Item> items = new ArrayList<>();
    private Scanner input;

    public Location(String name, String shortDescription, String longDescription) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public void addItem(Item newItem){
        items.add(newItem);
    }

    public void setPaths(Location north, Location south, Location west, Location east) {
        paths[0] = north;
        paths[1] = south;
        paths[2] = west;
        paths[3] = east;
    }

    public Location[] getPaths() { return paths; }

    public void doCommand(String[] command, Player player) {
        if (command[0].equals("n") && paths[0] != null) {
            player.moveTo(paths[0]);
            visitAmount++;
        } else if (command[0].equals("s") && paths[1] != null) {
            player.moveTo(paths[1]);
            visitAmount++;
        } else if (command[0].equals("w") && paths[2] != null) {
            player.moveTo(paths[2]);
            visitAmount++;
        } else if (command[0].equals("e") && paths[3] != null) {
            player.moveTo(paths[3]);
            visitAmount++;
        } else if (command[0].equals("help")) {
            System.out.println("Help text");
        } else if (command[0].equals("take")) {
            for (int i = 0; i < items.size(); i++) { // for loop som ska loopa genom alla items på platsen
                if (command[1].equals(items.get(i).getName()) && items.get(i) != null) { // kollar ifall andra delen av kommandot är lika med något av namnen på itemsen som finns sparade i items
                    player.giveItem(items.get(i));// tar bort item ur array items
                    System.out.println("You took the " + items.get(i).getName());
                    items.remove(items.get(i));
                } else {
                    System.out.println("Didnt work");
                }
            }
        }
    }
    public void describeYourself() {
        if (visitAmount == 0) {
            System.out.println(longDescription);
        } else {
            System.out.println(shortDescription);
        }

        System.out.println("You're currently at: " + name);
        if (items.size() != 0){
            System.out.println("There are items here: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getName());
            }
        }
        else{
            System.out.println("There are no items in this location.");
        }
        System.out.println();
        System.out.print("You see ");
        describePaths();
        System.out.println(" to the following directions: ");

        if (paths[0] != null) {
            System.out.println("north");
        }if (paths[1] != null) {
            System.out.println("south");
        }if (paths[2] != null) {
            System.out.println("west");
        }if (paths[3] != null) {
            System.out.println("east");
        }if (paths[0] == null && paths[1] == null && paths[2] == null && paths[3] == null) {
            System.out.println("You are trapped!");
        }
    }

    public abstract void describePaths();

    public ArrayList<Item> getItems() {
        return items;
    }
}