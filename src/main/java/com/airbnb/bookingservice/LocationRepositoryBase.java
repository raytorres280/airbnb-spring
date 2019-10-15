package com.airbnb.bookingservice;

import org.springframework.stereotype.Repository;

@Repository
public class LocationRepositoryBase implements LocationRepository {

    @Override
    public Location findById(int i) {

        return null;
    }
}
