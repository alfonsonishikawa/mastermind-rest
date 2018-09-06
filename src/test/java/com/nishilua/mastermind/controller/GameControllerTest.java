package com.nishilua.mastermind.controller;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nishilua.mastermind.App;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameControllerTest {
    @Value("${local.server.port}")
    int port;

    // GameID for several tests
    private static String gameId ;
    
    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testA1EmptyGamesListIsEmpty() {
    	when().
    		get("/v1/game").
    	then().
    		statusCode(200).body("games", hasSize(0)) ;
    }
    
    @Test
    public void testA2NewGameIdIsUuid() {
    	gameId = when()
    		.post("/v1/game")
    	.then().statusCode(200).extract().response().body().path("gameId") ;
    	
    	// Will throw an exception if it is not an UUID
    	UUID.fromString(gameId);
    }
    
    @Test
    public void testA3EmptyGamesListIsEmpty() {
    	when()
    		.get("/v1/game")
    	.then()
    		.statusCode(200)
    		.body("games.size()", is(1))
    		.and()
    		.body("games", contains(new String[] { gameId }) ) ;
    }
    
}