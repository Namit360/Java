package com.spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.model.Product;
import com.spring.repository.ProductRepository;
import com.spring.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController 
{
	@Autowired
	ProductService prodservice;
	
	@Autowired
	ProductRepository prodrepo;
	
	@RequestMapping("/load")
	public String loadReport()
	{
		return "Hotel Report .........";
	}
	
	@GetMapping("/get")
	public List<Product> getProducts()
	{
		List<Product> product = prodservice.getPtroducts();
		return product;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		return prodservice.deleteById(id);
	}
	
	@PostMapping("/add")
	public void addProduct(@RequestBody Product product)
	{
		prodservice.addProduct(product);
	}
	
	@PutMapping("/update")
	public void updateProduct(@RequestBody int id, @RequestBody Product product)
	{
		prodservice.updateProduct(id, product);
	}
	
	@GetMapping("/get/{productname}")
	public Product getProductByName( @PathVariable("productname") String name)
	{
		Product product = prodrepo.findByproductname(name);
		return product;
	}
}