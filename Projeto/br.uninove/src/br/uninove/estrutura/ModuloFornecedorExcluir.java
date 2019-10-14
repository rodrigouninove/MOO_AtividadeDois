package br.uninove.estrutura;

import br.uninove.empresa.Fornecedor;
import br.uninove.servico.EmpresaService;
import java.util.Scanner;

public class ModuloFornecedorExcluir extends FuncaoSistema {

    public ModuloFornecedorExcluir() {
        super("Exlcuir", "Excluir forcedores");
    }

    @Override
    public void Executar() {
        
        Scanner leitor = new Scanner(System.in);
        EmpresaService service = EmpresaService.getInstance();
        
        System.out.println(getDescricao());
        System.out.print("Digite o CPF do fornecedor: ");
        
        String cpf = leitor.nextLine();
        
        Fornecedor forncecedor = service.getFornecedor(cpf);
        
        if (forncecedor == null) {
            System.err.println(String.format("Não foi encontrado fornecedor com o CPF: %S", cpf));
            leitor.nextLine();
            return;
        }
        
        System.out.println(String.format("FORNECEDOR: %S - %s", forncecedor.getNome(), forncecedor.getServico()));
        System.out.println("Está correto? (S|N)");
        String confirm = leitor.nextLine();
        
        if ("N".equalsIgnoreCase(confirm)) {
            return;
        }
        
        service.excluir(forncecedor);
        System.out.println("Fornecedor excluido com sucesso!");
    }
    
}
