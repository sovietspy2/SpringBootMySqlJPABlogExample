package hu.blog.app.services;

import hu.blog.app.model.Comment;
import hu.blog.app.model.Post;
import hu.blog.app.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment, Post post) {
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
