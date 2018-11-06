package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utilitarios.Conexao;
import utilitarios.HoraExtraBean;

public class HoraExtraDAO {
    
    private Connection con = Conexao.abrirConexao();
    HoraExtraBean hxb = new HoraExtraBean();
    
    
    
    public void registraHX(HoraExtraBean hxb){
        
        String sql = "insert into TB_HORA_EXTRA (HORA_EXTRA_DATA, HORA_EXTRA_PERIODO, ID_HX_FUNC, ID_HX_USUARIO, HORA_EXTRA_VALOR)"
                + "VALUES ('" + hxb.getHx_data() + "', " + hxb.getHx_periodo() + ", " + hxb.getId_func() + ", 1,'"
                + hxb.getHora_extra() + "');";
        
        try{
            
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Hora extra cadastrada com sucesso!", "Cadastro de Hora Extra", JOptionPane.INFORMATION_MESSAGE);
        
        
        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }      
             
    }
    

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
