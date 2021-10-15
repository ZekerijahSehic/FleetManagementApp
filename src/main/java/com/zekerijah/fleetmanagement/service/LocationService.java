package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Country;
import com.zekerijah.fleetmanagement.model.Location;
import com.zekerijah.fleetmanagement.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public void saveLocation(Location location){
        locationRepository.save(location);
    }

    public Optional<Location> getLocationById(Integer id){
        return locationRepository.findById(id);
    }

    public void deleteLocationById(Integer id){
        locationRepository.deleteById(id);
    }
}
