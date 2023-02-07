public class OutdoorsArea extends Location{

    private String weather;

    public OutdoorsArea(String name, String shortDescription, String longDescription, String weather) {
        super(name, shortDescription, longDescription);
        this.weather = weather;
    }

    public void describePaths() {
        System.out.print("paths");
    }
    public String getWeather() { return weather; }

}