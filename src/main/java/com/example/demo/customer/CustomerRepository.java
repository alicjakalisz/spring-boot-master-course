package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.List;

//@Repository - bean config that implements CustomerRepository or CustomerFakeRepository is created so we dont these classes as components
//@Primary here and qualifier in other fake repo removed as everything is now done through configuration in CustomerConfiguration class
public class CustomerRepository implements CustomerRepo {




    @Override
    public List<Customer> getCustomers() {
        //todo
        return Collections.singletonList(new Customer(1L, "Todo. Implement real db", "todo", "email@gmail.com"));
    }
}
