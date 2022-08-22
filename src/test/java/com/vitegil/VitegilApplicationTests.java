package com.vitegil;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class VitegilApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJson(){
        String str = "{\"event\":\"device\"}"; //str相当于你发的json串
        String str1 = str;//接受
        System.out.println(str1); //打印

        System.out.println(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }
}
