package com.spring.service;
import java.util.List;
import com.spring.model.Product;

public interface ProductService 
{
	public Product findbyId(int id);
	public void addProduct(Product product);
	public String deleteById(int id);
	public void updateProduct(int id, Product product);
	public List<Product> getPtroducts();
}