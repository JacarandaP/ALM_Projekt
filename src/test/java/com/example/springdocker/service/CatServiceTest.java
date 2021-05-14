package com.example.springdocker.service;

import com.example.springdocker.model.Cat;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jacaranda Perez
 * Date: 2021-05-14
 * Project: spring-docker-demo
 */
@ExtendWith(MockitoExtension.class)
class CatServiceTest {

    CatService catService;

    @Mock
    CatRepository catRepository;

    @BeforeEach

    public void init() {
        catService = new CatService(catRepository);
    }

    @Test
    void getCatsTest(){

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



        when(catRepository.findAll()).thenReturn(Arrays.asList(cat1, cat2, cat3));

        List<Cat> actual = catService.getCats();

        assertEquals(Arrays.asList(cat1, cat2, cat3), actual);
        assertEquals(cat1.getName(), actual.get(0).getName());
        assertEquals(cat3.getName(), actual.get(2).getName());
        assertEquals(3, actual.size());
        verify(catRepository).findAll();
    }

    @Test
    void getCatsOfTypeTest() {
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

        when(catRepository.findCatByType(anyString())).thenReturn(Arrays.asList(cat1,cat3));

        List<String> catsOfType = catService.getCatsOfType("ragdoll");

        assertEquals(Arrays.asList(cat1.getName(), cat3.getName()), catsOfType);
        assertEquals(cat1.getName(), catsOfType.get(0));
        assertEquals(cat3.getName(), catsOfType.get(1));
        verify(catRepository).findCatByType(anyString());

    }

    @Test
    void saveNewCatTest(){
        String expectedName = "michi";
        String expectedColor = "black";
        String expectedType = "ragdoll";
        Cat cat1 = new Cat();
        cat1.setName(expectedName);
        cat1.setColor(expectedColor);
        cat1.setType(expectedType);

        when(catRepository.save(any())).thenReturn(cat1);

        Cat actualCat = catService.saveNewCat(cat1);

        assertEquals(cat1, actualCat);
        assertEquals(cat1.getName(), actualCat.getName());

        verify(catRepository).save(any());


    }


}