package dang.conferencedemo.repositories;

import dang.conferencedemo.models.Session_Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Session_ScheduleRepository extends JpaRepository<Session_Schedule, Long> {
}
