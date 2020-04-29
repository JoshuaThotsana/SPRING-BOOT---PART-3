package com.joshua.springboot.service;

import com.joshua.springboot.repository.FakeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {

    @LocalServerPort
    private int port;
    private URL baseUrl;
    @Autowired
    private TestRestTemplate template;

    UserServiceImpl service = new UserServiceImpl(new FakeRepo());

    @Test
    void addUser() {

        assertEquals("[Joshua] entered",service.addUser("Joshua","Mabotsa") );
        service.removeUser(1);
    }

    @Test
    void removeUser() {
        service.addUser("Joshua","Mabotsa");
        assertEquals("[Joshua] removed",service.removeUser(1));
    }

    @Test
    void getUser() {
        service.addUser("Joshua","Mabotsa");
        assertEquals("hello [Joshua]",service.getUser(1) );
    }

    @Test
    void testCache() {
        service.addUser("Joshua2","Mabotsa");
        service.getUser(1);
        service.getUser(1);
        service.getUser(1);
        service.getUser(1);
    }

    @BeforeEach
    public void urlLink()throws Exception{
        this.baseUrl=new URL("http://localhost:"+port);
    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<String> response = template.withBasicAuth("spring", "secret")
                .getForEntity("/private/hello", String.class);
    }

}