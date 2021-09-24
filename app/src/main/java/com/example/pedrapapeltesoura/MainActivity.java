package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton botaoPedra = findViewById(R.id.btnPedra);
        botaoPedra.setOnClickListener(v -> sortearMao(0));

        ImageButton botaoPapel = findViewById(R.id.btnPapel);
        botaoPapel.setOnClickListener(v -> sortearMao(1));

        ImageButton botaoTesoura = findViewById(R.id.btnTesoura);
        botaoTesoura.setOnClickListener(v -> sortearMao(2));
    }

    @SuppressLint("SetTextI18n")
    public void sortearMao(Integer numero){
        Vibrator systemService = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        systemService.vibrate(50);
        int[] imagens = {R.drawable.pedra, R.drawable.papel, R.drawable.tesoura};

        int imagemSorteada = new Random().nextInt(imagens.length);

        ImageView imgEscolhaApp = findViewById(R.id.imgEscolhaApp);
        imgEscolhaApp.setImageResource(imagens[imagemSorteada]);

        TextView textResultado = findViewById(R.id.textResultado);

        if (numero == imagemSorteada){
            textResultado.setText("Deu empate!");
        }else if ((numero == 0 && imagemSorteada == 1) || (numero == 1 && imagemSorteada == 2) || (numero == 2 && imagemSorteada == 0)){
            textResultado.setText("Você perdeu :(");
        }else{
            textResultado.setText("Você ganhou :)");
        }

    }


}