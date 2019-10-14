package br.uninove.estrutura;

import br.uninove.util.ScannerUtil;
import java.util.ArrayList;

public abstract class FuncaoSistema {

    private String nome;
    private String descricao;
    private ArrayList<FuncaoSistema> modulos;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public FuncaoSistema(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.modulos = new ArrayList<>();
    }

    protected void adicionarFuncao(FuncaoSistema funcaoSistema) {
        this.modulos.add(funcaoSistema);
    }

    public void exibirFuncoes() {

        try {

            ScannerUtil.mostrar(this.descricao);

            String pattern = "[%s] [%-15.15s] - %s";

            for (int i = 0; i < modulos.size(); i++) {
                ScannerUtil.mostrar(String.format(pattern, i, modulos.get(i).nome.toUpperCase(), modulos.get(i).descricao));
            }
            int opcao = 2;
            opcao = ScannerUtil.getInt();

            if (modulos.get(opcao).modulos.size() > 0) {
                modulos.get(opcao).exibirFuncoes();
            } else {
                modulos.get(opcao).Executar();
            }
            
        } catch (Exception e) {
            System.err.println("Opção inválida");
            this.exibirFuncoes();
        }
    }

    public abstract void Executar();

}
