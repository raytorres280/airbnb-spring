package com.airbnb.bookingservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations/{id}")
    private Location getLocation(@PathVariable int id) {
        return locationService.getLocationDetails(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void locationNotFoundHandler(LocationNotFoundException ex) {}

}
