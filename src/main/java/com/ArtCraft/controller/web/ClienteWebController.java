package com.ArtCraft.controller.web;

import com.ArtCraft.model.Cliente;
import com.ArtCraft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/clientes")
public class ClienteWebController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String getAllClientes(Model model, @RequestParam(required = false) String name) {
        List<Cliente> clientes;
        if (name != null && !name.isEmpty()) {
            clientes = clienteService.findByName(name);
        } else {
            clientes = clienteService.findAll();
        }
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/new")
    public String createClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente_form";
    }

    @GetMapping("/details/{id}")
    public String viewClienteDetails(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente.orElse(null));
        return "cliente_details";
    }

    @GetMapping("/edit/{id}")
    public String editClienteForm(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.findById(id);
        model.addAttribute("cliente", cliente.orElse(null));
        return "cliente_form";
    }

    @PostMapping("/save")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        if (cliente.getId() == null) {
            clienteService.insert(cliente);
        } else {
            clienteService.update(cliente);
        }
        return "redirect:/web/clientes";
    }
}
