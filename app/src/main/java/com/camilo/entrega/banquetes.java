package com.camilo.entrega;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class banquetes extends AppCompatActivity {

    ImageButton btnNavidad;
    ImageButton btnNuevo;
    ImageButton btnValentin;
    ImageButton btnMadre;
    ImageButton btnPadre;
    ImageButton btnAcademico;
    ImageButton btnAniversario;
    ImageButton btnCumple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_banquetes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar botones
        btnNavidad = findViewById(R.id.btnnavidad);
        btnNuevo = findViewById(R.id.btnnuevo);
        btnValentin = findViewById(R.id.btnvalentin);
        btnMadre = findViewById(R.id.btnmadre);
        btnPadre = findViewById(R.id.btnpadre);
        btnAcademico = findViewById(R.id.btnacademica);
        btnAniversario = findViewById(R.id.btnaniversario);
        btnCumple = findViewById(R.id.btncumple);

        // Listeners para cada botón
        btnNavidad.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete1.class);
            startActivity(intent);
        });

        btnNuevo.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete2.class);
            startActivity(intent);
        });

        btnValentin.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete3.class);
            startActivity(intent);
        });

        btnMadre.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete4.class);
            startActivity(intent);
        });

        btnPadre.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete5.class);
            startActivity(intent);
        });

        btnAcademico.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete6.class);
            startActivity(intent);
        });

        btnAniversario.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete7.class);
            startActivity(intent);
        });

        btnCumple.setOnClickListener(v -> {
            Intent intent = new Intent(banquetes.this, banquete8.class);
            startActivity(intent);
        });
    }
}
