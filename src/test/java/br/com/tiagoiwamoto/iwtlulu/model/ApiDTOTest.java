package br.com.tiagoiwamoto.iwtlulu.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:57
 */

public class ApiDTOTest {

    @Test
    public void testApiDTO(){
        ApiDTO<String> apiDTO = new ApiDTO<>();
        apiDTO = new ApiDTO<String>("", "", "");
        apiDTO = apiDTO.withCode("0").withMessage("").withDetail("");

        Assert.assertNotNull(apiDTO.getCode());
        Assert.assertNotNull(apiDTO.getMessage());
        Assert.assertNotNull(apiDTO.getDetails());
        Assert.assertNotNull(apiDTO.getProtocol());
        Assert.assertNotNull(apiDTO.getTimestamp());

        Assert.assertNotNull(apiDTO.toString());
    }

}
