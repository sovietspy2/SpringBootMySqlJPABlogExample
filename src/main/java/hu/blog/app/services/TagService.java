package hu.blog.app.services;

import hu.blog.app.model.Tag;
import hu.blog.app.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    public void delete(Integer id) {
        tagRepository.deleteById(id);
    }
}
