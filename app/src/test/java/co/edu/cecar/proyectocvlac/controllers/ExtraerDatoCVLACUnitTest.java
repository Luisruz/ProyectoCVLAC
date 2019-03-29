package co.edu.cecar.proyectocvlac.controllers;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExtraerDatoCVLACUnitTest {

    @Rule
    public GestionarTestExtraerDatoCVLAC gestionarTestExtraerDatoCVLAC = new GestionarTestExtraerDatoCVLAC();

    @Test
    public void testDatosCVLAC() {
        Investigador investigador1 = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");
        String nombreInvestigador1 = "Luty Del Carmen Gomezcaceres Peréz";
        String nacionalidadInvestigador1 ="Colombiana";
        String sexoInvestigador1="Femenino";
        List<String> lineaInvestigador1= new ArrayList<>();
        lineaInvestigador1.add("control de calidad de alimentos, Activa:Si");
        lineaInvestigador1.add("Tecnologìa y Calidad en la industria del Alimento Calidad en alimento, Activa:Si");
        lineaInvestigador1.add("contaminación ambiental, Activa:Si");

        assertEquals(nombreInvestigador1, investigador1.getNombres());
        assertEquals(nacionalidadInvestigador1,investigador1.getNacionalidad());
        assertEquals(sexoInvestigador1,investigador1.getSexo());
        assertEquals(lineaInvestigador1,investigador1.getLineas());

    }
}
