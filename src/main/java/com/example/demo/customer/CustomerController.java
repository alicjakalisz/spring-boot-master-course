package com.example.demo.customer;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

;
import javax.validation.Valid;
import java.util.List;

@RequestMapping(path="api/v1/customer") // so we can use localhost:8080/api/v1/customer
@RestController
@Deprecated //you use this annotation just to mark this as an older version.
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //localhost:8080/api/v1/customer/all
    @GetMapping(path = "all") // JACKSON library is converting Entity to Json and back?
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){ // @NotBlank needs to be set on getters in Customer class along with valid here.
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
