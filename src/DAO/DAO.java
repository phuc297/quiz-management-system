package DAO;

import java.util.ArrayList;

public interface DAO<T> {

    ArrayList<T> getAll();

    T get(int id);

    boolean insert(T o);

    boolean update(T o);

    boolean remove(int o);
}
