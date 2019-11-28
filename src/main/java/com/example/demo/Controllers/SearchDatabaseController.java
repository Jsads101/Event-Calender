package com.example.demo.Controllers;
import com.example.demo.Data.Events;
import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.SearchDatabaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
            ModelAndView mv = new ModelAndView("returnMyEventAttendees");
            List<BookingStatus> myPeople = repo.findByEvent(eventId);
            List<Events> myEvent = repo.showByEventId(eventId);
            mv.addObject("myEvent", myEvent);
            mv.addObject("myPeople", myPeople);
            return mv;
        }

        @GetMapping("/viewSpecificEvent")
        public ModelAndView viewSpecificEvent(@RequestParam int eventId) {
            ModelAndView mv = new ModelAndView("eventPage");
            List<Events> myEvent = repo.showByEventId(eventId);
            mv.addObject("myEvent", myEvent);
            return mv;
        }

    }