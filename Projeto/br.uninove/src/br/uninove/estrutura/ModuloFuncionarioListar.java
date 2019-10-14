package br.uninove.estrutura;

import br.uninove.servico.EmpresaService;
import br.uninove.empresa.*;
import br.uninove.util.ScannerUtil;
import java.text.SimpleDateFormat;

public class ModuloFuncionarioListar extends FuncaoSistema {

    public ModuloFuncionarioListar() {
        super("Listar", "Listar funcionarios cadastrados");
    }
    
    @Override
    public void Executar() {
        
        EmpresaService service = EmpresaService.getInstance();
        SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
        
        ScannerUtil.mostrar(getDescricao());
        String pattern = "%-15.15s %-28.28s %-20.14s %-15.15s %-15.15s %-15.15s";
        String pattern2 = "%s %-15.15s";
        ScannerUtil.mostrar(String.format(pattern, "MATRICULA", "NOME", "CPF", "NASCIMENTO", "DEPENDENTES", "DEPARTAMENTO"));
        for (Funcionario funcionario : service.listarFuncionarios()) {
            Departamento departamento = service.getDepartamento(funcionario);
            if (departamento != null) {
                ScannerUtil.mostrar(String.format(pattern2, funcionario.toString(), departamento.getSigla()));
            }else{
                ScannerUtil.mostrar(funcionario.toString());
            }
            
        }
        
        ScannerUtil.getString("Pressione enter para voltar...");
        
    }
    
}
