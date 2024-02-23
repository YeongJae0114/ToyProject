package hello.myblog.web.argumentResolver;

import hello.myblog.domain.member.Member;
import hello.myblog.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
        @Override
        public boolean supportsParameter(MethodParameter parameter) {

            boolean hasParameterAnnotation = parameter.hasParameterAnnotation(Login.class);
            boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType());

            return hasParameterAnnotation && hasMemberType;
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

            HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();
            HttpSession session = request.getSession(false);
            if(session ==null){
                return null;
            }
            return session.getAttribute(SessionConst.LOGIN_MEMBER);
        }
}
