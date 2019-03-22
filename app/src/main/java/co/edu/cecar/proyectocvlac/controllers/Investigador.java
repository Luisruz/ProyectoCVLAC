/**

    Clase: Investigador.java

    Version: 0.1

    Fecha Creaci�n: 12/02/2019

    Ultima Fecha de Modificaci�n: 

    Copyright: Jhon Jaime Mendez
*/

package co.edu.cecar.proyectocvlac.controllers;

/**
  Esta clase modela los datos de un Investigador
*/

public class Investigador {

    private String nombres;
    private String nacionalidad;
    private String sexo;
    private boolean categorizado;

    public Investigador(String nombres, String nacionalidad, String sexo,boolean categorizado) {

        this.nombres = nombres;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.categorizado = categorizado;

    }

    public String getNombres() {
            return nombres;
    }

    public void setNombres(String nombres) {
            this.nombres = nombres;
    }

    public String getNacionalidad() {
            return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
            return sexo;
    }

    public void setSexo(String sexo) {
            this.sexo = sexo;
    }

    public boolean isCategorizado() {
        return categorizado;
    }
	
}
