package com.example.demo.Controllers;
import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class SignUpController {

    private SignUpRepo repo;

    @Autowired
    public SignUpController (SignUpRepo repo){
        this.repo = repo;
    }


    @GetMapping("/signUp")

    public String addReview(@RequestParam int eventId, int statusId, String dietReq, String teamMembers) {

        BookingStatus newSignUp = new BookingStatus(eventId, statusId, dietReq, teamMembers);
        repo.signUp(newSignUp);
        return "redirect:/viewEvents";
    }

    @GetMapping(path = {"/greeting", "greeting/{name}"})
    public String greeting(@PathVariable Optional<String> name) {
        if (name.isPresent()){
            return "Hello "+name.get();
        } else {
            return "Hello Guest";
        }
    }



}