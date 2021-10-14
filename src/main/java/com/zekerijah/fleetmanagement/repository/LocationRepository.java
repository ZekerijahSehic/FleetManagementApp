package com.zekerijah.fleetmanagement.repository;

import com.zekerijah.fleetmanagement.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
