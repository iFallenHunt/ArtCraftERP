// src/main/java/com/ArtCraft/controller/web/VendaWebController.java
package com.ArtCraft.controller.web;

import com.ArtCraft.model.Cliente;
import com.ArtCraft.model.Produto;
import com.ArtCraft.model.Venda;
import com.ArtCraft.service.ClienteService;
import com.ArtCraft.service.ProdutoService;
import com.ArtCraft.service.impl.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/vendas")
public class VendaWebController {
    private final VendaService vendaService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public VendaWebController(VendaService vendaService, ClienteService clienteService, ProdutoService produtoService) {
        this.vendaService = vendaService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listVendas(Model model) {
        List<Venda> vendas = vendaService.findAll();
        model.addAttribute("vendas", vendas);
        return "vendas/list"; // Corrigido para refletir a estrutura atual
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Venda venda = new Venda();
        List<Cliente> clientes = clienteService.findAll();
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("venda", venda);
        model.addAttribute("clientes", clientes);
        model.addAttribute("produtos", produtos);
        return "vendas/vendas_form"; // Corrigido para refletir a estrutura atual
    }

    @PostMapping
    public String saveVenda(@ModelAttribute Venda venda) {
        vendaService.save(venda);
        return "redirect:/web/vendas";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Venda venda = vendaService.findById(id);
        List<Cliente> clientes = clienteService.findAll();
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("venda", venda);
        model.addAttribute("clientes", clientes);
        model.addAttribute("produtos", produtos);
        return "vendas/vendas_form"; // Corrigido para refletir a estrutura atual
    }

    @DeleteMapping("/{id}")
    public String deleteVenda(@PathVariable Long id) {
        vendaService.deleteById(id);
        return "redirect:/web/vendas";
    }
}
