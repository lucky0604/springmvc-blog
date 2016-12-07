package blog.controller;

import blog.forms.PostForm;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lucky on 12/6/16.
 */
@Controller
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notificationService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts")
    public String viewAll(Model model) {
        List<Post> allPosts = postService.findAll();
        /*
        for (Post post: allPosts) {
            model.addAttribute("post", post);
        }
        */
        model.addAttribute("allPosts", allPosts);
        return "posts/allPosts";
    }

    @RequestMapping("/posts/createPost")
    public String create(Post post) {
        return "posts/createPost";
    }

    @RequestMapping(value = "/posts/createPost", method = RequestMethod.POST)
    public String createPost(@Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "posts/createPost";
        }
        postService.create(post);
        notificationService.addInfoMessage("Post Successfully!");
        return "redirect:/posts";
    }
}
