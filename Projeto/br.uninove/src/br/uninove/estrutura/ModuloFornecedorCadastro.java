package br.uninove.estrutura;

import br.uninove.empresa.Fornecedor;
import br.uninove.servico.EmpresaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ModuloFornecedorCadastro extends FuncaoSistema {

    public ModuloFornecedorCadastro() {
        super("Cadastrar", "Cadastro de Fornecedores");
    }

    @Override
    public void Executar() {
        
        System.out.println(getDescricao());
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        boolean sair = false;
        while (!sair) {            
            
            try {
                Scanner leitor = new Scanner(System.in);
                System.out.print("Digite o nome do fornecedor: ");
                String nome = leitor.nextLine();
                System.out.print("Digite o CPF: ");
                String cpf = leitor.nextLine();
                System.out.print("Digite a Data de Nascimento (DD/MM/YYYY): ");
                String dataAuxiliar = leitor.nextLine();
                Date dataNascimento = formatDate.parse(dataAuxiliar);
                System.out.print("Digite a data de inicio do Fornecedor (DD/MM/YYYY):");
                dataAuxiliar = leitor.nextLine();
                Date dataInicio = formatDate.parse(dataAuxiliar);
                System.out.print("Digite o serviço prestado: ");
                String servico = leitor.nextLine();
                
                Fornecedor fornecedor = new Fornecedor(nome, cpf, dataNascimento, dataInicio, servico);
                
                EmpresaService
                        .getInstance()
                        .cadastrar(fornecedor);
                
                System.out.println("Fornecedor cadastrado com sucesso");
                
                sair = true;
                
            } catch (ParseException ex) {
                
                System.err.println("Formato da data invalido");
                
            }
            
        }
        
    }
    
}
