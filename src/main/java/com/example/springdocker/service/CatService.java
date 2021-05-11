package com.example.springdocker.service;

import com.example.springdocker.model.Cat;
import com.example.springdocker.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CatService {
    private final CatRepository catRepository;

    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    public void saveNewCat(Cat cat) {
        catRepository.save(cat);
    }

    public List<String> getCatsOfType(String type) {

        List<Cat> catsOfType = catRepository.findCatByType(type);

        return catsOfType.stream()
                .map(cat -> cat.getName())
                .collect(Collectors.toList());
    }
}
