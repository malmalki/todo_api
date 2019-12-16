package com.mohammed.todoapi;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoApplicationTests {

    @LocalServerPort
    int port;


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
    }

    @Test
    public void testRestController() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> stringResponseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/todos", String.class);

        logger.info(stringResponseEntity.toString());
        assertEquals("You have something wring", HttpStatus.OK, stringResponseEntity.getStatusCode());
//        assertNotNull("", stringResponseEntity);

    }

}
