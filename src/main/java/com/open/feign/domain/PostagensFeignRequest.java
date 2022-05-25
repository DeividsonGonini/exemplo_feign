package com.open.feign.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostagensFeignRequest {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

}

