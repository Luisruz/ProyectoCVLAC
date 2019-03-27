package co.edu.cecar.proyectocvlac.controllers;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtraerDatoCVLAC {

    public static Investigador getDatos(String url) {

        Investigador investigador = null;
        List<String> lineasInvestigacion = new ArrayList<>();

        try {

            //Se obtiene el documento HTML
            Document documentoHTML = Jsoup.connect(url).get();

            Elements tablas = documentoHTML.select("table"); //Se obtiene la segunda tabla
            Element tDatospersonales = documentoHTML.select("table").get(1);
            Elements filasTabla = tDatospersonales.select("tr"); // Se obtienen las filas de la tabla

            int filaNombre = 0;
            int filaNacionalidad = 2;
            int filaSexo = 3;
            if (filasTabla.size() > 5) {
                filaNombre = 2;
                filaNacionalidad = 4;
                filaSexo = 5;
            }

            //Se obtienen las columnas para cada atributo del invstigador
            String nombre = filasTabla.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTabla.get(filaNacionalidad).select("td").get(1).text();
            String sexo = filasTabla.get(filaSexo).select("td").get(1).text();

            //Se crea el objeto investigador
            investigador = new Investigador(nombre, nacionalidad, sexo, true);
            for (int i = 2; i < tablas.size(); i++) {
                Element tr = tablas.get(i).select("tr").first();
                if (tr!=null){
                    if(tr.text().equalsIgnoreCase("Líneas de investigación")){
                        Elements listas = tablas.get(i).select("li");
                        for (Element lista : listas) {
                          //  Log.i("dato lista",lista.text());
                         //   List<TextNode> nodos = lista.textNodes();
                            lineasInvestigacion.add(lista.text());
                            investigador.setLineas(lineasInvestigacion);
                        //    Log.i("datos extraer", lineasInvestigacion+"");
                        }
                    }
                }
            }



        } catch (IOException e) {

            e.printStackTrace();

        }

        return investigador;

    }
}
