public class ElvenRobe extends WearableItem{

    public ElvenRobe(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void putOn(Player player) {
        player.addHealth(10);
    }
}
