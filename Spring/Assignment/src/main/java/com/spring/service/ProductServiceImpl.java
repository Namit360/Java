package com.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	ProductRepository prodrepo;

	@Override
	public Product findbyId(int id) 
	{
		Product product =prodrepo.findById(id).get();
		return product;
	}

	@Override
	public void addProduct(Product product) 
	{
		prodrepo.save(product);
	}

	@Override
	public String deleteById(int id) 
	{
		prodrepo.deleteById(id);
		return "deleted id "+id;
	}

	@Override
	public void updateProduct(int id, Product product)
	{
		Product prod = prodrepo.findById(id).orElse(null);
		prod.setProductcost(product.getProductcost());		
		prod.setProductname(product.getProductname());
		prod.setTagid(product.getTagid());
	}

	@Override
	public List<Product> getPtroducts()
	{
		List<Product> product = prodrepo.findAll();
		return product;
	}
}