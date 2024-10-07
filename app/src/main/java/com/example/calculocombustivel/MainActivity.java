package com.example.calculocombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@author:<Brenda>
 *@ra:<1110482313042>
 */

public class MainActivity extends AppCompatActivity {

    private EditText editTextGasolina, editTextEtanol;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextEtanol = findViewById(R.id.editTextEtanol);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCombustivel();
            }
        });
    }

    private void calcularCombustivel() {
        String gasolinaInput = editTextGasolina.getText().toString();
        String etanolInput = editTextEtanol.getText().toString();

        if (gasolinaInput.isEmpty() || etanolInput.isEmpty()) {
            textViewResultado.setText("Por favor, preencha ambos os campos.");
            return;
        }

        double precoGasolina;
        double precoEtanol;

        try {
            precoGasolina = Double.parseDouble(gasolinaInput);
            precoEtanol = Double.parseDouble(etanolInput);
        } catch (NumberFormatException e) {
            textViewResultado.setText("Entrada inválida. Use números válidos.");
            return;
        }

        if (precoEtanol <= (precoGasolina * 0.7)) {
            textViewResultado.setText("Abasteça com Etanol.");
        } else {
            textViewResultado.setText("Abasteça com Gasolina.");
        }
    }
}
