package avaj.launcher;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
            Printer.printLine("Baloon#" + this.name + "(" + this.id + "): The sun is making the air so hot! Gonna get some serious height with this.");
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
            Printer.printLine("Baloon#" + this.name + "(" + this.id + "): It is raining on our parade, down we go.");
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
            Printer.printLine("Baloon#" + this.name + "(" + this.id + "): This fog isn'r helping, going to have to get lower.");
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
            Printer.printLine("Baloon#" + this.name + "(" + this.id + "): Damn snow, better get down before we crash.");
        }

        if (this.coordinates.getHeight() == 0) {
            Printer.printLine("Baloon#" + this.name + "(" + this.id + ") landing. Longitude: " + this.coordinates.getLongitude() + " Latitude: " + this.coordinates.getLatitude());
            this.weatherTower.unregister(this);
            Printer.printLine("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Printer.printLine("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}
