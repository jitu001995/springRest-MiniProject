package com.scii.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scii.exception.ProductNotFoundException;
import com.scii.model.Product;
import com.scii.service.IProductService;

@RestController
@RequestMapping("/app/product")
public class ProductController {
  private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private IProductService service;
		
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product prod){
		LOG.info("ENTERED INFO SAVE METHOD"); 
		ResponseEntity<String> rs = null;
		try {
			Integer id=service.saveProduct(prod);
			 String data="PRODUCT DATA SAVE WITH ID "+id;
		     rs=new ResponseEntity<String>(data,HttpStatus.CREATED);
		    LOG.debug(data);
		}catch(Exception e) {
			LOG.error("SAVING is Failed {}",e.getMessage());
			e.printStackTrace();
			rs = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOG.info("ABOUT to LEAVE SAVING METHOD");
		 return rs;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> list= service.getAll();
		ResponseEntity<List<Product>> rs = new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		return rs;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getOneProduct(@PathVariable("id") Integer id){
		LOG.info("ENTERED INFO GETTING ONE RECORD METHOD"); 
		ResponseEntity<?> res = null;
		try {
		 Product prod=service.getOneProduct(id);
		 LOG.debug("ONE DATA SUCCESSFULLY FETCHED BY ID {} "+prod.getProdId());
		  res=new ResponseEntity<Product>(prod,HttpStatus.OK);
	 }catch(ProductNotFoundException pe) {
		 LOG.error("ONE RECORD GETTING is Failed {}",pe.getMessage());
		 pe.printStackTrace();
		 res=new ResponseEntity<String>(pe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
		LOG.info("ABOUT TO LEAVE GETTING ONE RECORD METHOD BY ID");
		return res;
	} 
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteOneProudct(@PathVariable("id") Integer id){
		ResponseEntity<?> res = null;
		try {
			service.deleteProject(id);
			res = new ResponseEntity("Product removed"+id,HttpStatus.OK);
		}catch(ProductNotFoundException pe) {
			pe.printStackTrace();
			res = new ResponseEntity(pe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> updateProduct(@RequestBody Product prd){
		ResponseEntity<String> res=null;
		try {
			service.updateProject(prd);
			res = new ResponseEntity<String>("Prouduct "+prd.getProdId()+" Update",HttpStatus.OK);
		}catch(ProductNotFoundException pe) {
			pe.printStackTrace();
			res = new ResponseEntity<String>("Prouduct Not updated "+prd.getProdId()+" Update",HttpStatus.OK);
		}
		return res;
	}
	
	@PatchMapping("/update/{id}/{code}")
	public ResponseEntity<String> updateProductCode(
			 @PathVariable Integer id,
			 @PathVariable String code ){
		ResponseEntity<String> res=null;
		try {
			service.updateProductCodeById(code, id);
			res = new ResponseEntity("Product "+ id +" Updated with code "+code,HttpStatus.OK);
		}catch(ProductNotFoundException pe) {
			pe.printStackTrace();
			res = new ResponseEntity(pe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
	}
}
