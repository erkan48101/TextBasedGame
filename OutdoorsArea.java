public class OutdoorsArea extends Location{

    private String weather;

    public OutdoorsArea(String name, String shortDescription, String longDescription, String weather, Boolean lit) {
        super(name, shortDescription, longDescription, lit);
        this.weather = weather;
    }

    public String getWeather() { return weather; }

    @Override
    public void describePaths() {
        System.out.print("paths");
    }

    @Override
    public Boolean digCheck() { return true; }

    @Override
    public void describeAttribute() {
        System.out.println("The weather is: " + weather);
    }

}