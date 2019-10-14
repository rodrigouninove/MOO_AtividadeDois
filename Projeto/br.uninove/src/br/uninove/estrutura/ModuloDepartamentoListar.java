package br.uninove.estrutura;

import br.uninove.empresa.Departamento;
import br.uninove.servico.EmpresaService;
import java.util.Scanner;

public class ModuloDepartamentoListar extends FuncaoSistema {

    public ModuloDepartamentoListar() {
        super("Listar", "Listar departamentos cadastrados");
    }

    @Override
    public void Executar() {
        System.out.println(getDescricao());
        String pattern = "%-10s %-30s %-15s";
        System.out.println(String.format(pattern, "SIGLA", "NOME", "FUNCIONARIOS"));
        
        EmpresaService service = EmpresaService.getInstance();
        
        for (Departamento departamento : service.listarDepartamentos()) {
            System.out.println(String.format(pattern, departamento.getSigla(), departamento.getNome(), departamento.getTotalFuncionarios()));
        }
        
        System.out.println("Pressione enter para voltar...");
        Scanner leitor = new Scanner(System.in);
        leitor.nextLine();

        
    }
    
}
