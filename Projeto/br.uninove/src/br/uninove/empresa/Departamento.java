package br.uninove.empresa;

import java.util.ArrayList;

public class Departamento {

    protected String nome;
    protected String sigla;
    private ArrayList<Funcionario> funcionarios;

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Departamento(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.funcionarios = new ArrayList<>();
    }

    public void alocarFuncionario(Funcionario funcionario) {

        if (funcionarios.indexOf(funcionario) >= 0) {
            return;
        }
        
        funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario){
        this.funcionarios.remove(funcionario);
    }

    public boolean funcionarioAlocado(Funcionario funcionario) {
        return this.funcionarios.contains(funcionario);
    }

    public int getTotalFuncionarios() {
        return this.funcionarios.size();
    }

    @Override
    public String toString() {
        String pattern = "%-10s %-30s %-15s";
        return String.format(pattern, this.getSigla(), this.getNome(), this.getTotalFuncionarios());
    }
    
    

}
