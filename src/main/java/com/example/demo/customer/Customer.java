package com.example.demo.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

// JACKSON USES POJO with getter methods for serialisation to JSON file (happens with @RequestBody and @GetMapping in controller)
@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//you dont put annotation for getters as they have custom annotations like @Json ignore and we dont want to overwrite it
public class Customer {

    @Id
    private Long id;
    @NotBlank // JSON passed by client needs to have id - you need to set this contraints here but activate it in controller level by annotation @Valid
    private  String name;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // we put JsonIgnore on password getter
    // so when get method is called by the client it does not pass passowrd into Json body. This annotation makes is possible for the client to use post with Json including password
    private  String password;

    @NotBlank (message = "email must not be empty") // you can add message to pass back to client
    @Email //validates email format instead of custom validator you can put regex inside
    private String email;





    //empty constructor and all arg constructors have been deleted as replaced by lombok


    // getters need to exist! so JACKSON library could serilized properties and map it to JSON when passing it in cotrnoller to the client
    //properties in JSON comes from getters (not from attributes direclty). All of the getters will be included in json.
    //name convention important of getters. for Json file it removed get and small case Id, Name

    //id
    @JsonProperty(value = "customer_id") // that name will be passed in Json
    public Long getId() {
        return id;
    }

    //name
    public String getName() {
        return name;
    }

    // how not to pass this property to JSON
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
