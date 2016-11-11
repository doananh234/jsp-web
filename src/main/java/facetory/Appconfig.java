package facetory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Appconfig {
	protected static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shopdemo");
	
	protected static  EntityManager entityManager;
	
	protected EntityTransaction entityTransaction;
	
	public EntityManager getEntityManager() {
		if (this.entityManager == null)
		this.entityManager = entityManagerFactory.createEntityManager();
		return this.entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityTransaction getTransaction() {
		this.entityTransaction = this.entityManager.getTransaction();
		return this.entityTransaction;
	}
	public void setEntityTransaction(EntityTransaction entityTransaction) {
		this.entityTransaction = entityTransaction;
	}
	
}
