public class Shovel extends Tool{

    public Shovel(double weight, String name, int price) {
        super(weight, name, price);
    }


    @Override
    public void printYourself() {
        System.out.println("Weight: " + getWeight());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
    }

    @Override
    public void doCommand(String[] command, Player player) {
        if(command[0].equals("dig")){

        }
    }

    @Override
    public void use(Player player) {

    }
}
