package com.example.demo.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// you use it instead of manually convering URLToJSonObject (so making a call to api, gettting json, converting to string and parsing to jsonobject to get later
//members of your jsobobject to use them as attributes to your pojo.
//you inject JsobPlaceHlderClient as propery in service and use its methods described below to receive their model (you need to create pojo class). url is a test here.
//Later you can use this pojo class for getting info for your own Pojo/dto that you want to return to the client or save in db (it wont be necessary the same).
//you need to make a bean of JsobPlaceHolderClient

@FeignClient(
        value = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com/"
)
public interface JSONPlaceHolderClient {

    @GetMapping("posts")
    List<Post> getPosts();

    @GetMapping("posts/{postId}")
    Post getPost(@PathVariable("postId") Integer postId);
}