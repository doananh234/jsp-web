package shopdemo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproduct;

	private int idType;

	private String img;

	@Lob
	private String info;

	private String name;

	private String price;

	private int quatity;

	//bi-directional many-to-many association to Typeproduct
	@ManyToMany
	@JoinTable(
		name="product_has_typeproduct"
		, joinColumns={
			@JoinColumn(name="product_idproduct")
			}
		, inverseJoinColumns={
			@JoinColumn(name="typeproduct_idtypeProduct")
			}
		)
	private List<Typeproduct> typeproducts;

	public Product() {
	}

	public int getIdproduct() {
		return this.idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuatity() {
		return this.quatity;
	}

	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}

	public List<Typeproduct> getTypeproducts() {
		return this.typeproducts;
	}

	public void setTypeproducts(List<Typeproduct> typeproducts) {
		this.typeproducts = typeproducts;
	}

}