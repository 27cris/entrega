package com.camilo.entrega;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    EditText emailInput, passwordInput, confirmPasswordInput;
    Button registerButton;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        LinearLayout loginLayout = findViewById(R.id.loginLayout);

        dbHelper = new DatabaseHelper(this);

        registerButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();
            String pass = passwordInput.getText().toString().trim();
            String confirm = confirmPasswordInput.getText().toString().trim();

            if (email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(confirm)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            } else {
                boolean creado = dbHelper.insertarUsuario(email, pass);
                if (creado) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, InicioSesion.class));
                    finish();
                } else {
                    Toast.makeText(this, "Este correo ya está registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginLayout.setOnClickListener(v -> {
            startActivity(new Intent(this, InicioSesion.class));
            finish();
        });
    }
}
