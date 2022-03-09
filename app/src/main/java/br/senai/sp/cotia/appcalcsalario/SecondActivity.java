package br.senai.sp.cotia.appcalcsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private double salarioBrut, inss, vr,irf,va,liquidsala,valorvt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        salarioBrut = getIntent().getDoubleExtra("salbruto",1);
        inss = getIntent().getDoubleExtra("descInss",inss);
        vr = getIntent().getDoubleExtra("descValeRef",vr);
        irf = getIntent().getDoubleExtra("descIrrf",irf);
        va = getIntent().getDoubleExtra("descValeAlim",va);
        liquidsala = getIntent().getDoubleExtra("SalLiquido",liquidsala);
        valorvt = getIntent().getDoubleExtra("descValeTrans",valorvt);
    }
}

