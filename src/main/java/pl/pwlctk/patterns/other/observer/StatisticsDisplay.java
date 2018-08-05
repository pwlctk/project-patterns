package pl.pwlctk.patterns.other.observer;

public class StatisticsDisplay implements Observer, ShowElement {
    private double maxTemp = 0.0;
    private double minTemp = 20.0;
    private double tempSum = 0.0;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }

        show();
    }

    @Override
    public void show() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

}
