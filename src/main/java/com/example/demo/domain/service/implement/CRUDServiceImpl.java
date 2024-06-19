package com.example.demo.domain.service.implement;

import com.example.demo.common.SpanishEntityNameProvider;
import com.example.demo.data.repository.GenericRepository;
import com.example.demo.domain.service.interfaces.CRUDService;
import com.example.demo.exception.EntityNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CRUDServiceImpl<T, ID> implements CRUDService<T, ID> {

  protected abstract GenericRepository<T, ID> getRepository();

  @Override
  public T create(T t) {
    return getRepository().save(t);
  }

  @Override
  public T update(ID id, T t) throws Exception {
    Class<?> clazz = t.getClass();
    Method setIdMethod = clazz.getMethod("setId", id.getClass());
    setIdMethod.invoke(t, id);

    T entityGenericFound = getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(
        SpanishEntityNameProvider.getSpanishName(getEntityName()), (Integer) id));

    Class<?> genericClazz = entityGenericFound.getClass();
    Field field = genericClazz.getField("createdAt");
    field.setAccessible(true);
    Object createdAt = field.get(entityGenericFound);
    Method setCreatedAt = entityGenericFound.getClass().getMethod("setCreatedAt", createdAt.getClass());
    setCreatedAt.invoke(t, createdAt);

    return getRepository().save(t);
  }

  @Override
  public List<T> getAll() {
    return getRepository().findAll();
  }

  @Override
  public T getById(ID id) {
    return getRepository().findById(id).orElseThrow(()-> new EntityNotFoundException(SpanishEntityNameProvider.getSpanishName(getEntityName()), (Integer) id));
  }

  @Override
  public void delete(ID id) {
    getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(SpanishEntityNameProvider.getSpanishName(getEntityName()), (Integer) id));
    getRepository().deleteById(id);
  }

  private String getEntityName() {
    ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
    return ((Class<?>) parameterizedType.getActualTypeArguments()[0]).getSimpleName();
  }
}
