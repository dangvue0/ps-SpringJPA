package dang.conferencedemo.controllers;

import dang.conferencedemo.models.Speaker;
import dang.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Speaker> Get(@PathVariable Long id) {
        return speakerRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }
}
