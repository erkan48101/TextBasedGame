public class Sweater extends WearableItem{

    public Sweater(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void doCommand(String[] command, Player player) {

    }

    @Override
    public void putOn(Player player) {
        player.addHealth(3);
        super.putOn(player);
    }
}
