package br.com.kamehouse.lulu.core.repository;

import br.com.kamehouse.lulu.core.domain.Sigla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiglaRepository extends JpaRepository<Sigla, Long> {


    @Query(value = "select * from tbl_lulu_sigla order by id desc limit 1", nativeQuery = true)
    Optional<Sigla> ultimaSiglaCadastrada();

    @Query(value = "select * from tbl_lulu_sigla order by id asc limit 1", nativeQuery = true)
    Optional<Sigla> primeiraSiglaCadastrada();

}
