package com.example.demo.Data;

import com.example.demo.Controllers.CreateEventController;
import org.springframework.beans.factory.annotation.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.script.*;

public class CreateEvent {
    private String eventTitle;
    private String eventDesc;
    private String location;
    private String eventTime;
    private Date eventDate;
//    @Value("#{$('#tokenfield-2').tokenfield('getTokensList')}")
    private String tokenField;
    public static void main(String[] args){
        CreateEvent e = new CreateEvent();
        System.out.println(e.getTokenField());
        System.out.println(e.tokenField);
    }

//    List<String> items = Arrays.asList(tokenField.split("\\s*,\\s*"));





    public CreateEvent(){}

    public CreateEvent(String eventTitle, String eventDesc, String location, String eventTime, Date eventDate, String tokenField){
        this.eventTitle = eventTitle;
        this.eventDesc = eventDesc;
        this.location = location;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.tokenField = tokenField;
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

    public String getTokenField(){
        return tokenField;
    }
    public void setTokenField(String tokenField){
        this.tokenField = ("#{$('#tokenfield-2').tokenfield('getTokensList')}");
    }
}
