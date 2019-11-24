package com.example.demo.Controllers;

import com.example.demo.Data.BookingStatus;
import com.example.demo.Data.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class SignUpController {

//    public static final String SESSION_NOTES_KEY = "SESSION_NOTES";
    private SignUpRepo repo;

    @Autowired
    public SignUpController(SignUpRepo repo){
        this.repo = repo;
    }

    @GetMapping("/signUp")
    public String addReview(@RequestParam int peopleId, int eventId, int statusId, String dietReq){

        BookingStatus newSignUp = new BookingStatus(peopleId, eventId, statusId, dietReq);
        repo.signUp(newSignUp);
        return "redirect:/viewEvents.html";
    }
}
