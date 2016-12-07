package blog.controller;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
