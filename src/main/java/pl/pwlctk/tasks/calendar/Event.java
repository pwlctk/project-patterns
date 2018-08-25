package pl.pwlctk.tasks.calendar;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)

public class Event {

    @XmlElement(name = "member")
    private List<Member> memberList = new ArrayList<>();

    @XmlAttribute(name = "date")
    private String date;

    @XmlAttribute(name = "name")
    private String name;

    public Event() {
    }

    Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    Event(String date, String name, Member member) {
        this.memberList.add(member);
        this.date = date;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    void addMember(Member member){
        this.memberList.add(member);
    }

    void deleteMember(int id) {
        memberList.remove(id);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

}
