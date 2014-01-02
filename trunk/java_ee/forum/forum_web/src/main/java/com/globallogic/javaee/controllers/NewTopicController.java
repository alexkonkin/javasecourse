package com.globallogic.javaee.controllers;

import com.globallogic.javaee.exceptions.TopicEmptyNameProhibited;
import com.globallogic.javaee.exceptions.TopicWithGivenNameAlreadyExists;
import com.globallogic.javaee.exceptions.TopicWithGivenNameNotFound;
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
    public String registerUser(@ModelAttribute(value="topic") Topic topic,ModelMap model,HttpSession session)
    {
        /*
        System.out.println("current user login is " + topic.getUser().getLogin());
        System.out.println("current user password is " + topic.getUser().getPassword());
        System.out.println("current user id is " + topic.getUser().getId());
        */
        String createTopicStringResponse = new String();
        try {
            topicService.getTopicByName(topic.getName());
        }
        catch (TopicWithGivenNameNotFound topicWithGivenNameNotFound) {
            topicService.createTopic(topic);
            createTopicStringResponse = "Topic " + topic.getName() + " successfully created";
        }
        catch (TopicWithGivenNameAlreadyExists topicWithGivenNameAlreadyExists){
            createTopicStringResponse = topicWithGivenNameAlreadyExists.toString();
        }
        catch (TopicEmptyNameProhibited topicEmptyNameProhibited){
            createTopicStringResponse = topicEmptyNameProhibited.toString();
        }

        //model.addAttribute("createTopicStringResponse", createTopicStringResponse);
        session.setAttribute("createTopicStringResponse", createTopicStringResponse);
        return "redirect:/newtopic";
    }

}