package com.example.Clinica.controller;

import com.example.Clinica.model.entity.Consulta;
import com.example.Clinica.model.entity.Paciente;
import com.example.Clinica.model.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/form")
    public String form(Paciente paciente){
        return "/paciente/form";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        return ("/paciente/list");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Paciente paciente, BindingResult result) {
        if(result.hasErrors()) {
            return new ModelAndView("paciente/form");
        }
        pacienteRepository.save(paciente);
        return new ModelAndView("redirect:/pacientes/list");
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
}
