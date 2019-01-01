package pl.coderslab.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.dtos.RegistrationFormDTO;
import pl.coderslab.app.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    RegistrationService registrationService;


    @GetMapping
    public String prepareRegistrationForm(Model model){
        model.addAttribute("registrationFormData", new RegistrationFormDTO());
        return "/registration";
    }

    @PostMapping
    public String register(@ModelAttribute("registrationFormData") @Valid RegistrationFormDTO formDTO,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/registration";
        }
        if(!checkPasswords(formDTO)){
            bindingResult.rejectValue("confirmedPassword", "", "Hasło i powtórzone hasło muszą być zgodne");
            return "/registration";
        }
        boolean isLoginUnique = registrationService.checkLogin(formDTO.getLogin());
        if(!isLoginUnique){
            bindingResult.rejectValue("login", "", "Login już zajęty");
            return "/registration";
        }
        boolean isEmailUnique = registrationService.checkEmail(formDTO.getEmail());
        if(!isEmailUnique){
            bindingResult.rejectValue("email", "", "Email już występuje w systemie");
            return "/registration";
        }
        registrationService.registerUser(formDTO);
        return "/registration-success";
    }

    private boolean checkPasswords(RegistrationFormDTO formDTO) {
        return formDTO.getPassword().equals(formDTO.getConfirmedPassword());
    }
}
