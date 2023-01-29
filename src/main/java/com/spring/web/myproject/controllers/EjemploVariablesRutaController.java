package com.spring.web.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/")
    public String index(Model model){

        return "variables/index";
    }

//    URL dinámica para añadir variables. La variable texto irá cambiando dinámicamente
//    en función de lo que le pasemos
    @GetMapping("/string/{texto}")
//    @PathVariable para manejar URL's variables. El nombre de la URL y el de la variable
//    de la notación @PathVariable tienen que llamarse de la misma forma
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("resultado", "El texto añadido mediante @PathVariable es: " + texto);
        return "variables/ver";

    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("resultado", "El texto introducido es " + texto + ", junto con el número " + numero);
        return "variables/ver";
    }
}
