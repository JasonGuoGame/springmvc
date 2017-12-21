package com.helloword.web;

import com.helloword.entity.Person;
import com.helloword.dto.UserDTO;
import com.helloword.service.HelloWorldService;

import java.util.List;
import java.util.Map;

import com.helloword.service.PersonService;
import com.helloword.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by scnyig on 11/20/2017.
 */
@Controller
public class WelcomeController {
    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;
    @Autowired
    public WelcomeController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        logger.debug("index() is executed!");

        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());
        List<Person> persons = personService.listPersons();
        UserDTO userByEmail = userService.findUserByEmail("yin.guo@sas.com");
        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        logger.debug("hello() is executed - $name {}", name);

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("title", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());

        return model;

    }

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }
}
