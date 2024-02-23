package hello.myblog.web.blog.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogUpdateForm {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    private String content;
}
