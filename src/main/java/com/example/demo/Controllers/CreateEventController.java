package com.example.demo.Controllers;

import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.CreateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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

    @PostMapping("/CreateEventPage")
    @ResponseBody
    public String greetingSubmit(@ModelAttribute CreateEvent event) {
        System.out.println("!!!!!!!!!");
        System.out.println(event);
        System.out.println(event.getTokenField());

        return "TEST";
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
//        repo.addAttendees(attendees);

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
    public String addAttendees(@ModelAttribute("createEvent") CreateEvent createEvent) {
        System.out.println("!!!!!!!!!");
        System.out.println(createEvent);


//        repo.addAttendees(attendees); //Should I be doing this here?
        return "TEST";//attendees.getTokenField(); //Am I really getting my emails here?
        //There was an unexpected error (type=Bad Request, status=400).
        //Validation failed for object='createEvent'. Error count: 1
    }

//    @RequestMapping(value = "/invite", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody String create(@RequestParam("invitedJSON") CreateEvent attendees) {
//        return attendees.getTokenField();
//    }
}


