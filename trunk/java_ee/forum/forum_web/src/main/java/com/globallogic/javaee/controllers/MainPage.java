package com.globallogic.javaee.controllers;

import com.globallogic.javaee.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.globallogic.javaee.service.TopicService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainPage {
    @Resource
    TopicService topicService;

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(ModelMap model) {
        List<Topic> topicsList = topicService.findAllTopics();

        //model.addAttribute("topics", topicsList.get(0).getName());
        model.addAttribute("topics", topicsList);
        return "main";
    }
}