package br.com.kamehouse.lulu.entrypoint.dto;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SiglaDto {

    private Long id;
    private String sigla;
    private String significadoDaSigla;
    private TipoSigla tipo;
    private Autor autor;
    private LocalDateTime timestamp;

}
