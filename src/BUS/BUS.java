package BUS;

import java.util.ArrayList;

public interface BUS<T> {

    ArrayList<T> getAll();

    T get(int id);

    ArrayList<T> find(String s);

    ArrayList<T> findById(String s);

    boolean insert(T o);

    boolean update(T o);

    boolean remove(int id);
}
