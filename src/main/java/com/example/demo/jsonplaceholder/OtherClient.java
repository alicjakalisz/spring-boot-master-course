package com.example.demo.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "peopleInSpace",
        url = "http://api.open-notify.org/astros.json"
)
public interface OtherClient {

    @GetMapping("/posts") // here posts are not correct example from previous api, people in space has only url above
    List<Crew> getCrew();


}
