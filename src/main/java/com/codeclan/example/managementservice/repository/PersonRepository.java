package com.codeclan.example.managementservice.repository;

import com.codeclan.example.managementservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {
}
