public abstract class WearableItem extends Item {
    public WearableItem(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void doCommand(String[] command, Player player) {
        if (command[0].equals("wear") && command[1].equals(getName())){
            putOn(player);
            System.out.println("You put on the " + getName());
        }
    }

    @Override
    public void printYourself() {
        System.out.print("Name: " + getName());
        System.out.print(", Weight: " + getWeight());
        System.out.println(", price: " + getPrice());
    }

    public void putOn(Player player){
        player.removeItem(this);
    }
}