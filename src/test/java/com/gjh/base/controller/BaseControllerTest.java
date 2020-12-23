package com.gjh.base.controller;

import com.gjh.base.model.ApiResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseControllerTest {

    @Autowired
    BaseController baseController;

    @Test
    public void index() {
        ApiResult index = baseController.index();
        assertEquals(200, index.getStatus(), 0);
    }
}