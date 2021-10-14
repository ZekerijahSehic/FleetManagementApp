package com.zekerijah.fleetmanagement.repository;

import com.zekerijah.fleetmanagement.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
