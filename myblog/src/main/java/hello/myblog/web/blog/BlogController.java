package hello.myblog.web.blog;

import hello.myblog.domain.blog.Blog;
import hello.myblog.domain.blog.BlogRepository;
import hello.myblog.domain.member.Member;
import hello.myblog.domain.member.MemberRepository;
import hello.myblog.web.blog.form.BlogSaveForm;
import hello.myblog.web.blog.form.BlogUpdateForm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    @GetMapping
    public String blogs(Model model){
        List<Blog> blogs = blogRepository.findAll();
        List<Member> members = memberRepository.findAll();

        // members.stream().filter(m->m.getName().equals())

        model.addAttribute("blogs", blogs);

        return "blogs/blogs";
    }
    @GetMapping("/{blogId}")
    public String blog(@PathVariable Long blogId, Model model){
        Blog blog = blogRepository.findById(blogId);
        model.addAttribute("blog",blog);
        return "blogs/blog";
    }

    @GetMapping("/{blogId}/edit")
    public String editForm(@PathVariable Long blogId, Model model){
        Blog blog = blogRepository.findById(blogId);
        model.addAttribute("blog",blog);
        return "blogs/editForm";
    }
    @PostMapping("/{blogId}/edit")
    public String edit(@PathVariable Long blogId, @Validated @ModelAttribute("blog")BlogUpdateForm form, BindingResult bindingResult){
        if (form.getTitle() == null && form.getContent() == null ) {
            bindingResult.reject("err");
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "blogs/editForm";
        }
        Blog blog = new Blog();
        blog.setTitle(form.getTitle());
        blog.setContent(form.getContent());

        blogRepository.update(blogId, blog);
        return "redirect:/blogs/{blogId}";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute(new Blog());
        return "blogs/addForm";
    }
    @PostMapping("/add")
    public String addBlog(@Validated @ModelAttribute("blog")BlogSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (form.getTitle() == null && form.getContent() == null ){

        }
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "blogs/addForm";
        }
        // 성공
        Blog blog = new Blog();
        blog.setTitle(form.getTitle());
        blog.setContent(form.getContent());

        Blog saveBlog = blogRepository.save(blog);
        redirectAttributes.addAttribute("blogId", saveBlog.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/blogs/{blogId}";

    }

}
