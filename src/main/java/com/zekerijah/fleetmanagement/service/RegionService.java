package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Region;
import com.zekerijah.fleetmanagement.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegions(){
        return regionRepository.findAll();
    }

    public void saveRegion(Region region){
        regionRepository.save(region);
    }

    public Optional<Region> getRegionById(Integer id){
        return regionRepository.findById(id);
    }

    public void deleteRegionById(Integer id){
        regionRepository.deleteById(id);
    }
}
