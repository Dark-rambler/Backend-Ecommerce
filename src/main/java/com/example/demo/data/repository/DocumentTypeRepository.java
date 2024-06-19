package com.example.demo.data.repository;

import com.example.demo.domain.entity.DocumentType;
import com.example.demo.presentation.response.pojo.DocumentTypePojo;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DocumentTypeRepository extends GenericRepository<DocumentType, Integer>{

  Optional<DocumentType> findByIdAndActive(Integer id, Boolean active);

  @Query(
      "SELECT new com.example.demo.presentation.response.pojo.DocumentTypePojo"
          + "(d.id, d.name, d.description) "
          + "FROM DocumentType d "
          + "WHERE d.id = :id AND d.active"
  )
  DocumentTypePojo getPojoById(Integer id);

  @Query(
      "SELECT new com.example.demo.presentation.response.pojo.DocumentTypePojo"
          + "(d.id, d.name, d.description) "
          + "FROM DocumentType d "
          + "WHERE d.active"
  )
  List<DocumentTypePojo> search();

}
