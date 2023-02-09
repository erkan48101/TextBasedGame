public abstract class Tool extends Item {

    public Tool(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void printYourself() {
        System.out.print("Name: " + getName());
        System.out.print(", Weight: " + getWeight());
        System.out.println(", Price: " + getPrice());
    }

    public abstract void use(Player player);
}