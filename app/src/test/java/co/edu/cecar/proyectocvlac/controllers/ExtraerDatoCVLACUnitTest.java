package co.edu.cecar.proyectocvlac.controllers;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraerDatoCVLACUnitTest {

    @Rule
    public GestionarTestExtraerDatoCVLAC gestionarTestExtraerDatoCVLAC = new GestionarTestExtraerDatoCVLAC();

    @Test
    public void testDatosCVLAC() {
        // se definfen los datos de referencia con los que se provara el metodo extraer datos
        Investigador investigador1 = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");
        // se define los datos esperados
        String nombreInvestigador1 = "Luty Del Carmen Gomezcaceres Peréz";
        String nacionalidadInvestigador1 ="Colombiana";
        String sexoInvestigador1="Femenino";
        List<String> lineaInvestigador1= new ArrayList<>();
        lineaInvestigador1.add("control de calidad de alimentos, Activa:Si");
        lineaInvestigador1.add("Tecnologìa y Calidad en la industria del Alimento Calidad en alimento, Activa:Si");
        lineaInvestigador1.add("contaminación ambiental, Activa:Si");


        // se comprueba el valor esperado co nel obtenido
        assertEquals(nombreInvestigador1, investigador1.getNombres());
        assertEquals(nacionalidadInvestigador1,investigador1.getNacionalidad());
        assertEquals(sexoInvestigador1,investigador1.getSexo());
        assertEquals(lineaInvestigador1,investigador1.getLineas());

    }
}
