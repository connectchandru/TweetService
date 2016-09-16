package com.tweeter.service.controller;
import javax.servlet.http.HttpServletResponse;

import com.tweeter.service.controller.SpringServiceController;
import com.tweeter.service.dao.UserService;
import com.tweeter.service.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration ("classpath:rest-servlet.xml")
public class SpringServiceControllerTest {
	private static final String START = "/tweeter/";
    private UserService userService;	
    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        userService = (UserService) context.getBean("userService");
        RestAssuredMockMvc.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test public void getUserById() {
        //LocalDateTime dateTime = LocalDateTime.now ();
        //String now = formatter.format (dateTime);
    	String username= "connectchandru";
        org.mockito.Mockito.
                when (userService.getUserById(username)).
                thenReturn (new User ("connectchandru", "Chandrasekar","Srinivasan", "1988-03-06", "connectchandru@gmail.com"));

        given().
        when().
                get (START + username).
        then().
                statusCode (HttpServletResponse.SC_OK).
                contentType ("application/json").
                body ("username",  equalTo ("connectchandru")).
                body ("firstname",   equalTo ("Chandrasekar")).
                body ("lastname",   equalTo ("Srinivasan")).
                body ("dob",   equalTo ("1988-03-06")).
                body ("email", equalTo ("connectchandru@gmail.com"));
    }

    /*
    @Test
    public void getUserById() throws Exception {
        String username = "connectchandru";
        mockMvc.perform(
                get("/tweeter/{username}",username).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("username").value(username));
    }
    */


}
