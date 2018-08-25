package pl.pwlctk.tasks.calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String email;

    public Member() {
    }

    Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    public String getMember() {
        return name + ": " + email;
    }
}
