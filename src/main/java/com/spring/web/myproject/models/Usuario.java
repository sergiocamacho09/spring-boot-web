package com.spring.web.myproject.models;

public class Usuario {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private Integer edad;


//    GETTER Y SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido1(){
        return this.apellido1;
    }

    public String getApellido2(){
        return this.apellido2;
    }

    public String getEmail(){
        return this.email;
    }

    public Integer getEdad(){
        return this.edad;
    }
}
