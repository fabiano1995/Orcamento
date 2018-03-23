package com.fnoc.orcamento.orcamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Button btnPiso;
    private Button btnParede;
    private EditText vlPiso;
    private EditText vlParede;
    private EditText vlTotal;

    private double x;
    private double y;
    private double r;

    static final int PICK_VALOR_PISO_REQUEST = 300;
    static final int PICK_VALOR_PAREDE_REQUEST = 301;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPiso = findViewById(R.id.btnPiso);
        btnParede = findViewById(R.id.btnParde);
        vlPiso = findViewById(R.id.vlPiso);
        vlParede = findViewById(R.id.vlParede);
        vlTotal = findViewById(R.id.vlTotal);

        btnPiso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult( intent, PICK_VALOR_PISO_REQUEST);
            }
        });

        btnParede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivityForResult( intent,PICK_VALOR_PAREDE_REQUEST);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == PICK_VALOR_PISO_REQUEST && resultCode == 1 ){
            String valor = String.valueOf(data.getDoubleExtra("vlPisoQuantidade", 0));
            this.x = Double.parseDouble(valor);
            vlPiso.setText(valor);
        }

        if ( requestCode == PICK_VALOR_PAREDE_REQUEST && resultCode ==1 ){
            String valor = String.valueOf(data.getDoubleExtra("vlParedeTamanho", 0));
            this.y = Double.parseDouble(valor);
            vlParede.setText(valor);
        }

        String resultado = String.valueOf(this.r = (this.x + this.y));

        vlTotal.setText(resultado);

    }


}
