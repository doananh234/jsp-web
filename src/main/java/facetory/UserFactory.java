package facetory;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import shopdemo.User;



public class UserFactory  extends Appconfig implements IUser {
	EntityManager entityManager = getEntityManager();
	@Override
	public User login(String user, String pass) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select u from User u where u.username=:username and u.password=:password");
		query.setParameter("username", user);
		query.setParameter("password", pass);
		try {
			User _user = (User) query.getSingleResult();
			return _user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
