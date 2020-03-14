package com.example.demo.Tests;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.CreateEvent;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCs {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HttpSession session;

/*
    @org.junit.Test
    public void testCancelAttendingController() throws Exception {

        this.mockMvc.perform(post("/cancelAttending?eventId=1")).andDo(print()).andExpect(redirectedUrl("/viewEvents"));
    }*/

    @org.junit.Test
    public void testRegController() throws Exception {

        this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("registerTemplate"));
    }

    @org.junit.Test
    public void testRegController2() throws Exception {

        mockMvc.perform(get("/CreateEventPage")).andExpect(status().isOk()).andExpect(model().attribute("createEvent", instanceOf(CreateEvent.class)));
    }

    @org.junit.Test
    public void testAuthController() throws Exception {

        session.setAttribute("SESSION_USERNAME", "SadlerJM@cardiff.ac.uk");
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("redirect:/"));
    }

    @org.junit.Test
    public void testAuthController2() throws Exception {
        session.setAttribute("SESSION_USERNAME", null);
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("loginTemplate"));
    }
}



