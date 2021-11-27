package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

// copied Controller class to change the main path. You have now to version of your api . Both controllers are using services , repos etc,
//just have some small changes and path is different. Client has access to both APIs

@RequestMapping(path="api/v2/customers") // so we can use localhost:8080/api/v2/customer
@RestController
public class CustomerControllerV2 {

    private CustomerService customerService;
    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    //localhost:8080/api/v1/customer/all
    @GetMapping // JACKSON library is converting Entity to Json and back?
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }
    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id); //service throws exception in case id not found (not handled by handler)
    }


    // method just to simulate throwing exception that is handles by ApiExceptionHandler (has @ControllerAdvice annotation if there is exception at controller level thrown
    // and it is inncluded in handler, then it will take over and build ResponseEntity)
    @GetMapping(path = "{customerId}/apiexception")
    public Customer getCustomerApiException(@PathVariable("customerId") Long id){
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }
    @GetMapping(path = "{customerId}/notfoundexception")
    public Customer getCustomerNotFoundException(@PathVariable("customerId") Long id){
        throw new ApiRequestException("NotFoundException for customer " + id);
    }

    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
        System.out.println("POST REQUEST");
        System.out.println(customer);
    }

    @DeleteMapping(path ="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);

    }

    @PutMapping
    void UpdateNewCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST");
        System.out.println(customer);
    }
}
