package br.com.tiagoiwamoto.iwtlulu.business.service;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 05/05/2021 | 20:30
 */

import br.com.tiagoiwamoto.iwtlulu.entity.User;
import br.com.tiagoiwamoto.iwtlulu.exception.UserCreationException;
import br.com.tiagoiwamoto.iwtlulu.exception.UserNotFoundException;
import br.com.tiagoiwamoto.iwtlulu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        log.info("starting method saveUser()");
        try{
            return this.userRepository.save(user);
        }catch (Exception e){
            log.error("Failed to persist data on database", e);
            throw new UserCreationException();
        }
    }

    public User recoverUserWithEmailAndPassword(String email, String password){
        log.info("starting method recoverUserWithEmailAndPassword()");
        try{
            Optional<User> optionalUser = this.userRepository.findByEmailAndPassword(email, password);
            log.info("user found -> ".concat(optionalUser.toString()));
            return optionalUser.orElseThrow(UserCreationException::new);
        }catch (Exception e){
            log.error("Failed to recover data from database", e);
            throw new UserNotFoundException();
        }
    }

    public User recoverUserWithEmail(String email){
        log.info("starting method recoverUserWithEmail()");
        try{
            Optional<User> optionalUser = this.userRepository.findByEmail(email);
            log.info("user found -> ".concat(optionalUser.toString()));
            return optionalUser.orElseThrow(UserCreationException::new);
        }catch (Exception e){
            log.error("Failed to recover data from database", e);
            throw new UserNotFoundException();
        }
    }
}
