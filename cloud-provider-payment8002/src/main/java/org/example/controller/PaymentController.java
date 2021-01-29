package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.entities.CommonResult;
import org.example.entities.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    //@Value("${server.port}")
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入结果哈哈："+i);
        int a= 93;
        System.out.println("a = " + a);

        if (i>0){
            return new CommonResult(200,"插入成功！serverPort:"+serverPort,i);
        }else {
            return new CommonResult(444,"插入失败！",null);
        }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功！serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"查询失败！",null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
