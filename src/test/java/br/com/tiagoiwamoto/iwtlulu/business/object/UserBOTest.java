package br.com.tiagoiwamoto.iwtlulu.business.object;

import br.com.tiagoiwamoto.iwtlulu.business.service.UserService;
import br.com.tiagoiwamoto.iwtlulu.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 07:59
 */

@RunWith(SpringRunner.class)
public class UserBOTest {

    @InjectMocks
    private UserBO userBO;
    @Mock
    private UserService userService;

    @Test
    public void performUserCreation() {
        Mockito.when(this.userService.saveUser(Mockito.any())).thenReturn(new User());
        Assert.assertNotNull(this.userBO.performUserCreation(new User()));
    }

    @Test
    public void performLogin() {
        Mockito.when(this.userService.recoverUserWithEmailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(new User());
        Assert.assertNotNull(this.userBO.performLogin("email", "senha"));
    }

    @Test
    public void performFindUserByEmail() {
        Mockito.when(this.userService.recoverUserWithEmail(Mockito.anyString())).thenReturn(new User());
        Assert.assertNotNull(this.userBO.performFindUserByEmail("email"));
    }
}
