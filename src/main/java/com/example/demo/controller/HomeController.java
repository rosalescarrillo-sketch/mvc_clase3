package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.TripService;

@Controller
public class HomeController {

    @Autowired
    private TripService tripService;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("tripsLocales", tripService.findByTipo("LOCAL"));
        model.addAttribute("tripsInternacionales", tripService.findByTipo("INTERNACIONAL"));
        return "home";
    }
}