package dang.conferencedemo.controllers;

import dang.conferencedemo.models.Session;
import dang.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Session> Get(@PathVariable Long id) {
        return sessionRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting
        sessionRepository.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Session update(@PathVariable Long id) {
        return null;
    }
}
