package hello.myblog.web;

import hello.myblog.domain.blog.Blog;
import hello.myblog.domain.blog.BlogRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final BlogRepository blogRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }


}
