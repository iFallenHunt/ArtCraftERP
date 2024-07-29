package com.ArtCraft.controller.web;

import com.ArtCraft.model.Produto;
import com.ArtCraft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/produtos")
public class ProdutoWebController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String getAllProdutos(Model model) {
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/new")
    public String createProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos_form";
    }

    @GetMapping("/details/{id}")
    public String viewProdutoDetails(@PathVariable Long id, Model model) {
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
        } else {
            model.addAttribute("error", "Produto not found");
        }
        return "produtos_details";
    }

    @GetMapping("/edit/{id}")
    public String editProdutoForm(@PathVariable Long id, Model model) {
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
        } else {
            model.addAttribute("error", "Produto not found");
        }
        return "produtos_form";
    }

    @PostMapping("/save")
    public String saveProduto(@ModelAttribute Produto produto) {
        if (produto.getId() == null) {
            produtoService.insert(produto);
        } else {
            produtoService.update(produto);
        }
        return "redirect:/web/produtos";
    }
}
