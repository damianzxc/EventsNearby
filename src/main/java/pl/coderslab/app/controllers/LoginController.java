package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.app.dtos.LoginFormDTO;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.services.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {


    public static final String LOGGED_USER_KEY = "logged-key";


    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String prepareLoginForm(Model model){
        model.addAttribute("loginFormData", new LoginFormDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginFormData") @Valid LoginFormDTO form,
                        BindingResult bindingResult, HttpSession session) {

        if(bindingResult.hasErrors()){
            return "/login";
        }

        UserDTO user = loginService.login(form.getLogin(), form.getPassword());
        if(user == null) {
            bindingResult.rejectValue("login", "", "Login lub hasło niepoprawne");
            return "/login";
        }

        session.setAttribute(LOGGED_USER_KEY, user);
        return "redirect:/create";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/events";
    }
}
