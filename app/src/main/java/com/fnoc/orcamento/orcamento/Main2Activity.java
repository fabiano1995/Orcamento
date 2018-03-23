package com.fnoc.orcamento.orcamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main2Activity extends Activity {

    private Button btnOk;
    private Button btnCancelar;
    private EditText vlPisoQuantidade;
    private RadioButton vlPisoPorcelanato1;
    private RadioButton vlPisoPorcelanato2;
    private RadioButton vlPisoPorcelanato3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnOk = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);
        vlPisoQuantidade = findViewById(R.id.vlPisoQuantidade);
        vlPisoPorcelanato1 = findViewById(R.id.vlPisoPorcelanato1);
        vlPisoPorcelanato2 = findViewById(R.id.vlPisoPorcelanato2);
        vlPisoPorcelanato3 = findViewById(R.id.vlPisoPorcelanato3);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                double valor = Double.parseDouble(vlPisoQuantidade.getText().toString());

                if(vlPisoPorcelanato1.isChecked()){
                    valor *= 75.00;
                }

                if(vlPisoPorcelanato2.isChecked()){
                    valor *= 125.00;
                }

                if(vlPisoPorcelanato3.isChecked()){
                    valor *= 300.00;
                }

                intent.putExtra("vlPisoQuantidade", valor);
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
