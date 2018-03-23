package com.fnoc.orcamento.orcamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main3Activity extends Activity {

    private Button btnOk;
    private Button btnCancelar;
    private EditText vlParedeTamanho;
    private RadioButton vlParedeTinta1;
    private RadioButton vlParedeTinta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);
        vlParedeTamanho = findViewById(R.id.vlParedeTamanho);
        vlParedeTinta1 = findViewById(R.id.vlParedeTinta1);
        vlParedeTinta2 = findViewById(R.id.vlParedeTinta2);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                double valor = Double.parseDouble(vlParedeTamanho.getText().toString());

                if(vlParedeTinta1.isChecked()){
                    valor *= 35.00;
                }

                if(vlParedeTinta2.isChecked()){
                    valor *= 55.00;
                }

                intent.putExtra("vlParedeTamanho", valor);
                setResult(1, intent);
                finish();

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                setResult(0, intent);
                finish();

            }
        });

    }
}
