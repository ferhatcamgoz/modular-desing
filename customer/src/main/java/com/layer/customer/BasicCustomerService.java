package com.layer.customer;

import com.layer.basket.customer.BasketCustomerService;
import com.layer.basket.customer.BasketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BasicCustomerService implements CustomerService {

    @Autowired
    private BasketCustomerService basketService;
    @Autowired
    private CustomerRepo customerRepo;
    Logger logger = Logger.getLogger("com.layer.customer.BasicCustomerService");

    @Override
    public CustomerDto getCustomer(long customerId) {
       Customer customer =  customerRepo.findById(customerId).orElse(null);
         if(customer == null) {
              return new CustomerDto();
         }
         return new CustomerDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getName());
        logger.info("customer = " + customer);
        customer.setBasket(basketService.createBasket());
        customer = customerRepo.save(customer);

        return new CustomerDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(Customer customer) {
       return new CustomerDto(customerRepo.save(customer));
    }
}
