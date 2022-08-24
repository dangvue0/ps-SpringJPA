package dang.conferencedemo.controllers;

import dang.conferencedemo.models.Time_Slot;
import dang.conferencedemo.repositories.Time_SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/time_slots")
public class Time_SlotsController {

    @Autowired
    private Time_SlotRepository time_slotRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Time_Slot> list() {
        return time_slotRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Time_Slot> Get(@PathVariable Long id){
        return time_slotRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time_Slot create(@RequestBody final Time_Slot time_slot) {
        return time_slotRepository.saveAndFlush(time_slot);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void delete(@PathVariable Long id){
        time_slotRepository.deleteById(id);
    }

}
