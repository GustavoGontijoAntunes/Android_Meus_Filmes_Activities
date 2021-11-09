package br.com.vrstudios.meusfilmesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.vrstudios.meusfilmesapp.Model.Filme;

public class MainActivity extends AppCompatActivity {

    Button btnComprar, btnAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComprar = findViewById(R.id.btnComprar);
        btnAlugar = findViewById(R.id.btnAlugar);

        btnAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityComprar(false);
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirActivityComprar(true);
            }
        });
    }

    public void abrirActivityComprar(boolean ifLifetime){
        Intent intent = new Intent(getApplicationContext(), Comprar.class);
        Filme filme = new Filme("E o Ventor Levou", 9.90, ifLifetime);
        intent.putExtra("compraObj", filme);
        startActivity(intent);
    }
}