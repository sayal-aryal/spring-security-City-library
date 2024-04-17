package edu.miu.cs.cs489.lesson9.citylibrarywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/citylibrary"})
public class HomeController {

    @GetMapping(value = {"", "/home", "/public/home"})
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = { "/about", "/public/about"})
    public String displayAboutpage() {
        return "public/about";
    }

}
