package com.crudproject.crudops.Controller;

import com.crudproject.crudops.Entities.User;
import com.crudproject.crudops.Service.UserNotFoundException;
import com.crudproject.crudops.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController
{
    @Autowired UserService service;

    @GetMapping("/users")
    public String showUserList(Model model)
    {
        List<User> userList = service.listAll();
        model.addAttribute("userList",userList);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model)
    {
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes re)
    {
        service.save(user);
        re.addFlashAttribute("message","The data has been added successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id,Model model,RedirectAttributes re)
    {
        try
        {
            User user = service.get(id);
            model.addAttribute("user",user);
            model.addAttribute("pageTitle","Edit User ( ID :"+id+")");
            return "user_form";

        }
        catch (UserNotFoundException e) {
            e.printStackTrace();

            re.addFlashAttribute("message", "The user has been saved succressfully");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id,RedirectAttributes re)
    {
        try
        {
            service.delete(id);
            re.addFlashAttribute("message","The User Id "+id+ " has been deleted successfully");
        }
        catch (UserNotFoundException e) {
            re.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

}
