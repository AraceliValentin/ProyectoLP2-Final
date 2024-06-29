package com.cibertec.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cibertec.modelos.Producto;
import com.cibertec.repositorio.ProductoRepository;
@Controller
public class ProductoEliminar {

	@Autowired
    private ProductoRepository productoRepository;

    @PostMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") int idProducto) {
        Optional<Producto> productoOptional = productoRepository.findById(idProducto);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            productoRepository.delete(producto);
        }
        return "redirect:/productos";
    }
}
