package br.com.kamehouse.lulu.entrypoint.dto;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class SiglaDto {

    private Long id;
    @NotNull
    @Size(min = 2, max = 10)
    private String sigla;
    @NotNull
    @Size(min = 5, max = 500)
    private String significadoDaSigla;
    @NotNull
    private TipoSigla tipo;
    private Autor autor;
    private Integer total;
    private LocalDateTime timestamp;

}
