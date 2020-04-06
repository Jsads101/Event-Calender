package com.example.demo.test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.demo.Data.CreateEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import javax.servlet.http.HttpSession;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCs {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HttpSession session;


//UNIT TESTS USING MOCKMVC

    @org.junit.Test
    public void testRegController() throws Exception {

        this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("registerTemplate"));
    }


    @org.junit.Test
    public void testRegController2() throws Exception {

        mockMvc.perform(get("/CreateEventPage")).andExpect(status().isOk()).andExpect(model().attribute("createEvent", instanceOf(CreateEvent.class)));
    }


    @org.junit.Test
    public void testAuthController2() throws Exception {
        session.setAttribute("SESSION_USERNAME", null);
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("loginTemplate"));
    }


    @org.junit.Test
    public void testViewSpecificEventController() throws Exception {

        this.mockMvc.perform(get("/viewSpecificEvent?eventId=1")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("eventPage")).andExpect((model().attributeExists("myEvent")));
    }


    @org.junit.Test
    public void testViewEventsController() throws Exception {

        this.mockMvc.perform(get("/viewEvents")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("viewEvents")).andExpect((model().attributeExists("myEvent")));
    }


    @org.junit.Test
    public void testGetEventAttendeesController() throws Exception {

        this.mockMvc.perform(get("/searchMyEvents?eventId=1")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("returnMyAttendees")).andExpect((model().attributeExists("myEvent"))).andExpect((model().attributeExists("myPeople")));
    }

//COMPONENT TESTS USING MOCK MVC AND H2 DATABASE


    //The viewEvents controller returns a list of events. Default parameter for viewEvents is 1 which is
    //all upcoming events. Upcoming events in h2 are Harry Potter Marathon, Summer Party and Autumn Party -
    // this test tests for the presence of all three in the contents returned.

    @Test
    public void testViewEventsControllerReturnsUpcomingEvents() throws Exception {
        this.mockMvc.perform(get("/viewEvents")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Harry Potter"))).andExpect(content().string(containsString("Summer Party"))).andExpect(content().string(containsString("Autumn Party")));
    }

    //The viewEvents controller returns a list of events in the database. Parameter for viewEvents is 3 which is
    //all previous events. Previous event in h2 is Xmas Party - this test tests for the presence of this in
    // contents returned.
    @Test
    public void testViewEventsControllerReturnsPreviousEvent() throws Exception {
        this.mockMvc.perform(get("/viewEvents?selectSQL=3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Xmas Party")));
    }

    //The viewSpecificEventController returns info about a specific event (identified by parameter)
    //This test checks if the right event is returned i.e.the correct title is present in contents.
    @Test
    public void testViewSpecificEventReturnsRightObjectPropertyValues() throws Exception {
        this.mockMvc.perform(get("/viewSpecificEvent?eventId=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Harry Potter Marathon")));
    }


    // The /searchMyEvents controller returns the event object and a list of attendees for the event identified by the parameter.
    // This tests whether the controller returns a string containing the correct event title "Summer Party"
    // and the string "Jenny" as that is the person in the database attending the event where eventID = 3
    @Test
    public void testSearchMyEventsController() throws Exception {
        this.mockMvc.perform(get("/searchMyEvents?eventId=3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Summer Party"))).andExpect(content().string(containsString("Jenny")));
    }
}