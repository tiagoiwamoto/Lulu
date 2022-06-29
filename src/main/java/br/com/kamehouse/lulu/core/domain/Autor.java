package br.com.kamehouse.lulu.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_lulu_autor")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime timestamp;

    public Autor convertPassword(){
        this.senha = new BCryptPasswordEncoder().encode(this.senha);
        this.timestamp = LocalDateTime.now();
        return this;
    }

}
