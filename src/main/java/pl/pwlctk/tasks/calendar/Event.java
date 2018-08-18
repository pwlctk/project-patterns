package pl.pwlctk.tasks.calendar;

class Event {
    private String name;
    private String dateTime;

    Event(String name, String dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    String getDateTime() {
        return dateTime;
    }
}
