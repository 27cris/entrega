package com.camilo.entrega;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class banquete1 extends AppCompatActivity {

    ImageButton btnComentario;
    ImageButton btnatras;
    ImageButton btnCompartir;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_banquete1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa los botones
        btnCompartir = findViewById(R.id.btnCompartir);
        btnComentario = findViewById(R.id.btncomentario);
        btnatras = findViewById(R.id.btnatras);


        btnatras.setOnClickListener(v -> {
            Intent intent = new Intent(banquete1.this, banquetes.class);
            startActivity(intent);
        });

        btnCompartir.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String mensaje = "¡Mira este platillo navideño que encontré en CocinArte! 🎄🍽️";
            intent.putExtra(Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(intent, "Compartir con"));
        });
    }
}
