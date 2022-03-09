package br.senai.sp.cotia.appcalcsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity<intent> extends AppCompatActivity {
    private TextView tvResultPS;
    private EditText etSalarioBruto, etnumDependentes;
    private RadioGroup radioPlan, radioTransporte, radio_va, radio_vr;
    private Button btCalcular;
    private double salarioBrut, salarioLiq;
    private double inss = 0;
    double vr=0;
    double plan=0;
    double   irf = 0;
    double va = 0;
    double valorvt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refenciar os componentes
        etSalarioBruto = findViewById(R.id.salbruto);
        etnumDependentes = findViewById(R.id.numDependentes);
        btCalcular = findViewById(R.id.bt_calcular);
        radioPlan = findViewById(R.id.rbPlan);
        radioTransporte = findViewById(R.id.radioTransporte);
        radio_va = findViewById(R.id.radio_va);
        radio_vr = findViewById(R.id.radio_vr);
        // metodo para descobrir o desconto do plano de saúde
        //convertendo
        salarioBrut = Double.parseDouble(etSalarioBruto.getText().toString());
        btCalcular.setOnClickListener(v -> {

            //sAUDE

            switch (radioPlan.getCheckedRadioButtonId()) {

                case R.id.rb_stand:
                    if (salarioBrut <= 3000) {
                        plan = 60;

                    } else
                        plan = 80;

                case R.id.rb_basico:
                    if (salarioBrut <= 3000) {
                        plan = 80;

                    } else
                        plan = 110;

                case R.id.rb_super:
                    if (salarioBrut <= 3000) {

                        plan = 95;

                    } else {

                        plan = 135;
                    }

                case R.id.rb_master:
                    if (salarioBrut <= 3000) {
                        plan = 130;

                    } else {
                        plan = 180;
                    }
            }

            //VR

            if (radio_vr.getCheckedRadioButtonId() == R.id.possui_vr) {
                if (salarioBrut <= 3000) {
                    vr = 2.60 * 22;

                } else if (salarioBrut <= 5000) {
                    vr = 3.60 * 22;

                } else {
                    vr = 6.50 * 22;
                }
            }
            //Transporte
            if (radioTransporte.getCheckedRadioButtonId() == R.id.possui_vt) {
                valorvt = salarioBrut * 6 / 100;


            }
            //inss

            if (salarioBrut <= 1212.00) {
                inss = salarioBrut * (7.5 / 100);

            } else if (salarioBrut < 2427.35) {
                inss = salarioBrut * 9 / 100 - 14.18;

            } else if (salarioBrut < 3641.03) {
                inss = salarioBrut * 12 / 100 - 80.00;

            } else if (salarioBrut < 7087.22) {
                inss = salarioBrut * 14 / 100 - 160.82;

            } else {
                inss = 835.39;
            }

            //Calcular IRRF

            double dependentes = Double.parseDouble(etnumDependentes.getText().toString());
            double IRRF = salarioBrut - inss - (189.59 * dependentes);

            if (IRRF <= 1903.98) {


            } else if (IRRF < 2826.65) {
                irf = IRRF * 0.75 - 142.80;

            } else if (IRRF < 3751.05) {
                irf = IRRF * 0.15 - 354.80;

            } else if (IRRF < 4664.68) {
                irf = IRRF * 0.225 - 636.13;

            } else {
                irf = IRRF * 0.275 - 869.36;
            }

            if (radio_va.getCheckedRadioButtonId() == R.id.possui_va) {
                if (salarioBrut <= 3000) {
                    va = 15.00;

                } else if (salarioBrut <= 5000) {
                    va = 25.00;

                } else {
                    va = 35.00;

                }
            }

            // calcular salario liquido
            double liquidsala = salarioBrut - va - vr - plan - irf - inss - valorvt;

            //


            //validar texto
            if (etSalarioBruto.getText().toString() == null) {
                etSalarioBruto.setError("Valor não colocado");
            } else if (etnumDependentes.getText().toString() == null) {
                etnumDependentes.setError("Numero Inválido");
            } else if (radioPlan.toString() == null) {
                Snackbar.make(radioPlan, "Selecione uma opção de Vale Refeição", Snackbar.LENGTH_SHORT);
            } else if (radioTransporte.toString() == null) {
                Snackbar.make(radioTransporte, "Colocar alguma opcao no VT", Snackbar.LENGTH_LONG);
            } else if (radio_va.toString() == null) {
                Snackbar.make(radio_va, "coloque sim ou não ", Snackbar.LENGTH_LONG);
            } else if (radio_vr.toString() == null) {
                Snackbar.make(radio_vr, "Coloque alguma opção ", Snackbar.LENGTH_LONG);

            } else {
                Intent intent = new Intent(this, SecondActivity.class);
                //pendurando
                intent.putExtra("salario", salarioBrut);
                intent.putExtra("INSS", inss);
                intent.putExtra("valeRefeicao", vr);
                intent.putExtra("IRRF", irf);
                intent.putExtra("radiova", va);
                intent.putExtra("salario", liquidsala);
                intent.putExtra("vt", valorvt);

                startActivity(intent);

            }


        }



    }
    }
