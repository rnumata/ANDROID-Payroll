package br.com.payroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtHoras;
    EditText edtValorHora;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNome             = findViewById(R.id.edtNome);
        edtHoras            = findViewById(R.id.edtHorasTrabalhadas);
        edtValorHora        = findViewById(R.id.edtValorHora);
        btnCalcular         = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(     edtNome.getText().toString().isEmpty() ||
                        edtHoras.getText().toString().isEmpty() ||
                        edtValorHora.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Preencher todos os campos", Toast.LENGTH_SHORT).show();

                } else {

                    String nome     = edtNome.getText().toString();
                    int qtdHoras    = Integer.parseInt(edtHoras.getText().toString());
                    float vlrHora   = Float.parseFloat(edtValorHora.getText().toString());

                    Bundle bundle = new Bundle();

                    bundle.putString("nome", nome);
                    bundle.putInt("qtdHoras", qtdHoras);
                    bundle.putFloat("vlrHora", vlrHora);

                        //limpar Campos
                        edtNome.setText("");
                        edtHoras.setText("");
                        edtValorHora.setText("");

                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                    intent.putExtras(bundle);

                    startActivity(intent);
                }

            }
        });








    }
}