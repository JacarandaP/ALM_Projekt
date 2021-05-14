package com.example.springdocker.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class MyMathCalcTest {

    MyMathCalc myMathCalc;

    @BeforeEach
    public void beforeMyMathCalc() {
        myMathCalc = new MyMathCalc();
    }

 @Test
    public void addTest(){
        int expected = 4;
        int actual = myMathCalc.add(2, 2);

        assertEquals(expected, actual);
 }

 @Test
    public void multiplyTest(){
        int expected = 16;
        int actual = myMathCalc.multiply(2,8);

        assertEquals(expected, actual);
 }

 @Test
    public void divideTest(){
        float expected = 20/3;
        float actual = myMathCalc.divide(20, 3);

        assertEquals(expected, actual);

 }

 @Test
    public void divideTestThrows() {
        assertThrows(ArithmeticException.class, ()->myMathCalc.divide(5,0));
 }

}