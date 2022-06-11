package br.com.kamehouse.lulu.core.repository;

import br.com.kamehouse.lulu.core.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);

}
