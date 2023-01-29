package com.spring.web.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

//    Varios parámetros en la URL
    @GetMapping("/mix-params")
    public String stringParams(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("parametro", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
        return "params/ver";
    }

    @GetMapping("/mix-params-http")
    public String stringParams(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
//        HttpServletRequest devuelve por defecto un String, por eso hay que convertirlo a String
        Integer numero = null;
//        Try-Catch por si no se pudiera convertir el número de String a Integer
        try{
           numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero = 0;
        }

        model.addAttribute("parametro", "El saludo enviado es: '" + saludo + "' y el número es '" + numero + "'");
        return "params/ver";
    }
}
