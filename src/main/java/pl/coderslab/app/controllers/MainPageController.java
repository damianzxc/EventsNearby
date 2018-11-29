package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dtos.SearchFormDTO;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    EventService eventService;

    @GetMapping("/events")
    public String getMainPage(){
        return "main-page";
    }

    @ModelAttribute("eventList")
    public List<Event> events(){
        return eventService.findAllOrderByEndDate();
    }


}
