package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

import java.util.List;

@Controller
public class EventsListController {


    @Autowired
    private EventService eventService;

    @GetMapping("/{categoryId}")
    public String getEventsByCategory(@PathVariable Long categoryId, Model model){
        List<Event> events = eventService.findEventsByCategoryId(categoryId);
        model.addAttribute("eventsByCategory", events);
        return "events-by-category";
    }

}
