package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.services.UserService;

@Controller
public class UserActivationController {

    @Autowired
    UserService userService;

    private String message = "Konto aktywowano...";

    @GetMapping("/activate/{code}")
    public String activateAccount(@PathVariable String code, Model model) {
        userService.updateUserActivation(code);
        //model.addAttribute("message", message);
        return "activation-success";
    }
}
