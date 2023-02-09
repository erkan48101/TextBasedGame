public class Torch extends Tool {

    private Boolean lit;
    private Location location;
    private Room room;

    public Torch(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void doCommand(String[] command, Player player) {
        if (command[0].equals("getlit")) {
            System.out.println("You used your torch to light up the place!");
            use(player);
        } else if (command[0].equals("delight")) {
            turnOff(player);
        }
    }

    @Override
    public void use(Player player) {
        player.getLocation().setLit(true);
    }

    public void turnOff(Player player) {
        player.getLocation().setLit(false);
    }

    public Boolean getLit() {
        return lit;
    }
}
