package com.aop.learn_aspect.aop.data;

import com.aop.learn_aspect.aop.timer.TrackTimer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataService2 {

    private static List<Integer> numbers = new ArrayList<>();

    static {
        numbers.add(12);
        numbers.add(23);
        numbers.add(48);
    }

    @TrackTimer
    public List<Integer> retrieveData2(String dataName) throws InterruptedException{
        Thread.sleep(30);
        if(dataName.equalsIgnoreCase("Hacker")){
            System.out.println("My name is "+ dataName);
        }
        return numbers;
    }
}
