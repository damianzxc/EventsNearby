package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

import java.util.List;

@Controller
@RequestMapping(value = "events", produces = "text/html;charset=UTF-8")
public class MainPageController {


    @Autowired
    EventService eventService;

    @GetMapping
    public String getMainPage(){
        return "main-page";
    }

    @ModelAttribute("eventList")
    public List<Event> events(){
        return eventService.findAllOrderByEndDate();
    }
}
