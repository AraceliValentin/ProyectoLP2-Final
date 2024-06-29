package com.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.modelos.Producto;
import com.cibertec.repositorio.ProductoRepository;

@Controller
public class ProductoAgregar {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos/agregar")
    public String doGET(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "vistas/Productos/agregar";
    }

    @PostMapping("/productos/agregar")
    public String doPOST(Model model,
                                   @RequestParam("ID_Producto") int ID_Producto,
                                   @RequestParam("codigo") String codigo,
                                   @RequestParam("descripcion") String descripcion,
                                   @RequestParam("categoria") int categoria,
                                   @RequestParam("precio") double precio,
                                   @RequestParam("stock") int stock) {
        Producto producto = new Producto(ID_Producto, codigo, descripcion, categoria, precio, stock);
        productoRepository.save(producto);
        model.addAttribute("producto", producto);
        return "redirect:/productos";
    }
}
