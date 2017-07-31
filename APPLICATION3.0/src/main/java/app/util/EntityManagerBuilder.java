
package app.util;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerBuilder {
    
    private final static EntityManagerFactory FACTORY;
    static {
        FACTORY = Persistence.createEntityManagerFactory("prsistane_test");
    }
    
    @Produces
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    @PreDestroy
    public static void closeFactory() {
        FACTORY.close();
    } 
}
