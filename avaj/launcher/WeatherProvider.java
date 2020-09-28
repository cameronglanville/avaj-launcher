package avaj.launcher;

import java.lang.Math;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG" , "SUN", "SNOW"}; //types of weather

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int temp = (int)(Math.sqrt(Math.pow(coordinates.getLongitude(), 2) + Math.pow(coordinates.getLatitude(), 2) + Math.pow(coordinates.getHeight(), 2))) % 4;
        return weather[temp]; // generate weather based on the coordinates.
    }
    
}
