package avaj.launcher;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG" , "SUN", "SNOW"}; //types of weather

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int temp = ( coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() ) % 4;
        return weather[temp]; // generate weather based on the coordinates.
    }
    
}
