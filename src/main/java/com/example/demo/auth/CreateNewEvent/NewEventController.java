//package com.example.demo.auth.CreateNewEvent;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class NewEventController {
//
//        /*
//        Constants used for error messages
//        */
//        private static final String REG_ERROR_NULLS = "Form was incomplete";
//        private static final String REG_ERROR_UNKNOWN_ERROR = "Unknown Error";
//
//        private NewEventRepository repo;
//
//        @Autowired
//        public NewEventController(NewEventRepository r) {
//            repo = r;
//        }
//
//        @GetMapping("/CreateNewEvent")
//        public ModelAndView CreateNewEvent(HttpSession session) {
//
//        /* If a session attribute SESSION_USERNAME is set then redirect
//        the user to the homepage. This session attribute is set on
//        successful login, so access to the register page after which should
//        not be possible
//        */
//
//            //Use registerTemplate.html as the template to use
//            ModelAndView mv = new ModelAndView();
//            mv.setViewName("CreateEventPage");
//
//            //Create an empty user object and attach to the model
//            NewEvent e = new NewEvent();
//            mv.addObject("event", e);
//
//            return mv;
//        }
//
//        /*
//        Attempt to register a new user based on what was submitted in the form
//        on the register page
//        */
//        @PostMapping("/registration")
//        public ModelAndView registerUserAccount(@ModelAttribute("event") NewEvent newEvent) {
//            ModelAndView mv = new ModelAndView("CreateEventPage");
//            mv.addObject("event", newEvent);
//
//            List<String> errors = new ArrayList<>(0);
//
//            String submittedEventTitle = newEvent.getEventTitle();
//            String submittedEventDesc = newEvent.getEventDesc();
//            LocalTime submittedEventTime = newEvent.getEventTime();
//            LocalDate submittedEventDate = newEvent.getEventDate();
//            String submittedEventAttendees = newEvent.getAttendees();
//
//        /* Used for debugging
//        System.out.println("------");
//        System.out.println(submittedUsername);
//        System.out.println(submittedPassword);
//        System.out.println(submittedCPassword);
//        System.out.println("------");
//        */
//
//            // BASIC FORM VALIDATION
////            if (submittedUsername.isEmpty() || submittedPassword.isEmpty() || submittedCPassword.isEmpty())
////                errors.add(REG_ERROR_NULLS);
////            if (!submittedPassword.equals(submittedCPassword))
////                errors.add(REG_ERROR_PASSWORD_MISMATCH);
//
//            if (errors.size() > 0) {
//                mv.addObject("errors", errors);
//                return mv;
//            }
//
//        /*
//            If the form is filled in correctly, move on to other
//            potential errors.
//        */
//
//            boolean success = repo.addEvent(newEvent);
//            if (!success) {
//                errors.add(REG_ERROR_UNKNOWN_ERROR);
//                mv.addObject("errors", errors);
//                return mv;
//            } else {
//                //User does not exist and was added to the database successfully.
//                //Direct the user to now homepage
//                return new ModelAndView("redirect:/viewEvents");
//            }
//        }
//}
