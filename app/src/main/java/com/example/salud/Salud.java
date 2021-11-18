package com.example.salud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class Salud extends AppCompatActivity {
    EditText etNombre;
    EditText etPeso;
    EditText etAltura;
    Button btnCalcular, btnLimpiar, btnSalir;
    RadioButton rbVaron, rbMujer;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        etNombre = (EditText) findViewById(R.id.txtNombre);
        etPeso = (EditText) findViewById(R.id.txtPeso);
        etAltura = (EditText) findViewById(R.id.txtAltura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        rbVaron = (RadioButton) findViewById(R.id.rbVaron);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

            btnLimpiar.setOnClickListener((v) -> Limpiar());
            btnCalcular.setOnClickListener((v) -> CalcularIMC());
            btnSalir.setOnClickListener((v)->finish());
        }
        private void Limpiar()
        {
            etNombre.setText("");
            etAltura.setText("");
            etPeso.setText("");
        }
        private String MensajeIMC (double IMC)
        {
            String nombre= etNombre.getText().toString();
            /*----------PESO MUY BAJO------------*/
            if (IMC<18.5) {
                AlertDialog.Builder malo = new AlertDialog.Builder(this);
                malo.setTitle("¡Cuidado! "+nombre);
                malo.setMessage(" ⸮óᗝò? "+"\n"+"Tu IMc es de: "+IMC+"\n"+"Tienes Peso bajo muy grave"+"\n"+"¿Deseas que te ayudemos?");
                malo.setCancelable(false);
                malo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent vMalo = new Intent(Salud.this,PesoBajo.class);
                        startActivity(vMalo);
                    }
                });
                malo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                malo.show();
            }
            /*---------------PESO BUENO-----------------*/
            else if (IMC >= 18.5 & IMC<24.9){
                AlertDialog.Builder bueno = new AlertDialog.Builder(this);
                bueno.setTitle("Enhorabuena "+nombre);
                bueno.setMessage("ᕦ(óᗜò)ᕥ"+"\n"+"Tu IMc es de: "+IMC+"\n"+"Tu peso se encuentra en el promedio bueno"+"\n"+"¿Deseas saber como mantener tu peso?");
                bueno.setCancelable(false);
                bueno.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent vBueno = new Intent(Salud.this,PesoBueno.class);
                        startActivity(vBueno);
                    }
                });
                bueno.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                bueno.show();
            }
            /*----------------SOBREPESO------------*/
            else if (IMC >= 25.0 & IMC<29.9){
                AlertDialog.Builder malito = new AlertDialog.Builder(this);
                malito.setTitle("¡Puedes mejorar! "+nombre);
                malito.setMessage("(´• ﹏ •`)"+"\n"+"Tu IMc es de: "+IMC+"\n"+"Pueda que tengas sobrepeso, puedes mejorar"+"\n"+"¿Deseas que te ayudemos?");
                malito.setCancelable(false);
                malito.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent vAlto = new Intent(Salud.this,PesoAlto.class);
                        startActivity(vAlto);
                    }
                });
                malito.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                malito.show();
            }
            /*------------------------OBESISDAD----------------*/
            else if (IMC >= 30){
                AlertDialog.Builder malo = new AlertDialog.Builder(this);
                malo.setTitle("¡Cuidado! "+nombre);
                malo.setMessage("(づ´• ᗝ •`)づ"+"\n"+"Tu IMc es de: "+IMC+"\n"+"Tu peso excede al promedio, necesitas ayuda"+"\n"+"¿Deseas que te ayudemos?");
                malo.setCancelable(false);
                malo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        Intent vMuyalto = new Intent(Salud.this,PesoMuyAlto.class);
                        startActivity(vMuyalto);
                    }
                });
                malo.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        cancelar();
                    }
                });
                malo.show();
            }
            return null;
        }

        /*---------------------GENERO O SEXO-----------------*/
        private void CalcularIMC ()
        {
            DecimalFormat formato=new DecimalFormat("#.00");

            Double altura=Double.parseDouble(etAltura.getText().toString());
            Double peso=Double.parseDouble(etPeso.getText().toString());
            double IMC = (peso/(Math.pow(altura,2)));
            txtResultado.setText(formato.format(IMC));

            Toast.makeText(this, "tu IMC es "+String.format("&.2f",IMC)+MensajeIMC(IMC),Toast.LENGTH_LONG).show();
            if (rbMujer.isChecked()==true)
                Toast.makeText(this, "Eres Mujer",Toast.LENGTH_LONG).show();
            else if (rbVaron.isChecked()==true)
                Toast.makeText(this, "Eres Varon",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "No eligio genero",Toast.LENGTH_LONG).show();
        }
        /*-----------------------------------------------------*/

        private void cancelar() {
            return;
        }

    }
