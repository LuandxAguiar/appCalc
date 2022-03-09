package br.senai.sp.cotia.appcalcsalario.model;

public class Pessoa {
    private String planSaud;
    private String salarioBrut;
    private String inss;
    private String irrf;
    private String valeTransporte;
    private String valeAlimentacao;
    private String valeRefeicao;
    private String salarioLiq;




    public Pessoa () {

    }

    public String getSalarioLiq() {
        return salarioLiq;
    }

    public void setSalarioLiquido(String salarioLiquido) {
        this.salarioLiq = salarioLiquido;
    }

    public String getPlanSaud() {
        return planSaud;
    }

    public void setPlanoS(String planoS) {
        this.planSaud = planoS;
    }

    public String getValeRefei() {
        return valeRefeicao;
    }

    public void setValeRefei(String valeRefei) {
        this.valeRefeicao = valeRefei;
    }

    public String getSalarioBase() {
        return salarioBrut;
    }

    public void setSalarioBase(String salarioBase) {
        this.salarioBrut = salarioBase;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public String getIrrf() {
        return irrf;
    }

    public void setIrrf(String irss) {
        this.irrf = irrf;
    }

    public String getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(String valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public String getValeAlimen() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(String valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

}
