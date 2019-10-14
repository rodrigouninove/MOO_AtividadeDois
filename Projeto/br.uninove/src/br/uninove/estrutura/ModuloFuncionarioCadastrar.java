package br.uninove.estrutura;

import br.uninove.empresa.*;
import br.uninove.validacao.*;
import br.uninove.util.ScannerUtil;
import br.uninove.servico.EmpresaService;

import java.util.Date;

public class ModuloFuncionarioCadastrar extends FuncaoSistema {

    public ModuloFuncionarioCadastrar() {
        super("Cadastrar", "Cadastrar novo funcionario");
    }

    @Override
    public void Executar() {
        System.out.println(getDescricao());
        boolean sair = false;
        EmpresaService service = EmpresaService.getInstance();

        while (!sair) {

            String nome = ScannerUtil.getString("Nome do funcionario: ");
            String cpf = ScannerUtil.getString("CPF do funcionario: ");
            Date dataNascimento = ScannerUtil.getDate("Data de Nascimento (dd/MM/YYYY): ");
            String matricula = ScannerUtil.getString("Matricula do funcionario : ");

            IValidacao validacao = new FuncionarioValidacao();
            Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, matricula);
            
            if (!validacao.Valido(funcionario)) {
                continue;
            }
            
            service.cadastrar(funcionario);

            boolean cadastrarDependente = ScannerUtil.confirm("Funcionario cadastrado com sucuesso! Cadastrar Dependente? (S | N) :");

            while (cadastrarDependente) {
                funcionario.adicionarDependente(cadastrarDependente());
                cadastrarDependente = ScannerUtil.confirm("Cadastrar mais dependentes? (S|N): ");
            }
            
            ScannerUtil.mostrar("Funcionario cadastrado com sucesso");
            sair = true;

        }

    }

    public Pessoa cadastrarDependente() {

        String nome = ScannerUtil.getString("Nome do dependente: ");
        String cpf = ScannerUtil.getString("CPF do dependente: ");
        Date dataNascimento = ScannerUtil.getDate("Data de nascimento (DD/MM/YYYY): ");
        
        Dependente dependente = new Dependente(nome, cpf, dataNascimento);
        
        return dependente;

    }

}
