package com.layer.customer;

import com.layer.basket.customer.BasketDto;

public interface CustomerService {

    CustomerDto getCustomer(long customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(Customer customer);



}
