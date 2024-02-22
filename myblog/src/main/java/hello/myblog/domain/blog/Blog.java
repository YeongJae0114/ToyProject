package hello.myblog.domain.blog;

import lombok.Data;

@Data
public class Blog {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String date;

    public Blog(){}

    public Blog(String title, String content){
        this.title = title;
        this.content = content;
    }
}
