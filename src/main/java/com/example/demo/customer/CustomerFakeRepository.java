package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake") // value set up in case you want to use @Qualifier("fake") in dependency injection to point to this implementation
//bean config that implements CustomerRepository or CustomerFakeRepository is created so we dont these classes as components
public class CustomerFakeRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(new Customer(1L,"James Bond", "password123", "email@gmail.com"),
                            new Customer(2L,"Jamila Ahmed", "123password", "email@gmail.com"));
    }
}
