package com.example.jwt.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XssTest {

    @Test
    public void test(){
        String content = "<li>content</li>";
        String expected = "&lt;li&gt;content&lt;/li&gt;";



    }


}
