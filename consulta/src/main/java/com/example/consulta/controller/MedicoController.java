package com.example.consulta.controller;

import com.example.consulta.model.entity.Medico;
import com.example.consulta.model.repository.MedicoRepository;
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
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("medico", medicoRepository.medicos());
        return "/medicos/list";
    }

    @GetMapping("/form")
    public String form(Medico medico) {return "/medicos/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Medico medico) {
        medicoRepository.save(medico);
        return new ModelAndView("redirect:/medicos/list");
    }

    @PostMapping("/update")
    public ModelAndView update(Medico medico) {
        medicoRepository.update(medico);
        return new ModelAndView("redirect:/medicos/list");
    }
}
