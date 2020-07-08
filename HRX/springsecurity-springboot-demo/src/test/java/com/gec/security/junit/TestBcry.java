package com.gec.security.junit;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class TestBcry {

    @Test
    public void testBcrypt(){
        String password = "123";
        //$2a$10$eXTjw89R3PKklwcRx/G1W.mc./0QG7w.OVIm.wmXfQrBjNi4je36a
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String text = encoder.encode(password);
        System.out.println(text);
    }
}
