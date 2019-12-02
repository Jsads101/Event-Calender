package com.example.demo.Controllers;

import com.example.demo.Data.DeleteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeleteController {

    private DeleteRepo repo;

    @Autowired
    public DeleteController (DeleteRepo repo){
        this.repo = repo;
    }


    @PostMapping("/delete")
    public String delete(@RequestParam int eventId) {
        repo.delete(eventId);
        return "redirect:/viewEvents";
    }



}
