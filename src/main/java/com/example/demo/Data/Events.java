package com.example.demo.Data;

public class Events {

    private int eventID;
    private String eventName;
    private String organiserName;
    private String location;
    private String date;
    private String time;
    private int dReq;
    private boolean teamBased;
    private String description;


    public String getDescription() {
        return description;
    }

    public int getEventID() {
        return eventID;
    }

    public String getTime() {
        return time;
    }

    public String getEventName() {
        return eventName;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public int getDReq() {
        return dReq;
    }

    public boolean getTeamBased() {
        return teamBased;
    }

    public Events(String eventName, String organiserName, String location, String date, int dReq, boolean teamBased) {
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.location = location;
        this.date = date;
        this.dReq = dReq;
        this.teamBased = teamBased;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, int eventID) {

        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.eventID = eventID;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time, String description, int eventID) {
        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.description = description;
        this.eventID = eventID;
    }
}
