package com.example.springdocker.controller;

/**
 * Created by Jacaranda Perez
 * Date: 2021-05-12
 * Project: spring-docker-demo
 */

public class MyMathCalc {
   private int a, b;

   public int add(int a, int b){
       return a + b;
   }
   public int multiply(int a, int b){
       return a * b;
   }

   public double divide(int a, int b){

       return a/b;
   }

}
