package com.example.JPA.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    VeiculoRepository repository;

}