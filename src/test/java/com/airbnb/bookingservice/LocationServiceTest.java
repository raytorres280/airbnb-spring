package com.airbnb.bookingservice;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationServiceBase locationService;

    @Before
    public void setUp() throws Exception {
        locationService = new LocationServiceBase(locationRepository);
    }

    @Test
    public void getLocationDetails_returnsLocation() {
        given(locationRepository.findById((long) 1)).willReturn(java.util.Optional.of(new Location(1, "name", "city", (float) 4.2, 1)));

        Location loc = locationService.getLocationDetails(1);
        assertThat(loc.getId()).isEqualTo(1);
    }

    @Test(expected = LocationNotFoundException.class)
    public void getLocationDetails_throwsLocationNotFound() throws Exception {
        given(locationRepository.findById((long) 1)).willReturn(null);

        //is this better?
//        given(locationRepository.findById((long) 1)).willReturn(Optional.empty());

        locationService.getLocationDetails(1);

    }

}
