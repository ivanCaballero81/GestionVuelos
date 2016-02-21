/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.dto;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class UsuarioDto {

    private String codigo;
    private String nombre;
    private String password;
    private String tipo;
    private Date nacimiento;

    public UsuarioDto(
            String codigo,
            String nombre,
            String password,
            String tipo,
            Date nacimiento
    ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
        this.nacimiento = nacimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

}
