package hello.myblog.web;

import hello.myblog.domain.blog.Blog;
import hello.myblog.domain.blog.BlogRepository;
import hello.myblog.domain.member.Member;
import hello.myblog.web.argumentResolver.Login;
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
    public String home(@Login Member loginMember, Model model) {
        if (loginMember == null){
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }




}
