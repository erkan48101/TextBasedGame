import java.util.*;

public class Player {

    private String name;
    private Location position;
    private int gold;
    private int health;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name, Location location) {
        this.name = name;
        this.position = location;
    }

    public void doCommand(String[] command) {
        if (command[0].equals("inventory")) {
            System.out.println("\nInventory:");
            if (inventory.size() == 0) {
                System.out.println("Your inventory is empty\n");
            } else {
                for (int i = 0; i < inventory.size(); i++) {
                    //System.out.println(inventory.get(i).getName());
                    inventory.get(i).printYourself();
                    System.out.println();
                }
            }
        } if (command[0].equals("stats")){
            System.out.println("Stats:");
            System.out.println("Health: " + health);
            System.out.println("Gold: " + gold);
        } else {
            for (int i = 0; i < inventory.size(); i++){
                inventory.get(i).doCommand(command, this);
            }
        }
    }

    public void giveItem(Item item) {
        inventory.add(item);
    }
    public void removeItem (Item item){
        inventory.remove(item);
    }
    public Location getLocation() {
        return position;
    }
    public int getGold() {
        return gold;
    }
    public int getHealth(){
        return health;
    }
    public ArrayList getInventory(){return inventory;}
    public void setInventory(ArrayList<Item> inventory) {this.inventory = inventory;}
    public void setLocation(Location newPosition) {this.position = newPosition;}
    public void addHealth(int health){ this.health = this.health + health; }
    public void setName(String name) { this.name = name; }

    public void moveTo (Location destination) {
        position = destination;
        destination.describeYourself();
        destination.addVisitamount();
    }

    public int checkTorch () {
        for (int i = 0; i < inventory.size(); i++) {
            if (position.getItems().get(i).getName().equals("torch")){

            }
        }
        return 0;
    }

}