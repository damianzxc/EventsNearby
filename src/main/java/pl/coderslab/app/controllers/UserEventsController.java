package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;
import pl.coderslab.app.services.UserService;

import java.util.List;

@Controller
public class UserEventsController {

    @Autowired
    EventService eventService;

    @GetMapping("/userEvents")
    public String getUserEvents(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser){
        if(loggedUser != null){
            List<Event> events = eventService.findEventsByUserId(loggedUser.getId());
            model.addAttribute("userEvents", events);
            return "events-by-user";
        }
        return "redirect:/login";
    }


}
