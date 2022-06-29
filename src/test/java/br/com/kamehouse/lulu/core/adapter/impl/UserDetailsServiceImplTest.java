package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.repository.AutorRepository;
import br.com.kamehouse.lulu.utils.GenerateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private AutorRepository autorRepository;

    @Test
    void loadUserByUsername() {
        Mockito.when(this.autorRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(GenerateData.generateAutor()));
        Assertions.assertTrue(this.userDetailsService.loadUserByUsername("").getUsername().length() > 0);
    }
}