package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            long id = 103L;

            Member member = new Member();

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            System.out.println("rollback!!!");
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}