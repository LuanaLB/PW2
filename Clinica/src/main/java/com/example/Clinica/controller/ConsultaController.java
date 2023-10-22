package com.example.Clinica.controller;

import com.example.Clinica.model.entity.Consulta;
import com.example.Clinica.model.repository.ConsultaRepository;
import com.example.Clinica.model.repository.MedicoRepository;
import com.example.Clinica.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("consultas")
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

    @GetMapping("/listamedico/{id}")
    public String listamedico(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consultas", consultaRepository.consultasMedico(id) );
        return ("/consulta/listmedico");
    }
    @GetMapping("/listapaciente/{id}")
    public String listapaciente(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("consultas", consultaRepository.consultasPaciente(id));
        return ("consulta/listpaciente");
    }

}
