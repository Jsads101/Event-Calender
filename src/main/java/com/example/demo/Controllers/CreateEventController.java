package com.example.demo.Controllers;

import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.CreateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CreateEventController{
    private CreateEventRepo repo;

    @Autowired
    public CreateEventController(CreateEventRepo r) {
        repo = r;
    }

    /*
    GET HTTP request handler, equivalent to the above that uses the alternative addShow2 method
    */
//    @GetMapping(path = "/CreateEventPage")
//    @ResponseBody
//    public String addEvent(@RequestParam String eventTitle, @RequestParam String eventDesc, @RequestParam String location,
//                                @RequestParam Time eventTime, @RequestParam Date eventDate) {
//        CreateEvent event = new CreateEvent(eventTitle, eventDesc, location, eventTime, eventDate);
//        return String.valueOf(repo.addEvent(event));
//    }

    @PostMapping("/eventcreation")
    public ModelAndView newEvent(@ModelAttribute("createEvent") CreateEvent createEvent, @ModelAttribute("attendees") CreateEvent attendees) {
//        ModelAndView mv = new ModelAndView("CreateEventPage");
//        mv.addObject("createEvent", createEvent);

        repo.addEvent(createEvent);
        repo.addAttendees(attendees);

        //New event was successfully added
        return new ModelAndView("redirect:/viewEvents");
    }


//@RequestMapping(value = "/invite", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    String Submit(@RequestParam("name") String name) {
//        return name;
//    }

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    @ResponseBody
    public String addAttendees(@RequestBody CreateEvent attendees) {
        repo.addAttendees(attendees); //Should I be doing this here?
        return attendees.getTokenField();
    }
}


