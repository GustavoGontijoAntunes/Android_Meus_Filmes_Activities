package br.com.vrstudios.meusfilmesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finalizar extends AppCompatActivity {

    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar);

        btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartilharCompra();
            }
        });
    }

    public void voltarInicio(View v) {
        finish();
    }

    public void compartilharCompra() {
        // Criar um objeto do tipo Intent
        Intent share = new Intent();
        // Ação a ser realizada
        share.setAction(Intent.ACTION_SEND);
        // Extras
        share.putExtra(Intent.EXTRA_TEXT, "Venha assistir o filme 'E o Vento Levou' comigo!");
        // Definir o tipo de dado (Mime Type)
        share.setType("text/plain");
        // Criar um seletor (Intent Implícitas)
        Intent seletor = Intent.createChooser(share, "Selecione o app para compartilhar esta mensagem:");
        // Inicializar
        if(seletor.resolveActivity(getPackageManager()) != null) {
            startActivity(seletor);
        }



        /*
        // Definir quem pode compartilhar - Intent Explícita
        share.setPackage("com.whatsapp");
        // Inicializar Intent
        try {
            startActivity(share);
        } catch (Exception e) {
            e.getMessage();
        }
         */
    }
}