package com.example.salud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class Operaciones extends AppCompatActivity {

    //declarar variables
    Button btnSuma, btnResta, btnProducto, btnDiv, btnLimpiar, btnlog, btnraiz, btnelev;
    EditText txtnum1, txtnm2;
    TextView txtresultado, txtsigno, txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);

        txtnum1 = (EditText) findViewById(R.id.txtnro1);
        txtnm2 = (EditText) findViewById(R.id.txtnro2);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txtsigno = (TextView) findViewById(R.id.txtSigno);
        txtresultado = (TextView) findViewById(R.id.txtResultado);
        btnSuma = (Button) findViewById(R.id.btnmas);
        btnResta = (Button) findViewById(R.id.btnresta);
        btnProducto = (Button) findViewById(R.id.btnmulti);
        btnDiv = (Button) findViewById(R.id.btndividir);
        btnLimpiar = (Button) findViewById(R.id.btnlimpiar);
        btnlog = (Button) findViewById(R.id.btnlog);
        btnraiz = (Button) findViewById(R.id.btnraiz);
        btnelev = (Button) findViewById(R.id.btnelevado);


        btnraiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                txt1.setText("la raiz del 1° nro es" + Math.sqrt(numero1));
                txt2.setText("la raiz del 2° nro es" + Math.sqrt(numero1));
                txtsigno.setText("Raiz");

            }

        });

        btnelev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                txtresultado.setText("" + Math.pow(numero1, numero2));
                txtsigno.setText("+");

            }

        });
        btnlog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                txt1.setText("El log del 1° nro es" + Math.log(numero1));
                txt2.setText("El log del 2° nro es" + Math.log(numero1));
                txtsigno.setText("Log");
            }

        });


        btnSuma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 + numero2;
                txtresultado.setText("" + resultado);
                txtsigno.setText("+");

            }

        });

        btnResta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 - numero2;
                txtresultado.setText("" + resultado);
                txtsigno.setText("-");
            }

        });

        btnProducto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 * numero2;
                txtresultado.setText("" + resultado);
                txtsigno.setText("X");
            }

        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 / numero2;
                txtsigno.setText("/");
                if (numero2 == 0) {
                    txt1.setText("Lo siento pero");
                    txt2.setText("no puedo dividir entre 0");
                    txtresultado.setText("error :(");
                } else {
                    txtresultado.setText("" + resultado);
                }
            }

        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnum1.setText("");
                txtnum1.invalidate();
                txtnm2.setText("");
                txtnm2.invalidate();
                txtresultado.setText("");
                txtresultado.invalidate();
                txt1.setText("");
                txt2.setText("");
            }
        });
    }
}
