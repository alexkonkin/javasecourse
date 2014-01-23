package com.globallogic.javaee.controllers;

import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.validation.BindingResult;
import com.globallogic.javaee.service.TopicService;
import com.globallogic.javaee.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainPage {
    @Resource
    TopicService topicService;

    @Resource
    UserService userService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(ModelMap model) {
        List<Topic> topicsList = topicService.findAllTopics();
        model.addAttribute("topics", topicsList);
        return "main";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logoutFromForum(ModelMap model, HttpSession session) {
        session.setAttribute("isAuthenticated", false);
        List<Topic> topicsList = topicService.findAllTopics();
        model.addAttribute("topics", topicsList);
        return "main";
    }

    /*
     * Method is used to the local authentication, has been replaced with spring db authentication
     *
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value="user") User user, ModelMap modelMap,HttpSession session)
    {
        boolean isAuthenticated = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();


        isAuthenticated = userService.login(user);
        if(isAuthenticated)
            user = userService.findUserByLoginPassword(user);


        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);

        return "redirect:/";
    }
    */

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session)
    {
        boolean isAuthenticated = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        /*
        isAuthenticated = userService.login(user);
        if(isAuthenticated)
            user = userService.findUserByLoginPassword(user);
        */

        user.setLogin(auth.getName());
        if(auth.getName().equals("guest"))
            isAuthenticated = false;
        else
            isAuthenticated = true;

        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);
        //session.setAttribute("error", error);
        session.setAttribute("error",true);

        System.out.println("Spring  /loginfailed"); //get logged in username
        System.out.println("Spring username        : "+auth.getName()); //get logged in username
        System.out.println("Spring authorities     : "+auth.getAuthorities().toString());
        System.out.println("Spring isAuthenticated : "+auth.isAuthenticated());

        return "redirect:/";
    }

    @RequestMapping(value = "/loginpassed", method = RequestMethod.GET)
    public String loginPassed(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session)
    {
        boolean isAuthenticated = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        user.setLogin(auth.getName());
        user.setPassword(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
        User aUser = userService.findUserByLoginPassword(user);
        user.setId(aUser.getId());

        if(auth.getName().equals("guest"))
            isAuthenticated = false;
        else
            isAuthenticated = true;


        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);
        session.removeAttribute("error");

        return "redirect:/";
    }
}