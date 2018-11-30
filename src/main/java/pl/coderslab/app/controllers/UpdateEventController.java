package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.services.CategoryService;
import pl.coderslab.app.services.EventService;

import java.util.List;

@Controller
public class UpdateEventController {


    @Autowired
    EventService eventService;

    @Autowired
    CategoryService categoryService;


    @ModelAttribute("categoryList")
    public List<Category> categories(){
        return categoryService.getAll();
    }


    @GetMapping("/edit/{id:[0-9]+}")
    public String editEventForm(@SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser,
                                @PathVariable Long id, Model model){
        if(loggedUser != null){
            Event event = eventService.findOneById(id);
            if(event.getUser().getId() == loggedUser.getId()){
                model.addAttribute("eventUpdateForm", event);
                return "event-update-form";
            }
        }
        return "redirect:/login";
    }
}
