package com.example.demo.Data;

public class Events {

    private int eventID;
    private String eventName;
    private String organiserName;
    private String location;
    private String date;
    private String time;
    private boolean dReq;
    private boolean teamBased;

    public int getEventID (){
        return eventID;
    }

    public String getEventName(){
        return eventName;
    }

    public String getOrganiserName(){
        return organiserName;
    }

    public String getLocation(){
        return location;
    }

    public String getDate(){
        return date;
    }

    public boolean getDReq(){
        return dReq;
    }

    public boolean getTeamBased(){
        return teamBased;
    }

    public Events(String eventName, String organiserName, String location, String date, boolean dReq, boolean teamBased){
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.location = location;
        this.date = date;
        this.dReq = dReq;
        this.teamBased = teamBased;
    }

    public Events(String eventName, String organiserFN, String organiserSN, String location, String date, String time,int eventID) {

        this.eventName = eventName;
        this.organiserName = organiserFN + " " + organiserSN;
        this.location = location;
        this.date = date;
        this.time = time;
        this.eventID = eventID;
    }

}
