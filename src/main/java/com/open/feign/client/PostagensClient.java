package com.open.feign.client;

import com.open.feign.domain.PostagensFeignRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com/")
public interface PostagensClient {

    //Criando metodo para retorno de posts
    @GetMapping(value = "/posts")
    List<PostagensFeignRequest> getAllPosts();

    //Criando metodo para incluir postagens
    @PostMapping(value = "/posts",
            consumes = "application/json",
            produces = "application/json")
    PostagensFeignRequest save( @RequestBody PostagensFeignRequest postagensFeignRequest);


}
