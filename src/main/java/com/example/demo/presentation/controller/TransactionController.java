package com.example.demo.presentation.controller;


import com.example.demo.domain.entity.Transaction;
import com.example.demo.domain.service.interfaces.TransactionService;
import com.example.demo.presentation.request.dto.TransactionDto;
import com.example.demo.presentation.response.pojo.TransactionPojo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Transacciones", description = "Gestión de transacciones de ingresos y egresos")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

  private final TransactionService service;

  @Operation(summary = "Crear una transacción")
  @PostMapping
  public ResponseEntity<Transaction> create(
      @Valid @RequestBody TransactionDto dto) {
    Transaction saved = service.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @Operation(summary = "Actualizar una transacción")
  @PutMapping("/{id}")
  public ResponseEntity<Transaction> update(@PathVariable Integer id,
      @Valid @RequestBody TransactionDto dto) {
    Transaction updated = service.update(id, dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(updated);
  }

  @Operation(summary = "Obtener una transacción por su Id")
  @GetMapping("/{id}")
  public ResponseEntity<TransactionPojo> getById(@PathVariable Integer id) {
    TransactionPojo found = service.getPojoById(id);
    return ResponseEntity.status(HttpStatus.OK).body(found);
  }

  @Operation(summary = "Eliminar una transacción por su Id")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @Operation(summary = "Obtener un listado de transacciones")
  @GetMapping("/search")
  public ResponseEntity<List<TransactionPojo>> search() {
    List<TransactionPojo> list = service.search();
    return ResponseEntity.status(HttpStatus.OK).body(list);
  }
}
