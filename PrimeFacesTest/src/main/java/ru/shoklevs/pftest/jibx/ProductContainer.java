package ru.shoklevs.pftest.jibx;

import java.util.ArrayList;
import java.util.List;

import ru.shoklevs.pftest.model.Product;

public class ProductContainer {
	private List<Product> products;
	
	public static List listFactory() {
		return new ArrayList();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
