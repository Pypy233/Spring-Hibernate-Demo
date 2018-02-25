package com.example.blog.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)

public class UserControllerTest {
    private MockMvc mvc;
    @Before
    public void setup() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");

    }

    @Test
    public void getUserList() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }

    @Test
    public void postUser() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("\"Success\"")));
    }

    @Test
    public void getUser() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

    }

    @Test
    public void putUser() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("\"Success\"")));

    }

    @Test
    public void deleteUser() throws Exception{
        RequestBuilder request = null;
        request = get("/users/");
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("\"Success\"")));
    }
}