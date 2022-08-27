package dang.conferencedemo.controllers;

import dang.conferencedemo.models.Workshop;
import dang.conferencedemo.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/workshop")
public class WorkshopController {
    @Autowired
    private WorkshopRepository workshopRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Workshop> list() {
        return workshopRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Workshop> Get(@PathVariable Long id) {
        return workshopRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workshop create(@RequestBody final Workshop workshop) {
        return workshopRepository.saveAndFlush(workshop);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id) {
        workshopRepository.deleteById(id);
    }
}