package br.uninove.estrutura;

import br.uninove.empresa.Departamento;
import br.uninove.servico.EmpresaService;
import java.util.Scanner;

public class ModuloDepartamentoExcluir extends FuncaoSistema {

    public ModuloDepartamentoExcluir() {
        super("Ecluir", "Excluir deparamento");
    }

    @Override
    public void Executar() {
        
        Scanner leitor = new Scanner(System.in);
        EmpresaService service = EmpresaService.getInstance();
        
        System.out.println(getDescricao());
        System.out.print("Digite a sigla do departamento: ");
        
        String sigla = leitor.nextLine();
        
        Departamento departamento = service.getDepartamento(sigla);
        if (departamento == null) {
            System.err.println(String.format("Não foi encontrado depatamento com a sigla: %S", sigla));
            leitor.nextLine();
            return;
        }
        
        System.out.println(String.format("DEPARTAMENTO: %S - %s", departamento.getSigla(), departamento.getNome()));
        System.out.println("Está correto? (S|N)");
        String confirm = leitor.nextLine();
        
        if ("N".equalsIgnoreCase(confirm)) {
            return;
        }
        
        service.excluir(departamento);
        System.out.println("Departamento excluido com sucesso!");
        
    }
    
}
