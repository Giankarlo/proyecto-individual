package com.sw3p.proyecto.calculodeplanilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtHoras, txtDias;
    private CheckBox chkbPago, chkbDescuento;
    private RadioGroup rdgroupRound;
    private RadioButton rdbRedondeo, rdbNoredondeo;
    private Button btnCalcular, btnLimpiar;
    private TextView lblPago, lblDescuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoras = (EditText) findViewById(R.id.txtHoras);
        txtDias = (EditText) findViewById(R.id.txtDias);
        chkbPago = (CheckBox) findViewById(R.id.chkbPago);
        chkbDescuento =(CheckBox) findViewById(R.id.chkbDescuento);
        rdgroupRound =(RadioGroup) findViewById(R.id.rdgroupRound);
        rdbRedondeo =(RadioButton) findViewById(R.id.rdbRedondeo);
        rdbNoredondeo =(RadioButton) findViewById(R.id.rdbNoredondeo);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        lblPago = (TextView) findViewById(R.id.lblPago);
        lblDescuento = (TextView) findViewById(R.id.lblDescuento);
    }
     public void Calcular(View view){
        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int horas_mensuales = horas*dias;
        Double pago = horas_mensuales*15.50;
        Double descuento = 0.00;
        Double sueldo_base = 4500.00;

        if(chkbPago.isChecked()==true){
            lblPago.setText(String.valueOf(pago));
        }

        if(chkbDescuento.isChecked()==true && pago>4500){
            descuento = pago-(pago*0.1);
            lblDescuento.setText(String.valueOf(descuento));
        }

        if(rdgroupRound.getCheckedRadioButtonId()==R.id.rdbRedondeo){
            int pago_redondeo = (int)Math.round(pago);
            lblPago.setText(String.valueOf(pago_redondeo));
            int descuento_redondeo = (int)Math.round(descuento);
            lblDescuento.setText(String.valueOf(descuento_redondeo)) ;
        }
     }

     public void Limpiar(View view){
         txtHoras.setText("");
         txtDias.setText("");
         chkbPago.setChecked(false);
         chkbDescuento.setChecked(false);
         rdbRedondeo.setChecked(false);
         rdbNoredondeo.setChecked(false);
         lblPago.setText("Pago");
         lblDescuento.setText("Con descuento");
     }
}
