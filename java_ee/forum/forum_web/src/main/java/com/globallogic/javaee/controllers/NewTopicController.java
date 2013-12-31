package com.globallogic.javaee.controllers;

import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.service.MessageService;
import com.globallogic.javaee.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/newtopic")
public class NewTopicController {
    @Resource
    TopicService topicService;

    @ModelAttribute("topic")
    public Topic createModel() {
        return new Topic();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(ModelMap model) {

        return "newtopic";
    }

    @RequestMapping(value = "addTopic", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value="topic") Topic topic,/*BindingResult result*/ModelMap modelMap,HttpSession session)
    {

        return "redirect:/createTopic";
    }

}