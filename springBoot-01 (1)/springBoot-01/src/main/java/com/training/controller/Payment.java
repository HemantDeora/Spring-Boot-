package com.training.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
//component , service , repositroy
public class Payment {

    public String pay(){
        String payment = "UPI Payment";
        System.out.println("Payment by "+payment);
        return payment;
    }
}
