package com.helloword.web;

/**
 * Created by scnyig on 12/19/2017.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.BeanProperty;
import com.helloword.entity.Person;
import com.helloword.dto.UserDTO;
import com.helloword.entity.User;
import com.helloword.security.SecurityService;
import com.helloword.service.PersonService;
import com.helloword.service.UserService;
import com.helloword.service.UserServiceImpl;
import com.helloword.validator.UserValidator;
import org.hibernate.internal.util.beans.BeanInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout){

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserDTO user = new UserDTO();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /*@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserDTO user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            UserDTO user1 = userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", user1);
            modelAndView.setViewName("welcome");

        }
        return modelAndView;
    }*/

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("user") UserDTO user) {
        Person person = new Person();
        person.setLastName(user.getName());
        person.setEmail(user.getEmail());
        person.setFirstName(user.getName());
        personService.add(person);
        userService.saveUser(user);
        return new ModelAndView("welcome", "lastName", user.getUserName());
    }

    @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") UserDTO login) {
        ModelAndView mav = null;
        UserDTO user = userService.findUserByEmail(login.getName());
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("name", user.getName());
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }

    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO user = userService.findByName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") UserDTO userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.saveUser(userForm);

        securityService.autologin(userForm.getUserName(), userForm.getPassword());

        return "redirect:/welcome";
    }
}
