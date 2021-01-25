package org.example.service;


import org.apache.ibatis.annotations.Param;
import org.example.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
