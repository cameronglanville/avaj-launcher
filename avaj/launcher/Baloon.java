package avaj.launcher;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
        }
    }

    public void registerTower(WeatherTower WeatherTower) {
        // TODO Auto-generated method stub
    }

}
