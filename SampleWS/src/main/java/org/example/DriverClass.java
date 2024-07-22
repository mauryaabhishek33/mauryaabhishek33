package org.example;

import jdk.jfr.internal.StringPool;

public class DriverClass {


    public static void main(String[] args) throws InterruptedException {
        RateLimitApi limitApi = new RateLimitApi();
        for (int i=0; i<10; i++) {
            limitApi.fetchApi(new RequestDto());
        }
        Thread.sleep(2000);
        for (int i=0; i<10; i++) {
            limitApi.fetchApi(new RequestDto());
        }


    }
}
