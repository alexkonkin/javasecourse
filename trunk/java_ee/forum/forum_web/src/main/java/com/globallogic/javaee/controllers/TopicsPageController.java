package com.globallogic.javaee.controllers;

import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.service.MessageService;
import com.globallogic.javaee.service.ServiceFactory;
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
import java.util.List;


@Controller
@RequestMapping("/topic")
public class TopicsPageController {
    @Resource
    TopicService topicService;
    @Resource
    MessageService messageService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @ModelAttribute("topic")
    public Topic createTopicModel() {
        return new Topic();
    }


    @ModelAttribute("message")
    public Message createMessage(){
        return new Message();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(@RequestParam("topicId") Integer topicId, ModelMap model) {
        System.out.println("topic get controller : "+ topicId);
        Topic aTopic = topicService.getTopicById(topicId);

        List<Message> aMessages =  messageService.getMessageByTopicId(aTopic);

        /*
        System.out.println(aMessages.get(0).getContent());
        System.out.println(aMessages.get(0).getTopic().getName());
        System.out.println(aMessages.get(0).getUser().getLogin());
        */
        model.addAttribute("topic", aTopic);
        model.addAttribute("messages",aMessages);

        return "topic";
    }

    @RequestMapping(value = "addMessage", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value="message") Message message,/*BindingResult result*/ModelMap modelMap,HttpSession session)
    {

        Integer id = message.getTopic().getId();
        /*
        System.out.println(message.getContent());
        System.out.println ("current user login is "+ message.getUser().getLogin());
        System.out.println ("current user password is "+ message.getUser().getPassword());
        System.out.println ("current user id is "+ message.getUser().getId());
        System.out.println ("current topic id is "+ message.getTopic().getId());
        System.out.println ("current topic Name is "+ message.getTopic().getName());
        */
        message.getTopic().setUser(message.getUser());
        messageService.createMessage(message);

        return "redirect:/topic?topicId="+id;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteTopic(@RequestParam(value = "topicId") Integer topicId, ModelMap modelMap,HttpSession session)
    {
        messageService.deleteMessagesByTopicId(topicId);
        topicService.deleteTopicById(topicId);

        /*
        System.out.println(message.getContent());
        System.out.println ("current user login is "+ message.getUser().getLogin());
        System.out.println ("current user password is "+ message.getUser().getPassword());
        System.out.println ("current user id is "+ message.getUser().getId());
        System.out.println ("current topic id is "+ message.getTopic().getId());
        System.out.println ("current topic Name is "+ message.getTopic().getName());
        */
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/message", method = RequestMethod.GET)
    public String deleteMesssage(@RequestParam(value = "topicId") Integer topicId,
                                 @RequestParam(value = "messageId") Integer messageId ,
                                 ModelMap modelMap,HttpSession session)
    {
        messageService.deleteMessageById(messageId);
        /*
        System.out.println(message.getContent());
        System.out.println ("current user login is "+ message.getUser().getLogin());
        System.out.println ("current user password is "+ message.getUser().getPassword());
        System.out.println ("current user id is "+ message.getUser().getId());
        System.out.println ("current topic id is "+ message.getTopic().getId());
        System.out.println ("current topic Name is "+ message.getTopic().getName());
        */
        return "redirect:/topic?topicId="+topicId;
    }
}