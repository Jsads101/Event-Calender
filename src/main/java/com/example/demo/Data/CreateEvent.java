package com.example.demo.Data;

import java.sql.Date;
import java.sql.Time;

public class CreateEvent {
    private String eventTitle;
    private String eventDesc;
    private String location;
    private String eventTime;
    private Date eventDate;
    //String attendees?

    public CreateEvent(){}

    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate){
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
