package com.healthcare.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    
    @GetMapping("*")
    public String redirectToIndex() {
        return "redirect:/";
    }
}
