package hello.myblog;

import hello.myblog.domain.blog.Blog;
import hello.myblog.domain.blog.BlogRepository;
import hello.myblog.domain.member.Member;
import hello.myblog.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final BlogRepository blogRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        blogRepository.save(new Blog("testA", "10000"));
        blogRepository.save(new Blog("testB", "20000"));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("테스터");
        memberRepository.save(member);

    }

}