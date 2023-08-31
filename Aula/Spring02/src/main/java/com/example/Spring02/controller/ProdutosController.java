package com.example.Spring02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Spring02.dao.ProdutoDAO;
import com.example.Spring02.model.entity.Produto;

@Controller
@RequestMapping("/produtos") // Corrigido o mapping da classe
public class ProdutosController {
    
    @Autowired
    ProdutoDAO dao;

    @GetMapping("/form")
    public String form(Produto produto){
        return "produtos/form"; // Removido a barra inicial
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", dao.buscarProdutos());
        return new ModelAndView("produtos/list", model); // Removido a barra inicial
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        dao.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id){
        dao.remove(id);
        return "redirect:/produtos/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", dao.buscarProduto(id)); // Corrigido para buscarProduto
        return new ModelAndView("produtos/form", model); // Removido a barra inicial
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        dao.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
}
