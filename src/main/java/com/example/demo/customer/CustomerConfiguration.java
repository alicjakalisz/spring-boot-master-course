package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}") //here the default is false, but  go to Demoapplication edit and in program arguments --app.UseFakeCustomerRepo=true , we have overriden with true what is here
    private Boolean useFakeCustomerRepo;


    @Value("${info.company.name}")
    private String companyName; // value from the application.properties is inside in this variable

    //OR OTHER WAY:
    @Autowired
    private Environment environment;


    //w use this set when we want to inject a few service at the start of application. But in order so we can use this class (CommandLineRunner)
    //we need to create bean for this class. This class has not been created by us. We use it so we need to make a bean of it (we cannot add @Component annotations
    //to original class as it is not ours
    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){ //to map all the appliction properties re info app into class
        return args -> {
            System.out.println("Command line runner hooray");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.company.name"));
            System.out.println(infoApp);
            System.out.println(infoApp.getDescription());
        };
    }

    //if you implement configuraton set up for implementation of customerRepo (customerRepository or FakeCustomerRepository)
    // then you create this bean now and you can remove @Repository annotations from the classes.FIRST version had depending on boolean value to assign fakerepo or customerrepo
    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return new CustomerFakeRepository();
    }
}
