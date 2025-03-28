package com.Ejercicio1.Kevinshop.persistence.crud;

import com.Ejercicio1.Kevinshop.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRespository extends CrudRepository<Producto,Integer> {

    //- Primer Query Methods : Buscar toda la lista de productos que pertenescan a una categoria en especifico
    // ordenado en forma ascendente
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // - Segundo Query Methods : Buscar en productos los que tengan el stock menor al valor dado y el estado

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    // - Buscar por el nombre del producto
    Optional<Producto> findByNombreAndEstado(String nombre, boolean estado);

    //- Buscar por el estado del producto
    Optional<List<Producto>> findByEstado(boolean estado);

    // - Tercer Query Methods : Buscar en la lista de productos los que tengan precio de venta menor al solicitado,el stock debe ser mayor al solicitado,el estado debe ser activo
    Optional<List<Producto>> findByPrecioVentaLessThanAndCantidadStockGreaterThanAndEstado(double precioVenta, int cantidadStock , boolean estado);

    // - Cuarto : Buscar por codigo de barra y ordernar de forma ascendente por nombre
    Optional<List<Producto>> findByCodigoBarrasOrderByNombreAsc(String codigoBarras);
}
