package com.Ejercicio1.Kevinshop.web.controller;

import com.Ejercicio1.Kevinshop.domain.Product;
import com.Ejercicio1.Kevinshop.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/All")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategoryId(@PathVariable("id") int categoryId){
        return productService.getByCategoryId(categoryId);
    }

    @GetMapping("/stock/{quantity}")
    public Optional<List<Product>> getByStock(@PathVariable int quantity){
        return productService.getByStock(quantity);
    }

    @GetMapping("/name/{name}")
    public Optional<Product>getByNameProduct(@PathVariable String name){
        return productService.getByNameProduct(name);
    }

    @GetMapping("/state/{state}")
    public Optional<List<Product>>getByState(@PathVariable boolean state){
        return productService.getByState(state);
    }

    @PostMapping()
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    //Actualiza un producto por su id, si el id no existe crea un producto nuevo
    @PutMapping("/update/{productId}")
    public Product update(@RequestBody Product product , @PathVariable int productId){
        return productService.getProduct(productId).map(productUpdate ->{
            productUpdate.setName(product.getName());
            productUpdate.setCategoryId(product.getCategoryId());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setStock(product.getStock());
            productUpdate.setActive(product.getActive());
            return productService.save(productUpdate);
        }).orElseGet(()-> {
            product.setProductId(productId);
            return productService.save(product);
        });
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

}
