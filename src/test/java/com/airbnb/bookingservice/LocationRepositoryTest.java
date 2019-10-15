package com.airbnb.bookingservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findLocationById_returnsLocation() throws Exception {
        Location newLocation = entityManager.persistFlushFind(new Location(1, "name", "city", (float) 4.2, 1));
        Optional<Location> loc = repository.findById((long) 1);
        assertThat(loc.isPresent()).isTrue();
        assertThat(loc.get().getId()).isEqualTo(1);
    }

    @Test
    public void findLocationById_returnsNull() throws Exception {
        Optional<Location> loc = repository.findById((long) 1);
        assertThat(loc.isPresent()).isFalse();
    }
}
