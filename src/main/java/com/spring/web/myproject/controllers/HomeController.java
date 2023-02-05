package com.spring.web.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Redirigo a otra URL a través de esta clase JAVA
@Controller
public class HomeController {

//    Redirige automáticamente a localhost:8080/home/ al colocar localhost:8080/
//    Se podría redirigir a cualquier sitio web (Google, YouTube...)
    @GetMapping("/")
    public String home(){
        return "redirect:/home/";
//        Redirige de la misma forma que redirect pero sin reiniciar el Request
//        forward se utiliza para rutas propias del proyecto, no se puede utilizar para rutas externas
//        Por dejaba ejecutar un RequestDispatcher.forward()
//        return "forward:/home/";
    }
}
