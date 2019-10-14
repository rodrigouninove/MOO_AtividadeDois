package br.uninove.estrutura;

import br.uninove.servico.EmpresaService;
import br.uninove.empresa.*;
import br.uninove.util.ScannerUtil;
import java.util.Scanner;

public class ModuloDepartamentoAlocarFuncionario extends FuncaoSistema {

    public ModuloDepartamentoAlocarFuncionario() {
        super("Alocar Func.", "Alocar funcionarios ao departamento");
    }

    @Override
    public void Executar() {

        ScannerUtil.mostrar(getDescricao());

        EmpresaService service = EmpresaService.getInstance();
        Scanner leitor = new Scanner(System.in);
        Departamento departamento = null;

        boolean sair = false;
        //Pesquisa departamento
        while (!sair) {
            
            String sigla = ScannerUtil.getString("Digite a sigla do departamento: ");
            departamento = service.getDepartamento(sigla);

            if (departamento == null) {
                
                boolean confirm = ScannerUtil.confirm("Departamento não encontrado. Procurar novamente? (S | N)");
                
                if (confirm) {
                    continue;
                } else {
                    sair = true;
                    continue;
                }
            }

            ScannerUtil.mostrar(String.format("DEPARTAMENTO: %s - %s", departamento.getSigla(), departamento.getNome()));
            boolean confirm = ScannerUtil.confirm("Está correto? (S|N)");

            if (!confirm) {
                continue;
            }else{
                sair = true;
            }

        }

        //Pesquisa funcionario
        if (departamento != null) {

            Funcionario funcionario = null;
            sair = false;
            while (!sair) {

                String matricula = ScannerUtil.getString("Digite a matricula do funcionario: ");
                funcionario = service.getFuncionario(matricula);

                if (funcionario == null) {
                    boolean confirm  = ScannerUtil.confirm("Funcionario não encontrado. Procurar novamente? (S|N)");
                    if (confirm) {
                        continue;
                    } else {
                        sair = true;
                        continue;
                    }
                }
                
                ScannerUtil.mostrar(String.format("FUNCIONARIO: %s - %s", funcionario.getMatricula(), funcionario.getNome()));
                boolean confirm  = ScannerUtil.confirm("Está correto? (S|N)");

                if (!confirm) {
                    continue;
                }
                
                confirm = ScannerUtil.confirm(String.format("Deseja alocar o(a) funcionario(a) %s no departamento %s? (S|N)", funcionario.getNome(), departamento.getNome()));
                if (!confirm) {
                    break;
                }
                
                departamento.alocarFuncionario(funcionario);
                ScannerUtil.mostrar("Funcionario alocado com sucesso!");
                sair = true;

            }

        }

    }

}
