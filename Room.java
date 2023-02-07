public class Room extends Location {

    private int size;

    public Room(String name, String shortDescription, String longDescription, int size) {
        super(name, shortDescription, longDescription);
        this.size = size;
    }

    public void describePaths() {
        System.out.print("doors");
    }

    public int getSize() {
        return size;
    }

}