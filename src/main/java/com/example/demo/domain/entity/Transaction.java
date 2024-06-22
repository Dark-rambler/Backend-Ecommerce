package com.example.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "transaction")
public class Transaction extends Base{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "social_reason", nullable = false)
  private String socialReason;

  @Column(name = "document_number", nullable = false)
  private String documentNumber;

  @Column(name = "is_income", nullable = false)
  private Boolean isIncome;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "description", nullable = false, length = 100)
  private String description;

  @Column(name = "date", nullable = false)
  private LocalDateTime date;

  @ManyToOne
  @JoinColumn(name = "document_type_id", nullable = false)
  private DocumentType documentType;
}
