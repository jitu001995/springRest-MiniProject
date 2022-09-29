package com.scii.service;

import java.util.List;

import com.scii.model.Product;

public interface IProductService {
   Integer saveProduct(Product p);
   void updateProject(Product p);
   void deleteProject(Integer id);
   Product getOneProduct(Integer id);
   List<Product> getAll();
   
   public void updateProductCodeById(String code,Integer id);

}
