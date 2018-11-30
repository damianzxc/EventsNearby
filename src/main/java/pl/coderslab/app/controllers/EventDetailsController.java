package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

@Controller
public class EventDetailsController {


    @Autowired
    EventService eventService;


    @GetMapping("/details/{id}")
    public String getEventDetails(@PathVariable Long id, Model model){
        Event event = eventService.findOneById(id);
        model.addAttribute("eventDetails", event);
        return "event-details";
    }
}
