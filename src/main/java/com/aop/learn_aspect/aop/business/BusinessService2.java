package com.aop.learn_aspect.aop.business;


import com.aop.learn_aspect.aop.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService2 {

    private final DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public Integer findMinNumbers(String dataName) throws InterruptedException {
        Thread.sleep(30);
        List<Integer> numbers = dataService2.retrieveData2(dataName);
        Integer minNumber = numbers.stream().min(Integer::compare).orElse(0);
        return minNumber;
    }

}
