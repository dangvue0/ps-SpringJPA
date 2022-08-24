package dang.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "session_schedule")
public class Session_Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedule_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_slot_id", referencedColumnName = "time_slot_id")
    private Time_Slot time_slot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private Session session;

    private String room;

    public Session_Schedule() {
    }

    public Time_Slot getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(Time_Slot time_slot) {
        this.time_slot = time_slot;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Long getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Long schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
