package com.cibertec.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cibertec.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // Método para agregar un nuevo producto
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Producto (codigo, descripcion, categoria, precio, stock) " +
            "VALUES (:codigo, :descripcion, :categoria, :precio, :stock)", nativeQuery = true)
    void agregar(String codigo, String descripcion, int categoria, double precio, int stock);

    // Método para editar un producto existente
    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.codigo = :codigo, p.descripcion = :descripcion, " +
            "p.categoria = :categoria, p.precio = :precio, p.stock = :stock WHERE p.ID_Producto = :idProducto")
    void editar(int idProducto, String codigo, String descripcion, int categoria, double precio, int stock);

    // Método para eliminar un producto por su ID
    @Transactional
    @Modifying
    @Query("DELETE FROM Producto p WHERE p.ID_Producto = :idProducto")
    void eliminar(int idProducto);

    // Método para listar todos los productos
    @Query("SELECT p FROM Producto p")
    List<Producto> indexar();
}
