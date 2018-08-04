package pl.pwlctk.patterns.other.observer;

public class CurrentConditionsDisplay implements Observer, ShowElement {

    private Subject subject;
    private double temperature;
    private double humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.subject = weatherData;
        subject.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        show();
    }

    @Override
    public void show() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
