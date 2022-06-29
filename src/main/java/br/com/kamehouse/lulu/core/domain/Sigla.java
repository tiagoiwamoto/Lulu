package br.com.kamehouse.lulu.core.domain;

import br.com.kamehouse.lulu.core.domain.enums.TipoSigla;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_lulu_sigla")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Sigla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigla;
    private String significadoDaSigla;
    @Enumerated(EnumType.ORDINAL)
    private TipoSigla tipo;

    @ManyToOne
    @JoinColumn(name = "tbl_lulu_autor_id")
    private Autor autor;
    private LocalDateTime timestamp;

}
