public abstract class Item {
    private double weight;
    private String name;
    private int price;

    public Item(double weight, String name, int price) {
        this.weight = weight;
        this.name = name;
        this.price = price;
    }

    public abstract void printYourself();
    public abstract void doCommand(String[] command, Player player);

    public double getWeight() {return weight;}
    public String getName() {return name;}
    public int getPrice() {return price;}
    public void setWeight(double weight) { this.weight = weight; }
    public void setName(String name) {this.name = name; }
    public void setPrice(int price) {this.price = price; }
}