package br.com.kamehouse.lulu.utils;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.domain.Sigla;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import br.com.kamehouse.lulu.entrypoint.dto.SiglaDto;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class GenerateData {

    public static Autor generateAutor(){
        var autor = new Autor();
        autor.setSenha(UUID.randomUUID().toString());
        autor.setEmail(UUID.randomUUID().toString().concat("@").concat("provedor.com.br"));
        autor.setNome(UUID.randomUUID().toString());
        autor.setTimestamp(LocalDateTime.now());
        autor.setId(Long.valueOf(new Random().nextInt(99999999)));
        return autor;
    }

    public static AutorDto generateAutorDto(){
        var autorDto = new AutorDto();
        autorDto.setSenha(UUID.randomUUID().toString());
        autorDto.setEmail(UUID.randomUUID().toString().concat("@").concat("provedor.com.br"));
        autorDto.setNome(UUID.randomUUID().toString());
        autorDto.setTimestamp(LocalDateTime.now());
        return autorDto;
    }

    public static Sigla generateSigla(){
        Sigla sigla = new Sigla();
        sigla.setSigla(UUID.randomUUID().toString().replaceAll("-", "").substring(0,2));
        sigla.setSignificadoDaSigla(UUID.randomUUID().toString());
        sigla.setAutor(generateAutor());
        sigla.setTimestamp(LocalDateTime.now());
        sigla.setTipo(TipoSigla.PESSOAL);
        sigla.setId(Long.valueOf(new Random().nextInt(99999999)));
        return sigla;
    }

    public static SiglaDto generateSiglaDto(){
        SiglaDto siglaDto = new SiglaDto();
        siglaDto.setSigla(UUID.randomUUID().toString().replaceAll("-", "").substring(0,2));
        siglaDto.setSignificadoDaSigla(UUID.randomUUID().toString());
        siglaDto.setAutor(generateAutor());
        siglaDto.setTimestamp(LocalDateTime.now());
        siglaDto.setTipo(TipoSigla.PESSOAL);
        return siglaDto;
    }

}
