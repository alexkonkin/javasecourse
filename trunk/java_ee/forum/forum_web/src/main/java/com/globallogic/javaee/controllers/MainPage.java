package com.globallogic.javaee.controllers;

import com.globallogic.javaee.exceptions.UserWithGivenLoginAlreadyExists;
import com.globallogic.javaee.exceptions.UserWithGivenLoginNotFound;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import com.globallogic.javaee.service.AdminUserCheckerService;
import com.globallogic.javaee.service.UserRolesService;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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

    @Resource
    UserRolesService userRolesService;

    @Resource
    AdminUserCheckerService adminUserCheckerService;

    @ModelAttribute("user")
    public User createModel() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printForumTopics(ModelMap model) {
        List<Topic> topicsList = topicService.findAllTopics();
        model.addAttribute("topics", topicsList);

        //AdminUserCheckerService cust = (AdminUserCheckerService)    context.getBean("customerService");

        //System.out.println(adminUserCheckerService.getMessage());

        /*
        try {
            userService.findUserByLogin("admin");
        } catch (UserWithGivenLoginNotFound userWithGivenLoginNotFound) {
            User adminUser = new User();
            adminUser.setLogin("admin");
            adminUser.setPassword("123456");
            adminUser.setEnabled(true);
            userService.register(adminUser);

            UserRoles aUserRoles1 = new UserRoles();
            aUserRoles1.setUser(adminUser);
            aUserRoles1.setRole("ROLE_ADMINISTRATOR");
            userRolesService.createUserRole(aUserRoles1);

            UserRoles aUserRoles2 = new UserRoles();
            aUserRoles2.setUser(adminUser);
            aUserRoles2.setRole("ROLE_USER");
            userRolesService.createUserRole(aUserRoles2);

        } catch (UserWithGivenLoginAlreadyExists userWithGivenLoginAlreadyExists) {
            System.out.println("admin's mandatory account is checked and present in the database");
        }
        */

        return "main";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logoutFromForum(ModelMap model, HttpSession session) {
        session.setAttribute("isAuthenticated", false);
        List<Topic> topicsList = topicService.findAllTopics();
        model.addAttribute("topics", topicsList);
        return "main";
    }

    @RequestMapping(value = "/error403",method = RequestMethod.GET)
    public String error403(ModelMap model, HttpSession session) {

        return "error403";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session,SecurityContextHolderAwareRequestWrapper request)
    {
        boolean isAuthenticated = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        user.setLogin(auth.getName());
        if(auth.getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))
            isAuthenticated = false;
        else
            isAuthenticated = true;

        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);
        session.setAttribute("error",true);

        return "redirect:/";
    }

    @RequestMapping(value = "/loginpassed", method = RequestMethod.GET)
    public String loginPassed(@ModelAttribute(value="user") User user, /*BindingResult result*/ModelMap modelMap,HttpSession session,SecurityContextHolderAwareRequestWrapper request)
    {
        boolean isAuthenticated = false;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        user.setLogin(auth.getName());
        user.setPassword(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
        User aUser = userService.findUserByLoginPassword(user);
        user.setId(aUser.getId());

        if(auth.getAuthorities().toString().equals("[ROLE_ANONYMOUS]"))
            isAuthenticated = false;
        else
            isAuthenticated = true;

        session.setAttribute("userCredentials", user);
        session.setAttribute("isAuthenticated", isAuthenticated);
        session.setAttribute("authorities",auth);
        session.removeAttribute("error");

        System.out.println("role is : "+auth.getAuthorities().iterator().next().getAuthority());

        return "redirect:/";
    }
}