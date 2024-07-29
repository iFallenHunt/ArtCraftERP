package com.ArtCraft.controller.web;

import com.ArtCraft.model.Estoque;
import com.ArtCraft.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/estoque")
public class EstoqueWebController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public String getAllEstoques(Model model) {
        List<Estoque> estoques = estoqueService.findAll();
        model.addAttribute("estoques", estoques);
        return "estoque"; // Verifique se este arquivo existe em templates
    }

    @GetMapping("/new")
    public String createEstoqueForm(Model model) {
        model.addAttribute("estoque", new Estoque());
        return "estoque_form"; // Verifique se este arquivo existe em templates
    }

    @GetMapping("/details/{id}")
    public String viewEstoqueDetails(@PathVariable Long id, Model model) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isPresent()) {
            model.addAttribute("estoque", estoque.get());
        } else {
            model.addAttribute("error", "Estoque not found");
        }
        return "estoque_details"; // Verifique se este arquivo existe em templates
    }

    @GetMapping("/edit/{id}")
    public String editEstoqueForm(@PathVariable Long id, Model model) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isPresent()) {
            model.addAttribute("estoque", estoque.get());
        } else {
            model.addAttribute("error", "Estoque not found");
        }
        return "estoque_form"; // Verifique se este arquivo existe em templates
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
