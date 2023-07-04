package com.codeclan.example.managementservice.repository;

import com.codeclan.example.managementservice.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
