package p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CRUDOperations {
	
	public void insertEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Training t1 = new Training(1010, "Spring",40);
        entityManager.persist(t1);
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Training t2 = entityManager.find(Training.class, 1010);
        System.out.println("Training id :: " + t2.getTrainingId());
        System.out.println("Training Name :: " + t2.getTrainingName());
        System.out.println("Available Seats :: " + t2.getAvailableSeats());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Training t3 = entityManager.find(Training.class,1010);
        System.out.println("Training id :: " + t3.getTrainingId());
        System.out.println("Training Name :: " + t3.getTrainingName());
        System.out.println("Available Seats :: " + t3.getAvailableSeats());
        // The entity object is physically updated in the database when the transaction
        // is committed
        t3.setTrainingName("Hibernate");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Training t3 = entityManager.find(Training.class, 1005);
        System.out.println("Training id :: " + t3.getTrainingId());
        System.out.println("Training Name :: " + t3.getTrainingName());
        System.out.println("Available Seats :: " + t3.getAvailableSeats());;
        entityManager.remove(t3);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
