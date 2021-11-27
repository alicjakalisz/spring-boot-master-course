package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    //there are more than 1 implementations of interface customerRepo
   // public CustomerService(@Qualifier("fake") CustomerRepo customerRepo) we can point to Component with value fake to be injected here, otherwise the one with primary annotation will be injected
    public CustomerService( CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id){
      return     getCustomers().stream().filter(customer -> customer.getId().equals(id))
                .findFirst()
       //         .orElseThrow(()-> new IllegalStateException("customer with id " + id +" not found")); //apears in the log but client does not know about it. In status of response there is 500 Server Error initially.
        //one way to pass message to the client in status response (in properties file: server.error.include-message=always
        //server.error.include-binding-errors=always server.error.include-stacktrace=always)
        //second way - status codes

              .orElseThrow(()-> new NotFoundException("Not found expcetion"));
    }

}
