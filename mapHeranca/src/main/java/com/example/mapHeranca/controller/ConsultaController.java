package com.example.mapHeranca.controller;

import com.example.mapHeranca.model.entity.Consulta;
import com.example.mapHeranca.model.repository.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping("/list")
    public String listar(ModelMap model) {
        model.addAttribute("consultas", consultaRepository.consultas());
        return "/consulta/list";
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
