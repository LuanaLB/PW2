package com.example.consulta.controller;

import com.example.consulta.model.entity.Consulta;
import com.example.consulta.model.repository.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("consultas")
public class ConsultaController {
    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("consulta", consultaRepository.consultas());
        return "/consultas/list";
    }

    @GetMapping("/form")
    public String form(Consulta consulta) {
        return "/consultas/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Consulta consulta) {
        consultaRepository.save(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Consulta consulta) {
        consultaRepository.update(consulta);
        return new ModelAndView("redirect:/consultas/list");
    }
}
