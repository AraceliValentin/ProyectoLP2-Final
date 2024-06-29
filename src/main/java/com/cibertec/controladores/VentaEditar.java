package com.cibertec.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.modelos.Venta;
import com.cibertec.repositorio.VentaRepository;

@Controller
public class VentaEditar {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/editarVenta/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int idVenta, Model model) {
        Optional<Venta> ventaOptional = ventaRepository.findById(idVenta);
        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            model.addAttribute("venta", venta);
            return "vistas/venta/editar"; // Retornar la vista del formulario de editar venta
        } else {
            return "redirect:/ventas"; // Redirigir al listado de ventas si no se encuentra la venta
        }
    }

    @PostMapping("/actualizarVenta")
    public String actualizarVenta(Venta venta, Model model) {
        ventaRepository.save(venta); // Guardar la venta actualizada en la base de datos
        return "redirect:/ventas"; // Redirigir al listado de ventas después de actualizar
    }
}
