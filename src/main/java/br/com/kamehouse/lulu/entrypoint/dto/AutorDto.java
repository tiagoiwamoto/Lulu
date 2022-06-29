package br.com.kamehouse.lulu.entrypoint.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AutorDto {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime timestamp;
    private Integer total;

}
