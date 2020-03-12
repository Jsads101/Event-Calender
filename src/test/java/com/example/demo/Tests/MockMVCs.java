package com.example.demo.Tests;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCs {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    HttpSession session;


    // Unit tests using a mock MVC

    @org.junit.Test
    public void testCancelAttendingController() throws Exception {

        this.mockMvc.perform(post("/cancelAttending?eventId=1")).andDo(print()).andExpect(status().isOk()).andExpect(redirectedUrl("/viewEvents"));
    }

    @org.junit.Test
    public void testRegController() throws Exception {

        this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk()).andExpect(view().name("registerTemplate"));
    }




}

