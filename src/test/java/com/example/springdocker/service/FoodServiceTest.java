package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by Jacaranda Perez
 * Date: 2021-05-14
 * Project: spring-docker-demo
 */
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository foodRepository;

    @BeforeEach
    public void init(){
        foodService = new FoodService(foodRepository);
    }

    @Test
    void getFoodsTest(){
        Food food1 = new Food();
        food1.setName("pizza");
        food1.setDelicious(true);
        food1.setCanICookIt(true);

        Food food2 = new Food();
        food2.setName("tacos");
        food2.setDelicious(true);
        food2.setCanICookIt(false);

        Food food3 = new Food();
        food3.setName("hamburger");
        food3.setDelicious(true);
        food3.setCanICookIt(true);


        when(foodRepository.findAll()).thenReturn(Arrays.asList(food1, food2, food3));

        List<Food> actual = foodService.getFoods();

        assertEquals(Arrays.asList(food1, food2, food3), actual);
        assertEquals(food1.getName(), actual.get(0).getName());
        assertEquals(food3.getName(), actual.get(2).getName());
        assertEquals(3, actual.size());
        verify(foodRepository).findAll();
    }

    @Test
    void getCookableFoodsTest() {
        Food food1 = new Food();
        food1.setName("pizza");
        food1.setDelicious(true);
        food1.setCanICookIt(true);

        Food food2 = new Food();
        food2.setName("tacos");
        food2.setDelicious(true);
        food2.setCanICookIt(false);

        Food food3 = new Food();
        food3.setName("hamburger");
        food3.setDelicious(true);
        food3.setCanICookIt(true);

        when(foodRepository.findFoodByCanICookIt(true)).thenReturn(Arrays.asList(food1,food3));

        List<String> cookableFoods = foodService.getCookableFoods();

        assertEquals(Arrays.asList(food1.getName(), food3.getName()), cookableFoods);
        assertEquals(food1.getName(), cookableFoods.get(0));
        assertEquals(food3.getName(), cookableFoods.get(1));
        verify(foodRepository).findFoodByCanICookIt(anyBoolean());

    }

    @Test
    void saveNewFoodTest(){
        String expectedName = "pizza";
        boolean expectedisDelicious = true;
        boolean expectedisCookable = true;
        Food food1 = new Food();
        food1.setName(expectedName);
        food1.setDelicious(expectedisDelicious);
        food1.setCanICookIt(expectedisCookable);

        when(foodRepository.save(any())).thenReturn(food1);

        Food actualFood = foodService.saveNewFood(food1);

        assertEquals(food1, actualFood);
        assertEquals(food1.getName(), actualFood.getName());

        verify(foodRepository).save(any());


    }

}