package com.example.demo.Controllers;

import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.CreateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class CreateEventController{
    private CreateEventRepo repo;

    @Autowired
    public CreateEventController(CreateEventRepo r) {
        repo = r;
    }

    @GetMapping("/CreateEventPage")
    public String createEventPage(Model model) {
        model.addAttribute("createEvent", new CreateEvent());

        return "CreateEventPage"; //CreateEventsPage.html page name to open it
    }

    @PostMapping("/eventCreation")
    public String greetingSubmit(@ModelAttribute CreateEvent event) {
        repo.addEvent(event);
        repo.setEventID(event);
        repo.addAttendees(event);

        return "redirect:/viewSpecificEvent?eventId="+String.valueOf(event.getEventId());
    }


    /*@PostMapping("/eventcreation")
    public ModelAndView newEvent(@ModelAttribute("createEvent") CreateEvent createEvent, @ModelAttribute("attendees") CreateEvent attendees) {

        repo.addEvent(createEvent);

        return new ModelAndView("redirect:/viewSpecificEvent?eventId=repo.getEventID(createEvent)");
    }*/

}

