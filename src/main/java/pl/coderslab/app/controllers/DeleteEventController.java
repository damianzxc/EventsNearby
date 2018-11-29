package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.EventService;

@Controller
public class DeleteEventController {

    @Autowired
    EventService eventService;

    @GetMapping("/delete/{id:[0-9]+}")
    public String deleteEvent(@SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser,
                              @PathVariable Long id){
        if(loggedUser != null){
            Event event = eventService.findOneById(id);
            if(event.getUser().getId() == loggedUser.getId()){
                eventService.deleteEvent(id);
            }
        }
        return "redirect:/userEvents";
    }
}
