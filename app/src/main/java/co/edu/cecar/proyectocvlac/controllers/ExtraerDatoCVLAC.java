package co.edu.cecar.proyectocvlac.controllers;

import android.content.Context;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//coment
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtraerDatoCVLAC {
    private ExtraerDatoCVLAC() {

    }

    public static Investigador getDatos(String url) {

        Investigador investigador = null;
        //array
        List<String> lineasInvestigacion = new ArrayList<>();

        try {
            Document documentoHTML = Jsoup.connect(url).get();
//estructura
            Elements tablas = documentoHTML.select("table"); //Se obtiene la segunda tabla
            Element tDatospersonales = documentoHTML.select("table").get(1);
            Elements filasTabla = tDatospersonales.select("tr");

            int filaNombre = 0;
            int filaNacionalidad = 2;
            int filaSexo = 3;
            if (filasTabla.size() > 5) {
                filaNombre = 2;
                filaNacionalidad = 4;
                filaSexo = 5;
            }
//datos person
            String nombre = filasTabla.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTabla.get(filaNacionalidad).select("td").get(1).text();
            String sexo = filasTabla.get(filaSexo).select("td").get(1).text();
//lineas
            investigador = new Investigador(nombre, nacionalidad, sexo, true);
            for (int i = 2; i < tablas.size(); i++) {
                Element tr = tablas.get(i).select("tr").first();
                if (tr != null) {
                    if (tr.text().equalsIgnoreCase("Líneas de investigación")) {
                        Elements listas = tablas.get(i).select("li");
                        for (Element lista : listas) {
                            lineasInvestigacion.add(lista.text());
                            investigador.setLineas(lineasInvestigacion);
                        }
                    }
                }
            }
//excepcion
        } catch (IOException e) {
            System.out.println(e);
        }

        return investigador;

    }
}
