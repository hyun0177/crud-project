package com.example.firstproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/First")
    public String NiceToMeetYou(Model model){
        model.addAttribute("username", "김현철");
        return "meeting";
    }
    @GetMapping("/bye")
    public String Bye(Model model){
        model.addAttribute("userID", "rnfh3ehd");
        return "bye";
    }
}
