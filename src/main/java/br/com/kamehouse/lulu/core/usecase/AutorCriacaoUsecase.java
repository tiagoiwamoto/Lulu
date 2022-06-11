package br.com.kamehouse.lulu.core.usecase;

import br.com.kamehouse.lulu.core.adapter.impl.AutorAdapterImpl;
import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.entrypoint.dto.AutorDto;
import br.com.kamehouse.lulu.entrypoint.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorCriacaoUsecase {

    private final AutorAdapterImpl autorAdapterImpl;

    public ResponseDto<Autor> criacaoDeAutor(AutorDto autorDto){
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        autor.convertPassword();
        Autor autorSalvo = this.autorAdapterImpl.salvar(autor);
        BeanUtils.copyProperties(autorSalvo, autorDto);
        autorDto.setSenha("#############################");
        return ResponseDto.of(HttpStatus.CREATED, autorDto);
    }

}
