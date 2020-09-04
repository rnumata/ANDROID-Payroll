package br.com.payroll;

public class Funcionario {

    private String nome;
    private int horas;
    private float valorHora;
    private float salBruto;
    private float salLiquido;
    private float ir;
    private float inss;
    private float fgts;


    /* Atalho command N */

    public Funcionario(String nome, int horas, float valorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
        calcularSalBruto();
        calcularIR();
        calcularINSS();
        calcularFGTS();
        calcularSalLiq();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getSalBruto() {
        return salBruto;
    }

    public void setSalBruto(float salBruto) {
        this.salBruto = salBruto;
    }

    public float getSalLiquido() {
        return salLiquido;
    }

    public void setSalLiquido(float salLiquido) {
        this.salLiquido = salLiquido;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getFgts() {
        return fgts;
    }

    public void setFgts(float fgts) {
        this.fgts = fgts;
    }


    /* Metodos */

    public void calcularSalBruto(){
        this.salBruto = this.valorHora * this.horas;
    }

    public void calcularIR(){
        if(this.salBruto <= 1372.81f){
            this.ir = 0;
        } else if(this.salBruto <= 2743.25f){
            this.ir = this.salBruto * 0.15f;
        } else {
            this.ir = this.salBruto * 0.275f;
        }
    }

    public void calcularINSS(){
        if(this.salBruto <= 868.29f){
            this.inss = this.salBruto * 0.08f;
        } else if(this.salBruto <= 1447.14f){
            this.inss = this.salBruto * 0.09f;
        } else if(this.salBruto <= 2894.28f) {
            this.inss = this.salBruto * 0.11f;
        } else {
            this.inss = 318.37f;
        }
    }

    public void calcularFGTS(){
        this.fgts = this.salBruto * 0.08f;
    }

    public void calcularSalLiq(){
        this.salLiquido = this.salBruto - this.ir - this.inss;
    }

}
