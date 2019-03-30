//paquete
package co.edu.cecar.proyectocvlac.controllers;

//lib
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;

import co.edu.cecar.proyectocvlac.R;
//lista
import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText txtNombres;
    private TextInputEditText txtNacionalidad;
    private TextInputEditText txtSexo;
    private TextInputEditText txtCategoria;
    private ListView listViewLineaInvestigacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//referencia
        txtNombres = findViewById(R.id.txtNombres);
        txtNacionalidad = findViewById(R.id.txtNacionalidad);
        txtSexo = findViewById(R.id.txtSexo);
        txtCategoria = findViewById(R.id.txtCategorizado);
        listViewLineaInvestigacion=findViewById(R.id.listViewLineaInvestigacion);

//button
        Button btObtenerDatosCVLac = findViewById(R.id.btnObtenerDatos);
        btObtenerDatosCVLac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                extraerDatosCVLAC();

            }
        });
    }

    public void extraerDatosCVLAC() {

        new Thread(new Runnable() {
            @Override
            public void run() {
//lineas de invest
                Investigador investigador = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");
                adicionarDatosCasillasTexto(investigador);
            }

        }).start();

    }

    public void adicionarDatosCasillasTexto(final Investigador investigador) {
//hilo
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
//datos personales
                txtNombres.setText(investigador.getNombres());
                txtNacionalidad.setText(investigador.getNacionalidad());
                txtSexo.setText(investigador.getSexo());
                txtCategoria.setText(investigador.isCategorizado() ? "Si" : "No");

                runOnUiThread(new Runnable() {
                    @Override
            //lineas de inves
                    public void run() {
                        listViewLineaInvestigacion.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                                simple_list_item_1,investigador.getLineas()));
                    }
                });
            }
        });

    }

}
