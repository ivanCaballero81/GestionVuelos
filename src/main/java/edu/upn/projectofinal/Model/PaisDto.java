/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.Model;

/**
 *
 * @author ivan
 */
public class PaisDto {

    private int Idpais;
    private String nombre;

    public PaisDto(
            int Idpais,
            String nombre
    ) {
        this.Idpais = Idpais;
        this.nombre = nombre;
    }

    public int getIdpais() {
        return Idpais;
    }

    public void setIdpais(int Idpais) {
        this.Idpais = Idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
