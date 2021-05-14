package com.example.springdocker.repository;

import com.example.springdocker.model.Cat;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jacaranda Perez
 * Date: 2021-05-14
 * Project: spring-docker-demo
 */
@DataMongoTest
class CatRepositoryTest {

    @Autowired
    CatRepository catRepository;

    @Test
    void findCatByTypeTest(){

        Cat cat1 = new Cat();
        cat1.setName("mishu");
        cat1.setColor("black");
        cat1.setType("ragdoll");

        Cat cat2 = new Cat();
        cat2.setName("lulo");
        cat2.setColor("white");
        cat2.setType("siamese");


        Cat cat3 = new Cat();
        cat3.setName("michi");
        cat3.setColor("white");
        cat3.setType("ragdoll");

        catRepository.save(cat1);
        catRepository.save(cat2);
        catRepository.save(cat3);

        List<Cat> ragdollCatsList = catRepository.findCatByType("ragdoll");

        assertEquals(Arrays.asList(cat1,cat3), ragdollCatsList);


    }


}