package com.example.demo.Data;

public class BookingStatus {
    private int bsId;
    private int personId;
    private int eventId;
    private int statusId;
    private String dietReq;

    public int getBsId(){
        return bsId;
    }

    public int getPersonId(){
        return personId;
    }

    public int getEventId(){
        return eventId;
    }

    public int getStatusId(){
        return statusId;
    }

    public String getDietReq(){
        return dietReq;
    }


    public BookingStatus (int bsId, int personId, int eventId, int statusId, String dietReq){
        this.bsId = bsId;
        this.personId = personId;
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
    }

    public BookingStatus (int personId, String dietReq){
        this.personId = personId;
        this.dietReq = dietReq;
    }


}
