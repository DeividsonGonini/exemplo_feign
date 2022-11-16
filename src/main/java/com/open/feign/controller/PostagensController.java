package com.open.feign.controller;

import com.open.feign.client.PostagensClient;
import com.open.feign.domain.PostagensFeignRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping
public class PostagensController {

    private PostagensClient postagensClient;

    //Retorna todas as postagens
    @GetMapping("posts")
    public List<PostagensFeignRequest> getAllPosts() {
        return postagensClient.getAllPosts();
    }

    //Retorna apenas com os ids Pares
    @GetMapping("post_par")
    public List<PostagensFeignRequest> getPostsPares() {

        List<PostagensFeignRequest> postagens = postagensClient.getAllPosts();

        List<PostagensFeignRequest> postagensPar = postagens.stream()
                .limit(10)
                .filter(elementoLista -> elementoLista.getId() % 2 == 0)
                .collect(Collectors.toList());

        return postagensPar;
    }

    //Retorna apenas com os ids começados com 1
    @GetMapping("posts/id_alterado")
    public List<PostagensFeignRequest> getAlteraId() {
        List<PostagensFeignRequest> postagens = postagensClient.getAllPosts();

        List<PostagensFeignRequest> postIdsUmAlterado = postagens
                .stream()
                .filter(postagem -> postagem.getId().toString().startsWith("1"))
                .collect(Collectors.toList());

    return postIdsUmAlterado;
    }

    @PostMapping("/posts")
    public PostagensFeignRequest save(@RequestBody PostagensFeignRequest postagensFeignRequest) {
      PostagensFeignRequest postagemRequest = postagensClient.save(postagensFeignRequest);
        return postagemRequest;
    }

}
