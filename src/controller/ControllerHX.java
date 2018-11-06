package controller;

import model.FuncionarioDAO;
import model.HoraExtraDAO;
import utilitarios.HoraExtraBean;

public class ControllerHX {
    
    HoraExtraBean hxb = new HoraExtraBean();
    HoraExtraDAO hdao = new HoraExtraDAO();
    FuncionarioDAO fdao = new FuncionarioDAO();
    

    
    public void registraHX(HoraExtraBean hxb){
    
        hdao.registraHX(hxb);
    
    }
    
}
