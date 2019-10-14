package br.uninove.estrutura;

import br.uninove.empresa.Departamento;
import br.uninove.servico.EmpresaService;
import br.uninove.util.ScannerUtil;


public class ModuloDepartamentoCadastro extends FuncaoSistema {

    public ModuloDepartamentoCadastro() {
        super("Cadastrar", "Cadastro de Departamentos");
    }

    @Override
    public void Executar() {
        
        System.out.println(getDescricao());
        
        boolean sair = false;

        while (!sair) {
            EmpresaService service = EmpresaService.getInstance();
            
            String nome = ScannerUtil.getString("Nome do departamento: ");
            String sigla = ScannerUtil.getString("Sigla do departamento: ");
            Departamento departamento = new Departamento(nome, sigla);
            
            service.cadastrar(departamento);
            
            boolean confirm = ScannerUtil.confirm("Cadastro realizado com sucesso. Cadastrar outro? (S | N)");
            if (!confirm) {
                sair = true;
            }
        }

    }

}
