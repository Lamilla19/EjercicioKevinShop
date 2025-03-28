package com.Ejercicio1.Kevinshop.persistence.Mapper;


import com.Ejercicio1.Kevinshop.domain.Product;
import com.Ejercicio1.Kevinshop.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//Especificamos que esta interface es de mapper
// se el parametro uses para señalar a Java que cuando quiera convertir categoria use el que ya esta creado
//CategoryMapper.class
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})

public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "categoria",target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProducto(Product product);

}
