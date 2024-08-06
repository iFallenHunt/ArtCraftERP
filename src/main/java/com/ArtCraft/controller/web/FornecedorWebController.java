package com.ArtCraft.controller.web;

import com.ArtCraft.model.Fornecedor;
import com.ArtCraft.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/fornecedores")
public class FornecedorWebController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public String getAllFornecedores(Model model) {
        List<Fornecedor> fornecedores = fornecedorService.findAll();
        model.addAttribute("fornecedores", fornecedores);
        return "fornecedor/fornecedores";
    }

    @GetMapping("/new")
    public String createFornecedorForm(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedor/fornecedor_form";
    }

    @GetMapping("/details/{id}")
    public String viewFornecedorDetails(@PathVariable Long id, Model model) {
        Fornecedor fornecedor = fornecedorService.findById(id).orElse(null);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/fornecedor_details";
    }

    @GetMapping("/edit/{id}")
    public String editFornecedorForm(@PathVariable Long id, Model model) {
        Fornecedor fornecedor = fornecedorService.findById(id).orElse(null);
        model.addAttribute("fornecedor", fornecedor);
        return "fornecedor/fornecedor_form";
    }

    @PostMapping("/save")
    public String saveFornecedor(@ModelAttribute Fornecedor fornecedor) {
        if (fornecedor.getId() == null) {
            fornecedorService.insert(fornecedor);
        } else {
            fornecedorService.update(fornecedor);
        }
        return "redirect:/web/fornecedores";
    }
}
