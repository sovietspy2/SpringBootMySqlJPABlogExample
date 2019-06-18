package hu.blog.app.repositories;

import hu.blog.app.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
