public abstract class Weapon extends Item {
    private int damage;

    public Weapon(double weight, String name, int price, int damage) {
        super(weight, name, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) { this.damage = damage; }

    @Override
    public void printYourself() {
        System.out.println("Weapon: " + getName() + ", damage: " + damage + ", weight: " + getWeight() + ", price: " + getPrice());
    }

}
