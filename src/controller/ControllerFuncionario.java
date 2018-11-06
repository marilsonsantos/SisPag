package controller;

import model.FuncionarioDAO;
import utilitarios.AusenciaBean;
import utilitarios.FuncionarioBean;
import utilitarios.HoraExtraBean;

public class ControllerFuncionario {
    
    FuncionarioBean fb = new FuncionarioBean();
    FuncionarioDAO fdao = new FuncionarioDAO();
    
    public HoraExtraBean exibeFuncionario(HoraExtraBean hxb){
    
        return fdao.exibeHXFuncionario(hxb);
    
    }
    
    public AusenciaBean exibeFuncionario(AusenciaBean ab){
    
        return fdao.exibeAusenciaFuncionario(ab);
    
    }
    
    public void controllerCadastro(FuncionarioBean fb){
    
        fdao.cadastrar(fb);
    
    }
    
    public void controllerConsulta(FuncionarioBean fb){
    
        fdao.consultar(fb);
    
    }
    
    public void controllerAlteraracao(FuncionarioBean fb){
    
        fdao.alterar(fb);
    
    }
    
    public void controllerDesativacao(FuncionarioBean fb){
    
        fdao.desativar(fb);
    
    }
    
}
