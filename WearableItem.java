public abstract class WearableItem extends Item {
    public WearableItem(double weight, String name, int price) {
        super(weight, name, price);
    }

    public abstract void putOn(Player player);
}