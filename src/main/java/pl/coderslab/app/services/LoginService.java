package pl.coderslab.app.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dtos.UserDTO;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.UserRepository;

@Service
@Transactional
public class LoginService {

    @Autowired
    UserRepository userRepository;


    public UserDTO login(String login, String password) {
        if(login == null || login.isEmpty()){
            return null;
        }
        if(password == null || password.isEmpty()){
            return null;
        }
        User user = userRepository.findActiveUserByLogin(login);
        if(!BCrypt.checkpw(password, user.getPassword())) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(login);
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
