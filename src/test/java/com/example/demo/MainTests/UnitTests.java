package com.example.demo.MainTests;

import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.CreateEvent;
import com.example.demo.auth.base.BaseController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UnitTests {

    private BaseController baseController;
    private HttpSession session;


    /*This test will pass if the ModelandView object returned by the home() method in the
Base Controller is not empty when the method is called */

    @org.junit.Test
    public void whenMethodIsCalledObjectIsNotEmpty() {
        baseController = new BaseController();
        ModelAndView result = baseController.home(session);
        assertEquals(result.isEmpty(), false);
    }

    //This test will pass if the correct View is set by the home() method

     @org.junit.Test
    public void whenMethodIsCalledCorrectViewIsSet() {
        baseController = new BaseController();
        String result = baseController.home(session).getViewName();
        assertEquals(result, "loginTemplate");
    }

    //This test will pass if the correct String is returned and therefore the user is redirected correctly to the eventpage.
    @org.junit.Test
    public void whenEventPageMethodRunsUserIsRedirectedToEventPage(){
        baseController = new BaseController();
        String result = baseController.eventPage();
        assertEquals(result, "eventPage");
    }

    @org.junit.Test
    public void testGetEventId(){
        CreateEvent testCreateEvent  = new CreateEvent("Party", "Fun", "office", "7pm", 1, 1, 1);
        assertEquals("Party", testCreateEvent.getEventTitle());
    }

}



