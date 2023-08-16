package com.springboot.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/home")
//    @RequestMapping(value = "/home", method = RequestMethod.GET) too long
    public String home(Model model) {
        model.addAttribute("content", "success");
        return "home";
    }
}
