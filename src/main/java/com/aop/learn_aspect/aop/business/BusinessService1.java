package com.aop.learn_aspect.aop.business;

import com.aop.learn_aspect.aop.data.DataService1;
import com.aop.learn_aspect.aop.timer.TrackTimer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTimer
    public Integer findMaxNumbers(String dataName, String retroType) throws InterruptedException {
        if(retroType.equalsIgnoreCase("batman")){
            System.out.println("Iam "+ retroType);
        }
        Thread.sleep(30);
        List<Integer> numbers = dataService1.retrieveData1(dataName);
        Integer maxNumber = numbers.stream().max(Integer::compare).orElse(0);
        return maxNumber;
    }


}
