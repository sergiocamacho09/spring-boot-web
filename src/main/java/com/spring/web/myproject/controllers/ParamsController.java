package com.spring.web.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String newIndex(){
        return "params/index";
    }

    @GetMapping("/string")
    public String stringParam(@RequestParam(name = "texto", defaultValue = "añada un parámetro en la URL") String texto, Model model){
        model.addAttribute("parametro", "El parámetro de la URL es: " + texto);
        return "params/ver";
    }
}
