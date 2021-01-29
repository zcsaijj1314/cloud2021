package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //单机版，写死了地址
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //集群，写服务的名称
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
      return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        //return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",CommonResult.class);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/getforentity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        //return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",CommonResult.class);
        ResponseEntity<CommonResult> forObject = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
        if (forObject.getStatusCode().is2xxSuccessful()){
            return forObject.getBody();
        }else {
            return new CommonResult<>(444,"操作失败 ");
        }
    }
}
