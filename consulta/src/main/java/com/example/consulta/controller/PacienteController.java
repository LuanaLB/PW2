package com.example.consulta.controller;

import com.example.consulta.model.entity.Paciente;
import com.example.consulta.model.repository.PacienteRepository;
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
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("paciente", pacienteRepository.pacientes());
        return "/paciente/list";
    }

    @GetMapping("/form")
    public String form(Paciente paciente) {
        return "/paciente/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Paciente paciente) {
        pacienteRepository.save(paciente);
        return new ModelAndView("redirect:/paciente/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Paciente paciente) {
        pacienteRepository.update(paciente);
        return new ModelAndView("redirect:/paciente/list");
    }
}