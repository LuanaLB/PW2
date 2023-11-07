package com.consulta.consulta.controller;

import com.consulta.consulta.model.entity.Medico;
import com.consulta.consulta.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("medicos", medicoRepository.medicos());
        return "/medico/listmedico";
    }

    @GetMapping("/form")
    public String form(Medico medico){
        return "/medico/form";
    }

    @PostMapping("/save")
    public String save(Medico medico){
        medicoRepository.save(medico);
        return ("redirect:/medicos/list");
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id){
        medicoRepository.remove(id);
        return ("redirect:/medicos/list");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("medico", medicoRepository.medico(id));
        return ("/medico/form");
    }

    @PostMapping("/update")
    public String update(Medico medico) {
        medicoRepository.update(medico);
        return ("redirect:/medicos/list");
    }
}
