package hello.myblog.web.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class LoginForm {
        @NotEmpty
        private String loginId;

        @NotEmpty String password;
}
