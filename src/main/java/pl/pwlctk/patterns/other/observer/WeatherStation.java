package pl.pwlctk.patterns.other.observer;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.setReadings(80, 65, 30.4f);
        weatherData.setReadings(82, 70, 29.2f);
        weatherData.setReadings(78, 90, 29.2f);
    }
}
