package hello.myblog.domain.login;

import hello.myblog.domain.member.Member;
import hello.myblog.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String passward){
        return memberRepository.findByLoginId(loginId)
                .filter(m->m.getPassword().equals(passward))
                .orElse(null);
    }
}
