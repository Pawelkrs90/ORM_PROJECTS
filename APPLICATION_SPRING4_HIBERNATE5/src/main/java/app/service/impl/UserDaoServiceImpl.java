package app.service.impl;

import app.model.User;
import app.model.dao.UserDao;
import app.service.UserDaoService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl implements UserDaoService<User>{
    
    private UserDao userDao;
    
    public void setUserDao(UserDao dao){
        this.userDao = dao;
    }
    
    @Override
    @Transactional
    public void save(User user) {
        
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(int id) {
        return (User) userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return (User) userDao.getUserByName(name);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public boolean checkUserLoginExist(String login) {
        return userDao.checkUserLoginExist(login);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteUserByName(String name) {
        userDao.deleteUserByName(name);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }

}