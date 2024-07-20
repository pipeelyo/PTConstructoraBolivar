package com.ConstructoraBolivar.afgc.infrastructure.controllers;

import com.ConstructoraBolivar.afgc.application.services.LocationService;
import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.infrastructure.adapters.ExternalServiceAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;
    private final ExternalServiceAdapter externalServiceAdapter;

    public LocationController(final LocationService locationService, final ExternalServiceAdapter externalServiceAdapter) {
        this.locationService = locationService;
        this.externalServiceAdapter = externalServiceAdapter;
    }

    @PostMapping
    public ResponseEntity<Location> createCharacter(@RequestBody Location location) {
        Location created = locationService.createLocation(location);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getCharacter(@PathVariable Long id) {
        return  locationService.getLocation(id)
                .map(character -> new ResponseEntity<>( character, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllCharacters() {
        List<Location> locations = locationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateCharacter(@PathVariable Long id, @RequestBody Location location){
        return  locationService.updateLocation(id, location)
                .map(location1 -> new ResponseEntity<>(location1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteCharacter(@PathVariable Long id) {
        if(locationService.deleteLocation(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/aditionalinfo")
    public ResponseEntity<Location> getCharacterByAditionalInfo(@RequestParam Long id){
        Location location = externalServiceAdapter.getLocation(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
