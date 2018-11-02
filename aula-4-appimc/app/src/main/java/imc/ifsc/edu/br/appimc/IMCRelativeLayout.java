package imc.ifsc.edu.br.appimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IMCRelativeLayout extends AppCompatActivity {
    EditText etPeso ;
    EditText etAltura ;
    TextView tvIMC ;
    Double imc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcrelative_layout);
        //Associação dos atributos da classe java com os Objetos que estão
        this.etPeso = (EditText) findViewById(R.id.EditTextPeso);
        this.etAltura = (EditText)findViewById(R.id.EditTextAltura);
        this.tvIMC = (TextView) findViewById(R.id.TextViewResultadoIMC);
    }
    public void calculaIMC(View view) {

        Double peso = Double.parseDouble(this.etPeso.getText().toString());
        Double altura = Double.parseDouble(this.etAltura.getText().toString());
        this.imc=calculaIMC(altura,peso);
        tvIMC.setText(imc.toString());
    }

    public double calculaIMC (Double altura, double peso) {
        Double imc = peso /(altura * altura);
        DecimalFormat f = new DecimalFormat("#.####");
        return Double.parseDouble(f.format(imc));
    }


    public void openCreditos(View v ){
        Intent intent =new Intent(this,CreditosActivity.class);
        startActivity(intent);

    }
}
