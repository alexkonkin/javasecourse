package com.globallogic.javaee.controllers;

import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globallogic.javaee.service.TopicService;
import com.globallogic.javaee.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/topic")
public class TopicsPageController {
    @Resource
    TopicService topicService;

    @Resource
    UserService userService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(@RequestParam("topicId") Integer topicId, ModelMap model) {
        //List<Topic> topicsList = topicService.findAllTopics();
        //model.addAttribute("topics", topicsList);

        System.out.println("topic get controller : "+ topicId);
        Topic aTopic = topicService.getTopicById(topicId);

        model.addAttribute("topic", aTopic);

        return "topic";
    }

    @RequestMapping(value = "/topic/add", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session)
    {
        //session.setAttribute("userCredentials", user);

        return "redirect:/topic";
    }

}