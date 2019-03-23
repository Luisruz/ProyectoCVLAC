package co.edu.cecar.proyectocvlac.controllers;

import org.junit.Rule;
import org.junit.Test;

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
        Investigador investigador1 = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000315826");
        // se define los datos esperados
        String nombreInvestigador1 = "Carlos Segundo Cohen Manrique";
        String nacionalidadInvestigador1 ="Colombiana";
        String sexoInvestigador1="Masculino";
        // se comprueba el valor esperado co nel obtenido
        assertEquals(nombreInvestigador1, investigador1.getNombres());
        assertEquals(nacionalidadInvestigador1,investigador1.getNacionalidad());
        assertEquals(sexoInvestigador1,investigador1.getSexo());

    }
 /*
    @Test
   public void testDatosCVLAC1() {
        //se obtiene los datos del investigador
        Investigador investigador = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");
        // se define los datos esperados
        String nombreInvestigador = "Luty Del Carmen Gomezcaceres Peréz";
        // se ocmpara con los datos que se esperan
        assertEquals(nombreInvestigador, investigador.getNombres());
    }*/
}
