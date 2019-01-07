package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.model.Category;
import pl.coderslab.app.model.Event;
import pl.coderslab.app.model.User;
import pl.coderslab.app.services.CategoryService;
import pl.coderslab.app.services.EventService;
import pl.coderslab.app.services.PhotoLoadService;
import pl.coderslab.app.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EventFormController {


    @Autowired
    private EventService eventService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    PhotoLoadService photoLoadService;

    @Autowired
    UserService userService;


    @GetMapping("/create")
    public String prepareEventCreationForm(Model model, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser){
        if(loggedUser != null){
            model.addAttribute("eventCreationForm", new Event());
            return "/event-add-photo";
        }
        return "redirect:/login";
    }

    @PostMapping("/create")
    public String addNewEvent(@ModelAttribute("eventCreationForm") @Valid Event event,
                              BindingResult bindingResult,
                              @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser,
                              @Param("image") MultipartFile file,
                              HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "event-add-photo";
        }
        if(!eventService.checkEndDate(event)){
            bindingResult.rejectValue("endDate","", "Data musi być w przyszłości");
            return "event-add-photo";
        }
        if(!eventService.checkDates(event)){
            bindingResult.rejectValue("startDate", "", "Niepoprawne daty ");
            return "event-add-photo";
        }
        saveEventWithPhoto(event, loggedUser, file, request);
        return "redirect:/events";
    }

    private void saveEventWithPhoto(@Valid @ModelAttribute("eventCreationForm") Event event, @SessionAttribute(value = LoginController.LOGGED_USER_KEY, required = false) UserDTO loggedUser, @Param("image") MultipartFile file, HttpServletRequest request) {
        String photoPath = "";
        if(file != null){
            photoPath = photoLoadService.uploadFile(file, request);
        }
        User user = userService.findById(loggedUser.getId());
        event.setUser(user);
        event.setPhotoURL(photoPath);
        eventService.addEvent(event);
    }


    @ModelAttribute("categoryList")
    public List<Category> categories(){
        return categoryService.getAll();
    }
}
