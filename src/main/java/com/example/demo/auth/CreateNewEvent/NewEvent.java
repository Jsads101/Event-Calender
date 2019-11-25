package com.example.demo.auth.CreateNewEvent;

import java.time.LocalDate;
import java.time.LocalTime;

public class NewEvent {
    private String eventTitle;
    private String eventDesc;
    private LocalTime eventTime;
    private LocalDate eventDate;
    private String attendees;

    public NewEvent(){}

    public NewEvent (String eventTitle, String eventDesc, LocalTime eventTime, LocalDate eventDate, String attendees){
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.attendees = attendees;
    }

    public String getEventTitle(){
        return eventTitle;
    }
    public void setEventTitle(String eventTitle){
        this.eventTitle = eventTitle;
    }
    public String getEventDesc(){
        return eventDesc;
    }
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
    public LocalTime getEventTime(){
        return eventTime;
    }
    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }
    public LocalDate getEventDate(){
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public String getAttendees(){
        return attendees;
    }
    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }
}
