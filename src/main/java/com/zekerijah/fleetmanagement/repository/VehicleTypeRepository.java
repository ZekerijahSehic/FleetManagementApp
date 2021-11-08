package com.zekerijah.fleetmanagement.repository;

import com.zekerijah.fleetmanagement.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

    @Query(value = "select * from Vehicle_Type v where v.details like %:keyword% or v.description like %:keyword%", nativeQuery = true)
    List<VehicleType> findByKeyword(@Param("keyword") String keyword);
}
