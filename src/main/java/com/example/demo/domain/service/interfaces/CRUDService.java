package com.example.demo.domain.service.interfaces;

import java.util.List;

public interface CRUDService<T, ID> {
  T create(T t);
  T update(ID id, T t) throws Exception;
  List<T> getAll();
  T getById(ID id);
  void delete(ID id);
}
