package hu.blog.app.controller;

import hu.blog.app.model.Tag;
import hu.blog.app.repositories.TagRepository;
import hu.blog.app.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/tags")
    public String loadTags(Model model) {
        model.addAttribute("tags", tagService.findAllTags());
        model.addAttribute("tagData", new Tag());
        return "tags/list";
    }

    @PostMapping("/tag_save")
    public String tagSave(@ModelAttribute Tag tagData) {
        tagService.save(tagData);
        return "redirect:/tags";
    }

    @GetMapping("/delete_tag/{id}")
    public String deleteTag(@PathVariable Integer id) {
        tagService.delete(id);
        return "redirect:/tags";
    }

}
