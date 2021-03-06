package com.example.pre.evaluation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pre.evaluation.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Optional<Address> findByStudentId(int id);

}
