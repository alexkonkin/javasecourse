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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session)
    {
        boolean isAuthenticated = false;
        isAuthenticated = userService.login(user);
        if(isAuthenticated)
            user = userService.findUserByLoginPassword(user);
        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);
        return "redirect:/";
    }
}