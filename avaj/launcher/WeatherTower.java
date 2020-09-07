package avaj.launcher;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    } // this is what I need to call to get the weather.

    public void changeWeather() {
        this.conditionsChanged();
    }
    
}
