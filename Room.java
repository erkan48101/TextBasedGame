public class Room extends Location {

    private int size;
    private Player player;

    public Room(String name, String shortDescription, String longDescription, int size, Boolean lit) {
        super(name, shortDescription, longDescription, lit);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void describePaths() {
        System.out.print("doors");
    }

    @Override
    public Boolean digCheck() {
        return false;
    }

    @Override
    public void describeAttribute() {
        System.out.println("The room has a size of: " + size);
    }

}
