package Impl;

/**
 * Created by SO on 05.07.2017.
 */
public interface DAO<T>{

    void create(T value);


    T read(int id);


    T update(T value);


    void delete(T value);

}
