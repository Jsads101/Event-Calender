package com.example.demo.Controllers;

import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.SearchDatabaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


    @RestController
    public class SearchDatabaseController {

        private SearchDatabaseRepo repo;

        @Autowired
        public SearchDatabaseController (SearchDatabaseRepo repo) {
            this.repo = repo;
        }

        @GetMapping("/searchMyEvents")
        public ModelAndView getEventAttendees(@RequestParam int eventId) {
            ModelAndView mv = new ModelAndView("returnMyAttendees");
            List<BookingStatus> myPeople = repo.findByEvent(eventId);
            mv.addObject("myPeople", myPeople);
            return mv;
        }

       /* @GetMapping("/searchMyEvents")
        public Object searchMyEvents(@RequestParam int eventId) {

            List<BookingStatus> myAttendees= repo.findByEvent(eventId);

            return myAttendees;
        }*/

    }

