package com.example.Clinica.controller;

import com.example.Clinica.model.entity.Agenda;
import com.example.Clinica.model.repository.AgendaRepository;
import com.example.Clinica.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("agendas", agendaRepository.agendas());
        return "/agenda/list";
    }

    @GetMapping("/form")
    public String form(ModelMap model, Agenda agenda) {
        model.addAttribute("medicos", medicoRepository.medicos());
        return "/agenda/form";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id){
        agendaRepository.remove(id);
        return ("redirect:/agendas/list");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("agenda", agendaRepository.agenda(id));
        model.addAttribute("medicos", medicoRepository.medicos());
        return ("/agenda/form");
    }

    @PostMapping("/update")
    public String update(Agenda agenda) {
        agendaRepository.update(agenda);
        return ("redirect:/agendas/list");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Agenda agenda, BindingResult result, ModelMap model) {
        if(result.hasErrors()) {
            model.addAttribute("medicos", medicoRepository.medicos());
            return new ModelAndView("/agenda/form");
        }
        agendaRepository.save(agenda);
        return new ModelAndView("redirect:/agendas/list");
    }

    @GetMapping("/medico/{medicoId}")
    public ModelAndView agendaDeMedico(@PathVariable("medicoId") Long medicoId, ModelMap model) {
        model.addAttribute("agendas", agendaRepository.agendasDeMedico(medicoId));
        return new ModelAndView("/medico/listConsultaMed", model);
    }
}
