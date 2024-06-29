package com.cibertec.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.modelos.Cliente;
import com.cibertec.modelos.Venta;
import com.cibertec.repositorio.ClienteRepository;
import com.cibertec.repositorio.VentaRepository;

@Controller
public class VentaIndex {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/ventas")
    public String listarVentas(Model model) {
        List<Venta> listaVentas = ventaRepository.findAll(); // Obtener todas las ventas
        model.addAttribute("listaVentas", listaVentas); // Agregar la lista al modelo para mostrar en la vista
        return "vistas/Venta/index"; // Retornar la vista de listado de ventas
    }

    @GetMapping("/agregarVentaIndex")
    public String mostrarFormularioVenta(Model model) {
        List<Cliente> listaClientes = clienteRepository.findAll(); // Obtener todos los clientes
        model.addAttribute("listaClientes", listaClientes); // Agregar la lista al modelo para el formulario
        model.addAttribute("venta", new Venta()); // Agregar una nueva instancia de Venta al modelo
        return "vistas/venta/agregar"; // Retornar la vista del formulario de agregar venta
    }

    @PostMapping("/guardarVentaIndex")
    public String guardarVenta(Venta venta, Model model) {
        // Guardar la nueva venta en la base de datos
        ventaRepository.save(venta);

        // Redirigir al listado de ventas después de guardar
        return "redirect:/ventas";
    }
}
