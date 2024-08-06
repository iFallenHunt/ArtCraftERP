package com.ArtCraft.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinanceiroWebController {

    @GetMapping("/web/financeiro")
    public String showFinanceiroPage() {
        return "financeiro"; // Certifique-se de que o nome do arquivo é "financeiro.html"
    }
}
