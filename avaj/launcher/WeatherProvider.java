package avaj.launcher;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String weather[];

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
    }
    
}
