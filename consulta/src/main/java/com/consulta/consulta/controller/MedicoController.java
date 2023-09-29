package com.consulta.consulta.controller;

import com.consulta.consulta.model.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "/veiculo/listmedico";
    }
}
