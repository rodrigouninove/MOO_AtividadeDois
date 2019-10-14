package br.uninove.empresa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Funcionario extends Pessoa{

    private String matricula;
    private ArrayList<Pessoa> dependentes;

    public Funcionario(String nome, String cpf, Date dataNascimento, String matricula) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.dependentes = new ArrayList<>();
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    
    
    public void adicionarDependente(Pessoa pessoa){
        this.dependentes.add(pessoa);
    }
    
    public void removerDependente(Pessoa pessoa){
        this.dependentes.remove(pessoa);
    }

    @Override
    public String toString() {
        SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
        String pattern = "%-15.15s %-28.28s %-20.14s %-15.15s %-15.15s";
        return String.format(pattern, this.getMatricula(), this.getNome(), this.getCpf(), fData.format(this.getDataNascimento()), this.dependentes.size());
    }
    
    
    
    
    
    
    
}
