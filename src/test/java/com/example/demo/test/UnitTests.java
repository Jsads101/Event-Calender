package com.example.demo.test;
import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.Events;
import com.example.demo.Data.PTeam;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UnitTests {


    @org.junit.Test
    public void testCreateEventGetters(){
        CreateEvent testCreateEvent  = new CreateEvent("Party", "Xmas Party. Black Tie", "office", "7pm", 1, 3, 1);
        assertEquals("Party", testCreateEvent.getEventTitle());
        assertEquals("Xmas Party. Black Tie", testCreateEvent.getEventDesc());
        assertEquals("office", testCreateEvent.getLocation());
        assertEquals("7pm", testCreateEvent.getEventTime());
        assertEquals(1, testCreateEvent.getDietaryReq());
        assertEquals(1, testCreateEvent.getTeamBased());
        assertEquals(3, testCreateEvent.getTeamSize());
    }

    @org.junit.Test
    public void testCreateEventSetters(){
        CreateEvent testCreateEvent  = new CreateEvent();
        String a = "Summer Party";
        String b = "office";
        String c = "8pm";
        testCreateEvent.setEventTitle(a);
        testCreateEvent.setLocation(b);
        testCreateEvent.setEventTime(c);
        assertEquals(a, testCreateEvent.getEventTitle());
        assertEquals(b, testCreateEvent.getLocation());
        assertEquals(c, testCreateEvent.getEventTime());
    }


    @org.junit.Test
    public void testBookingStatusGetters(){
        PTeam testPTeam  = new PTeam(1,1);
        assertEquals(1, testPTeam.getPersonId());
        assertEquals(1, testPTeam.getTeamId());
    }


    @org.junit.Test
    public void testEventGetters(){
        Events testEvents  = new Events("Party", "office", "21.12.2020", "7pm", 1);
        assertEquals("Party", testEvents.getEventName());
        assertEquals("office", testEvents.getLocation());
        assertEquals("7pm", testEvents.getTime());
        assertEquals("21.12.2020", testEvents.getDate());
        assertEquals(1, testEvents.getEventID());
    }




}



