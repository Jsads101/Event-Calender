package com.example.demo.Data;

public class Event {

    private int eventID;
    private String eventName;
    private String organiserName;
    private String location;
    private String date;
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

    public Event (String eventName, String organiserName, String location, String date, boolean dReq, boolean teamBased){
        this.eventName = eventName;
        this.organiserName = organiserName;
        this.location = location;
        this.date = date;
        this.dReq = dReq;
        this.teamBased = teamBased;
    }

}
