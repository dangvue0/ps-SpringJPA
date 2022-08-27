package dang.conferencedemo.repositories;

import dang.conferencedemo.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
