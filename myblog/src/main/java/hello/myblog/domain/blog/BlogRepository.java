package hello.myblog.domain.blog;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository {
    private static final Map<Long, Blog> blogStore = new HashMap<>();
    private static long sequence = 0L;

    // 저장
    public Blog save(Blog blog){
        blog.setId(sequence++);
        blogStore.put(blog.getId(), blog);
        return blog;
    }
    // id로 객체 찾기
    public Blog findById(Long id){
       return blogStore.get(id);
    }
    // 목록
    public List<Blog>findAll(){
        return new ArrayList<>(blogStore.values());
    }
    // 수정
    public void update(Long id, Blog updateParam){
        Blog findblog = findById(id);
        findblog.setContent(updateParam.getContent());
        findblog.setTitle(updateParam.getTitle());
    }
    public void clearStore(){
        blogStore.clear();
    }
}
