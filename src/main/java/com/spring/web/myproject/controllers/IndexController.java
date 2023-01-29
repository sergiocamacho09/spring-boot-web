package com.spring.web.myproject.controllers;

import com.spring.web.myproject.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
//Ruta de primer nivel de nuestro controlador
@RequestMapping(value = "/home")
public class IndexController {

//    Añadir datos a la vista de diferentes formas
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("titulo", "Este título viene desde el backend");
        return "index";
    }

    @RequestMapping(value = "/modelmap", method = RequestMethod.GET)
    public String indexModelMap(ModelMap modelMap){
        modelMap.addAttribute("titulo", "Datos añadidos a través de Model Map");
        return "index";
    }

//    Con RequestMapping indicamos la extensión de la URL junto con el verbo HTTP que empleará
    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String indexMap(Map<String, Object> map){
        map.put("titulo", "Datos añadidos a través de Map");
        return "index";
    }

    @GetMapping(value = "/modelandview")
    public ModelAndView indexModelAndView(ModelAndView mv){
        mv.addObject("titulo", "Hola Mundo a través de ModelAndView");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String detallesUsuario(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Sergio");
        usuario.setApellido1("Camacho");
        usuario.setApellido2("Toledano");
        usuario.setEdad(23);
        usuario.setEmail("example@gmail.com");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

//    Indicamos el nombre del atributo que se le pasará a través del modal
//    Los datos quedarían disponibles para que los use cualquier función del controlador
//    Se emplea ModelAttribute si esos datos van a ser usados en más de una lista
    @ModelAttribute("usuarios")
    public List<Usuario> listaUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Pedro", "Carmena", "Martin", null, 17),
                new Usuario("Sergio", "Camacho", "Toledano", "email@email.com", 23),
                new Usuario("Celia", "Camacho", "Toledano", null, 28));
        return usuarios;
    }
    @RequestMapping(value = "/lista" , method = RequestMethod.GET)
    public String listar(Model model){

//        List<Usuario> usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Pedro", "Carmena", "Martin", null, 17));
//        usuarios.add(new Usuario("Sergio", "Camacho", "Toledano", "email@email.com", 23));
//        usuarios.add(new Usuario("Celia", "Camacho", "Toledano", null, 28));

        model.addAttribute("titulo", "Lista de usuarios");

        return "lista";
    }
    
}
