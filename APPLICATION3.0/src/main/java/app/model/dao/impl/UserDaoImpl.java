package app.model.dao.impl;

import app.model.User;
import app.model.dao.UserDao;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@ApplicationScoped
@Default
public class UserDaoImpl implements UserDao<User>{
    
    @Inject
    private EntityManager entityManager;// = EntityManagerBuilder.getEntityManager();

    @Override
    public void save(User user) {
        System.out.println("DAO - SAVE");
       /* EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);
        
        transaction.commit();*/
   }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserById(int id) {
     /*   EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
    
        User user = entityManager.find(User.class, id);
        
        transaction.commit();
        
        return user;*/
        return null;
    }

    @Override
    public User getUserByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserList() {
       /* EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<User> userList;
        
        try{
            Query query = entityManager.createQuery("SELECT u FROM USERS u");
            userList = query.getResultList();
            transaction.commit();
            return userList;
        }
        catch(Exception e){
            transaction.rollback();
        }
        finally{
            entityManager.close();
        }
        */
        return null;
    }

    @Override
    public boolean checkUserLoginExist(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUserByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}   


