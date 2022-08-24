package dang.conferencedemo.controllers;
import dang.conferencedemo.models.Session_Schedule;
import dang.conferencedemo.repositories.Session_ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/session_schedule")
public class Session_ScheduleController {
    @Autowired
    private Session_ScheduleRepository sessionScheduleRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Session_Schedule> list() {
        return sessionScheduleRepository.findAll();
    }

    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Session_Schedule> Get(@PathVariable Long id) {
        return sessionScheduleRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session_Schedule create(@RequestBody final Session_Schedule session_schedule) {
        return sessionScheduleRepository.saveAndFlush(session_schedule);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id) {
        sessionScheduleRepository.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Session_Schedule update(@PathVariable Long id) {
        return null;
    }

}
