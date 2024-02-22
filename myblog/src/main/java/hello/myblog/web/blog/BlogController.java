package hello.myblog.web.blog;

import hello.myblog.domain.blog.Blog;
import hello.myblog.domain.blog.BlogRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogRepository blogRepository;

    @GetMapping
    public String blogs(Model model){
        List<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs", blogs);
        return "blogs/blogs";
    }
    @GetMapping("/{blogId}")
    public String blog(@PathVariable Long blogId, Model model){
        Blog blog = blogRepository.findById(blogId);
        model.addAttribute("blog",blog);
        return "blogs/blog";
    }

    @PostConstruct
    public void init() {
        blogRepository.save(new Blog("testA", "10000"));
        blogRepository.save(new Blog("testB", "20000"));
    }
}
