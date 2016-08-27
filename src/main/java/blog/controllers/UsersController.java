package blog.controllers;

import blog.forms.LoginForm;
import blog.forms.RegisterForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        if (!userService.authenticate(loginForm.getUsername(),loginForm.getPassword())){
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }
        //TO DO
        notifyService.addInfoMessage("Login successful.");
        return "redirect:/";
    }

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        if (!userService.registerValidation(
                registerForm.getUsername())) {
            notifyService.addErrorMessage("Invalid registration!");
            return "users/register";
        }
        //TO DO
        notifyService.addInfoMessage("Registration successful");
        return "redirect:/";
    }

    @RequestMapping("/users/logout")
    public String logout() {
        //TO DO
        return "redirect:/";
    }
}





