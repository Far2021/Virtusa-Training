package com.example.Register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Register.domain.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {

}
