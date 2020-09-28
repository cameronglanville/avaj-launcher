package avaj.launcher;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            Printer.printLine("JetPlane#" + this.name + "(" + this.id + "): Sun's out, guns out. We are going far.");
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            Printer.printLine("JetPlane#" + this.name + "(" + this.id + "): It's raining hard, but we're still going.");
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            Printer.printLine("JetPlane#" + this.name + "(" + this.id + "): foggy, but we are still going on");
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            Printer.printLine("JetPlane#" + this.name + "(" + this.id + "): snow, we have to get lower");
        }

        if (this.coordinates.getHeight() == 0) {
            Printer.printLine("JetPlane#" + this.name + "(" + this.id + ") landing. Longitude: " + this.coordinates.getLongitude() + " Latitude: " + this.coordinates.getLatitude());
            this.weatherTower.unregister(this);
            Printer.printLine("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Printer.printLine("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}
