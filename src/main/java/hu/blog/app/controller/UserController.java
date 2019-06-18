package hu.blog.app.controller;

import hu.blog.app.model.User;
import hu.blog.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("userData", new User());
        return "user/list";
    }

    @PostMapping("/user_save")
    public String tagSave(@ModelAttribute User userData) {
        userService.save(userData);
        return "redirect:/users";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteTag(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
