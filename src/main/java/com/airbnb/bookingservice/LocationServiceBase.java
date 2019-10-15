package com.airbnb.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceBase implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceBase(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getLocationDetails(int id) {
        Location loc = locationRepository.findById(id);
        if(loc == null) {
            throw new LocationNotFoundException();
        }
        return loc;
    }
}
