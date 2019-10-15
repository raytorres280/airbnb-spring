package com.airbnb.bookingservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getLocationById_returnsLocation () throws Exception {

        ResponseEntity<Location> res = restTemplate.getForEntity("/locations/1", Location.class);

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(Objects.requireNonNull(res.getBody()).getId()).isEqualTo(1);
        Assertions.assertThat(res.getBody().getName()).isEqualTo("Hoboken");


    }
}
