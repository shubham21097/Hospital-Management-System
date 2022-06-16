package com.codingsaiyan.HospitalManagementSystem.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingsaiyan.HospitalManagementSystem.Entity.Address;

public interface AddressJpaDAO extends JpaRepository<Address, Integer> {

}
