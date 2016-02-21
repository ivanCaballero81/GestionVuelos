/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.Model;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class PasajeroDto {

    private int id;
    private String nombre;
    private String paterno;
    private String materno;
    private Tipo tipodocumento;
    private String numeroDocumento;
    private Date nacimiento;
    private String mail;
    private int idPais;

    public PasajeroDto(
            int id, 
            String nombre, 
            String paterno, 
            String materno, 
            Tipo tipodocumento,
            String numeroDocumento,
            Date nacimiento,
            String mail, 
            int idPais
    ) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tipodocumento = tipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.nacimiento = nacimiento;
        this.mail = mail;
        this.idPais = idPais;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Tipo getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipo tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    
    public enum Tipo {

        DNI("DOCUMENTO_DNI"),
        PASAPORTE("DOCUMENTO_PASS");

        private final String key;

        private Tipo(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }
}
