package br.uninove.estrutura;

import br.uninove.empresa.*;
import br.uninove.servico.EmpresaService;
import java.util.Scanner;


public class ModuloFuncionarioExcluir extends FuncaoSistema {

    public ModuloFuncionarioExcluir() {
        super("Excluir", "Excluir funcionarios");
    }

    @Override
    public void Executar() {
        Scanner leitor = new Scanner(System.in);
        EmpresaService service = EmpresaService.getInstance();
        
        System.out.println(getDescricao());
        System.out.print("Digite o CPF do funcionario: ");
        
        String cpf = leitor.nextLine();
        
        Funcionario funcionario = service.getFuncionario(cpf);
        
        if (funcionario == null) {
            System.err.println(String.format("Não foi encontrado funcionario com o CPF: %S", cpf));
            leitor.nextLine();
            return;
        }
        
        System.out.println(String.format("FUNCIONARIO: %S ", funcionario.getNome()));
        System.out.println("Está correto? (S|N)");
        String confirm = leitor.nextLine();
        
        if ("N".equalsIgnoreCase(confirm)) {
            return;
        }
        
        service.excluir(funcionario);
        System.out.println("Fornecedor excluido com sucesso!");
    }
    
}
