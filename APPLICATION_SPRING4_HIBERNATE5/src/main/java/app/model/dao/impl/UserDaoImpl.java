package app.model.dao.impl;

import app.exceptions.UserNotFoundException;
import app.model.User;
import app.model.dao.UserDao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao<User>{
    
    private SessionFactory sessionFactory;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
     
    @Transactional
    @Override
    public void save(User user) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            session.persist(user);

            transaction.commit();
            logger.info("Save - succes");
        }
        catch(Exception e){
           logger.info("Save - failed");
           transaction.rollback(); 
        }
    }

    @Override
    public void update(User user) {
       
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            session.merge(user);

            transaction.commit();
            logger.info("Update - succes");
        }
        catch(Exception e){
           logger.info("Update - failed");
           transaction.rollback(); 
        } 
    }

    @Override
    public User getUserById(int id) {
        
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            User user = session.get(User.class, id);
            
            if(user==null){
                throw new NullPointerException(); 
            }

            transaction.commit();
            logger.info("GetUserById - succes");
            return user;
        }
        catch(Exception e){
           logger.info("GetUserById - failed");
           transaction.rollback(); 
           throw new UserNotFoundException(id);
        } 
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            Query query = session.createQuery("FROM User u WHERE u.username = :username");
            query.setParameter("username", name);
            
            User user = (User) query.list().get(0);
            
            if(user==null){
                throw new NullPointerException(); 
            }

            transaction.commit();
            logger.info("GetUserByName - succes");
            return user;
        }
        catch(Exception e){
           logger.info("GetUserByName - failed");
           transaction.rollback(); 
           throw new UserNotFoundException(name);
        } 
    }

    @Override
    public List<User> getUserList() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            Query query = session.createQuery("FROM User u");
 
            List<User> userList = query.list();
            
            if(userList==null || userList.isEmpty()){
                throw new NullPointerException(); 
            }

            transaction.commit();
            logger.info("GetUserList - succes");
            return userList;
        }
        catch(Exception e){
           logger.info("GetUserList - failed");
           transaction.rollback(); 
           throw new UserNotFoundException();
        } 
    }

    @Override
    public boolean checkUserLoginExist(String login) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        
        try{
            transaction.begin();
            Query query = session.createQuery("FROM User u WHERE u.username = :login");
            query.setParameter("login", login);

            if(query.list().isEmpty()){
                throw new RuntimeException();
            }

            transaction.commit();
            logger.info("CheckUserLoginExist - succes");
            return true;
        }
        catch(Exception e){
           logger.info("CheckUserLoginExist - failed");
           transaction.rollback(); 
           return false;
        } 
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();
            session.delete(user);

            session.getTransaction().commit();
            logger.info("Delete - succes");

        }
        catch(HibernateException hE){
            logger.info("Delete - failed");
            transaction.rollback();
        }
    }

    @Override
    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();
            List<User> userList = session.createQuery("FROM User u").list();

            userList.forEach(x->session.delete(x));

            session.getTransaction().commit();
            logger.info("DeleteAll - succes");

        }
        catch(Exception e){
            logger.info("DeleteAll - failed");
            transaction.rollback();
        } 
    }

    @Override
    public void deleteUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();
            User user = session.get(User.class, id);

            session.delete(user);

            session.getTransaction().commit();
            logger.info("DeleteUserById - succes");

        }
        catch(Exception e){
            logger.info("DeleteUserById - failed");
            transaction.rollback();
        } 
    }    
    
    @Override
    public void deleteUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try{
            transaction.begin();
            Query query = session.createQuery("FROM User u WHERE u.username = :name");
            query.setParameter("name", name);
            
            session.delete(query.list().get(0));

            session.getTransaction().commit();
            logger.info("DeleteUserById - succes");

        }
        catch(Exception e){
            logger.info("DeleteUserById - failed");
            transaction.rollback();
        } 
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}   


