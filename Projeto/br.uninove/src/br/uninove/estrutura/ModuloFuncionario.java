package br.uninove.estrutura;

public class ModuloFuncionario extends FuncaoSistema {

    public ModuloFuncionario() {
        super("Funcionarios", "Gestão de funcionarios");
        
        adicionarFuncao(new ModuloRetorno());
        adicionarFuncao(new ModuloFuncionarioCadastrar());
        adicionarFuncao(new ModuloFuncionarioListar());
        adicionarFuncao(new ModuloFuncionarioExcluir());
    }

    @Override
    public void Executar() {
        
    }
    
}
