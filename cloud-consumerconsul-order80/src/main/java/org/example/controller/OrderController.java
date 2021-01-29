package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //单机版，写死了地址
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //集群，写服务的名称
    public static final String INVOKE_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/su")
    public String paymentinfo(){
      return  restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }

}
