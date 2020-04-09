package br.com.unipar.loginpage;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edLogin;
    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verificarUsuario(View view){

        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);

        String result= "";

        String nome = edLogin.getText().toString();
        String senha = edPassword.getText().toString();

        if(nome.equals("teste") && senha.equals("123")){
            segundaTela(view);
        }else {
            result = "Nome ou senha incorreto tente novamnete";
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
    public void segundaTela(View view){
        Intent intent = new Intent(this,CalcularSalario.class);
        startActivity(intent);
    }
}
