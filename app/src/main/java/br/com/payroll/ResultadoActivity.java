package br.com.payroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtHoras;
    TextView txtValorHora;
    TextView txtSalBruto;
    TextView txtIr;
    TextView txtInss;
    TextView txtFgts;
    TextView txtSalLiq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtNome         = findViewById(R.id.txtNome);
        txtHoras        = findViewById(R.id.txtHoras);
        txtValorHora    = findViewById(R.id.txtValorHora);
        txtSalBruto     = findViewById(R.id.txtSalBruto);
        txtIr           = findViewById(R.id.txtIr);
        txtInss         = findViewById(R.id.txtInss);
        txtFgts         = findViewById(R.id.txtFgts);
        txtSalLiq       = findViewById(R.id.txtSalLiq);

        Intent intent = getIntent();


        Bundle bundle = intent.getExtras();


        String nome     = bundle.getString("nome");
        int horas       = bundle.getInt("qtdHoras");
        float valorHora = bundle.getFloat("vlrHora");


        Funcionario funcionario = new Funcionario(nome, horas, valorHora);


        String valorHoraFormat  = String.format(Locale.FRANCE,"%.2f", funcionario.getValorHora());
        String salBrutoFormat   = String.format(Locale.FRANCE, "%.2f", funcionario.getSalBruto());
        String irFormat         = String.format(Locale.FRANCE, "%.2f", funcionario.getIr());
        String inssFormat       = String.format(Locale.FRANCE, "%.2f", funcionario.getInss());
        String fgtsFormat       = String.format(Locale.FRANCE, "%.2f", funcionario.getFgts());
        String salLiqFormat     = String.format(Locale.FRANCE, "%.2f", funcionario.getSalLiquido());


        txtNome.setText("Funcionario: " + funcionario.getNome());
        txtHoras.setText("Horas Trabalhadas: " + funcionario.getHoras());
        txtValorHora.setText("Valor Hora: R$ " + valorHoraFormat);
        txtSalBruto.setText("Salário Bruto: R$ " + salBrutoFormat);
        txtIr.setText("IR: R$ " + irFormat);
        txtInss.setText("INSS: R$ " + inssFormat);
        txtFgts.setText("FGTS: R$ " + fgtsFormat);
        txtSalLiq.setText("Salário Líquido: R$ " + salLiqFormat);

    }
}