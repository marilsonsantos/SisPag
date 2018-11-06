package controller;

import java.sql.Connection;
import model.EmpresaDAO;
import utilitarios.Conexao;
import utilitarios.EmpresaBean;

public class ControllerEmpresa {
    
    Connection con = Conexao.abrirConexao();
    
    EmpresaDAO edao = new EmpresaDAO();
    
    public void controllerCadastro(EmpresaBean eb) {
        
        edao.cadastrar(eb);
        
    }
    
    public void controllerConsulta(EmpresaBean eb) {
        
        edao.exibeEmpresa(eb);
        
    }
    
    public void controllerAlterar(EmpresaBean eb) {
        
        edao.alterarEmpresa(eb);
        
    }
    
    public void controllerValidacao(EmpresaBean eb) {
    
        edao.validaCadastro(eb);
    
    }
}
