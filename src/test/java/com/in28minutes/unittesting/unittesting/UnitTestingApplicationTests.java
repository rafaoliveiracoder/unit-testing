package com.in28minutes.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = UnitTestingApplication.class)
//@TestPropertySource(locations= {"classpath:test-configuration.properties"})
public class UnitTestingApplicationTests {

    @Test
    public void contextLoads() {
    }

}