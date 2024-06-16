package com.example.demo.data.repository;

import com.example.demo.domain.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {


}
