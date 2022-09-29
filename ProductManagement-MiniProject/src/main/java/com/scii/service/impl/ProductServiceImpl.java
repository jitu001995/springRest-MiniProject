package com.scii.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.scii.exception.ProductNotFoundException;
import com.scii.model.Product;
import com.scii.repo.ProductRepository;
import com.scii.service.IProductService;
import com.scii.util.CalculationUtil;

@Service
public class ProductServiceImpl implements IProductService {
    
	@Autowired
	private ProductRepository repo;
	
	@Override
	public Integer saveProduct(Product p) {
		CalculationUtil.blogic(p);
		repo.save(p);
		return p.getProdId();
	}

	@Override
	public void updateProject(Product p) {
		CalculationUtil.blogic(p);
		repo.save(p);		
	}

	@Override
	@DeleteMapping("/remove/{id}")
	public void deleteProject(@PathVariable Integer id) {
		repo.delete(getOneProduct(id));
	}

	@Override
	public Product getOneProduct(Integer id) {
		Optional<Product> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ProductNotFoundException("Product "+id+" Not Exist"); 
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public void updateProductCodeById(String code, Integer id) {
		if(!repo.existsById(id)) {
			throw new ProductNotFoundException("Product "+id+" Not Exist");
		} else {
			repo.updateProductCodeById(code, id);
		}
		
	}

}
