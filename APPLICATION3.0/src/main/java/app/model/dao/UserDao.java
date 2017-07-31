package app.model.dao;

import java.util.List;

public interface UserDao<E>{
    
    public void save(E e);
    public void update(E e);
    public E getUserById(int id);
    public E getUserByName(String name);
    public List<E> getUserList();
    public boolean checkUserLoginExist(String login);
    public void delete(E e);
    public void deleteAll();
    public void deleteUserById(int id);
    public void deleteUserByName(String name);
}