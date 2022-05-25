package com.open.feign.controller;

import com.open.feign.client.PostagensClient;
import com.open.feign.domain.PostagensFeignRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("post_par")
    public List<PostagensFeignRequest> getPostsPares() {

        List<PostagensFeignRequest> postagens = postagensClient.getAllPosts();

        List<PostagensFeignRequest> postagensPar = postagens.stream()
                .limit(10)
                .filter(elementoLista -> elementoLista.getId() % 2 == 0)
                .collect(Collectors.toList());

        return postagensPar;
    }

    //filtroando os ids começados com 1
    @GetMapping("posts/id_alterado")
    public List<PostagensFeignRequest> getAlteraId() {
        List<PostagensFeignRequest> postagens = postagensClient.getAllPosts();

        List<PostagensFeignRequest> postIdsUmAlterado = postagens
                .stream()
                .filter(postagem -> postagem.getId().toString().startsWith("1"))
                .collect(Collectors.toList());

    return postIdsUmAlterado;
    }
}
