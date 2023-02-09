public class Shovel extends Tool{

    public Shovel(double weight, String name, int price) {
        super(weight, name, price);
    }

    @Override
    public void doCommand(String[] command, Player player) {
        if(command[0].equals("dig") && player.getLocation().digCheck() && !player.getLocation().getItems().isEmpty()){
            System.out.println("You dug a hole in the ground!");
            use(player);
        }
        else if (command[0].equals("dig") && !player.getLocation().digCheck()){
            System.out.println("You couldnt dig with your shovel here.");
        }
        else if (command[0].equals("dig") && player.getLocation().getItems().isEmpty()){
            System.out.println("There are no items underground here.");
        }
    }

    @Override
    public void use(Player player) {
        if (player.getLocation().getItems() != null){
            System.out.print("You found an: ");
            System.out.println(player.getLocation().getItems().get(0).getName() + "!");
            player.giveItem(player.getLocation().getItems().get(0));
            if (player.getLocation().getItems().get(0) != null) {
                player.getLocation().getItems().remove(0);
            }
        }
        else {
            System.out.println("You didnt find anything");
        }
    }
}
