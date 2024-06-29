package com.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.modelos.Cliente;
import com.cibertec.repositorio.ClienteRepository;

@Controller
public class ClienteEliminar {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/eliminarCliente")
    public String doGET(Model modelo, @RequestParam("cod") int idEliminar) {
        Cliente cliente = clienteRepository.buscarPorId(idEliminar);
        modelo.addAttribute("cliente", cliente);
        return "vistas/Cliente/eliminar";
    }

    @PostMapping("/eliminarCliente")
    public String doPOST(Model modelo, @RequestParam("txtId") int id) {
        clienteRepository.eliminar(id);
        // Después de eliminar, redirigir a la página principal de Clientes
        return "redirect:/buscarCliente";
    }
}
