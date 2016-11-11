package facetory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import shopdemo.Product;
import shopdemo.User;


public class ProductFactory extends Appconfig implements IProduct {

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery("SELECT p FROM Product p").getResultList();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return  getEntityManager().find(Product.class, id);
	}

	@Override
	public Product createNewProduct(Product p) {
		try {
			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			 getEntityManager().persist(p);
			 getEntityManager().flush();
			 getEntityManager().clear();
			transaction.commit();
			return getProductIndex(0);
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean updateNewProduct(Product p) {
		// TODO Auto-generated method stub
		try {
			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().merge(p);
			getEntityManager().flush();
			getEntityManager().clear();
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean deleteNewProductById(int idp) {
		// TODO Auto-generated method stub
		try {
			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().remove(getById(idp));
			getEntityManager().flush();
			getEntityManager().clear();
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Product> getPaging(int pageIndex, int limit) {
		Query query = getEntityManager().createQuery("select p from Product p order by p.idproduct desc");
		//"select p from Product p order by p.idproduct limit :start, 1"
//		query.setParameter("start", (pageIndex - 1)* limit);
//		query.setParameter(";", limit);
		try {
			List<Product> listProduct = query.setFirstResult((pageIndex - 1)* limit).setMaxResults(limit).getResultList();
			return listProduct;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public Product getProductIndex(int index) {
		Query query = entityManager.createQuery("select p from Product p order by p.idproduct desc");
//		query.setParameter("start", id);
		try {
			Product product = (Product)  query.setFirstResult(index).setMaxResults(1).getSingleResult();
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public long getCount() {
		Query p = getEntityManager().createNativeQuery("SELECT COUNT(*) FROM Product");
		return (long)p.getSingleResult();
	}
	

}
