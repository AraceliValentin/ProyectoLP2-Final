package com.cibertec.controladores;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.modelos.Venta;
import com.cibertec.repositorio.VentaRepository;

@Controller
public class VentaAgregar {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/agregarVenta")
    public String mostrarFormulario(Model modelo) {
        Venta venta = new Venta(); // Crear una nueva instancia de Venta
        modelo.addAttribute("venta", venta); // Agregarla al modelo para el formulario
        return "vistas/Venta/agregar"; // Retornar la vista del formulario de agregar venta
    }

    @PostMapping("/agregarVenta")
    public String agregarVenta(Model modelo,
                               @RequestParam("txtClienteId") int clienteId,
                               @RequestParam("txtFecha") Date fecha) {
        // Convertir java.util.Date a java.sql.Date si es necesario
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());

        // Crear una nueva instancia de Venta con los datos recibidos
        Venta nuevaVenta = new Venta();
        nuevaVenta.setCliente_ID(clienteId);
        nuevaVenta.setFecha(fechaSQL); // Asignar fechaSQL, que es java.sql.Date

        // Guardar la nueva venta en la base de datos
        ventaRepository.save(nuevaVenta);

        // Agregar la venta al modelo para mostrarla en la vista de éxito o detalle
        modelo.addAttribute("venta", nuevaVenta);

        // Retornar la vista donde se muestra la nueva venta (puedes ajustar según tu estructura de vistas)
        return "vistas/Venta/detalle";
    }
}
