package facetory;

import java.util.List;

import shopdemo.Product;



public interface IProduct {
	public List<Product> getAll();
	public List<Product> getPaging(int pageIndex,int limit);
	public Product getById(int id);
	public Product getProductIndex(int index);
	public Product createNewProduct(Product p);
	public boolean updateNewProduct(Product p);
	public boolean deleteNewProductById(int p);
	public long getCount();
	
}
