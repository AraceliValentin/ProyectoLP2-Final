package com.cibertec.controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cibertec.modelos.Producto;
import com.cibertec.repositorio.ProductoRepository;

@Controller
public class ProductoEditar {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int idProducto, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(idProducto);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            model.addAttribute("producto", producto);
            return "vistas/Productos/editar";
        } else {
            return "redirect:/productos";
        }
    }

    @PostMapping("/productos/actualizar")
    public String actualizarProducto(Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos";
    }
}
