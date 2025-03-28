package com.Ejercicio1.Kevinshop.domain.service;

import com.Ejercicio1.Kevinshop.domain.Product;
import com.Ejercicio1.Kevinshop.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategoryId(int categoryId){
        return productRepository.getByCategoryId(categoryId);
    }

    public  Optional<List<Product>> getByStock(int quantity){
        return productRepository.getByStock(quantity);
    }

    public Optional<Product>getByNameProduct(String name){
        return productRepository.getByNameProduct(name);
    }

    public Optional<List<Product>> getByState(boolean state){
        return  productRepository.getByState(state);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product ->{
                productRepository.delete(productId);
                return true;
        }).orElse(false);
    }





}
