package br.uninove.estrutura;

class ModuloFornecedor extends FuncaoSistema {
    
    public ModuloFornecedor() {
        super("Forcenedor", "Gestão de fornecedores");
        adicionarFuncao(new ModuloRetorno());
        adicionarFuncao(new ModuloFornecedorCadastro());
        adicionarFuncao(new ModuloFornecedorListar());
        adicionarFuncao(new ModuloFornecedorExcluir());
    }

    @Override
    public void Executar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
