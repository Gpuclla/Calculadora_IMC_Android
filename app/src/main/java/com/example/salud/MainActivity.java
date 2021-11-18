package com.example.salud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSalir, btnCalcular, btnSalud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular= (Button) findViewById(R.id.btnCalcular);
        btnSalir= (Button) findViewById(R.id.btnSalir);
        btnSalud= (Button) findViewById(R.id.btnSalud);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarOperaciones();
            }
        });

        btnSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LlamarSalud();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void  LlamarSalud()
    {
        Intent vSalud = new Intent(MainActivity.this,Salud.class);
        startActivity(vSalud);
    }

    private void LlamarOperaciones()
    {
        Intent vOperaciones=new Intent(MainActivity.this,Operaciones.class);
        startActivity(vOperaciones);
    }

}