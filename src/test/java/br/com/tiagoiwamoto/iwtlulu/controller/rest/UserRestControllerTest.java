package br.com.tiagoiwamoto.iwtlulu.controller.rest;

import br.com.tiagoiwamoto.iwtlulu.business.object.UserBO;
import br.com.tiagoiwamoto.iwtlulu.entity.User;
import br.com.tiagoiwamoto.iwtlulu.model.ApiDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:46
 */

@RunWith(SpringRunner.class)
public class UserRestControllerTest {

    @InjectMocks
    private UserRestController userRestController;
    @Mock
    private UserBO userBO;

    @Test
    public void login() {
        Mockito.when(this.userBO.performLogin(Mockito.anyString(), Mockito.anyString())).thenReturn(new ApiDTO<>("", "", new User()));
        Assert.assertNotNull(Objects.requireNonNull(this.userRestController.login("", "").getBody()).getDetails());
    }

    @Test
    public void recoverUserByEmail() {
        Mockito.when(this.userBO.performFindUserByEmail(Mockito.anyString())).thenReturn(new ApiDTO<>("", "", new User()));
        Assert.assertNotNull(Objects.requireNonNull(this.userRestController.recoverUserByEmail("").getBody()).getDetails());
    }

    @Test
    public void create() {
        Mockito.when(this.userBO.performUserCreation(Mockito.any())).thenReturn(new ApiDTO<>("", "", new User()));
        Assert.assertNotNull(Objects.requireNonNull(this.userRestController.create(new User()).getBody()).getDetails());
    }
}
