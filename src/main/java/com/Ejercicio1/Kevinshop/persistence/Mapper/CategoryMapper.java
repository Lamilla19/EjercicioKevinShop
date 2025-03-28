package com.Ejercicio1.Kevinshop.persistence.Mapper;

import com.Ejercicio1.Kevinshop.domain.Category;
import com.Ejercicio1.Kevinshop.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface CategoryMapper {

    @Mappings({
            @Mapping(source ="idCategoria", target ="categoryId"),
            @Mapping(source ="descripcion", target ="nameCategory"),
            @Mapping(source ="estado", target ="active")
    })
    Category toCategory(Categoria categoria);

    //ahora a la inversa
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
