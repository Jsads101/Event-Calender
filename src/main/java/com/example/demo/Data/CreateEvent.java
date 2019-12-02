package com.example.demo.Data;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class CreateEvent {
    private int eventId;
    private String eventTitle;
    private String eventDesc;
    private String location;
    private String eventTime;
    private Date eventDate;
//    @Value("#{$('#tokenfield-2').tokenfield('getTokensList')}")
    private List<String> tokenField;
//    public static void main(String[] args){ //only for testing
//        CreateEvent e = new CreateEvent();
//        System.out.println(e.getTokenField());
//        System.out.println(e.tokenField);//both souts return null :(((
//    }

//    List<String> attendees = Arrays.asList(getTokenField().split("\\s*,\\s*")); //changing email addresses String to an ArrayList
    //For now this throws NullPointerException

    public CreateEvent(){

    }

    public CreateEvent(int eventId, String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField){
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        //this.tokenField = tokenField;
        this.tokenField = Arrays.asList(tokenField.split("\\s*,\\s*")); //changing email addresses String to an ArrayList

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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

    public List<String> getTokenField(){
        return tokenField;
    }
    public void setTokenField(List<String> tokenField){
        this.tokenField = tokenField;
    }
}
