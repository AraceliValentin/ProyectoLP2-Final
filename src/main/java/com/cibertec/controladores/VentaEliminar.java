package com.cibertec.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cibertec.modelos.Venta;
import com.cibertec.repositorio.VentaRepository;

@Controller
public class VentaEliminar {

    @Autowired
    private VentaRepository ventaRepository;

    @PostMapping("/eliminarVenta/{id}")
    public String eliminarVenta(@PathVariable("id") int idVenta) {
        Optional<Venta> ventaOptional = ventaRepository.findById(idVenta);
        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            ventaRepository.delete(venta); // Eliminar la venta de la base de datos
        }
        return "redirect:/ventas"; // Redirigir al listado de ventas después de eliminar
    }
}
