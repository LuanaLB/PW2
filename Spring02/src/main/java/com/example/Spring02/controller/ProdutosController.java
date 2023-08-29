package com.example.Spring02.controller;
import com.example.Spring02.dao.PessoaDAO;
import com.example.Spring02.model.entity.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pessoas")
public class PessoasController {
    PessoaDAO dao;

    public PessoasController(){
        dao = new PessoaDAO();
    }

    @GetMapping("/form")
    public String form(Pessoa pessoa){
        return "/pessoas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("pessoas", dao.buscarPessoas());
        return new ModelAndView("/pessoas/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Pessoa pessoa){
        dao.save(pessoa);
        return new ModelAndView("redirect:/pessoas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        dao.remove(id);
        return new ModelAndView("redirect:/pessoas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", dao.buscarPessoa(id));
        return new ModelAndView("/pessoas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Pessoa pessoa) {
        dao.update(pessoa);
        return new ModelAndView("redirect:/pessoas/list");
    }

}
