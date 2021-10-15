package com.zekerijah.fleetmanagement.repository;

import com.zekerijah.fleetmanagement.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
