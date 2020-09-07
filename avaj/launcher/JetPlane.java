package avaj.launcher;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
        } else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
        } else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
        }
    }

    public void registerTower(WeatherTower WeatherTower) {
        // TODO Auto-generated method stub
    }

}
