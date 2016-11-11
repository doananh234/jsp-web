package shopdemo;

import java.util.List;

import com.google.gson.Gson;

import facetory.ProductFactory;

public class test {
	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		List<Product> p = pf.getPaging(1, 5);
		String json = new Gson().toJson(p );
		System.out.println(json);
	}
}
