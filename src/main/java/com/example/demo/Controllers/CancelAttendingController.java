package com.example.demo.Controllers;

import com.example.demo.Data.CancelAttendingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CancelAttendingController {

    private CancelAttendingRepo repo;

    @Autowired
    public CancelAttendingController(CancelAttendingRepo repo){
        this.repo = repo;
    }


    @PostMapping("/cancelAttending")

    public String cancelAttending(@RequestParam int eventId) {

        repo.cancelAttending(eventId);
        return "redirect:/viewEvents";
    }

}