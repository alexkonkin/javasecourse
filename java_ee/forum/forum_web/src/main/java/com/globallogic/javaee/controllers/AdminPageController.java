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
@RequestMapping("/admin")
public class AdminPageController {
    @Resource
    TopicService topicService;
    @Resource
    MessageService messageService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @ModelAttribute("message")
    public Message createMessage(){
        return new Message();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(ModelMap model) {
        System.out.println("administrator's page has been requested");
        return "admin";
    }
}