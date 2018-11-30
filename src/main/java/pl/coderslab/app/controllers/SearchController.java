package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

import java.util.List;

@Controller
public class SearchController {


    @Autowired
    EventService eventService;


    @PostMapping("/search")
    public String findEvents(@RequestParam("search") String search, Model model){
        List<Event> events = eventService.findByName(search);
        model.addAttribute("eventsBySearch", events);
        return "events-by-search";
    }
}
