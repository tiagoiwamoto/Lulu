package br.com.tiagoiwamoto.iwtlulu.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 12/05/2021 | 09:37
 */

@RunWith(SpringRunner.class)
public class PageControllerTest {

    @InjectMocks
    private PageController pageController;

    @Test
    public void index() {
        Assert.assertNotNull(this.pageController.index());
    }
}
