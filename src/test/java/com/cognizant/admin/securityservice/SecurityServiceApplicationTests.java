package com.cognizant.admin.securityservice;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest(classes=SecurityServiceApplicationTests.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class SecurityServiceApplicationTests {
	
	private MockMvc mockMvc;
	@Test
    public void test_getuser() throws Exception {
        ModelAndView modelAndView = mockMvc.perform(get("/users")).
            andExpect(status().isOk()).andReturn().getModelAndView();
        assertEquals("login", modelAndView.getViewName());
    }


}
