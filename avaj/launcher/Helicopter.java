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
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): The sun is shining, it's a great day to see the sights.");
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): The rain has come, this is fine.");
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): Damn fog, I can hardly see where I am going.");
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            Printer.printLine("Helicopter#" + this.name + "(" + this.id + "): The snow is too cold! The rotors can't take much more of this.");
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
