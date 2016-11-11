package shopdemo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Typeproduct.findAll", query="SELECT t FROM Typeproduct t")
public class Typeproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtypeProduct;

	private String about;

	private String name;

	//bi-directional many-to-many association to Product
	@ManyToMany(mappedBy="typeproducts")
	private List<Product> products;

	public Typeproduct() {
	}

	public int getIdtypeProduct() {
		return this.idtypeProduct;
	}

	public void setIdtypeProduct(int idtypeProduct) {
		this.idtypeProduct = idtypeProduct;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}