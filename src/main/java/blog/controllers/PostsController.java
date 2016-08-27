package blog.controllers;

import blog.forms.CreatePostForm;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping("/posts")
    public String viewAll(Model model) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/viewAll";
    }

    @RequestMapping("/posts/create")
    public String createP(CreatePostForm createPostForm) {
        return "posts/create";
    }

    @RequestMapping(value="/posts/create", method = RequestMethod.POST)
    public String createPost(@Valid CreatePostForm createPostForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return  "posts/create";
        }
        notifyService.addInfoMessage("Post created.");
        return "redirect:/";
    }
}
