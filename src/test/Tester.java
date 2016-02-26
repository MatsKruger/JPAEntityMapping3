package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        
    }
}
