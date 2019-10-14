package br.uninove.estrutura;

import br.uninove.empresa.Fornecedor;
import br.uninove.servico.EmpresaService;
import java.util.*;

public class ModuloFornecedorListar extends FuncaoSistema {

    public ModuloFornecedorListar() {
        super("Listar","Listar fornecedores cadastrados");
    }

    @Override
    public void Executar() {
        
        System.out.println(getDescricao());
        String pattern = "%-25.25s %-19.14s %-30.30s %-30.30s";
        System.out.println(String.format(pattern, "NOME", "CPF", "SERVICO", "RELACIONAMENTO/DIAS"));
        
        EmpresaService service = EmpresaService.getInstance();
        
        for (Fornecedor fornecedor : service.listarFornecedores()) {
            System.out.println(fornecedor.toString()); 
        }
        
        
        System.out.println("Pressione enter para voltar...");
        Scanner leitor = new Scanner(System.in);
        leitor.nextLine();
        
    }
    
}
