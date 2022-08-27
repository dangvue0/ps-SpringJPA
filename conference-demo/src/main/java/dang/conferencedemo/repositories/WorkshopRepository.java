package dang.conferencedemo.repositories;

import dang.conferencedemo.models.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
