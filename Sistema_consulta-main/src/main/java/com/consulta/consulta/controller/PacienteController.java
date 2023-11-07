package com.consulta.consulta.controller;

import com.consulta.consulta.model.entity.Paciente;
import com.consulta.consulta.model.repository.PacienteRepository;
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
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        return "/paciente/listpaciente";
    }

    @PostMapping("/save")
    public String save(Paciente paciente){
        pacienteRepository.save(paciente);
        return ("redirect:/pacientes/list");
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id){
        pacienteRepository.remove(id);
        return ("redirect:/pacientes/list");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("paciente", pacienteRepository.paciente(id));
        return ("/paciente/form");
    }

    @PostMapping("/update")
    public String update(Paciente paciente) {
        pacienteRepository.update(paciente);
        return ("redirect:/pacientes/list");
    }
    @GetMapping("/form")
    public String form(Paciente paciente){
        return "/paciente/form";
    }
}

