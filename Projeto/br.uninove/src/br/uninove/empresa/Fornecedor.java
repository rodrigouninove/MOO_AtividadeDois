package br.uninove.empresa;

import java.util.Calendar;
import java.util.Date;


public class Fornecedor extends Pessoa{

    private Date inicio;
    private String servico;

    public Date getInicio() {
        return inicio;
    }

    public String getServico() {
        return servico;
    }
    
    
    public Fornecedor(String nome, String cpf, Date dataNascimento, Date inicio, String servico) {
        super(nome, cpf, dataNascimento);
        this.inicio = inicio;
        this.servico = servico;
    }
    
    public long getTempoRelacionamento(){
        
        Calendar calendar = Calendar.getInstance();
        long diff = calendar.getTime().getTime() - this.inicio.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        
        return diffDays;
    }

    @Override
    public String toString() {
        String pattern = "%-25.25s %-19.14s %-30.30s %-20.20s";
        return String.format(pattern, this.getNome(),  this.getCpf(), this.getServico(), this.getTempoRelacionamento());
    }
    
    
    
    
}
