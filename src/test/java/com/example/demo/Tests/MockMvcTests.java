package com.example.demo.Tests;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class MockMvcTests {

    @Autowired
    private MockMvc mockMvc;


    // Unit tests using a mock MVC

    /*
    @org.junit.Test
    public void testViewEvent() throws Exception {

        this.mockMvc.perform(get("/cancelAttending?eventId=1")).andDo(print()).andExpect(redirectedUrl("/viewEvents.html"));
    }

    @org.junit.Test
    public void testReturnReviews2() throws Exception {
        this.mockMvc.perform(get("/viewEvents?eventId=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Office")));
    }


    @org.junit.Test
    public void testReview3() throws Exception {

        this.mockMvc.perform(get("/addReview?resource='Book'?topic='CSS'?review='Bad'")).andDo(print()).andExpect(redirectedUrl("/ReviewPage.html"));
    }


    @org.junit.Test
    public void testController1() throws Exception {

        this.mockMvc.perform(get("/reviews3?topic=CSS")).andDo(print()).andExpect(status().isOk()).andExpect(model().attributeExists("reviewList"));
    }



    //Component Test Using Test Databasde
    @org.junit.Test
    public void testReturnReviews() throws Exception {
        this.mockMvc.perform(get("/reviews3?topic=CSS")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Rubbish")));
    }

    //Component Test Using Test Databasde
    @org.junit.Test
    public void testReturnReviews2() throws Exception {
        this.mockMvc.perform(get("/reviews3?topic=HTML")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Amazing")));
    } */

}

