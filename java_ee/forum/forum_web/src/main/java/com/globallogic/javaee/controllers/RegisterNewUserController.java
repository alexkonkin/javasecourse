package com.globallogic.javaee.controllers;

import com.globallogic.javaee.exceptions.UserWithGivenLoginAlreadyExists;
import com.globallogic.javaee.exceptions.UserWithGivenLoginNotFound;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/register")
public class RegisterNewUserController {
    @Resource
    UserService userService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumUsers(ModelMap model) {

        return "register";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value="user") User user,ModelMap model,HttpSession session)
    {
        /*
        System.out.println("current user login is " + user.getLogin());
        System.out.println("current user password is " + user.getPassword());
        System.out.println("post: inside addUser method");
        */
        String registerNewUserStringResponse = new String("");

        try {
            userService.findUserByLogin(user.getLogin());
        }
        catch (UserWithGivenLoginNotFound userWithGivenLoginNotFound) {
                userService.register(user);
                registerNewUserStringResponse = "User " + user.getLogin() + " successfully created";
                System.out.println(registerNewUserStringResponse);
        }
        catch (UserWithGivenLoginAlreadyExists userWithGivenLoginAlreadyExists) {
            registerNewUserStringResponse = userWithGivenLoginAlreadyExists.toString();
            System.out.println(registerNewUserStringResponse);
        }

        session.setAttribute("registerNewUserStringResponse",registerNewUserStringResponse);

        return "redirect:/register";
    }

}