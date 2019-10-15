package com.airbnb.bookingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceBase implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceBase(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location getLocationDetails(long id) {
        Optional<Location> loc = locationRepository.findById(id);
        if(!loc.isPresent()) {
            throw new LocationNotFoundException();
        }
        return loc.get();
    }
}
