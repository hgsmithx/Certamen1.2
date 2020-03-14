package com.example.certamen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView Num1;
    private TextView Num2;
    private TextView Operador;
    private Button btnRandoms;
    private Button btnSuma;
    private Button btnResta;
    private Button btnMul;
    private Button btnDiv;
    private Button btnLimpiar;
    private Button btnPar;
    private Button btnPrimo;
    private TextView Resultado;
    private TextView label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Num1 = findViewById(R.id.txtNumero1);//TextView Numero 1 Random
        Num2 = findViewById(R.id.txtNumero2);//TextView Numro 2 Random
        Operador = findViewById(R.id.txtOperador);
        btnRandoms = findViewById(R.id.btnRandom);// Btn generador de numeros random
        btnSuma = findViewById(R.id.btnSuma);// Btn de suma
        btnResta = findViewById(R.id.btnResta);//Btn de resta
        btnMul = findViewById(R.id.btnMul);// Btn de multiplicacion
        btnDiv = findViewById(R.id.btnDiv); //Btn de division
        btnLimpiar = findViewById(R.id.btnLimpiar);//Btn para limpiar los TextView
        btnPar = findViewById(R.id.btnPar);
        btnPrimo = findViewById(R.id.btnPrimo);
        Resultado = findViewById(R.id.label2);
        label = findViewById(R.id.label3);

        btnRandoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumerosRandom();
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ComprovarVacio()==true){
                    Resultado.setText("ERROR");
                }else{
                    Operador.setText("+");
                    Resultado.setText(Suma(Integer.parseInt(Num1.getText().toString()),Integer.parseInt(Num2.getText().toString()))+"");
                }

            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ComprovarVacio()==true){
                    Resultado.setText("ERROR");
                }else{
                    Operador.setText("-");
                    Resultado.setText(Resta(Integer.parseInt(Num1.getText().toString()),Integer.parseInt(Num2.getText().toString()))+"");
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ComprovarVacio()==true){
                    Resultado.setText("ERROR");
                }else{
                    Operador.setText("x");
                    Resultado.setText(Multiplicacion(Integer.parseInt(Num1.getText().toString()),Integer.parseInt(Num2.getText().toString()))+"");
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ComprovarVacio()==true){
                    Resultado.setText("ERROR");
                }else{
                    Operador.setText("/");
                    Resultado.setText(Division(Integer.parseInt(Num1.getText().toString()),Integer.parseInt(Num2.getText().toString()))+"");
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resultado.setText("");
                Operador.setText("?");
                Num1.setText("");
                Num2.setText("");
                label.setText("");
            }
        });
       btnPar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(ComprovarVacio()==true){
                   Resultado.setText("ERROR");
               }else{
                   int num1 =Integer.parseInt(Num1.getText().toString());
                   int num2 = Integer.parseInt(Num2.getText().toString());
                   int par = num1+num2;
                   if ( par%2==0){
                       label.setText("Es par");
                   }else{
                       label.setText("Es Impar");
                   }
               }
           }
       });
       btnPrimo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String operador = Operador.getText().toString();
               if(ComprovarVacio()==true || operador=="?"){
                   Resultado.setText("ERROR");
               }else{
                   int num1 =Integer.parseInt(Num1.getText().toString());
                   int num2 = Integer.parseInt(Num2.getText().toString());
                   int primo = num1+num2;
                    if(esPrimo(primo)==true){
                        label.setText("Es primo");
                    }else{
                        label.setText("No es primo");
                    }

               }
           }
       });

    }
    public void NumerosRandom(){
        Random numRandom = new Random();
        int Random1 = numRandom.nextInt(100);
        int Random2 = numRandom.nextInt(100);

        Num1.setText(Random1+"");
        Num2.setText(Random2+"");
    }

    public float Suma(int x, int y){
        return x+y;
    }
    public float Resta(int x, int y){
        return x-y;
    }
    public float Multiplicacion(int x, int y){
        return x*y;
    }
    public float Division(int x, int y){
        return x/y;
    }
    public boolean ComprovarVacio(){
        String cadena;
        cadena = Num1.getText().toString();
        if (cadena == ""){
            return true;
        }else{
            return false;
        }
    }
    public  Boolean esPrimo(int numero)
    {
        Boolean esPrimoActual = true;
        if(numero<2)
        {
            esPrimoActual = false;
        }
        else
        {
            for(int x=2; x*x<=numero; x++)
            {
                if( numero%x==0 ){
                    esPrimoActual = false;
                    break;
                }
            }
        }
        return esPrimoActual;
    }

}

