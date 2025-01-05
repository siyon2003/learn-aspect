package com.aop.learn_aspect.aop.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataService1 {

    private static List<Integer> numbers = new ArrayList<>();

    static {
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
    }

    public List<Integer> retrieveData1(String dataName){
        if(dataName.equalsIgnoreCase("Hacker")){
            System.out.println("My name is "+ dataName);
        }
        return numbers;
    }
}
