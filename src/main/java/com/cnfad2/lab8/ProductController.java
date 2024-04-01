package com.cnfad2.lab8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/product")
public class ProductController {
	List<Product> products = new ArrayList<Product>();
	
	@GetMapping()
	public List<Product> getProdcutList() {
		return products;
	}
	
	@PostMapping()
	public String postProducts(@RequestBody Product product) {
		product.setId(products.size()+1);
		products.add(product);
		return "New Product Added";
	}
	
	@PutMapping("/{id}")
	public String postProduct(@PathVariable int id, @RequestBody Product p ) {
		for (Product product : products) {
			if(product.id == id) {
				product.setName(p.getName());
				product.setPrice(p.getPrice());
				return "Product Updated";
			}
		}
		return "Product Not Found";
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		for(Product product: products) {
			if(product.getId() == id) {
				products.remove(product);
				return "Deleted Successfully";
			}
		}
		return "Not Found";
	}
}
