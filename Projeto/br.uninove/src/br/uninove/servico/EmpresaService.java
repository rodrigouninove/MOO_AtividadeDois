package br.uninove.servico;

import java.util.ArrayList;
import br.uninove.empresa.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class EmpresaService {
    
    private static EmpresaService _instance;
    private ArrayList<Departamento> _departamentos;
    private ArrayList<Funcionario> _funcionarios;
    private ArrayList<Fornecedor> _fornecedores;
    
    private EmpresaService(){ 
        
        try {
            _departamentos = new ArrayList<>();
            _funcionarios = new ArrayList<>();
            _fornecedores = new ArrayList<>();
            
            SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy");
            Funcionario teste1 = new Funcionario("Rodrigo Nunes de Oliveira", "000.000.000-01", sFormat.parse("20/03/1982"), "MAT0001");
            Funcionario teste2 = new Funcionario("Evelyn Batista de Alencar", "000.000.000-02", sFormat.parse("24/02/1994"), "MAT0002");
            _funcionarios.add(teste1);            
            _funcionarios.add(teste2);
            
            
            Departamento rh = new Departamento("Recursos Humanos", "RH");
            Departamento mktp = new Departamento("Marketing de Produtos", "MKT-P");
            Departamento exp = new Departamento("Expedição", "EXP");
            Departamento mnt = new Departamento("Manutenção", "MNT");
            
            _departamentos.add(rh);
            _departamentos.add(mktp);
            _departamentos.add(exp);
            _departamentos.add(mnt);
            
            Fornecedor fornecedor = new Fornecedor("Fornecedor 1","000.000.000-03", sFormat.parse("20/03/1982"), sFormat.parse("01/01/2019"), "Manutencao de equipamentos");
            _fornecedores.add(fornecedor);

            
        } catch (ParseException ex) {
            System.err.println("Erro ao formatar data");
        }
        
        
    }
    
    public static EmpresaService getInstance(){
        
        if(_instance == null){
            _instance = new EmpresaService();
        }
        
        return _instance;
    }
    
    
    public void cadastrar(Departamento departamento){
        this._departamentos.add(departamento);
    }
    
    public ArrayList<Departamento> listarDepartamentos(){
        return this._departamentos;
    }
    
    public Departamento getDepartamento(String sigla){
        
        Departamento encontrado = null;
        for (Departamento departamento : _departamentos) {
            if (sigla.equalsIgnoreCase(departamento.getSigla())) {
                encontrado= departamento;
                break;
            }
        }

        return encontrado;
    }
    
    public Departamento getDepartamento(Funcionario funcionario){
        
        Departamento encontrado = null;
        for (Departamento _departamento : _departamentos) {
            if (_departamento.funcionarioAlocado(funcionario)) {
                encontrado = _departamento;
                break;
            }
        }
        
        return encontrado;
        
    }
    
    public void excluir(Departamento departamento){
        _departamentos.remove(departamento);
    }
    
    
    
    public void cadastrar(Funcionario funcionario){
        this._funcionarios.add(funcionario);
    }
    
    public ArrayList<Funcionario> listarFuncionarios(){
        return this._funcionarios;
    }
    
    public Funcionario getFuncionario(String matricula){
        
        Funcionario funcionarioEncontrado = null;
        for (Funcionario funcionrio : _funcionarios) {
            if (matricula.equalsIgnoreCase(funcionrio.getMatricula())) {
                funcionarioEncontrado = funcionrio;
            }
        }
        
        return funcionarioEncontrado;
    }
    
    public void excluir(Funcionario funcionario){
        _funcionarios.remove(funcionario);
    }
    
    
    
    public void cadastrar(Fornecedor fornecedor){
        _fornecedores.add(fornecedor);
    }
    
    public ArrayList<Fornecedor> listarFornecedores(){
        return _fornecedores;
    }
    
    public void excluir(Fornecedor fornecedor){
        _fornecedores.remove(fornecedor);
    }
    
    public Fornecedor getFornecedor(String cpf){
        Fornecedor encontrado = null;
        
        for (Fornecedor fornecedor : _fornecedores) {
            
            if (cpf.equalsIgnoreCase(fornecedor.getCpf())) {
                encontrado = fornecedor;
            }
        }
        
        return encontrado;
    }
    
    
    
}
