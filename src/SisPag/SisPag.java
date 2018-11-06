package SisPag;

import view.CadastroEmpresa;
import view.TelaLogin;
import model.EmpresaDAO;

public class SisPag {
    
    public static void main(String[] args) {

       EmpresaDAO edao = new EmpresaDAO();
       CadastroEmpresa ce = new CadastroEmpresa(); 
       TelaLogin tl = new TelaLogin();
          
       edao.PossuiEmpresa();
       
       int ControleEmpresa = edao.getTotEmpresa();
           
       if (ControleEmpresa == 0) {
           
           ce.setVisible(true); 
                          
       }else{
     
           tl.setVisible(true);
           
       }  
             
    }
}
