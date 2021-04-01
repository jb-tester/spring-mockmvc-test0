package com.mytests.spring.springmockmvctest0;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringMockmvcTest0ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(get("/controller1/test1")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("test1"))
                 .andExpect(model().attribute("test1_attr1", "test1"));
    }

    @Test
    void test2() throws Exception{
        this.mockMvc.perform(get("/controller1/test2/{pv1}_{pv2}/start", "foo","bar"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("test2"))
                .andExpect(model().attribute("test2_attr1", "test2"))
                .andExpect(model().attribute("pv1", "foo"))
                .andExpect(model().attribute("pv2", "bar"))
        
        ;
    }
    @Test
    public void test3() throws Exception {
        this.mockMvc.perform(get("/controller1/test3").param("param1","foo")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("test3"))
                .andExpect(model().attribute("req_param1", "foo"))
                .andExpect(model().attribute("test3_attr1", "test3"));
    }
    
}
