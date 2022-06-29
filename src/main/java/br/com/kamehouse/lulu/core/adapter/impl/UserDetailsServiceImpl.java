package br.com.kamehouse.lulu.core.adapter.impl;

import br.com.kamehouse.lulu.core.domain.Autor;
import br.com.kamehouse.lulu.core.domain.UserDetailsImpl;
import br.com.kamehouse.lulu.core.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AutorRepository autorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Autor autor = this.autorRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new UserDetailsImpl(autor);
    }
}
