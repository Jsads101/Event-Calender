package com.example.demo.Data;


public class BookingStatus {
    private int bookingStatusId;
    private int peopleId;
    private int eventId;
    private int statusId;
    private String dietReq;

    public int getBookingStatusId(){
        return bookingStatusId;
    }

    public int getPeopleId(){
        return peopleId;
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


    public BookingStatus (int bookingStatusId, int peopleId, int eventId, int statusId, String dietReq){
        this.bookingStatusId = bookingStatusId;
        this.peopleId = peopleId;
        this.eventId = eventId;
        this.statusId = statusId;
        this.dietReq = dietReq;
    }

    public BookingStatus (int peopleId, String dietReq){
        this.peopleId = peopleId;
        this.dietReq = dietReq;
    }


}
