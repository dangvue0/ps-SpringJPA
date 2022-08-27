package dang.conferencedemo.controllers;
import dang.conferencedemo.models.Tag;
import dang.conferencedemo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Tag> list() {
        return tagRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Tag> Get(@PathVariable Long id) {
        return tagRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag create(@RequestBody final Tag tag) {
        return tagRepository.saveAndFlush(tag);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id) {
        tagRepository.deleteById(id);
    }
}
