package avaj.launcher;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
        }
    }

    public void registerTower(WeatherTower WeatherTower) {
        // TODO Auto-generated method stub
    }

}
