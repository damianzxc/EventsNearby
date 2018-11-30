package pl.coderslab.app.dtos;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class RegistrationFormDTO {

    @NotBlank
    @NotNull(message = "Login musi zostać podany")
    @Size(min = 3, max = 12, message = "Login musi zawierać od 3 do 12 znaków")
    private String login;

    @Email(message = "Niepoprawny format email")
    private String email;

    @NotBlank(message = "Hasło musi zostać podane")
    @NotNull(message = "Hasło musi zostać podane")
    private String password;

    @NotBlank(message = "Powtórzone hasło musi być podane")
    @NotNull(message = "Powtórzone hasło musi być podane")
    private String confirmedPassword;

    @Override
    public String toString() {
        return "RegistrationFormDTO{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationFormDTO that = (RegistrationFormDTO) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmedPassword, that.confirmedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, password, confirmedPassword);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
