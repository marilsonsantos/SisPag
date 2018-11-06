
package controller;

import model.AusenciaDAO;
import model.FuncionarioDAO;
import utilitarios.AusenciaBean;


public class ControllerAusencia {
    
    AusenciaBean ab = new AusenciaBean();
    AusenciaDAO asdao = new AusenciaDAO();
    FuncionarioDAO fdao = new FuncionarioDAO();
    
     public void registraAusencia(AusenciaBean ab){
    
        asdao.registraAusencia(ab);
    
    }
    
}
