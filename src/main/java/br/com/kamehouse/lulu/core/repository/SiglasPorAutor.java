package br.com.kamehouse.lulu.core.repository;

import java.time.LocalDateTime;

public interface SiglasPorAutor {

    Long getId();
    String getNome();
    String getEmail();
    LocalDateTime getTimestamp();
    Integer getTotal();

}
