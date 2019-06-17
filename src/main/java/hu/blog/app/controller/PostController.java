package hu.blog.app.controller;

import hu.blog.app.model.Comment;
import hu.blog.app.model.Post;
import hu.blog.app.services.CommentService;
import hu.blog.app.services.PostService;
import hu.blog.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.smartcardio.CommandAPDU;

@Controller
public class PostController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/list_posts")
    public String index(Model model) {
        model.addAttribute("posts", postService.loadPosts());
        return "posts/list";
    }

    @GetMapping("/edit_post/{id}")
    public String edit() {
        return "posts/edit";
    }

    @GetMapping("/new_post")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("users", userService.getUsers());
        return "posts/new";
    }

    @PostMapping("/post_save")
    private String savePost(@ModelAttribute Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/delete_post/{id}")
    public String deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/add_comment/{id}")
    public String add_comment(@PathVariable Integer id, Model model) throws Exception {
        model.addAttribute("comment", new Comment());
        model.addAttribute("post", postService.loadPost(id));
        model.addAttribute("users", userService.getUsers());
        return "posts/add_comment";
    }

    @PostMapping("/save_comment/{dd}")
    private String saveComment(@PathVariable Integer dd, @ModelAttribute Comment comment,@ModelAttribute Post post) throws Exception {
        commentService.saveComment(comment, postService.loadPost(dd));
        return "redirect:/";
    }



}
