package com.Ejercicio1.Kevinshop.domain.repository;

import com.Ejercicio1.Kevinshop.domain.Product;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    //Definimos las reglas que tendra nuestro dominio
    List<Product> getAll();

    Optional<List<Product>> getByCategoryId(int categoryId);

    Optional<List<Product>> getByStock(int quantity);

    Optional<Product> getProduct(int productId);

    Optional<Product>getByNameProduct(String name);

    Product save(Product product);

    Optional<List<Product>> getByState(boolean active);

    void  delete(int productId);
}
