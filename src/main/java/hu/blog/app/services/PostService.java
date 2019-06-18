package hu.blog.app.services;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import hu.blog.app.model.Post;
import hu.blog.app.model.PostEditForm;
import hu.blog.app.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> loadPosts() {
        return postRepository.findAll();
    }

    public Post loadPost(Integer id) throws Exception {
        Optional<Post> post = postRepository.findById(id);

        if (!post.isPresent()) {
            throw new Exception("NO ID");
        }

        return post.get();
    }

    public PostEditForm getFormData(Integer id) throws Exception {
        return new PostEditForm(loadPost(id));
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void savePost(Integer id, PostEditForm post) {
        Post original = postRepository.findById(id).get();
        original.setText(post.getText());
        original.setTitle(post.getTitle());
        original.setVisible(post.getVisible());
        postRepository.save(original);
    }

    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }

}
