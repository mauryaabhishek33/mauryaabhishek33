package org.example;

import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimitApi {


    private int MAX_THRESHOLD_LIMIT = 5;

    private Map<LocalDateTime, Integer> currentLimit = new ConcurrentHashMap<>();

    public RateLimitApi() {

    }

    public RateLimitApi(int thresholdLimit) {
        this.MAX_THRESHOLD_LIMIT = thresholdLimit;
    }

    public void fetchApi(RequestDto requestBody) {
        LocalDateTime currentDateTime = LocalDateTime.now();
      //  simmi.rai@mpokket.com
        currentDateTime = currentDateTime.truncatedTo(ChronoUnit.SECONDS);
        if (!currentLimit.containsKey(currentDateTime)) {
            currentLimit.put(currentDateTime, 0);
        }
        if (currentLimit.get(currentDateTime) < MAX_THRESHOLD_LIMIT) {
            currentLimit.put(currentDateTime, currentLimit.get(currentDateTime) + 1);
            System.out.println("TRUE");
            System.out.println(currentDateTime);
        } else if (currentLimit.get(currentDateTime) >= MAX_THRESHOLD_LIMIT) {
            System.out.println("FALSE");
            System.out.println(currentDateTime);

        }
    }
}
//        if (MAX_THRESHOLD_LIMIT==currentLimit) {
//            System.out.println("False");
//        } else {
//            currentLimit++;
//            System.out.println("True");
//        }
//    }
//}
