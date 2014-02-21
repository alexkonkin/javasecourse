package com.globallogic.javaee.controllers;

import com.globallogic.javaee.exceptions.UserWithGivenIdNotFound;
import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.service.MessageService;
import com.globallogic.javaee.service.TopicService;
import com.globallogic.javaee.service.UserService;
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
    @Resource
    UserService userService;

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
        List<User> aUsers =  userService.findAllUsers();
        model.addAttribute("users", aUsers);
        return "admin";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String adminManage(@RequestParam(value = "isEnabled") Boolean isEnabled, @RequestParam(value = "userId") Integer userId , ModelMap modelMap,HttpSession session) throws UserWithGivenIdNotFound {
        User aUser = userService.findUserById(userId);
        aUser.setEnabled(isEnabled);
        userService.setAccountStatus(aUser);
        return "redirect:/admin";
    }

}