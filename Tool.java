public abstract class Tool extends Item {

    public Tool(double weight, String name, int price) {
        super(weight, name, price);
    }
    public abstract void doCommand(String command[], Player player);
    public abstract void use(Player player);
}