public class ElvenRobe extends WearableItem{

    public ElvenRobe(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void printYourself() {
        System.out.print("Name: " + getName());
        System.out.println("Weight: " + getWeight());
        System.out.println("price: " + getPrice());
    }

    @Override
    public void doCommand(String[] command, Player player) {
        if (command[0].equals("wear")){
            putOn(player);
            System.out.println("You put on the " + getName());
        }
    }

    @Override
    public void putOn(Player player) {
        player.addHealth(10);
    }
}
