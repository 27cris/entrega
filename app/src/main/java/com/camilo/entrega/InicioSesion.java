package com.camilo.entrega;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InicioSesion extends AppCompatActivity {

    EditText emailInput, passwordInput;
    Button loginButton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        LinearLayout registerPrompt = findViewById(R.id.registerPrompt);

        dbHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();
            String pass = passwordInput.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                boolean loginCorrecto = dbHelper.validarLogin(email, pass);
                if (loginCorrecto) {
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Aquí puedes abrir un HomeActivity
                    // startActivity(new Intent(this, HomeActivity.class));
                    // finish();
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerPrompt.setOnClickListener(v -> {
            startActivity(new Intent(this, Registro.class));
            finish();
        });
    }
}
