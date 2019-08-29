package com.example.practica_controlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private Spinner spiner;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.valor1);
        valor2 = (EditText) findViewById(R.id.valor2);
        resultado = (TextView) findViewById(R.id.resultado);
        spiner = (Spinner) findViewById(R.id.spinner);

        String[] opciones = {"sumar","restar","multiplicar","dividir"};
        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_agustin, opciones);
        spiner.setAdapter(adaptador);
    }

    public void Calcular(View view){
        String numero1 = valor1.getText().toString(), numero2 = valor2.getText().toString(), result = "";
        int num1 = Integer.parseInt(numero1), num2 = Integer.parseInt(numero2);

        String seleccion = spiner.getSelectedItem().toString();
        if(seleccion.equals("sumar")){
            result = String.valueOf(num1+num2);
        }
        else{
            if(seleccion.equals("restar")){
                result = String.valueOf(num1-num2);
            }
            else{
                if(seleccion.equals("multiplicar")){
                    result = String.valueOf(num1*num2);
                }
                else{
                    if(num2 == 0)
                        Toast.makeText(this, "El divisor no puede valer 0", Toast.LENGTH_SHORT).show();
                    else
                        result = String.valueOf(num1/num2);
                }
            }
        }

        resultado.setText(result);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
