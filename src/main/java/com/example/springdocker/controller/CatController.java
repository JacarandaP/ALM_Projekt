package com.example.springdocker.controller;

import com.example.springdocker.model.Cat;
import com.example.springdocker.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CatController {
    private final CatService service;

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return service.getCats();
    }

    @PostMapping("/addcat")
    public void saveNewCat(@RequestBody Cat cat) {
        service.saveNewCat(cat);
    }

    @GetMapping("/cats/type")
    public List<String> getCatsByType(@RequestParam String type) {
        return service.getCatsOfType(type);
    }
}
