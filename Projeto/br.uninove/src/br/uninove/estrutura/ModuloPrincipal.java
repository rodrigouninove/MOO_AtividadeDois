package br.uninove.estrutura;

public class ModuloPrincipal extends FuncaoSistema{

    public ModuloPrincipal() {
        super("Principal", "Menu principal da aplicação");

        adicionarFuncao(new ModuloDepartamento());
        adicionarFuncao(new ModuloFuncionario());
        adicionarFuncao(new ModuloFornecedor());
    }
    
    @Override
    public void Executar() {
        
    }
    
}
