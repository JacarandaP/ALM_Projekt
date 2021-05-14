package com.example.springdocker.repository;

import com.example.springdocker.model.Cat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CatRepository extends MongoRepository <Cat, Long> {

    List<Cat> findCatByType(String type);


}
