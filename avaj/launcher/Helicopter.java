package avaj.launcher;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): it is hot, we are going far.");
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): it is raining, gliding alone just fine.");
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): foggy, but we are still going on.");
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): snow, the rotors can't take much more of this.");
        }

        if (this.coordinates.getHeight() == 0) {
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + ") landing. Longitude: " + this.coordinates.getLongitude() + " Latitude: " + this.coordinates.getLatitude());
            this.weatherTower.unregister(this);
            Printer.printLine("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Printer.printLine("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}
