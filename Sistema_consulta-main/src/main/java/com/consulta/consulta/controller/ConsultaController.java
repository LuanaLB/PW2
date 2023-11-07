

package com.consulta.consulta.controller;

import com.consulta.consulta.model.entity.Consulta;
import com.consulta.consulta.model.entity.Medico;
import com.consulta.consulta.model.entity.Paciente;
import com.consulta.consulta.model.repository.MedicoRepository;
import com.consulta.consulta.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consulta.consulta.model.repository.ConsultaRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/form")
    public String form(ModelMap model, Consulta consulta) {
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        model.addAttribute("medicos", medicoRepository.medicos());
        return "/consulta/form";
    }
    @GetMapping("/list")
    public String listar(ModelMap model) {
        model.addAttribute("consultas", consultaRepository.consultas());
        return "/consulta/list";
    }

    @GetMapping("/medico/{medicoId}")
    public ModelAndView consultasDeMedico(@PathVariable("medicoId") Long medicoId, ModelMap model) {
        model.addAttribute("consultas", consultaRepository.consultasDeMedico(medicoId));
        return new ModelAndView("/medico/listConsultaMed", model);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ModelAndView consultasDePaciente(@PathVariable("pacienteId") Long pacienteId, ModelMap model) {
        model.addAttribute("consultas", consultaRepository.consultasDePaciente(pacienteId));
        return new ModelAndView("/paciente/listConsultaPac", model);
    }

    @PostMapping("/save")
    public String save(Consulta consulta) {
        consultaRepository.save(consulta);
        return ("redirect:/consultas/list");
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        consultaRepository.remove(id);
        return ("redirect:/consultas/list");
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consulta", consultaRepository.consulta(id));
        model.addAttribute("pacientes", pacienteRepository.pacientes());
        model.addAttribute("medicos", medicoRepository.medicos());
        return ("/consulta/form");
    }

    @PostMapping("/update")
    public String update(Consulta consulta) {
        consultaRepository.update(consulta);
        return ("redirect:/consultas/list");
    }
}