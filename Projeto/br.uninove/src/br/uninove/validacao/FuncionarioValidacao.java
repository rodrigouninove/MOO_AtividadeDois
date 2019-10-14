package br.uninove.validacao;

import br.uninove.empresa.Funcionario;

public class FuncionarioValidacao implements IValidacao {

    @Override
    public boolean Valido(Object obj) {
        
        Funcionario funcionario = (Funcionario)obj;
        StringBuilder sb = new StringBuilder();
        String pattern = "%S - %s. %n";
        boolean valido = true;
        
        if (funcionario.getCpf().length() < 14){
            sb.append(String.format(pattern, "cpf", "cpf inválido"));
        }
        
        if (funcionario.getNome().trim().length() == 0) {
            sb.append(String.format(pattern, "nome", "nome invalido"));
        }
        
        if (funcionario.getMatricula().trim().length() < "MAT0000".length()) {
            sb.append(String.format(pattern, "matricula", "matricula invalida"));
        }
        
        if (sb.length() > 0) {
            System.err.println("Funcionário inválido");
            System.err.println(sb.toString());
            valido = false;
        }
        
        return valido;
    }
    
}
