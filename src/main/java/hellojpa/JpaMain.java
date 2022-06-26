package hellojpa;

import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;

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
            Order order = new Order();
            OrderItem orderItem = new OrderItem();

            order.addOrderItem(orderItem);

            em.persist(orderItem);
            em.persist(order);

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
