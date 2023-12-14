package com.layer.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomer/{id}")
    public CustomerDto getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/createCustomer")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/updateCustomer")
    public CustomerDto updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
