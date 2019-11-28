package com.example.demo.Controllers;

import com.example.demo.Data.CreateEvent;
import com.example.demo.Data.CreateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateEventController {
    private CreateEventRepo repo;

    /*
    Constructor instructs Spring to inject a dependency (see slides + online documentation)
    In this case a TVShowRepository object so that we can use it in response to requests.
    */
    @Autowired
    public CreateEventController(CreateEventRepo r) {
        repo = r;
    }

    /*
    GET HTTP request handler
    */
//    @GetMapping(path = "/tvshows")
//    @ResponseBody
//    public Object getAllShows() {
//        /*
//        Use TVShowRepository's findall method (see TVShowRepository.java)
//        to retrieve all TVShow data as a list of TVShow objects.
//
//        Loop over these to create another list of just the titles
//        */
//        List<TVShow> shows = repo.findAll();
//
//        List<String> showNames = new ArrayList<>(shows.size());
//        for (TVShow show : shows)
//            showNames.add(show.getTitle());
//
//        return showNames.toString();
//        //return showNames; //extra: change to @RestController, remove @ResponseBody
//        //return shows; //extra: change to @RestController, remove @ResponseBody
//    }

    /*
    GET HTTP request handler, expects a parameter with that matches the name
    of a TVShow in the database
    */
//    @GetMapping(path = "/numberOfSeasons")
//    @ResponseBody
//    public Object getNumberOfSeasons(@RequestParam String title) {
//        /*
//        Use TVShowRepository's findByTitle method (see TVShowRepository.java)
//        to retrieve TVShow data where the title matches what was sent by
//        the client as a list of TVShow objects. Size should be 1 if it exists,
//        but more than one could exist if the database allows.
//         */
//        List<TVShow> show = repo.findByTitle(title);
//
//        if (show.size() == 0)
//            return "Unknown";
//        else
//            return show.get(0).getNum_seasons();
//    }

    /*
    GET HTTP request handler that expects 2 parameters a tv show title and the
    number of seasons.
    */
//    @GetMapping(path = "/addTVShow")
//    @ResponseBody
//    public String addTVShow(@RequestParam String title, @RequestParam int num_seasons) {
//        /*
//        Create a new TVShow object from the request parameters.
//        Use the repository to add it to the database.
//        Return the response from the Repository (1 = success).
//
//        Note that we could add more logic here, such as checking if the
//        TV Show already exists in the database.
//        */
//        TVShow show = new TVShow(title, num_seasons);
//        return String.valueOf(repo.addShow(show));
//    }

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
    public ModelAndView registerUserAccount(@ModelAttribute("createEvent") CreateEvent createEvent) {
        ModelAndView mv = new ModelAndView("CreateEventPage");
        mv.addObject("createEvent", createEvent);

//        List<String> errors = new ArrayList<>(0);

        String submittedEventTitle = createEvent.getEventTitle();
//        String submittedPassword = user.getPassword();
//        String submittedCPassword = user.getCpassword();

        //New event was successfully added
        return new ModelAndView("redirect:/viewEvents");
    }
}
