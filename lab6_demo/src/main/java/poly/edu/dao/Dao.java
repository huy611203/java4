package poly.edu.dao;

import java.util.List;

public abstract class Dao<E,K>{
   abstract public void insert(E entity);
   abstract public void update(E entity);
   abstract public void delete(K entity);
   abstract public List<E> finAll();
   abstract public E finByID(K key);
   
}