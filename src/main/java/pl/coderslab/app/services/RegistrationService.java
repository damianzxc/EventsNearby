package pl.coderslab.app.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dtos.RegistrationFormDTO;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.UserRepository;

@Service
@Transactional
public class RegistrationService {


    @Autowired
    UserRepository userRepository;


    public boolean checkLogin(String login) {
        if(login == null || login.isEmpty()){
            return false;
        }
        User user = userRepository.findByLogin(login);
        return user == null;
    }

    public boolean checkEmail(String email) {
        if(email == null || email.isEmpty()){
            return false;
        }
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    public void registerUser(RegistrationFormDTO formDTO) {
        User user = new User();
        user.setLogin(formDTO.getLogin());
        user.setEmail(formDTO.getEmail());
        user.setPassword(formDTO.getPassword());
        user.setActivationCode("1234");
        userRepository.save(user);
    }
}
