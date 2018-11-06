package controller;

import model.UsuarioDAO;
import utilitarios.UsuarioBean;


public class ControllerUsuario {
    
    UsuarioDAO udao = new UsuarioDAO();
    
    public void controllerValidacao(UsuarioBean ub){
    
        udao.validaLogin(ub);
    
    }
    
    public void controllerCadastro(UsuarioBean ub){
    
        udao.cadastrar(ub);
    
    }
    
    public void controllerConsulta(UsuarioBean ub){
    
        udao.consultar(ub);
    
    }
    
    public void controllerAlterar(UsuarioBean ub){
    
        udao.alterar(ub);
    
    }
    
    public void controllerSenha(UsuarioBean ub){
    
        udao.alterarSenha(ub);
    
    }

    public void controllerRecuperacaoSenha(UsuarioBean ub){
    
        udao.recuperarSenha(ub);
    
    }

}
