package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.app.services.UserService;

@Controller
public class UserActivationController {


    @Autowired
    UserService userService;


    @GetMapping("/activatelink/{code}")
    public String activateAccount(@PathVariable String code) {
        userService.updateUserActivation(code);
        return "activation-success";
    }
}
