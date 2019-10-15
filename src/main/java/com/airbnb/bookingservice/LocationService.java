package com.airbnb.bookingservice;

import org.springframework.stereotype.Service;

public interface LocationService {
    Location getLocationDetails(long id);
}
