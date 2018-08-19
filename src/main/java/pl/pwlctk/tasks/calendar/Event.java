package pl.pwlctk.tasks.calendar;

import javax.xml.bind.annotation.*;

@XmlType(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)

public class Event {
    @XmlAttribute(name = "date")
    private String date;

    @XmlValue
    private String name;

    public Event() {
    }

    Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    String getDate() {
        return date;
    }
}
