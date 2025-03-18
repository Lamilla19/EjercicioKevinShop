package com.Ejercicio1.Kevinshop;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar(){
        return "Hola Mundo Kevin - Tremendo Crack";
    }

    @GetMapping("/buen")
    public String presentacion(){
        return  "Buenos dias amigos";
    }
}
