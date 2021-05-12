package br.com.tiagoiwamoto.iwtlulu.business.service;

import br.com.tiagoiwamoto.iwtlulu.entity.User;
import br.com.tiagoiwamoto.iwtlulu.exception.UserCreationException;
import br.com.tiagoiwamoto.iwtlulu.exception.UserNotFoundException;
import br.com.tiagoiwamoto.iwtlulu.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 08:18
 */

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        Mockito.when(this.userRepository.save(Mockito.any())).thenReturn(new User());
        Assert.assertNotNull(this.userService.saveUser(new User()));
    }

    @Test(expected = UserCreationException.class)
    public void saveUserException() {
        Mockito.when(this.userRepository.save(Mockito.any())).thenThrow(NullPointerException.class);
        this.userService.saveUser(new User());
    }

    @Test
    public void recoverUserWithEmailAndPassword() {
        Mockito.when(this.userRepository.findByEmailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(new User()));
        Assert.assertNotNull(this.userService.recoverUserWithEmailAndPassword("email", "password"));
    }

    @Test(expected = UserNotFoundException.class)
    public void recoverUserWithEmailAndPasswordException() {
        Mockito.when(this.userRepository.findByEmailAndPassword(Mockito.anyString(), Mockito.anyString())).thenThrow(NullPointerException.class);
        this.userService.recoverUserWithEmailAndPassword("email", "password");
    }

    @Test
    public void recoverUserWithEmail() {
        Mockito.when(this.userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(new User()));
        Assert.assertNotNull(this.userService.recoverUserWithEmail("email"));
    }

    @Test(expected = UserNotFoundException.class)
    public void recoverUserWithEmailException() {
        Mockito.when(this.userRepository.findByEmail(Mockito.anyString())).thenThrow(NullPointerException.class);
        this.userService.recoverUserWithEmail("email");
    }
}
