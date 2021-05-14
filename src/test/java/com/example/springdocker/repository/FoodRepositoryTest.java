package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
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
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @Test
    void findFoodByCanICookItTest(){

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

        foodRepository.save(food1);
        foodRepository.save(food2);
        foodRepository.save(food3);


        List<Food> actualListFoodICanCook = foodRepository.findFoodByCanICookIt(true);

        assertEquals(Arrays.asList(food1,food3), actualListFoodICanCook);
    }

}