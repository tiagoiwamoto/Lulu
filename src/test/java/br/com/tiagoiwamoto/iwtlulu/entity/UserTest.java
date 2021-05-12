package br.com.tiagoiwamoto.iwtlulu.entity;

import br.com.tiagoiwamoto.iwtlulu.model.UserStatusEnum;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:55
 */

public class UserTest {

    @Test
    public void testEntity(){
        User user = new User();
        user.setId(1L);
        user.setName("");
        user.setEmail("");
        user.setPassword("");
        user.setStatus(UserStatusEnum.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());

        Assert.assertNotNull(user.getId());
        Assert.assertNotNull(user.getName());
        Assert.assertNotNull(user.getEmail());
        Assert.assertNotNull(user.getPassword());
        Assert.assertNotNull(user.getStatus());
        Assert.assertNotNull(user.getCreatedAt());
        Assert.assertNotNull(user.toString());
    }

}
