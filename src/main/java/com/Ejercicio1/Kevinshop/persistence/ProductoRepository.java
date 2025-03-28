package com.Ejercicio1.Kevinshop.persistence;

import com.Ejercicio1.Kevinshop.domain.Product;
import com.Ejercicio1.Kevinshop.domain.repository.ProductRepository;
import com.Ejercicio1.Kevinshop.persistence.Mapper.ProductMapper;
import com.Ejercicio1.Kevinshop.persistence.crud.ProductoCrudRespository;
import com.Ejercicio1.Kevinshop.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository

public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRespository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    //Obtener una lista de productos por una categoria en especifico ordenados en orden Alfabetico
    public Optional<List<Product>> getByCategoryId(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByStock(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getByNameProduct(String name){
        Optional<Producto> productos = productoCrudRepository.findByNombreAndEstado(name , true);
        return productos.map(produ ->mapper.toProduct(produ));
    }

    //Metodo para buscar un producto por su id

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public  Optional<List<Product>> getByState(boolean state){
        Optional<List<Producto>> productos = productoCrudRepository.findByEstado(state);
        return productos.map(produ -> mapper.toProducts(produ));
    }

    @Override
    //Metodo de guardar un producto
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    //Metodo de eliminar un producto
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
