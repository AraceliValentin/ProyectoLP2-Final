package com.cibertec.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.modelos.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // Método para agregar una nueva venta
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Venta (Cliente_ID, Fecha) VALUES (:clienteId, :fecha)", nativeQuery = true)
    void agregar(int clienteId, Date fecha);

    // Método para buscar una venta por su ID
    @Query("SELECT v FROM Venta v WHERE v.ID_Venta = :idVenta")
    Venta buscarPorIdVenta(Integer idVenta);

    // Método para actualizar una venta
    @Transactional
    @Modifying
    @Query("UPDATE Venta v SET v.Cliente_ID = :clienteId, v.Fecha = :fecha WHERE v.ID_Venta = :idVenta")
    void actualizar(Integer clienteId, Date fecha, Integer idVenta);

    // Método para eliminar una venta por su ID
    @Transactional
    @Modifying
    @Query("DELETE FROM Venta v WHERE v.ID_Venta = :idVenta")
    void eliminar(Integer idVenta);

    // Método para buscar ventas por Cliente_ID
    @Query("SELECT v FROM Venta v WHERE v.Cliente_ID = :clienteId")
    List<Venta> buscarPorCliente(int clienteId);
}
