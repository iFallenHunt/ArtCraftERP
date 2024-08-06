package com.ArtCraft.controller.web;

import com.ArtCraft.model.Produto;
import com.ArtCraft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/produtos")
public class ProdutoWebController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String getAllProdutos(Model model) {
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos/produtos";
    }

    @GetMapping("/new")
    public String createProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/produto_form";
    }

    @GetMapping("/details/{id}")
    public String viewProdutoDetails(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id).orElse(null);
        model.addAttribute("produto", produto);
        return "produtos/produto_details";
    }

    @GetMapping("/edit/{id}")
    public String editProdutoForm(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id).orElse(null);
        model.addAttribute("produto", produto);
        return "produtos/produto_form";
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
