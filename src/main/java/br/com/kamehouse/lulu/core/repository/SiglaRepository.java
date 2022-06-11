package br.com.kamehouse.lulu.core.repository;

import br.com.kamehouse.lulu.core.domain.Sigla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiglaRepository extends JpaRepository<Sigla, Long> {
}
