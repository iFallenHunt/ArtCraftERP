package com.ArtCraft.controller.web;

import com.ArtCraft.model.Estoque;
import com.ArtCraft.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/estoque")
public class EstoqueWebController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public String getAllEstoque(Model model) {
        List<Estoque> estoque = estoqueService.findAll();
        model.addAttribute("estoque", estoque);
        return "estoque/estoque";
    }

    @GetMapping("/new")
    public String createEstoqueForm(Model model) {
        model.addAttribute("estoque", new Estoque());
        return "estoque/estoque_form";
    }

    @GetMapping("/details/{id}")
    public String viewEstoqueDetails(@PathVariable Long id, Model model) {
        Estoque estoque = estoqueService.findById(id).orElse(null);
        model.addAttribute("estoque", estoque);
        return "estoque/estoque_details";
    }

    @GetMapping("/edit/{id}")
    public String editEstoqueForm(@PathVariable Long id, Model model) {
        Estoque estoque = estoqueService.findById(id).orElse(null);
        model.addAttribute("estoque", estoque);
        return "estoque/estoque_form";
    }

    @PostMapping("/save")
    public String saveEstoque(@ModelAttribute Estoque estoque) {
        if (estoque.getId() == null) {
            estoqueService.insert(estoque);
        } else {
            estoqueService.update(estoque);
        }
        return "redirect:/web/estoque";
    }
}
