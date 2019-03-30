package co.edu.cecar.proyectocvlac.controllers;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class GestionarTestExtraerDatoCVLAC  extends TestWatcher {
    @Override
    protected void succeeded(Description description) {
        System.out.println("la prueba del metodo "+description.getClassName()+ " ha sido Exitosa");
    }
    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("la prueba del metodo "+description.getClassName()+ " ha sido Fallado");
        System.out.println("El error presentado es "+e.getLocalizedMessage());
    }
}
