package br.uninove.estrutura;


public class ModuloDepartamento extends FuncaoSistema {

    public ModuloDepartamento() {
        
        super("Departamentos", "Gestão de departamentos");
        
        adicionarFuncao(new ModuloRetorno());
        adicionarFuncao(new ModuloDepartamentoCadastro());
        adicionarFuncao(new ModuloDepartamentoListar());
        adicionarFuncao(new ModuloDepartamentoExcluir());
        adicionarFuncao(new ModuloDepartamentoAlocarFuncionario());
        
    }

    @Override
    public void Executar() {
        
    }

}
