package com.example.Spring02.controller;
import com.example.Spring02.dao.ProdutoDAO;
import com.example.Spring02.model.entity.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
    ProdutoDAO dao;

    public ProdutosController(){
        dao = new ProdutoDAO();
    }

    @GetMapping("/form")
    public String form(Produto produto){
        return "/produtos/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("produtos", dao.buscarProdutos());
        return new ModelAndView("/produtos/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        dao.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        dao.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", dao.buscarProdutos());
        return new ModelAndView("/produtos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        dao.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

}
