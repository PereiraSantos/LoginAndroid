package br.com.unipar.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class CalcularSalario extends AppCompatActivity {

    private EditText edSalario;
    private String msg = "";
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_salario);
    }

    public void validaText(View view){

        edSalario = findViewById(R.id.edSalario);

        if (edSalario.getText().toString().equals("")){
            result = "Campo salario não pode ser vazio";
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        }else{
            calcular(view);
        }
    }

    public void calcular(View view) {

        edSalario = findViewById(R.id.edSalario);

        double salarioBruto = Double.parseDouble(edSalario.getText().toString());
        double desconto = 0;
        double salarioLiquido = 0;


        if(salarioBruto <= 1800.00){
            desconto = (salarioBruto * 9) / 100;
            msg = "9%";
        }else if(salarioBruto >= 1800.01 && salarioBruto <= 2750.00){
            desconto = (salarioBruto * 10) / 100;
            msg = "10%";
        }else if(salarioBruto >= 2750.01 && salarioBruto <= 4780.00){
            desconto = (salarioBruto * 10.5) / 100;
            msg = "10,5%";
        }else if(salarioBruto >= 4780.01){
            desconto = (salarioBruto * 12) / 100;
            msg = "12%";
        }

        salarioLiquido = salarioBruto - desconto;

        result = "Valor do salario: R$ "+Double.toString(salarioBruto)+"\nValor descontado: R$ "+ Double.toString(desconto)+" ("+ msg+
                 ")\nValor liquido: R$ "+ Double.toString(salarioLiquido);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
